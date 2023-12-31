package com.thanh.pages;

import com.thanh.utils.DataGenerateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.thanh.keywords.WebUI.*;

public class CustomersPage extends CommonPage {
    private By buttonNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputVAT = By.xpath("//input[@id='vat']");
    private By inputPhoneNumber = By.xpath("//input[@id='phonenumber']");
    private By dropdownGroups = By.xpath("//label[normalize-space()='Groups']//following-sibling::div");
    private By labelGroups = By.xpath("//label[normalize-space()='Groups']");
    private By searchGroups = By.xpath("(//input[contains(@type,'search')])[2]");
    private By buttonDeselectAll = By.xpath("//button[normalize-space()='Deselect All']");
    private By dropdownCurrency = By.xpath("//label[normalize-space()='Currency']//following-sibling::div");
    private By searchCurrency = By.xpath("(//input[contains(@type,'search')])[3]");
    private By dropdownDefaultLanguage = By.xpath("//label[contains(.,'Default')]//following-sibling::div");
    private By inputAddress = By.xpath("//textarea[@id='address']");

    private By inputCity = By.id("city");
    private By inputState = By.id("state");
    private By inputZipCode = By.xpath("//input[@id='zip']");
    private By dropdownCountry = By.xpath("//label[@for='country']//following-sibling::div");
    private By searchCountry = By.xpath("(//input[contains(@type,'search')])[4]");
    private By buttonSaveAdd = By.xpath("(//button[normalize-space()='Save'])[2]");

    //Delete


    //Edit
    private By buttonSaveEdit = By.xpath("(//button[normalize-space()='Save'])[3]");


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

    public void enterInformation(String companyName, String groups, String currency, String nameLanguage, String country) {

        setText(inputCompany, companyName);
        setText(inputVAT, DataGenerateUtils.getRandomVAT());
        setText(inputPhoneNumber, DataGenerateUtils.getPhoneNumberLimit());
//        clickElement(dropdownGroups);
//        setTextAndKey(searchGroups, groups, Keys.ENTER);
//        clickElement(labelGroups);
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

    public void clickSaveButtonAdd() {
        clickElement(buttonSaveAdd);
    }

    public void clickSaveButtonEdit() {
        clickElement(buttonSaveEdit);
    }

    public void searchCustomer(String companyName) {
        setTextAndKey(inputSearch, companyName, Keys.ENTER);
        waitForPageLoaded();
        checkSearchTableByColumn(3, companyName);
        sleep(2);
    }

    public void reSearchCustomer(String companyName) {
        setTextAndKey(inputSearch, companyName, Keys.ENTER);
        waitForPageLoaded();
        sleep(2);
        verifyEquals(getElementText(emptyDataInTable), "No matching records found");
    }

    public void clickViewButton(int row, int column) {
        scrollToElement(By.xpath("//tbody/tr[" + row + "]/td[" + column + "]"));
        moveToElement(By.xpath("//tbody/tr[" + row + "]/td[" + column + "]"));
        waitForPageLoaded();
        clickElement(By.xpath("//tbody/tr[" + row + "]/td[" + column + "]//a[normalize-space()='View']"));
    }

    public void editInformation(String companyName, String groups, String currency, String nameLanguage, String country) {

        clearAndFillText(inputCompany, companyName);
        clearAndFillText(inputVAT, DataGenerateUtils.getRandomVAT());
        clearAndFillText(inputPhoneNumber, DataGenerateUtils.getPhoneNumberLimit());
//        clickElement(dropdownGroups);
//        clickElement(buttonDeselectAll);
//        setTextAndKey(searchGroups, groups, Keys.ENTER);
//        clickElement(labelGroups);
        clickElement(dropdownCurrency);
        setTextAndKey(searchCurrency, currency, Keys.ENTER);
        languageDefault(nameLanguage);
        scrollToElement(inputAddress);
        clearAndFillText(inputAddress, DataGenerateUtils.getFullAddress());
        clearAndFillText(inputCity, DataGenerateUtils.getNameCity());
        scrollToElement(inputState);
        clearAndFillText(inputState, DataGenerateUtils.getNameState());
        clearAndFillText(inputZipCode, DataGenerateUtils.getZipCode());
        clickElement(dropdownCountry);
        setTextAndKey(searchCountry, country, Keys.ENTER);
    }
}

