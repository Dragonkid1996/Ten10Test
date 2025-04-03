package com.ten10test.pages;

import com.ten10test.GlobalBaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

public class PageBase extends GlobalBaseTest {

    public WebElement findElement(By element) {
        return driver.findElement(element);
    }

    public void findAndClick(By element) {
        WebElement el = findElement(element);

        try {
            el.click();
        } catch (Exception e) {
            scrollToBottomOfPage(el);
            el.click();
        }
    }

    public void findAndClickInDropDown(By element) {
        WebElement el = findElement(element);

        try {
            el.click();
        } catch (Exception e) {
            scrollFromElement(el);
            el.click();
        }
    }

    public void sendKeys(By element, String text) {
        findElement(element).sendKeys(text);
    }

    public void clearElement(By element) {
        findElement(element).clear();
    }

    public Alert changeToAlert() {
        return driver.switchTo().alert();
    }

    public String getAlertText() {
        return changeToAlert().getText();
    }

    public void moveSlider(By element, int moveAmount) throws InterruptedException {
        new Actions(driver)
                .moveToElement(findElement(element))
                .clickAndHold()
                .moveByOffset(moveAmount, 0)
                .release()
                .perform();
        Thread.sleep(3500);
    }

    public void clickInterestRateElement(int interestRate) {
        By interestRateBy = By.id("rate-" + interestRate + "%");
        findAndClickInDropDown(interestRateBy);
    }

    public boolean isCheckboxChecked(By element) {
        return Boolean.parseBoolean(findElement(element).getDomProperty("checked"));
    }

    public void scrollToBottomOfPage(WebElement element) {
        new Actions(driver)
                .scrollToElement(element)
                .perform();
    }

    public void scrollFromElement(WebElement element) {
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(element);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 200)
                .perform();
    }
}
