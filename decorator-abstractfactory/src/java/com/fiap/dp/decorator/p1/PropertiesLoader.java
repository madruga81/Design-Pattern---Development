package com.fiap.dp.decorator.p1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Use: PropertiesLoader <nomeArquivo>. Exemplo: report.properties");
            return;
        }
        
        String fileName = args[0];
        loadA(fileName);
        loadB(fileName);
    }

    private static void loadA(String fileName) {
        try {
            Properties props = new Properties();
            props.load(open(fileName));
            System.out.println(props);
        } catch (IOException e) {
            System.err.println("I/O error loading properties");
        }
    }

    private static InputStream open(String fileName) throws FileNotFoundException {
        return new FileInputStream(fileName);
    }

    private static void loadB(String fileName) {
        try {
            Properties props = new Properties();
            props.load(openBuffered(fileName));
            System.out.println(props);
        } catch (IOException e) {
            System.err.println("I/O error loading properties");
        }
    }

    private static InputStream openBuffered(String fileName) throws FileNotFoundException {
        return new BufferedInputStream(new FileInputStream(fileName));
    }
}
