package com.thanh.pages;

import org.openqa.selenium.By;

import static com.thanh.keywords.WebUI.*;


public class ProjectsPage {
    private By buttonNewProject = By.xpath("//a[normalize-space()='New Project']");
    private By inputProjectName = By.xpath("//input[@id='name']");
    private By dropdownCustomer = By.xpath("//label[contains(.,'Customer')]//following-sibling::div//button");
    private By searchCustomer = By.xpath("//div[contains(@class,'bs3 open')]//input[@placeholder='Type to search...']");
    private By inputTotalRate = By.xpath("//input[@id='project_cost']");
    private By inputEstimatedHours = By.xpath("//input[@id='estimated_hours']");


    public void enterSearchCustomer(String nameCustomer) {
        setText(searchCustomer, nameCustomer);
        sleep(0.5);
        clickElement(By.xpath("(//span[normalize-space()='" + nameCustomer + "'])[1]"));
        sleep(0.5);
    }

    public void clickNewProject() {
        clickElement(buttonNewProject);
    }

    public void enterProjectInformation() {
        setText(inputProjectName, "Thanh0001");
        clickElement(dropdownCustomer);
        enterSearchCustomer("Thanh_13062023");
        setText(inputTotalRate, "50");
        sleep(0.5);
        setText(inputEstimatedHours, "7");
        sleep(0.5);
    }

}
