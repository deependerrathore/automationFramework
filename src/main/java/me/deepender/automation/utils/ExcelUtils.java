package me.deepender.automation.utils;

import me.deepender.automation.constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class ExcelUtils {
    private ExcelUtils() {

    }

    //TODO: Try with resources

    public static List<Map<String, String>> qgetTestDetails() {
        List<Map<String, String>> list = null;
        FileInputStream file = null;
        try {
            file = new FileInputStream(FrameworkConstants.getExcelPath());
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet("RUNNERSHEET");

            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();

            Map<String, String> map = null;
            list = new ArrayList<>();
            for (int i = 1; i <= rowCount; i++) {
                map = new HashMap<>();
                for (int j = 0; j < colCount; j++) {
                    map.put(sheet.getRow(0).getCell(j).getStringCellValue(), sheet.getRow(i).getCell(j).getStringCellValue());
                }
                list.add(map);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (Objects.nonNull(file))
                    file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
