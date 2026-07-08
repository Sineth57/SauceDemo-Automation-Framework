import base.BaseClass;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;

public class LoginTests extends BaseClass{


    @DataProvider(name = "loginData")
    public Object[][] getExcelData() throws IOException {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testData\\Logincredentials.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int totalRows = sheet.getLastRowNum();
        int totalColumns = sheet.getRow(0).getLastCellNum();

        Object[][] testData = new Object[totalRows][totalColumns];

        for (int r = 1; r <= totalRows; r++) {
            XSSFRow row = sheet.getRow(r);
            for (int c = 0; c < totalColumns; c++) {
                XSSFCell cell = row.getCell(c);
                testData[r - 1][c] = cell.toString();
            }
        }

        workbook.close();
        file.close();

        return testData;
    }


    @Test(dataProvider = "loginData")
    public void loginTestScenario(String userName, String password, String expectedValidation) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName, password);

        Thread.sleep(3000);

        boolean urlVerification = driver.getCurrentUrl().contains("inventory");

        if (expectedValidation.equalsIgnoreCase("valid")) {
            Assert.assertTrue(urlVerification, "Expected login success and navigated to products dashboard");
        } else {
            Assert.assertFalse(urlVerification, "Expected login failed but navigated to products dashboard");
        }
    }





}
