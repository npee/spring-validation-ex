package io.npee.spring.validation.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.npee.spring.validation.domain.ItemV5;
import io.npee.spring.validation.domain.ItemV5;
import io.npee.spring.validation.domain.PriceV3;
import io.npee.spring.validation.domain.PriceV3;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerV5Test {
    
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void addItemTest() throws Exception{
        ItemV5 item = new ItemV5("itemA", new PriceV3(Boolean.FALSE, 10000, 20000), new PriceV3(Boolean.TRUE, 1000, 2000));
        MvcResult mvcResult = this.mockMvc.perform(post("/api/v5/item-v1")
                                                       .contentType(MediaType.APPLICATION_JSON)
                                                       .content(objectMapper.writeValueAsString(item)))
                                          .andDo(print())
                                          .andExpect(status().isOk())
                                          .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        ItemV5 responseItem = objectMapper.readValue(contentAsString, ItemV5.class);
        assertEquals(item.getName(), responseItem.getName());
        assertEquals(item.getBuyPrice().getMax(), responseItem.getBuyPrice().getMax());
        assertEquals(item.getRentPrice().getMax(), responseItem.getRentPrice().getMax());
    }

    @Test
    void addValidatedPriceConstraintTest_bad_request() throws Exception{
        ItemV5 item = new ItemV5("itemA", new PriceV3(Boolean.FALSE, 10000, 20000), new PriceV3(Boolean.TRUE, 20000, 10000));
        this.mockMvc.perform(post("/api/v5/item-v2")
                                 .contentType(MediaType.APPLICATION_JSON)
                                 .content(objectMapper.writeValueAsString(item)))
                    .andDo(print())
                    .andExpect(status().isBadRequest())
                    .andReturn();
    }

    @Test
    void addValidatedPriceConstraintTest_success() throws Exception{
        ItemV5 item = new ItemV5("itemA", new PriceV3(Boolean.FALSE, 10000, 20000), new PriceV3(Boolean.TRUE, null, null));
        MvcResult mvcResult = this.mockMvc.perform(post("/api/v5/item-v2")
                                                       .contentType(MediaType.APPLICATION_JSON)
                                                       .content(objectMapper.writeValueAsString(item)))
                                          .andDo(print())
                                          .andExpect(status().isOk())
                                          .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        ItemV5 responseItem = objectMapper.readValue(contentAsString, ItemV5.class);
        assertEquals(item.getName(), responseItem.getName());
        assertEquals(item.getBuyPrice().getMax(), responseItem.getBuyPrice().getMax());
        assertEquals(item.getRentPrice().getMax(), responseItem.getRentPrice().getMax());
    }

}