package com.socks.ui.test;

import com.codeborne.selenide.Selenide;
import com.socks.api.ProjectConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeMethod;

import javax.security.auth.login.Configuration;

public class BaseUITest {
    @BeforeMethod
    public void setUp() {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());

        RestAssured.baseURI = config.baseUrl();
        com.codeborne.selenide.Configuration.baseUrl = config.baseUrl();
    }

    protected <T> T at (Class<T> pageClass) {
        return Selenide.page(pageClass);
    }
}
