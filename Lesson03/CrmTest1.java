package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CrmTest1 {
    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        login();
        driver.get("https://crm.geekbrains.space/project/my"); //пользователь на странице мои проекты
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.urlContains("create"));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("crm_project[name]")));
        driver.findElement(By.name("crm_project[name]")).sendKeys("project05");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("crm_project[manager]")));
        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys("Континент+");
        driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();
        driver.findElement(By.xpath("//div[@class='select2-container select2']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys("Frolov");
        driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();
        Select businessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnit.selectByVisibleText("Research & Development");
        Select curator = new Select(driver.findElement(By.name("crm_project[curator]")));
        curator.selectByVisibleText("Ким Юрий");
        Select rp = new Select(driver.findElement(By.name("crm_project[rp]")));
        rp.selectByVisibleText("Гатов Фёдор");
        Select administrator = new Select(driver.findElement(By.name("crm_project[administrator]")));
        administrator.selectByVisibleText("Ямутина Вера");
        Select manager = new Select(driver.findElement(By.name("crm_project[manager]")));
        manager.selectByVisibleText("Палкина Анна");
        driver.findElement(By.xpath("//button[contains(.,'Сохранить и закрыть')]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Проект сохранен']")));
        driver.findElement(By.xpath("//*[text()='Проект сохранен']"));
        Thread.sleep(5000);
        driver.quit();
    }

    private static void login() {
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}