package com.geekbrains.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseView {

   public NavigationMenuElement navigationMenuElement;
    public MainPage(WebDriver driver) {
        super(driver);
        navigationMenuElement = new NavigationMenuElement(driver);
    }
    @FindBy(xpath = "//a[@title='Geekbrains']")
    public WebElement geekBrainsHomeButton;
    public By geekBrainsHomeButtonLocator = By.xpath("//a[@title='Geekbrains']");
}
