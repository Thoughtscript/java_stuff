package com.thoughtscript.springunit.controllers;

import com.thoughtscript.springunit.services.ExampleService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ExampleControllerUnitTest {

    private MockMvc mockMvc;

    @Mock
    private ExampleService exampleService;

    @InjectMocks
    private ExampleController exampleController;


    @Before
    public void preTest() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(exampleController).build();
    }

    @Test
    public void test() {
        try {
            when(exampleService.helloText()).thenReturn("Hello You!");
            mockMvc.perform(get("/test/fetch"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                    .andExpect(jsonPath("$.text").value("Hello You!"));

            verify(exampleService, times(1)).helloText();
            verifyNoMoreInteractions(exampleService);

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    @After
    public void postTest() {
        mockMvc = null;
    }
}