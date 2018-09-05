package com.javarush.task.task33.task3309;

/* 
Комментарий внутри xml

Реализовать метод toXmlWithComment, который должен возвращать строку - xml представление объекта obj.
В строке перед каждым тегом tagName должен быть вставлен комментарий comment.
Сериализация obj в xml может содержать CDATA с искомым тегом. Перед ним вставлять комментарий не нужно.

Пример вызова:
toXmlWithComment(firstSecondObject, "second", "it's a comment")

Пример результата:
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<first>
<!--it's a comment-->
<second>some string</second>
<!--it's a comment-->
<second>some string</second>
<!--it's a comment-->
<second><![CDATA[need CDATA because of < and >]]></second>
<!--it's a comment-->
<second/>
</first>


Требования:
1. Метод toXmlWithComment должен быть статическим.
2. Метод toXmlWithComment должен быть публичным.
3. Если во входящем xml отсутствует искомый тег, то добавлять комментарии не нужно.
4. Количество комментариев вставленных в xml должно быть равно ко
*/

import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.regex.Pattern;

import static java.lang.Boolean.TRUE;

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static String toXmlWithComment(Object obj, String tagName, String comment) {
        String xmlString = null;
        try {
            StringWriter writer = new StringWriter();
            Marshaller marshaller = JAXBContext.newInstance(obj.getClass()).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(obj, writer);

            xmlString = writer.toString();
            Document doc = convertXMLStringToDocument(xmlString);

            Element element = doc.getDocumentElement();
            NodeList nodeList = doc.getElementsByTagName("*");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeName().equals(tagName)) {
                    Comment commentElement = doc.createComment(comment);
                    element.insertBefore(commentElement, node);
                }
                replaceTextWithCDATA(node, doc);
            }

            xmlString = convertDocumentToXMLString(doc);

        } catch (JAXBException | NullPointerException ignored) {}

        return xmlString;
    }

    private static String convertDocumentToXMLString(Document doc) {
        try {
            doc.setXmlStandalone(false);
            StringWriter writer = new StringWriter();
            TransformerFactory
                    .newInstance()
                    .newTransformer()
                    .transform(new DOMSource(doc), new StreamResult(writer));
            return writer.getBuffer().toString();
        } catch (TransformerException ignore) {
        }
        return null;
    }

    private static Document convertXMLStringToDocument(String xmlStr) {
        try {
            return DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(new InputSource(new StringReader(xmlStr)));
        } catch (Exception ignore) {
        }
        return null;
    }

    private static void replaceTextWithCDATA(Node node, Document doc) {
        if ((node.getNodeType() == 3) && (Pattern.compile("[<>&'\"]").matcher(node.getTextContent()).find())) {
            Node cnode = doc.createCDATASection(node.getNodeValue());
            node.getParentNode().replaceChild(cnode, node);
        }

        NodeList nodeList = node.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            replaceTextWithCDATA(nodeList.item(i), doc);
        }
    }
}
