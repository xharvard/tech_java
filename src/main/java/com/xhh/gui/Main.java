package com.xhh.gui;

/**
 * 图形界面
 * AWT(Abstract Window Toolkit):抽象窗口工具箱,把用户界面元素的绘制任务委派给每个目标平台的本地GUI工具库。观感效果依赖具体平台。
 * Swing:基于AWT架构之上，提供了功能强大的用户界面组件，观感效果统一。
 * Swing处理"被绘制的"的用户界面类；AWT负责事件处理等底层机制。
 * 
 * Swing提供了一种称为Metal的独立于平台的观感。
 * 1、Metal:javax.swing.plaf.metal
 * 2、nimbus:javax.swing.plaf.nimbus
 * 3、synth:javax.swing.plaf.synth
 * 4、motif:com.sun.java.swing.plaf.motif
 * 5、windows：com.sun.java.swing.plaf.windows
 * 
 * 顶层窗口称为框架(frame)。对应AWT中的Frame类，Swing中为JFrame类。它的修饰部件(按钮、标题栏、图标等)由用户窗口系统绘制，不是由Swing绘制。
 * 
 * 绘制一个组件，需要定义一个扩展JComponent的类，并覆盖PaintComponent方法。
 * 所有的绘制都必须使用Graphics对象，其中包含了绘制图案、图像和文本的方法。
 * 
 * 2D图形： Graphics2D类，是Graphics的子类。常用的有Line2D,Rectangle2D,Ellipse2D,Point2D,RoundRectangle2D,Arc2D,QuadCurve2D,CubicCurve2D,Path2D
 * 每个类有2个内部类表示float和double精度: Rectangle2D.Float和Rectangle2D.Double
 * Graphics2D的setPaint()方法设置颜色。 draw()方法绘制图形；fill()方法填充图形。
 * 
 * font:
 *
 */
public class Main {

	public static void main(String[] args) {

	}

}
