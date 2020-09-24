
package com.common.util;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class JaxBeanAndXmlConvertUtils {
    private static Map<Class, JAXBContext> jaxbContextMap = new ConcurrentHashMap<>();

    public static String bean2Xml(Object o) {
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
            log.error("java convert xml error.", e);
            throw new RuntimeException(e);
        }
        return strWriter.toString();
    }

    public static <T> T xml2Bean(String xmlSource, Class<T> c) {
        if (StringUtils.isBlank(xmlSource)) {
            return null;
        }
        Object o;
        try {
            long start = System.currentTimeMillis();
            Unmarshaller unmarshaller = createUnmarshaller(c);
            o = unmarshaller.unmarshal(new StringReader(xmlSource));
            long end = System.currentTimeMillis();
            log.info("xml2Bean time: {}", end - start);
        } catch (JAXBException e) {
            log.error("xml convert java error.", e);
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

    private static Unmarshaller createUnmarshaller(Class c) throws JAXBException {
        JAXBContext jaxbContext = getJAXBContext(c);
        return jaxbContext.createUnmarshaller();
    }

    private static JAXBContext getJAXBContext(Class c) throws JAXBException {
        JAXBContext jc = jaxbContextMap.get(c);
        if ( jc == null ) {
            synchronized (c) {
                jc = JAXBContext.newInstance(c);
                jaxbContextMap.put(c, jc);
            }
        }
        return jc;
    }

    public class MapAdapter extends XmlAdapter<MapElements[], Map<String, String>> {
        @Override
        public MapElements[] marshal(Map<String, String> arg0) throws Exception {
            MapElements[] mapElements = new MapElements[arg0.size()];

            int i = 0;
            for (Map.Entry<String, String> entry : arg0.entrySet()) {
                mapElements[i++] = new MapElements(entry.getKey(), entry.getValue());
            }

            return mapElements;
        }

        @Override
        public Map<String, String> unmarshal(MapElements[] arg0) throws Exception {
            Map<String, String> r = new HashMap<String, String>();
            for (MapElements mapelement : arg0) {
                r.put(mapelement.key, mapelement.value);
            }
            return r;
        }
    }

    class MapElements {
        @XmlElement
        public String key;
        @XmlElement
        public String value;

        private MapElements() {
        } //Required by JAXB

        public MapElements(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
