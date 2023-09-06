package com.cc.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class TC_A {
@Test
    public void webTables() throws IOException {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

    driver.get("http://the-internet.herokuapp.com/challenging_dom");
    WebElement h3_dom = driver.findElement(By.xpath("//h3[normalize-space()='Challenging DOM']"));
    h3_dom.isDisplayed();

    List<WebElement> thead =driver.findElements(By.xpath("//table/thead/tr/th"));
    List<String> all_head=new ArrayList<>();

    //Fetch Header
    for(int i=0; i<thead.size()-1; i++) {
        all_head.add(thead.get(i).getText());
        System.out.println(thead.get(i).getText());
    }

    int total_rows=10;
    int total_col=7;
        for (int num_row = 1; num_row < total_rows; num_row++) {
            all_head.add("\n");
            for (int icol = 1; icol < total_col; icol++) {
                System.out.println(num_row+"--"+icol);
                WebElement info = driver.findElement(By.xpath("//table/tbody/tr[" + num_row + "]/td[" + icol + "]"));
                System.out.println(info.getText());
                all_head.add(info.getText());
            }
        }
//6. CSV file name should be webtable_{current_timestamp in MM-DD-YY-HH-MI-SS format}.csv
        SimpleDateFormat sdFormat = new SimpleDateFormat("MM-DD-YY-HH-mm-SS");
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DATE, 0);
        String Date = sdFormat.format(date.getTime());
        String csvfile = System.getProperty("user.dir")+"\\Home\\briq\\"+"webtable_"+Date+".csv";

    FileWriter writer = new FileWriter(csvfile);
    String collect = all_head.stream().collect(Collectors.joining(","));
    System.out.println(collect);

    writer.write(collect);
    writer.close();

driver.quit();


}
}


