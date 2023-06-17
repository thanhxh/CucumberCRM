package com.thanh.pages;

import com.thanh.utils.DataGenerateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.thanh.keywords.WebUI.*;

public class CustomersPage {
    private By buttonNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputVAT = By.xpath("//input[@id='vat']");
    private By inputPhoneNumber = By.xpath("//input[@id='phonenumber']");
    private By dropdownGroups = By.xpath("//label[normalize-space()='Groups']//following-sibling::div");
    private By searchGroups = By.xpath("(//input[contains(@type,'search')])[2]");
    private By dropdownCurrency = By.xpath("//label[normalize-space()='Currency']//following-sibling::div");
    private By searchCurrency = By.xpath("(//input[contains(@type,'search')])[3]");
    private By dropdownDefaultLanguage = By.xpath("//label[contains(.,'Default')]//following-sibling::div");
    private By inputAddress = By.xpath("//textarea[@id='address']");

    private By inputCity = By.id("city");
    private By inputState = By.id("state");
    private By inputZipCode = By.xpath("//input[@id='zip']");
    private By dropdownCountry = By.xpath("//label[@for='country']//following-sibling::div");
    private By searchCountry = By.xpath("(//input[contains(@type,'search')])[4]");
    private By buttonSave = By.xpath("(//button[normalize-space()='Save'])[2]");
    private By inputSearch = By.xpath("(//input[contains(@placeholder,'Search')])[2]");

    private void languageDefault(String nameLanguage) {
        clickElement(dropdownDefaultLanguage);
        sleep(1);
        scrollToElement(By.xpath("//span[normalize-space()='" + nameLanguage + "']"));
        sleep(0.5);
        clickElement(By.xpath("//span[normalize-space()='" + nameLanguage + "']"));
        sleep(0.5);
    }

    public void clickNewCustomer() {
        clickElement(buttonNewCustomer);
    }

    public void enterInformation(String nameCompany, String groups, String currency, String nameLanguage, String country) {

        setText(inputCompany, nameCompany);
        setText(inputVAT, DataGenerateUtils.getRandomVAT());
        setText(inputPhoneNumber, DataGenerateUtils.getPhoneNumberLimit());
        clickElement(dropdownGroups);
        setTextAndKey(searchGroups, groups, Keys.ENTER);
        clickElement(dropdownCurrency);
        setTextAndKey(searchCurrency, currency, Keys.ENTER);
        languageDefault(nameLanguage);
        scrollToElement(inputAddress);

        setText(inputAddress, DataGenerateUtils.getFullAddress());
        setText(inputCity, DataGenerateUtils.getNameCity());
        scrollToElement(inputState);
        setText(inputState, DataGenerateUtils.getNameState());
        setText(inputZipCode, DataGenerateUtils.getZipCode());
        clickElement(dropdownCountry);
        setTextAndKey(searchCountry, country, Keys.ENTER);
    }

    public void clickSaveButton() {
        clickElement(buttonSave);
    }


    public void searchCustomer(String nameCompany) {
        setTextAndKey(inputSearch, nameCompany, Keys.ENTER);
        waitForPageLoaded();
        checkSearchTableByColumn(3, nameCompany);
        sleep(2);
    }

    public void clickDeleteButton(int row, int column) {
        moveToElement(By.xpath("//tbody/tr[" + row + "]/td[" + column + "]"));
        waitForPageLoaded();
        clickElement(By.xpath("//tbody/tr[" + row + "]/td[" + column + "]//a[normalize-space()='Delete']"));
    }

    public void clickConfirmDeleteButton() {
        sleep(3);
        alertAccept();
    }
}
