package com.geekbrains.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateProject extends BaseView{
    public CreateProject(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[text()='Создать проект']")
    public WebElement createProjectButton;
    public void creteProject() {
        createProjectButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new CreateProjectPage(driver).selectManagerLocator));
    }
    public By createProjectButtonLocator = By.xpath("//a[text()='Создать проект']");
    }
