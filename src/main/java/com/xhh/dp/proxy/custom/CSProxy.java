package com.xhh.dp.proxy.custom;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * 自定义代理实现类
 *
 */
public class CSProxy {
    private static String ln = "\r\n";

    public static Object newProxyInstance(CSClassLoader loader, Class<?>[] interfaces, CSInvocationHandler h)
            throws IllegalArgumentException {
        try {
            // 1、生成源代码
            String proxySrc = generateSrc(interfaces[0]);

            // 2、将生成的源代码写出到磁盘，保存为.java文件
            String filePath = CSProxy.class.getResource("").getPath();
            File file = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(file);
            fw.write(proxySrc);
            fw.flush();
            fw.close();

            // 3、编译源代码，生成.class文件
            // 要想获取JavaCompiler，必须将tools.jar文件从jdk目录下拷贝到了jre目录下
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(file);

            CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            // 4、将class文件加载到JVM,返回被代理后的对象
            Class<?> proxyClass = loader.findClass("$Proxy0");
            Constructor<?> constructor = proxyClass.getConstructor(CSInvocationHandler.class);
            // file.delete();

            return constructor.newInstance(h);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成源代码
     * 
     * @param interfaces
     * @return
     */
    private static String generateSrc(Class<?> interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.xhh.dp.proxy.custom;" + ln);
        sb.append("import java.lang.reflect.Method;" + ln);
        sb.append("public class $Proxy0 implements " + interfaces.getName() + "{" + ln);
        sb.append("CSInvocationHandler h;" + ln);
        sb.append("public $Proxy0(CSInvocationHandler h) {" + ln);
        sb.append("this.h = h;" + ln);
        sb.append("}" + ln);

        for (Method method : interfaces.getMethods()) {
            sb.append("public " + method.getReturnType().getName() + " " + method.getName() + "(){" + ln);
            sb.append("try{" + ln);
            sb.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" + method.getName()
                    + "\",new Class[]{});" + ln);
            sb.append("this.h.invoke(this, m, null);" + ln);
            sb.append("}catch(Throwable e){e.printStackTrace();}" + ln);
            sb.append("}" + ln);
        }
        sb.append("}");
        return sb.toString();
    }

}
