package com.geekbrains.lesson6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class CompanySubMenu extends BaseView{

    public CompanySubMenu(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[text()='Контактные лица']")
    public WebElement companyContactUsersButton;
    public void creteCompanyContact() {
      companyContactUsersButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new CreateContactPerson(driver).createContactPersonButtonLocator));
    }
}
