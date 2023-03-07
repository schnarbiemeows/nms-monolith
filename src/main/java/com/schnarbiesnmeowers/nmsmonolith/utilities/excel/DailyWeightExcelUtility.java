package com.schnarbiesnmeowers.nmsmonolith.utilities.excel;

import com.schnarbiesnmeowers.nmsmonolith.pojos.DailyWeight;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DailyWeightExcelUtility extends ExcelUtility {


    public static List<DailyWeight> processFile(String filepath, int userId, String tabName, int columnNumber) {
        Sheet sheet = openExcelWorkBook(filepath,tabName);
        List<DailyWeight> spreadsheetRecords = getRecordsFromSheet(sheet,userId,1,columnNumber);
        return spreadsheetRecords;
    }

    private static List<DailyWeight> getRecordsFromSheet(Sheet sheet,int userId, int i, int columnNumber) {
        List<DailyWeight> weightRecords = new ArrayList();
        for (Row row : sheet) {
            if(row!=null&&
                    null!=row.getCell(2)&&row.getCell(2).getNumericCellValue()>0.0d&&
                    null!=row.getCell(1)) {
                DailyWeight dw = new DailyWeight();
                try {
                    //dw.setCalendarDate(row.getCell(1).getDateCellValue());
                    dw.setWeight(BigDecimal.valueOf(row.getCell(2).getNumericCellValue()));
                    dw.setUserId(userId);
                    weightRecords.add(dw);
                } catch(NullPointerException np) {
                    System.out.println("NullPointerException: " + np.getLocalizedMessage());
                } catch(Exception ex) {
                    System.out.println("Exception: " + ex.getLocalizedMessage());
                }


            }
        }
        return weightRecords;
    }


}
