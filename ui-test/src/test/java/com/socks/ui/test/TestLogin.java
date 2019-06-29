package com.socks.ui.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.socks.api.conditions.Conditions;
import com.socks.api.payloads.UserPayload;
import com.socks.api.services.UserApiService;
import com.socks.ui.LoggedUserPage;
import com.socks.ui.MainPage;
import org.testng.annotations.Test;

import static com.socks.api.conditions.Conditions.statusCode;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class TestLogin extends BaseUITest{

    private final UserApiService userApiService = new UserApiService();

    @Test
    public void userCanLoginWithValidCredentials() {

        UserPayload user = new UserPayload()
                .username(randomAlphanumeric(6))
                .email("test@mail.com")
                .password("test123");

        //expect
        userApiService.registerUser(user)
                .shouldHave(statusCode(200));

        MainPage.open()
                .loginAs(user.username(), user.password());

        LoggedUserPage loggedUserPage = at(LoggedUserPage.class);

        loggedUserPage.logoutBtn().shouldHave(Condition.text("logout"));
        loggedUserPage.userName().shouldHave(Condition.text("Logged in as"));
    }
}
