package com.geekbrains.lesson6;

import com.geekbrains.lesson6.pages.*;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.geekbrains.lesson6.Configuration.BASE_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;


public class LoginWithPageObjectTests extends BaseTest{

    @BeforeEach
    public void goToPage () {
        driver.get(BASE_URL);
    }


    void loginTest() {
        loginPage.inputLogin.sendKeys("Applanatest1");
        loginPage.inputPassword.sendKeys("Student2020!");
        loginPage.buttonSubmit.click();
    }

    void loginTestWithFluentPage() {
                new LoginPage(driver).fillInputLogin("Applanatest1").fillInputPassword("Student2020!").submitLogin();
    }
    @Test
    @Feature("Тестирование создание нового контактного лица")
    void createNewCompanyContactUser() throws InterruptedException {
        new LoginPage(driver).login("Applanatest1","Student2020!")
                .navigationMenuElement.openNavigationItem("Контрагенты");
        new CompanySubMenu(driver).creteCompanyContact();
        new CreateContactPerson(driver).creteCompanyContact();
        new CreateContactPersonPage(driver)
                .fillDescriptionLastName("Резбаев")
                .fillDescriptionFirstName("Danil")
                .selectOrganization()
                .fillDescriptionCompany("Континент+")
                .waitResult()
                .selectResultText()
                .fillDescriptionJobTitle("QA")
                .saveAndCloseButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(CreateContactPersonPage.contactPersonSavedLocator)));
        assertThat(new CreateContactPersonPage(driver).contactPersonSaved, isDisplayed());
    }

    @Feature("Тестирование создание нового проекта")
    @Test
    void createNewProject() throws InterruptedException {
        new LoginPage(driver).login("Applanatest1","Student2020!")
                .navigationMenuElement.openNavigationItem("Проекты");
        new ProjectSubMenu(driver).creteProject();
        new CreateProject(driver).creteProject();
        new CreateProjectPage(driver)
                .fillDescriptionName("проект15")
                .selectOrganization()
                .fillDescriptionCompany("Континент")
                .waitResult()
                .selectResultText()
                .waitResultPrimaryContact()
                .primaryContactPerson()
                .fillDescriptionPrimaryContact("Frolov")
                .waitResult()
                .selectResultText()
                .selectBusinessUnitText("Research & Development")
                .selectCuratorText("Ким Юрий")
                .selectProjectManagerText("Гатов Фёдор")
                .selectAdministratorText("Ямутина Вера")
                .selectManagerText("Палкина Анна")
                .saveAndCloseButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(CreateProjectPage.projectSavedLocator)));
        assertThat(new CreateProjectPage(driver).projectSaved, isDisplayed());
    }
}
