package AppiumDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;

public class Utility {
    public ExtentReports extent;
    ExtentTest test;
    MobileElement element;
    public static Object[][] readExcel(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;

            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                data[i - 1][j] = (cell == null) ? "" :
                        switch (cell.getCellType()) {
                            case STRING -> cell.getStringCellValue();
                            case NUMERIC -> DateUtil.isCellDateFormatted(cell)
                                    ? cell.getDateCellValue().toString()
                                    : (cell.getNumericCellValue() % 1 == 0)
                                    ? String.valueOf((int) cell.getNumericCellValue())
                                    : String.valueOf(cell.getNumericCellValue());
                            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
                            case FORMULA -> cell.getCellFormula();
                            default -> cell.toString();
                        };
            }
        }

        workbook.close();
        fis.close();
        return data;
    }

    public void tapOn(AndroidDriver<MobileElement> driver, String xpath) {
        driver.findElementByXPath(xpath).click();
    }

    public void enterValue(String value, String xpath, AndroidDriver<MobileElement> driver) {
        element = driver.findElementByXPath(xpath);
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    public void verifyIsPresent(String actual, String expected, ExtentTest test) {
        try {
            Assert.assertEquals(actual.trim(), expected.trim());
            test.pass("Match Passed: Expected = " + expected + ", Actual = " + actual);
        } catch (AssertionError e) {
            test.fail("Match Failed: Expected = " + expected + ", Actual = " + actual);
            Assert.fail("Match Failed: Expected = " + expected + ", Actual = " + actual); // To fail test
        }
    }


    public void verifyIsDisplayed(String path,AndroidDriver<MobileElement> driver,ExtentTest test){
        try{
            element= driver.findElementByXPath(path);
            Assert.assertTrue(element.isDisplayed());
            test.pass("Element displayed");
        }
        catch (AssertionError e){
            test.fail("Element not displayed");
            Assert.fail("Element not displayed");
        }
    }
    public void verifyAndLog(SoftAssert softAssert, String actual, String expected, String fieldName) {
        if (actual.equalsIgnoreCase(expected)) {
            test.log(Status.PASS, fieldName + " matched: " + actual);
        } else {
            test.log(Status.FAIL, fieldName + " mismatch. Expected: " + expected + ", Found: " + actual);
            softAssert.fail(fieldName + " mismatch"); // triggers failure
        }
    }

}
