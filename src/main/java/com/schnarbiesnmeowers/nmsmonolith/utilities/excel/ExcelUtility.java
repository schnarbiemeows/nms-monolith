package com.schnarbiesnmeowers.nmsmonolith.utilities.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtility {

    protected static Sheet openExcelWorkBook(String filename, String tabName) {
        FileInputStream file = null;
        Workbook workbook = null;
        Sheet sheet = null;
        try {
            file = new FileInputStream(new File(filename));
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheet(tabName);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getLocalizedMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getLocalizedMessage());
        } catch(Exception e) {
            System.out.println("Exception: " + e.getLocalizedMessage());
        }
        return sheet;
    }


}
