package com.thanh.pages;

import org.openqa.selenium.By;

import static com.thanh.keywords.WebUI.*;

public class CommonPage {
    public By avatar = By.xpath("//img[contains(@class,'img img-responsive')]");
    public By inputSearch = By.xpath("(//input[contains(@placeholder,'Search')])[2]");
    public By emptyDataInTable = By.xpath("//tbody//tr//td[contains(text(),'No matching')]");

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

    public void clickDeleteButton(int row, int column) {
        scrollToElement(By.xpath("//tbody/tr[" + row + "]/td[" + column + "]"));
        moveToElement(By.xpath("//tbody/tr[" + row + "]/td[" + column + "]"));
        waitForPageLoaded();
        clickElement(By.xpath("//tbody/tr[" + row + "]/td[" + column + "]//a[normalize-space()='Delete']"));
    }

    public void clickConfirmDeleteButton() {
        sleep(3);
        alertAccept();
    }


}
