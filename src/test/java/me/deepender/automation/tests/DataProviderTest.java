package me.deepender.automation.tests;

import me.deepender.automation.enums.ConfigProperties;
import me.deepender.automation.utils.JsonUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DataProviderTest {
    @Test(dataProvider = "getData")
    public void test1(HashMap<String, String> map) throws IOException {
        System.out.println(map.get("username") + "|" + map.get("password") + "|" + map.get("firstname") + "|");
    }

    @Test
    public void testJsonUtil() throws Exception {
        System.out.println(JsonUtils.getValueFromMap(ConfigProperties.URL));
    }

    @DataProvider
    public Object[] getData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/excel/testData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("testdata");
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        System.out.println(rowCount + "         " + colCount);
        Object[] data = new Object[rowCount];
        Map<String, String> map;
        for (int i = 1; i <= rowCount; i++) {
            map = new HashMap<>();
            for (int j = 0; j < colCount; j++) {
                map.put(sheet.getRow(0).getCell(j).getStringCellValue(), sheet.getRow(i).getCell(j).getStringCellValue());
                data[i - 1] = map;
            }
        }
        return data;
    }
}
