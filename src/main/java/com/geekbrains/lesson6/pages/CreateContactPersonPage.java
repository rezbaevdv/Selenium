package com.geekbrains.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateContactPersonPage extends BaseView {
    public CreateContactPersonPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(name = "crm_contact[lastName]")
    public WebElement contactLastName;
    public CreateContactPersonPage fillDescriptionLastName(String DescriptionLastName) {
        contactLastName.sendKeys(DescriptionLastName);
        return this;
    }
    @FindBy(name = "crm_contact[firstName]")
    public WebElement contactFirstName;
    public CreateContactPersonPage fillDescriptionFirstName(String DescriptionFirstName) {
        contactFirstName.sendKeys(DescriptionFirstName);
        return this;
    }
    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement selectOrganizationButton;

    public CreateContactPersonPage selectOrganization() {
        selectOrganizationButton.click();
        return this;
    }
    @FindBy(xpath = "//div[@id='select2-drop']/div/input")
    public WebElement inputCompany;

    public CreateContactPersonPage fillDescriptionCompany(String DescriptionCompany) {
        inputCompany.sendKeys(DescriptionCompany);
        return this;
    }
    public CreateContactPersonPage waitResult() {
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new CreateContactPersonPage(driver).selectResultLocator));
        return this;
    }
    public By selectResultLocator = By.xpath("//div[@class='select2-result-label']");
    @FindBy(xpath = "//div[@class='select2-result-label']")
    public WebElement selectResult;
    public CreateContactPersonPage selectResultText() {
        selectResult.click();
        return this;
    }
    @FindBy(name = "crm_contact[jobTitle]")
    public WebElement jobTitle;
    public By jobTitleLocator = By.name("crm_contact[jobTitle]");
    public CreateContactPersonPage fillDescriptionJobTitle(String descriptionJobTitle) {
        jobTitle.sendKeys(descriptionJobTitle);
        return this;
    }
    @FindBy(xpath = "//button[contains(.,'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;
    @FindBy(xpath = contactPersonSavedLocator)
    public WebElement contactPersonSaved;
    public static final String contactPersonSavedLocator =  "//*[text()='Контактное лицо сохранено']";
}

