package com.geekbrains.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateContactPerson extends BaseView{
    public CreateContactPerson(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[text()='Создать проект']")
    public WebElement createContactPersonButton;
    public void creteCompanyContact() {
        createContactPersonButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new CreateContactPersonPage(driver).jobTitleLocator));
    }
    public By createContactPersonButtonLocator = By.xpath("//a[text()='Создать проект']");
    }
