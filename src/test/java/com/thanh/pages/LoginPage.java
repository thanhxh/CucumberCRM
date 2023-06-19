package com.thanh.pages;

import com.thanh.constants.ConstantGlobal;
import org.openqa.selenium.By;

import static com.thanh.keywords.WebUI.*;

public class LoginPage extends CommonPage {
    //Khai báo Objects
    private By labelLogin = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By messageError = By.xpath("//div[@class='text-center alert alert-danger']");
    private By messageEmpty = By.xpath("//div[@class='alert alert-danger text-center']");
    private By buttonForgotPassword = By.xpath("//a[normalize-space()='Forgot Password?']");
    private By buttonConfỉm = By.xpath("//button[normalize-space()='Confirm']");
    private By messageAfterConfirm = By.xpath("//div[contains(text(),'new password')]");


    //Hàm xử lý đặc trưng cho Login Page
    public void gotoLoginPage() {
        openURL(ConstantGlobal.URL);
        verifyElementVisible(labelLogin);
    }

    public void loginAdminRole() {
        enterEmailAndPassword(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        clickLoginButton();
    }

    public void enterEmailAndPassword(String email, String password) {
        setText(inputEmail, email);
        setText(inputPassword, password);
    }

    public void clickLoginButton() {
        clickElement(buttonLogin);
    }

    public void clickForgotPasswordButton() {
        clickElement(buttonForgotPassword);
    }


    public void clickConfirmButton() {
        clickElement(buttonConfỉm);
        sleep(2);
    }

    public void verifyErrorMessage() {
        verifyElementVisible(messageError, "The error message not visible");
        verifyEquals(getElementText(messageError), "Invalid email or password", "The content of message error not match. ");
    }

    public void verifyRedirectToDashboardPage() {
        verifyElementVisible(avatar, "Can not redirect to Dashboard Page");
    }

    public void enterValidPassword(String password) {
        setText(inputPassword, password);
    }

    public void enterValidUsername(String email) {
        setText(inputEmail, email);
        sleep(2);
    }

    public void verifyEmptyMessagePassword() {
        verifyElementVisible(messageEmpty, "The empty message not visible");
        verifyEquals(getElementText(messageEmpty), "The Password field is required.");
    }

    public void verifyEmptyMessageEmail() {
        verifyElementVisible(messageEmpty, "The empty message not visible");
        verifyEquals(getElementText(messageEmpty), "The Email Address field is required.");
    }

    public void verifyMessageForgotPassword() {
        verifyElementVisible(messageAfterConfirm, "The message after confirm is not visible");
        verifyEquals(getElementText(messageAfterConfirm), "Error setting new password");
    }

}
