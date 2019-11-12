package com.xhh.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

/**
 * XML的3种解析方式：
 * 
 * 1、文档对象模型(Document Object Model, DOM):树型解析器，一次读入所有文档内容
 * 
 * 2、事件触发模型(Simple API for XML, SAX):流机制解析器，在读入xml的时候生成相应事件
 * 
 * 3、SAX的改进，一种拉解析器(StAX),可以实现网络爬虫
 * 
 * XML的写出: 1、Transformer 2、XMLStreamWriter(StAX)
 * 
 * 定位节点： XPath
 * 
 * ==================================================
 * JAXB（Java Architecture for XML Binding）是J2SE和J2EE平台的一部分，让开发者能够快速完成Java类和XML的互相映射。
 * JAXB 允许Java人员将Java类映射为XML表示方式。其实，JAXB是一个业界标准，是一项可以根据XML Schema产生Java类的技术
 * ，并且可以将Java对象树的内容写到XML文档中。
 * JAXB为XML节点和属性提供提供了各种面向对象的处理方式，可以基于注解或适配器将XML转换为Java对象。
 * 因为其优雅的处理方式，从JRE6开始，JAXB就已经成为了JRE的内置模块
 * 
 * 参考：https://www.w3cschool.cn/jaxb2/jaxb2-5hnk2zo8.html
 * 
 */
public class Main {

    public static void main(String[] args) throws Exception {
        // DOM
        // com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        // org.w3c.dom.xxx w3c标准接口
        Document document = builder.parse(new File(""));

        // SAX
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        saxParser.parse(new File(""), new DefaultHandler());

        // StAX
        URL url = new URL("http://www.w3c.org");
        InputStream in = url.openStream();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(in);
        reader.next();

        // XPath
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        xPath.evaluate("", new InputSource());

        // XML输出,比较通用。可以输出各种类型，包含html,xml,text
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "");
        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(new File(""))));

        // StAX的XML输出
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = outputFactory.createXMLStreamWriter(new FileOutputStream(new File("")));
        writer.writeStartDocument();
        writer.writeStartElement("");
        writer.writeAttribute("", "");
        writer.writeEndElement();
        writer.writeEndDocument();
    }

}
