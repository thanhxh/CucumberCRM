package com.thanh.pages;

import com.thanh.keywords.WebUI;
import com.thanh.utils.DataGenerateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

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
        WebUI.clickElement(dropdownDefaultLanguage);
        WebUI.sleep(1);
        WebUI.scrollToElement(By.xpath("//span[normalize-space()='" + nameLanguage + "']"));
        WebUI.sleep(0.5);
        WebUI.clickElement(By.xpath("//span[normalize-space()='" + nameLanguage + "']"));
        WebUI.sleep(0.5);
    }

    public void clickNewCustomer() {
        WebUI.clickElement(buttonNewCustomer);
    }

    public void enterInformation(String nameCompany, String groups, String currency, String nameLanguage, String country) {

        WebUI.setText(inputCompany, nameCompany);
        WebUI.setText(inputVAT, DataGenerateUtils.getRandomVAT());
        WebUI.setText(inputPhoneNumber, DataGenerateUtils.getPhoneNumberLimit());
        WebUI.clickElement(dropdownGroups);
        WebUI.setTextAndKey(searchGroups, groups, Keys.ENTER);
        WebUI.clickElement(dropdownCurrency);
        WebUI.setTextAndKey(searchCurrency, currency, Keys.ENTER);
        languageDefault(nameLanguage);
        WebUI.scrollToElement(inputAddress);

        WebUI.setText(inputAddress, DataGenerateUtils.getFullAddress());
        WebUI.setText(inputCity, DataGenerateUtils.getNameCity());
        WebUI.scrollToElement(inputState);
        WebUI.setText(inputState, DataGenerateUtils.getNameState());
        WebUI.setText(inputZipCode, DataGenerateUtils.getZipCode());
        WebUI.clickElement(dropdownCountry);
        WebUI.setTextAndKey(searchCountry, country, Keys.ENTER);
    }

    public void clickSaveButton() {
        WebUI.clickElement(buttonSave);
    }

    public void checkSearchTableByColumn(int column, String name) {
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);

        //Xác định số dòng của table sau khi search
        List<WebElement> row = WebUI.getWebElements(By.xpath("//table//tbody/tr"));
        int rowTotal = row.size(); //Lấy ra số dòng
        System.out.println("Number lines found: " + rowTotal);
        //Duyệt từng dòng
        for (int i = 1; i <= rowTotal; i++) {
            WebElement elementCheck = WebUI.getWebElement(By.xpath("//table//tbody/tr[" + i + "]/td[" + column + "]"));

            WebUI.scrollToElement(elementCheck);

            System.out.print(name + " - ");
            System.out.println(elementCheck.getText());
            Assert.assertEquals(elementCheck.getText(), name, "Line number " + i + " doesn't contain search value.");
        }

    }

    public void searchCustomer(String nameCompany) {
        WebUI.setTextAndKey(inputSearch, nameCompany, Keys.ENTER);
        WebUI.waitForPageLoaded();
        checkSearchTableByColumn(3, nameCompany);
        WebUI.sleep(2);
    }

    public void clickDeleteButton(int row, int column) {
        WebUI.moveToElement(By.xpath("//tbody/tr[" + row + "]/td[" + column + "]"));
        WebUI.waitForPageLoaded();
        WebUI.clickElement(By.xpath("//tbody/tr[" + row + "]/td[" + column + "]//a[normalize-space()='Delete']"));
    }

    public void clickConfirmDeleteButton() {
        WebUI.sleep(3);
        WebUI.alertAccept();
    }
}
