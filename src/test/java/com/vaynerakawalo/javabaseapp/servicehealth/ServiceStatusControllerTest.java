package com.vaynerakawalo.javabaseapp.servicehealth;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Clock;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = "service.version=testVersion"
)
class ServiceStatusControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Clock clock;

    @ParameterizedTest
    @ValueSource(strings = {"/health", "/healthcheck"})
    void health_returnsStatusOk(String uri) throws Exception {

        var expected = """
                {
                  "status": "OK"
                }
                """;

        mockMvc.perform(get(uri))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }

    @Test
    void info_providesCorrectVersion() throws Exception {
        mockMvc.perform(get("/info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.version").value("testVersion"));
    }

    @Test
    void info_providesServiceUptime() throws Exception {
        when(clock.millis()).thenReturn(100L);

        mockMvc.perform(get("/info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.uptime").value(100));
    }
}
