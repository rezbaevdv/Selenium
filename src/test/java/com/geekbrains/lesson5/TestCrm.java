package com.geekbrains.lesson5;
import io.github.bonigarcia.wdm.WebDriverManager;
//import lesson4.BoxTests;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

//import static lesson5.BackGroundColor.hasColor;
//import static lesson5.CustomExpectedConditions.elementFirstInCollection;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
//import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

    public class TestCrm {
        WebDriver driver;
        WebDriverWait webDriverWait;
        private static final String BASE_URL = "https://crm.geekbrains.space/";

        @BeforeSuite
        void setupDataBase() {
            System.out.println("Before suite setup database");
        }

        @BeforeTest
        void setUp() {
            WebDriverManager.chromedriver().setup();
        }

        @BeforeMethod
        void setUpBrowser() {
            driver = new ChromeDriver();
            webDriverWait = new WebDriverWait(driver, 5);
            driver.get(BASE_URL);
            login();
        }
        @Test
                (description = "Сохранить новое конактное лицо в crm", enabled = true)
        void saveNewContactTest() throws InterruptedException {
        Actions move = new Actions(driver);
        WebElement contractor = driver.findElement(By.xpath("//span[text()='Контрагенты']/ancestor::a"));
        move.moveToElement(contractor).build().perform();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//span[text()='Контактные лица']/ancestor::a")));
        driver.findElement(By.xpath("//span[text()='Контактные лица']/ancestor::a")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//a[text()='Создать контактное лицо']")));
        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                    By.name("crm_contact[lastName]")));
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Резбаев");
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Д.В.");
        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys("Континент+");
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[@class='select2-result-label']")));
        driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("QA");
        driver.findElement(By.xpath("//button[contains(.,'Сохранить и закрыть')]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[text()='Контактное лицо сохранено']")));
        driver.findElement(By.xpath("//*[text()='Контактное лицо сохранено']"));
            Thread.sleep(2000);
    }
        @Test
                (description = "Сохранить новый проект в crm", enabled = true)
        void saveNewProjectTest() throws InterruptedException {
            driver.get("https://crm.geekbrains.space/project/my"); //пользователь на странице мои проекты
            driver.findElement(By.xpath("//a[text()='Создать проект']")).click();
            WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
            webDriverWait.until(ExpectedConditions.urlContains("create"));
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("crm_project[name]")));
            driver.findElement(By.name("crm_project[name]")).sendKeys("project09");
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("crm_project[manager]")));
            driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
            driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys("Континент+");
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[@class='select2-result-label']")));
            driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[@class='select2-container select2']")));
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
            Thread.sleep(2000);
        }
        @Test
                (description = "Демонстация actions в crm", enabled = true)
        void dragAndDropTest() throws InterruptedException {
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath("//i[@class='icon-bar-chart']//ancestor::span[@class]")))
                    .build()
                    .perform();
            driver.findElement(By.xpath("//span[text()='Управение панелями инструментов']")).click();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Настройки представления']")));
            driver.findElement(By.xpath("//a[@title='Настройки представления']")).click();
            actions.clickAndHold(driver.findElement(By.xpath("//label[text()='Наименование']//ancestor::tr//span[@title='Move column']")))
                    .dragAndDrop(driver.findElement(By.xpath("//label[text()='Наименование']//ancestor::tr")),
                            driver.findElement(By.xpath("//label[text()='Владелец']//ancestor::tr")))
                    .build()
                    .perform();
            Thread.sleep(2000);
        }
        private void login() {
            driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
            driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
            driver.findElement(By.id("_submit")).click();
        }
        @AfterMethod
        void closeBrowser() {
            driver.quit();
        }
    }
