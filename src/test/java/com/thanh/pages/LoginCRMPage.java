package com.thanh.pages;

import com.thanh.constants.ConstantGlobal;
import org.openqa.selenium.By;

import static com.thanh.keywords.WebUI.*;

public class LoginCRMPage extends CommonPage {
    //Khai báo Objects
    private By labelLogin = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By messageAlert = By.xpath("//div[@class='text-center alert alert-danger']");


    //Hàm xử lý đặc trưng cho Login Page
    public void gotoLoginPage() {
        openURL(ConstantGlobal.URL);
        verifyElementVisible(labelLogin);
    }

    public void enterEmailAndPassword(String email, String password) {
        setText(inputEmail, email);
        setText(inputPassword, password);
    }

    public void clickLoginButton() {
        clickElement(buttonLogin);
    }

    public void verifyRedirectToDashboardPage() {
        verifyElementVisible(avatar, "Can not redirect to Dashboard Page");
    }
}
