package com.cc.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TC_B {
@Test
    public void test() {

        String pathdwn = System.getProperty("user.dir")+"\\src\\main\\java\\com\\cc\\dataFiles";

    ChromeOptions options = new ChromeOptions();
    Map<String, Object> prefs = new HashMap<String, Object>();
    prefs.put("download.default_directory", pathdwn);
    options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/download");

        driver.findElement(By.xpath("//a[normalize-space()='BugattiNegro.jpg']")).click();

        driver.get("https://the-internet.herokuapp.com/upload");

    WebElement input_upload = driver.findElement(By.xpath("//input[@id='file-upload']"));
            input_upload.isDisplayed();
    input_upload.sendKeys(pathdwn+"\\BugattiNegro.jpg");

    driver.findElement(By.xpath("//input[@id='file-submit']")).click();

    driver.findElement(By.xpath("//h3[normalize-space()='File Uploaded!']")).isDisplayed();

    String name = driver.findElement(By.xpath("//div[@id='uploaded-files']")).getText();
    System.out.println("File Uploaded: "+name);
    }
}
