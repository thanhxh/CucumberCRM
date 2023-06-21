package com.thanh.pages;

import com.thanh.utils.DataGenerateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.thanh.keywords.WebUI.*;


public class ProjectsPage extends CommonPage {
    private By buttonNewProject = By.xpath("//a[normalize-space()='New Project']");
    private By inputProjectName = By.xpath("//input[@id='name']");
    private By dropdownCustomer = By.xpath("//label[contains(.,'Customer')]//following-sibling::div//button");
    private By searchCustomer = By.xpath("//div[contains(@class,'bs3 open')]//input[@placeholder='Type to search...']");
    private By inputTotalRate = By.xpath("//input[@id='project_cost']");
    private By inputEstimatedHours = By.xpath("//input[@id='estimated_hours']");
    private By startDate = By.xpath("//input[@id='start_date']");
    private By deadLine = By.xpath("//input[@id='deadline']");
    private By frameDescription = By.xpath("//iframe[@id='description_ifr']");
    private By inputDescription = By.xpath("//body");
    private By buttonSave = By.xpath("//button[normalize-space()='Save']");


    public void enterSearchCustomer(String nameCustomer) {
        setText(searchCustomer, nameCustomer);
        sleep(0.5);
        clickElement(By.xpath("(//span[normalize-space()='" + nameCustomer + "'])[1]"));
        sleep(0.5);
    }

    public void clickNewProject() {
        clickElement(buttonNewProject);
    }

    public void dayOfStartDate(String numberDay) {
        clickElement(startDate);
        sleep(2);
        clickElement(By.xpath("//div[@class='xdsoft_calendar']//table//tbody//tr//td[normalize-space()='" + numberDay + "']"));
        sleep(0.5);
    }

    public void dayOfDeadline(String numberDay, String value) {
        clickElement(deadLine);
        sleep(2);
        clickElement(By.xpath("(//div[@class='xdsoft_calendar']//table//tbody//tr//td[normalize-space()='" + numberDay + "'])[" + value + "]"));
        sleep(0.5);
    }

    public void enterProjectInformation(String projectName, String customerName, String totalRate, String estimatedHours) {
        setText(inputProjectName, projectName);
        clickElement(dropdownCustomer);
        enterSearchCustomer(customerName);
        setText(inputTotalRate, totalRate);
        sleep(0.5);
        setText(inputEstimatedHours, estimatedHours);
        sleep(0.5);
        scrollToElement(startDate);
        dayOfStartDate("20");
        dayOfDeadline("22", "2");
        switchToFrameByElement(frameDescription);
        setText(inputDescription, DataGenerateUtils.getRandomString(20));
        sleep(1);
        switchToExitFrame();
    }

    public void clickSaveButton() {
        clickElement(buttonSave);
        sleep(1);
    }

    public void searchProject(String statusName, String projectName) {
        clickElement(By.xpath("//a//span[normalize-space()='" + statusName + "']"));
        sleep(1);
        setTextAndKey(inputSearch, projectName, Keys.ENTER);
        waitForPageLoaded();
        checkSearchTableByColumn(2, projectName);
        sleep(2);
    }

    public void clickEditButton(int row, int column) {
        scrollToElement(By.xpath("//tbody/tr[" + row + "]/td[" + column + "]"));
        moveToElement(By.xpath("//tbody/tr[" + row + "]/td[" + column + "]"));
        waitForPageLoaded();
        clickElement(By.xpath("//tbody/tr[" + row + "]/td[" + column + "]//a[normalize-space()='Edit']"));
    }

    public void editProjectInformation(String projectName, String totalRate, String estimatedHours) {
        clearAndFillText(inputProjectName, projectName);
        clickElement(dropdownCustomer);
        clearAndFillText(inputTotalRate, totalRate);
        sleep(0.5);
        clearAndFillText(inputEstimatedHours, estimatedHours);
        sleep(0.5);
        switchToFrameByElement(frameDescription);
        clearAndFillText(inputDescription, DataGenerateUtils.getRandomString(100));
        sleep(1);
        switchToExitFrame();
    }

    public void reSearchProject(String statusName, String projectName) {
        clickElement(By.xpath("//a//span[normalize-space()='" + statusName + "']"));
        sleep(1);
        setTextAndKey(inputSearch, projectName, Keys.ENTER);
        waitForPageLoaded();
        sleep(2);
        verifyEquals(getElementText(emptyDataInTable), "No matching records found");
    }

}
