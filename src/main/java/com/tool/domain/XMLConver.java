
package com.tool.domain;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;


/**
 * XMLConver 转换xml格式
 *
 * @author kaka
 * @date 2017-09-21
 * @since v1.1.0
 */
public class XMLConver {
   private static final Logger LOGGER = LoggerFactory.getLogger(XMLConver.class);

    public static String java2Xml(Object o) {
        if (o == null) {
            return null;
        }
        StringWriter strWriter = new StringWriter();
        try {
            Marshaller marshaller = createMarshaller(o.getClass());
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(o, strWriter);
        } catch (JAXBException e) {
            LOGGER.error("java conver xml error.", e);
            throw new RuntimeException(e);
        }
        return strWriter.toString();
    }

    public static <T> T javaFromXml(String xmlSource, Class<T> c) {
        if (StringUtils.isBlank(xmlSource)) {
            return null;
        }
        Object o;
        try {
            Unmarshaller unmarshaller = createUnmarshaller(c);
            o = unmarshaller.unmarshal(new StringReader(xmlSource));
        } catch (JAXBException e) {
            LOGGER.error("xml conver java error.{}", e);
            throw new RuntimeException(e);
        }
        return (T) o;
    }

    private static Marshaller createMarshaller(Class... c) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(c);
        return jaxbContext.createMarshaller();
    }

    private static Unmarshaller createUnmarshaller(Class... c) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(c);
        return jaxbContext.createUnmarshaller();
    }

    public static Map toMap(String xml) throws Exception{
        XmlMapper xmlSerializer = new XmlMapper();
        return xmlSerializer.readValue(xml, Map.class);
    }
}
