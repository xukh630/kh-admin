package com.kh.admin.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 类ConfigTableUtil.java的实现描述：代码生成mybatis需要的generator table 内容
 * 
 * @author wb-yejian 2016年1月11日 上午11:20:02
 */
public class ConfigTableUtil {

    public static void generateConfigTable(File sourceFile) {

        BufferedReader reader = null;
        try {
            // System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(sourceFile));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                String[] lineArray = tempString.split("#");

                String tableLine = generateTableLine(lineArray);
                // 显示tableLine
                // System.out.println(tableLine);
                // 显示行号
                // System.out.println("line " + line + ": " + tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    private static String generateTableLine(String[] lineArray) {
        StringBuilder lineBuilder = new StringBuilder();
        String column = lineArray[0].trim();
        String property = getProperty(lineArray);
        String javaType = getJavaType(lineArray[1].trim());
        String jdbcType = getJdbcType(lineArray[1].trim());
        lineBuilder.append("<columnOverride column=\"");
        lineBuilder.append(column);
        lineBuilder.append("\" property=\"");
        lineBuilder.append(property);
        lineBuilder.append("\" javaType=\"");
        lineBuilder.append(javaType);
        lineBuilder.append("\" jdbcType=\"");
        lineBuilder.append(jdbcType);
        lineBuilder.append("\" />");
        return lineBuilder.toString();
    }

    private static String getProperty(String[] lineArray) {
        String temp = lineArray[0].trim().toLowerCase();
        String[] tempArray = temp.split("_");
        StringBuilder propertyBuilder = new StringBuilder();
        for (int i = 0; i < tempArray.length; i++) {
            if (i == 0) {
                propertyBuilder.append(tempArray[i]);
            } else {
                propertyBuilder.append(String.valueOf(tempArray[i].charAt(0)).toUpperCase()
                                       + tempArray[i].substring(1));
            }
        }
        return propertyBuilder.toString();
    }

    private static String getJavaType(String type) {
        String javaType = "";
        if (type.contains("NUMBER(18,2)")) {
            javaType = "java.math.BigDecimal";
        } else if (type.contains("NUMBER(22)")) {
            javaType = "java.lang.Long";
        } else if (type.contains("VARCHAR")) {
            javaType = "String";
        } else if (type.contains("DATE")) {
            javaType = "java.util.Date";
        }
        return javaType;
    }

    private static String getJdbcType(String type) {
        String jdbcType = "";
        if (type.contains("NUMBER")) {
            jdbcType = "NUMERIC";
        } else if (type.contains("VARCHAR")) {
            jdbcType = "VARCHAR";
        } else if (type.contains("DATE")) {
            jdbcType = "TIMESTAMP";
        }
        return jdbcType;
    }

    // D:/apps/xteam/database/tp_head
    // SUBMIT_USER_ID # NUMBER(22)
    // SUBMIT_TYPE # VARCHAR2(50)
    // SUBMIT_DATE # DATE
    // SUBMIT_COSTCENTER # VARCHAR2(50)
    // ADVANCE_AMOUNT_APPROVED # NUMBER(18,2)
  

    // public static void main(String[] args) {
    // String fileName = "D:/apps/xteam/database/tp_head";
    // File file = new File(fileName);
    // ConfigTableUtil.generateConfigTable(file);
    // }

}
