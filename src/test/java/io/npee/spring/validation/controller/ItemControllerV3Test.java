package io.npee.spring.validation.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.npee.spring.validation.domain.ItemV3;
import io.npee.spring.validation.domain.PriceV1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerV3Test {
    
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void addItemTest() throws Exception{
        ItemV3 item = new ItemV3("itemA", new PriceV1(Boolean.FALSE, 10000, 20000), new PriceV1(Boolean.TRUE, 1000, 2000));
        MvcResult mvcResult = this.mockMvc.perform(post("/api/v3/item-v1")
                                                       .contentType(MediaType.APPLICATION_JSON)
                                                       .content(objectMapper.writeValueAsString(item)))
                                          .andDo(print())
                                          .andExpect(status().isOk())
                                          .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        ItemV3 responseItem = objectMapper.readValue(contentAsString, ItemV3.class);
        assertEquals(item.getName(), responseItem.getName());
        assertEquals(item.getBuyPrice().getMax(), responseItem.getBuyPrice().getMax());
        assertEquals(item.getRentPrice().getMax(), responseItem.getRentPrice().getMax());
    }

    @Test
    void addValidatedItemTest() throws Exception{
        ItemV3 item = new ItemV3("itemA", null, null);
        this.mockMvc.perform(post("/api/v3/item-v2")
                                 .contentType(MediaType.APPLICATION_JSON)
                                 .content(objectMapper.writeValueAsString(item)))
                    .andDo(print())
                    .andExpect(status().isBadRequest())
                    .andReturn();
    }

}