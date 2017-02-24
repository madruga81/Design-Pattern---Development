package com.fiap.dp.templatemethod;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.fiap.dp.templatemethod.dao.DAOFactory;
import com.fiap.dp.templatemethod.dao.cache.CacheDAOFactory;

public class ReportPrinterTest {

    private static final String PROPERTIES_FILENAME = "report.properties";
    private static final String FACTORY_PREFIX = "source.factory.";
    private static final String CACHE_POSTFIX = ".cache";

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("Usage: ReportPrinterTest <source-type>");
            return;
        }
        
        String sourceType = args[0];
        DAOFactory daoFactory = createDAOFactory(sourceType);
        
        ReportPrinter reportPrinter = new ReportPrinter(daoFactory);
        reportPrinter.printReport(System.out);
        
        reportPrinter.printCity("Sete Lagoas", System.out);
        reportPrinter.printState("Sao Paulo", System.out);
        reportPrinter.printCountry("Estados Unidos", System.out);
    }

    private static DAOFactory createDAOFactory(String sourceType) throws ReportException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTIES_FILENAME);
        if (is == null) {
            throw new ReportException(PROPERTIES_FILENAME + " not found");
        }

        Properties props = new Properties();
        try {
            props.load(is);
        } catch (IOException ioe) {
            throw new ReportException("Error loading properties", ioe);
        }

        String propName = FACTORY_PREFIX + sourceType;
        String className = props.getProperty(propName);
        if (className == null) {
            throw new ReportException("No factory for source '" + sourceType + "' (set property '" + propName + "')");
        }

        DAOFactory factory = null;
        try {
            Class daoClass = Class.forName(className);
            factory = (DAOFactory) daoClass.newInstance();
        } catch (ClassNotFoundException cnfe) {
            throw new ReportException("Error loading class '" + className + "'", cnfe);
        } catch (InstantiationException ie) {
            throw new ReportException("Error instantiating class '" + className + "'", ie);
        } catch (IllegalAccessException iae) {
            throw new ReportException("Illegal access instantiating class '" + className + "'", iae);
        } catch (ClassCastException cce) {
            throw new ReportException("Class '" + className + "' is not a " + DAOFactory.class.getName(), cce);
        }
        
        boolean useCache = false;
        String useCachePropName = FACTORY_PREFIX + sourceType + CACHE_POSTFIX;
        String useCachePropValue = props.getProperty(useCachePropName);
        if (useCachePropValue != null) {
            useCache = Boolean.valueOf(useCachePropValue).booleanValue();
        }

        if (useCache) {
            factory = new CacheDAOFactory(factory);
        }
        
        return factory;
    }
}
