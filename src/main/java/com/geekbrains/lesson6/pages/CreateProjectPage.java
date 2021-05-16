package com.geekbrains.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateProjectPage extends BaseView {
    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(name = "crm_project[name]")
    public WebElement projectName;
    public CreateProjectPage fillDescriptionName(String DescriptionName) {
        projectName.sendKeys(DescriptionName);
        return this;
    }
    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement selectOrganizationButton;
    public CreateProjectPage selectOrganization() {
        selectOrganizationButton.click();
        return this;
    }
    @FindBy(xpath = "//div[@id='select2-drop']/div/input")
    public WebElement inputCompany;
    public CreateProjectPage fillDescriptionCompany(String DescriptionCompany) {
        inputCompany.sendKeys(DescriptionCompany);
        return this;
    }
    public CreateProjectPage waitResult() {
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new CreateProjectPage(driver).selectResultLocator));
        return this;
    }

    @FindBy(xpath = "//div[@class='select2-result-label']")
    public WebElement selectResult;
    public By selectResultLocator = By.xpath("//div[@class='select2-result-label']");
    public CreateProjectPage selectResultText() {
        selectResult.click();
        return this;
    }
    public CreateProjectPage waitResultPrimaryContact() {
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        new CreateProjectPage(driver).primaryContactPersonButtonLocation));
        return this;
    }

    @FindBy(xpath = "//div[@class='select2-container select2']")
    public WebElement primaryContactPersonButton;
    public By primaryContactPersonButtonLocation = By.xpath("//div[@class='select2-container select2']");
    public CreateProjectPage primaryContactPerson() {
        primaryContactPersonButton.click();
        return this;
    }
    @FindBy(xpath = "//div[@id='select2-drop']/div/input")
    public WebElement inputPrimaryContact;
    public CreateProjectPage fillDescriptionPrimaryContact(String DescriptionPrimaryContact) {
        inputPrimaryContact.sendKeys(DescriptionPrimaryContact);
        return this;
    }
    @FindBy(name = "crm_project[businessUnit]")
    public WebElement selectBusinessUnit;
    public CreateProjectPage selectBusinessUnitText(String businessUnitText) {
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        new CreateProjectPage(driver).selectOptionLocator));
        selectBusinessUnit.sendKeys(businessUnitText);
        return this;
    }
    @FindBy(name = "crm_project[curator]")
    public WebElement selectCurator;
    public CreateProjectPage selectCuratorText(String curatorText) {
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        new CreateProjectPage(driver).selectOptionLocator));
        selectCurator.sendKeys(curatorText);
        return this;
    }

    public By selectOptionLocator = By.xpath("//*[@name]/option[@selected]");
    public CreateProjectPage waitSelectOptionFrame() {
        return this;
    }

    @FindBy(name = "crm_project[rp]")
    public WebElement selectProjectManager;
    public CreateProjectPage selectProjectManagerText(String projectManagerText) {
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        new CreateProjectPage(driver).selectOptionLocator));
        selectProjectManager.sendKeys(projectManagerText);
        return this;
    }

    @FindBy(name = "crm_project[administrator]")
    public WebElement selectAdministrator;
    public CreateProjectPage selectAdministratorText(String administratorText) {
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        new CreateProjectPage(driver).selectOptionLocator));
        selectAdministrator.sendKeys(administratorText);
        return this;
    }

    @FindBy(name = "crm_project[manager]")
    public WebElement selectManager;
    public By selectManagerLocator = By.name("crm_project[curator]");
    public CreateProjectPage selectManagerText(String managerText) {
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        new CreateProjectPage(driver).selectOptionLocator));
        selectManager.sendKeys(managerText);
        return this;
    }
    @FindBy(xpath = "//button[contains(.,'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;
    @FindBy(xpath = projectSavedLocator)
    public WebElement projectSaved;
    public static final String projectSavedLocator =  "//*[text()='Проект сохранен']";
}

