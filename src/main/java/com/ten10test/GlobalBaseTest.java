package com.ten10test;

import com.ten10test.utils.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class GlobalBaseTest extends DriverFactory {

    @BeforeEach
    void setupDriver() {
        driver = newDriver();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
}
