package com.thanh.pages;

import com.thanh.keywords.WebUI;
import org.openqa.selenium.By;

public class CommonPage {
    public By avatar = By.xpath("//img[contains(@class,'img img-responsive')]");

    public void menuName(String name) {
        WebUI.clickElement(By.xpath("//span[normalize-space()='" + name + "']"));
    }

    public CustomersPage openCustomersPage() {
        menuName("Customers");
        return new CustomersPage();
    }


}
