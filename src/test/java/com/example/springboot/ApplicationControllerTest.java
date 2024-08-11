package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHello() throws Exception {
        mockMvc.perform(get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello Spring Boot!")));
    }

    @Test
    public void testReturnInput() throws Exception {
        mockMvc.perform(get("/input")
                        .param("name", "joe")
                        .param("id", "10"))
                .andExpect(status().isOk());
    }

    @Test
    public void testOutputForReturnInput() throws Exception {
        mockMvc.perform(get("/input")
                .param("name", "joe")
                .param("id", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("name: "+ "joe"+" id:"+"10"));

    }


    @Test
    public void testBadRequestForId() throws Exception {
        mockMvc.perform(get("/input")
                        .param("name", "joe")
                        .param("id", "-1"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Invalid input ..."));
    }

    @Test
    public void testDefaultValueifNameEmpty() throws Exception {
        mockMvc.perform(get("/input")
                .param("name", "")
                .param("id", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("name: "+ "default-name"+" id:"+"10"));
    }

    @Test
    public void testDefaultValueifNameNull() throws Exception {
        mockMvc.perform(get("/input")
                        .param("name", "null")
                        .param("id", "10"))
                .andExpect(status().isBadRequest());

    }

    // Status Codes: Ensure the API returns appropriate HTTP status codes
    // 200 OK,
    // 201 Created,
    // 400 Bad Request,
    // 404 Not Found,
    // 500 Internal Server Error

    @Test
    public void test200OK() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk());
    }

    @Test
    public void test404NotFound() throws Exception{
        mockMvc.perform(get("/not"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void test400BadRequest() throws Exception {
        mockMvc.perform(get("/input")
                        .param("name", "bad-rqst-test-name")
                        .param("id", "-1"))
                    .andExpect(status().isBadRequest());

    }

    @Test
    public void test500InternalServerError() throws Exception {
        mockMvc.perform(get("/runtime-err"))
                .andExpect(status().is5xxServerError());
    }

    @Test
    public void testNullPointerExceptionforId() throws Exception {
        mockMvc.perform(get("/input")
                        .param("name", "bad-rqst-test-id"))
                .andExpect(status().is5xxServerError())
                .andExpect(content().string("Cannot invoke \"java.lang.Integer.intValue()\" because \"id\" is null"));

    }

}
