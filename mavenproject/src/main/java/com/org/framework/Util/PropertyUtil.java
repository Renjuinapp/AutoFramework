package com.org.framework.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public final class PropertyUtil {
	private static final Logger logger = LoggerFactory.getLogger(PropertyUtil.class);
    protected Properties properties;
    protected Properties Config;                   
    private String ConfigProps = "..//mavenproject/PropertyFiles/ConfigFile";
    private static PropertyUtil propertyUtil = new PropertyUtil();

    public PropertyUtil(){
        {

            properties = new Properties();
            Config = new Properties();
        
            try {
                properties.load(new FileInputStream(ConfigProps));

            } catch (IOException ex) {

                logger.info("Unable to load " + ConfigProps + ex);

            }

        }
    }

    public static final Properties getConfigProps() {
        if(null == propertyUtil)
            propertyUtil = new PropertyUtil();
        return propertyUtil.properties;
    }


    public static void createTestFile(){
        File testFile = new File("testtestsetsestestest.txt");
        try {
            testFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   }