package com.scope;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mahadev.b\\Desktop\\driver\\chromedriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        /// (//div[@class='a-cardui-body']/div[1]/div[1]/a)[2] amezon
        ////div[@id="desktop-grid-2"]/div/div[2]/div[1]/div[2]amezon



        //1.Give me a count of a link on a page
        //2.get the count of the link in the footer section
        //3. get the total number of links in first column in footer section
        //4. click on each link on column and see the new windows are opening or not
        //5. get the title of every page
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> linkList = driver.findElements(By.tagName("a"));
        int linkCount = linkList.size();
        System.out.println(linkCount);

        //2.get the count of the link in the footer section
        WebElement footerDriver = driver.findElement(By.id("gf-BIG")); //Limiting web driver scope
        System.out.println(footerDriver.findElements(By.tagName("a")).size());
        System.out.println(driver.findElements(By.xpath("//div[@id = 'gf-BIG'] //a")).size());

        //3. get the total number of links in first column in footer section

        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());

        //4. click on each link on column and see the new windows are opening or not
        for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {
            String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
//            System.out.println(columnDriver.findElements(By.tagName("a")).get(i).getText());

        }

        //5. get the title of every page
        Thread.sleep(5000);
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());

        }

    }
}
