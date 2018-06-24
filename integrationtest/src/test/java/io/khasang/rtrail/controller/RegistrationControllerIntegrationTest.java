package io.khasang.rtrail.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class RegistrationControllerIntegrationTest {
    @Test
    public void showRegistrationFormTest() throws Exception {
        RegistrationController registrationController = new RegistrationController();
        MockMvc mockMvc = standaloneSetup (registrationController).build();
        mockMvc.perform(get("/registration"))
                .andExpect(view().name("registration.jsp"));
    }
    @Test
    public void showLoginFormTest() throws Exception {
        RegistrationController registrationController = new RegistrationController();
        MockMvc mockMvc = standaloneSetup (registrationController).build();
        mockMvc.perform(get("/login"))
                .andExpect(view().name("login.jsp"));
    }
}
