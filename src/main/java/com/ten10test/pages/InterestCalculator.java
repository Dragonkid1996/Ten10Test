package com.ten10test.pages;

import org.openqa.selenium.By;

public class InterestCalculator extends PageBase{

    public By mainLogo = By.className("header-bar");

    public By principalAmountSlider = By.className("custom-range");

    public By interestRateButton = By.className("dropdown-toggle");
    public By interestRateDropDown = By.className("dropdown-menu");
    public By interestRateDropDownButton = By.className("dropdown-item");

    public static By durationDaily = By.linkText("Daily");
    public static By durationMonthly = By.linkText("Monthly");
    public static By durationYearly = By.linkText("Yearly");

    public By durationActive = By.className("active");

    public By consentCheckBox = By.className("form-check-input");

    public By calculateButton = By.className("btn-primary");

    public By interestAmountLabel = By.id("interestAmount");
    public By totalAmountLabel = By.id("totalAmount");
}
