package io.npee.spring.validation.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.npee.spring.validation.domain.ItemV1;
import io.npee.spring.validation.domain.ItemV2;
import io.npee.spring.validation.domain.PriceV2;
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
class ItemControllerV2Test {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void addItemTest() throws Exception{
        ItemV2 item = new ItemV2("itemA", new PriceV2(Boolean.FALSE, 10000, 20000));
        MvcResult mvcResult = this.mockMvc.perform(post("/api/v2/item-v1")
                                                       .contentType(MediaType.APPLICATION_JSON)
                                                       .content(objectMapper.writeValueAsString(item)))
                                          .andDo(print())
                                          .andExpect(status().isOk())
                                          .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        ItemV2 responseItem = objectMapper.readValue(contentAsString, ItemV2.class);
        assertEquals(item.getName(), responseItem.getName());
        assertEquals(item.getPrice().getMax(), responseItem.getPrice().getMax());
    }

    @Test
    void addValidatedItemTest() throws Exception{
        ItemV2 item = new ItemV2("itemA", null);
        this.mockMvc.perform(post("/api/v2/item-v2")
                                                       .contentType(MediaType.APPLICATION_JSON)
                                                       .content(objectMapper.writeValueAsString(item)))
                                          .andDo(print())
                                          .andExpect(status().isBadRequest())
                                          .andReturn();
    }
}