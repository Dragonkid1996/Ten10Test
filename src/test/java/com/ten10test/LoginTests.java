package com.ten10test;

import com.ten10test.pages.Login;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTests extends Login {

    @Test
    @DisplayName("I can login to the interest calculator app")
    void loginToPage() {
        findAndClick(loginButton);
        sendKeys(emailTextField, "EMAIL_GOES_HERE");
        sendKeys(passwordTextField, "PASSWORD_GOES_HERE");
        findAndClick(submitLoginButton);
    }
}
