package com.hcl.example.ticketHeatMap.server.api;

import com.hcl.example.ticketHeatMap.server.Swagger2SpringBoot;
import com.hcl.example.ticketHeatMap.server.configuration.JacksonConfiguration;
import com.hcl.example.ticketHeatMap.server.configuration.SwaggerDocumentationConfig;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TicketApiControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getTicketsForHeatmap() {
       // mvc.perform(get())
    }
}