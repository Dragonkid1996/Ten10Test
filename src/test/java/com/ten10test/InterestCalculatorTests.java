package com.ten10test;

import com.ten10test.pages.InterestCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InterestCalculatorTests extends InterestCalculator {

    @BeforeEach
    void setup() {
        new LoginTests().loginToPage();
    }

    @ParameterizedTest(name = "I can input the principal amount")
    @ValueSource(ints = {-125, -50, 10, 75, 100})
    void inputPrincipalAmount(int principalAmountSlide) throws InterruptedException {
        assertNotNull(findElement(mainLogo));
        moveSlider(principalAmountSlider, principalAmountSlide);
        findElement(principalAmountSlider);
    }

    @ParameterizedTest(name = "I can select the duration for interest")
    @MethodSource("inputDurationElements")
    void inputDuration(By durationElement) {
        findAndClick(durationElement);
        assertEquals(findElement(durationActive), findElement(durationElement));
    }

    @ParameterizedTest(name = "I can select a {0} interest rate")
    @ValueSource(ints = {1, 4, 8, 12, 15})
    void inputInterestRate(int interestRate) {
        findAndClick(interestRateButton);
        assertNotNull(interestRateDropDown);
        clickInterestRateElement(interestRate);
        findAndClick(interestRateDropDownButton);
        assertEquals("Selected Rate: " + interestRate + "%", findElement(interestRateButton).getText());
    }

    @Test
    @DisplayName("I can consent to calculating my interest rate")
    void consentToTerms() {
        findAndClick(consentCheckBox);
        assertTrue(isCheckboxChecked(consentCheckBox));
    }

    @Test
    @DisplayName("I can calculate the correct interest rate")
    void calculateInterestRate() {
        findAndClick(durationDaily);
        findAndClick(interestRateButton);
        clickInterestRateElement(7);
        findAndClick(interestRateDropDownButton);
        findAndClick(consentCheckBox);
        findAndClick(calculateButton);
        assertTrue(findElement(interestAmountLabel).getText().contains("1.44"));
        assertTrue(findElement(totalAmountLabel).getText().contains("7501.44"));
    }

    @Test
    @DisplayName("I cannot calculate interest with missing mandatory fields")
    void popupWhenMissingFields() {
        findAndClick(calculateButton);
        assertEquals("Please fill in all fields.", getAlertText());
    }

    static List<By> inputDurationElements() {
        return List.of(durationDaily, durationMonthly, durationYearly);
    }
}
