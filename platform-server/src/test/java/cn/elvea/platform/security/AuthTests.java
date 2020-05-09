package cn.elvea.platform.security;

import cn.elvea.ApplicationBaseWebTests;
import cn.elvea.platform.commons.constants.SecurityConstants;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 登录认证相关测试
 *
 * @author elvea
 */
public class AuthTests extends ApplicationBaseWebTests {

    @Test
    public void passwordAuthTest() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(SecurityConstants.AUTH_TOKEN_PATH)
                .param("grant_type", "password")
                .param("username", "admin")
                .param("password", "admin")
                .param("client_id", "webapp")
                .param("client_secret", "webapp"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.access_token").isNotEmpty())
                .andExpect(jsonPath("$.refresh_token").isNotEmpty())
                .andExpect(jsonPath("$.expires_in").isNotEmpty())
                .andExpect(jsonPath("$.scope").isNotEmpty())
                .andExpect(jsonPath("$.jti").isNotEmpty())
                .andExpect(jsonPath("$.token_type").value("bearer"))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void clientCredentialsAuthTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(SecurityConstants.AUTH_TOKEN_PATH)
                .param("grant_type", "client_credentials")
                .param("client_id", "webapp")
                .param("client_secret", "webapp")
        ).andExpect(status().isOk());
    }

}
