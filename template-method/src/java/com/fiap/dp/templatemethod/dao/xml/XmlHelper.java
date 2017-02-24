package com.fiap.dp.templatemethod.dao.xml;

import java.io.BufferedInputStream;
import java.io.InputStream;

import com.fiap.dp.templatemethod.ReportException;

class XmlHelper {
    private static final String XML_FILENAME = "places.xml";

    private XmlHelper() {}

    public static InputStream openXML() throws ReportException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(XML_FILENAME);
        if (is == null) {
            throw new ReportException(XML_FILENAME + " not found");
        }
        return is;
    }
    
    public static BufferedInputStream openXMLasBufferedInputStream() throws ReportException {
        return new BufferedInputStream(openXML());
    }
    
}
