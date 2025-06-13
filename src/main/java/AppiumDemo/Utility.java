package AppiumDemo;

import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
public void tapOn(AndroidDriver<MobileElement> driver,By locator){
    MobileElement ele=driver.findElement(locator);
    ele.click();
}
    public static Object[][] readExcel(String filePath, String sheetName) throws IOException, IOException {
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
                            case NUMERIC -> (int) cell.getNumericCellValue(); // or use cell.getNumericCellValue() for decimals
                            case BOOLEAN -> cell.getBooleanCellValue();
                            default -> "";
                        };
            }
        }
        workbook.close();
        return data;
    }

    public void tapOn(AndroidDriver<MobileElement> driver, By locator, ExtentTest test, String stepDescription) {
        try {
            MobileElement elem = driver.findElement(locator);
            elem.click();
            logInfo(test, stepDescription + " - clicked successfully");
            test.pass(stepDescription + " - passed");
        } catch (Exception e) {
            logFail(test, stepDescription + " - failed due to: " + e.getMessage());
        }
    }
public void enterValue(String val,String xpath,AndroidDriver<MobileElement> driver){
    MobileElement ele=driver.findElement(By.xpath(xpath));
    ele.click();
    ele.sendKeys(val);
}
    public void enterValue(String value, String xpath, AndroidDriver<MobileElement> driver, ExtentTest test, String field) {
        try {
            driver.findElement(By.xpath(xpath)).sendKeys(value);
            logInfo(test, "Entered value in " + field + ": " + value);
            test.pass("Entered " + value + " in " + field);
        } catch (Exception e) {
            logFail(test, "Failed to enter value in " + field + ": " + e.getMessage());
        }
    }

    public void logInfo(ExtentTest test, String message) {
        test.info(message);
        System.out.println("INFO: " + message);
    }

    public void logPass(ExtentTest test, String message) {
        test.pass(message);
    }

    public void logFail(ExtentTest test, String message) {
        test.fail(message);
    }

    public void verifyIsDisplayed(String xpath, AndroidDriver<MobileElement> driver, ExtentTest test) {
        try {
            boolean status = driver.findElement(By.xpath(xpath)).isDisplayed();
            logStepStatus(test, status, "Element not found: " , "Element visible: " );
        } catch (Exception e) {
            logFail(test, "Verification failed: " + e.getMessage());
        }
    }

    public void logStepStatus(ExtentTest test, boolean condition, String failMessage, String passMessage) {
        if (condition) {
            test.pass(passMessage);
        } else {
            test.fail(failMessage);
        }
    }
    public static String takeScreenshot(AndroidDriver<MobileElement> driver, String testName) {
        File srcFile = driver.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";
        File destFile = new File(path);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

}
