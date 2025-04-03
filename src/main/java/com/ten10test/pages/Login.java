package com.ten10test.pages;

import org.openqa.selenium.By;

public class Login extends PageBase {

    public By loginButton = By.className("btn-secondary");

    public By emailTextField = By.id("UserName");
    public By passwordTextField = By.id("Password");

    public By submitLoginButton = By.id("login-submit");
}
