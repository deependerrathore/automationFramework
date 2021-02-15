package me.deepender.automation.tests;

import me.deepender.automation.pages.OrangeHRMLoginPage;
import me.deepender.automation.reports.ExtentReport;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class OrangeHRMTests extends BaseTest {
    private OrangeHRMTests() {

    }

    @Test(dataProvider = "LoginLogoutDataProvier")
    public void loginLogout(HashMap<String,String> map) throws InterruptedException {
        String title = new OrangeHRMLoginPage()
                .setUsername(map.get("username")).setPassword(map.get("password")).clickLoginBtn()
                .clickWelcome().clickLogout()
                .getTitle();

        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }

    @DataProvider(name="LoginLogoutDataProvier",parallel = true)
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

