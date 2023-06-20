package com.thanh.pages;

import org.openqa.selenium.By;

import static com.thanh.keywords.WebUI.clickElement;

public class CommonPage {
    public By avatar = By.xpath("//img[contains(@class,'img img-responsive')]");

    public void menuName(String name) {
        clickElement(By.xpath("//span[normalize-space()='" + name + "']"));
    }

    public CustomersPage openCustomersPage() {
        menuName("Customers");
        return new CustomersPage();
    }

    public ProjectsPage openProjectsPage() {
        menuName("Projects");
        return new ProjectsPage();
    }


}
