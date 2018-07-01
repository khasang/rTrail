package io.khasang.rtrail.controller;

import io.khasang.rtrail.config.AppConfig;
import io.khasang.rtrail.config.HibernateConfig;
import io.khasang.rtrail.config.SecurityConfig;
import io.khasang.rtrail.config.application.WebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, SecurityConfig.class, HibernateConfig.class, WebConfig.class})
@WebAppConfiguration
@Transactional
public class AdminControllerIntegrationTest {
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private Filter springSecurityFilterChain;
    private MockMvc mvc;

    private final static String ROOT_USERS = "/admin/users";
    private final static String GET = "/get";
    private final static String ALL = "/all";
    private final static String CURRENT = "/current";
    private final static String ROLE = "/role";
    private final static String NAME = "/name";

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .addFilters(springSecurityFilterChain)
                .build();
    }

    @Test
    public void requestProtectedUrlWithUser() throws Exception {
        mvc
                .perform(get(ROOT_USERS + GET + ALL)
                        .with(user("user").password("pass").roles("USER")))
                .andExpect(status().isForbidden())
                .andExpect(authenticated().withUsername("user"));
    }

    @Test
    public void requestProtectedUrlWithAdmin() throws Exception {
        mvc
                .perform(get(ROOT_USERS + GET + NAME + "/admin")
                        .with(user("admin").password("pass").roles("ADMIN")))
                .andExpect(status().isOk())
                .andExpect(authenticated().withUsername("admin"));
    }

    @Test
    public void requestProtectedUrlWithAuthentication() throws Exception {
        Authentication authentication = new TestingAuthenticationToken("test", "notused", "ROLE_USER");
        mvc
                .perform(get(ROOT_USERS + GET + ROLE + "/USER").with(authentication(authentication)))
                .andExpect(status().is(403))
                .andExpect(authenticated().withAuthentication(authentication));
    }

    @Test
    public void checkUserAuthorities() throws Exception {
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_MODERATOR"));
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        mvc
                .perform(get(ROOT_USERS)
                        .with(user("admin").password("pass").roles("USER", "MODERATOR", "ADMIN")))
                .andExpect(status().isNotFound())
                .andExpect(authenticated().withUsername("admin").withAuthorities(grantedAuthorities));
    }

    @Test
    public void checkCurrentAuthorizedUser() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get(ROOT_USERS + GET + CURRENT)
                        .with(user("admin").password("pass").roles("ADMIN")))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("admin"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("pass"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.authorities[0].authority").value("ROLE_ADMIN"));
    }
}