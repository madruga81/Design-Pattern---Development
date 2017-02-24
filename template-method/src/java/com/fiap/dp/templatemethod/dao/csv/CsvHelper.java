package com.fiap.dp.templatemethod.dao.csv;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.fiap.dp.templatemethod.ReportException;

class CsvHelper {
    private static final String CSV_FILENAME = "places.csv";

    private CsvHelper() {}

    public static InputStream openCSV() throws ReportException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(CSV_FILENAME);
        if (is == null) {
            throw new ReportException(CSV_FILENAME + " not found");
        }
        return is;
    }
    
    public static BufferedReader openCSVasBufferedReader() throws ReportException {
        return new BufferedReader(new InputStreamReader(openCSV()));
    }
    
}
