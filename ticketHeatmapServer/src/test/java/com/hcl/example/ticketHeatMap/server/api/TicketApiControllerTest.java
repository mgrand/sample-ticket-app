package com.hcl.example.ticketHeatMap.server.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TicketApiControllerTest {
    private static final String TEST_DATA_FILE = "/testData.json";

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mvc;

    private static String jsonString;

    @BeforeClass
    public static void setup() throws Exception {
        char[] buffer = new char[99999];
        try (Reader reader = new InputStreamReader(TicketApiControllerTest.class.getResourceAsStream(TEST_DATA_FILE), StandardCharsets.UTF_8)) {
            int length = reader.read(buffer);
            jsonString = new String(buffer, 0, length);
        }
    }

    @Test
    public void getTicketsForHeatmap() throws Exception {
        assertNotNull("mvc not null", mvc);
       mvc.perform(get("/ticket/heatmap?regions=usa&status=any"))
               .andExpect(status().isOk())
               .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
               .andExpect(content().json(jsonString));
        mvc.perform(get("/ticket/heatmap?regions=usa&status=open"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andDo(result -> assertEquals(5, objectMapper.readTree(result.getResponse().getContentAsString()).size()));
        mvc.perform(get("/ticket/heatmap?regions=usa&status=closed"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andDo(result -> assertEquals(2, objectMapper.readTree(result.getResponse().getContentAsString()).size()));
        mvc.perform(get("/ticket/heatmap?regions=europe&status=closed"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andDo(result -> assertEquals(0, objectMapper.readTree(result.getResponse().getContentAsString()).size()));
    }
}