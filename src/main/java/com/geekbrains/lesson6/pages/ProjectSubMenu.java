package com.geekbrains.lesson6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectSubMenu extends BaseView {

    public ProjectSubMenu(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[text()='Мои проекты']")
    public WebElement companyProjectButton;
    public void creteProject() {
        companyProjectButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new CreateProject(driver).createProjectButtonLocator));
    }
}
