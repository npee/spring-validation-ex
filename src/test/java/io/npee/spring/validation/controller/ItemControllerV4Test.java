package io.npee.spring.validation.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.npee.spring.validation.domain.ItemV4;
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
class ItemControllerV4Test {
    
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void addItemTest() throws Exception{
        ItemV4 item = new ItemV4("itemA", new PriceV2(Boolean.FALSE, 10000, 20000), new PriceV2(Boolean.TRUE, 1000, 2000));
        MvcResult mvcResult = this.mockMvc.perform(post("/api/v4/item-v1")
                                                       .contentType(MediaType.APPLICATION_JSON)
                                                       .content(objectMapper.writeValueAsString(item)))
                                          .andDo(print())
                                          .andExpect(status().isOk())
                                          .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        ItemV4 responseItem = objectMapper.readValue(contentAsString, ItemV4.class);
        assertEquals(item.getName(), responseItem.getName());
        assertEquals(item.getBuyPrice().getMax(), responseItem.getBuyPrice().getMax());
        assertEquals(item.getRentPrice().getMax(), responseItem.getRentPrice().getMax());
    }

    @Test
    void addValidatedPriceTest_success() throws Exception{
        ItemV4 item = new ItemV4("itemA", new PriceV2(Boolean.TRUE, 10000, 20000), null);
        MvcResult mvcResult = this.mockMvc.perform(post("/api/v4/item-v2")
                                                       .contentType(MediaType.APPLICATION_JSON)
                                                       .content(objectMapper.writeValueAsString(item)))
                                          .andDo(print())
                                          .andExpect(status().isOk())
                                          .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        ItemV4 responseItem = objectMapper.readValue(contentAsString, ItemV4.class);
        assertEquals(item.getName(), responseItem.getName());
        assertEquals(item.getBuyPrice().getMax(), responseItem.getBuyPrice().getMax());
        assertNull(item.getRentPrice());
        assertNull(responseItem.getRentPrice());
    }

    @Test
    void addValidatedPriceTest_bad_request() throws Exception{
        ItemV4 item = new ItemV4("itemA", null, null);
        this.mockMvc.perform(post("/api/v4/item-v2")
                                 .contentType(MediaType.APPLICATION_JSON)
                                 .content(objectMapper.writeValueAsString(item)))
                    .andDo(print())
                    .andExpect(status().isBadRequest())
                    .andReturn();
    }

    @Test
    void addValidatedInnerPriceTest_success() throws Exception{
        ItemV4 item = new ItemV4("itemA", new PriceV2(Boolean.FALSE, 100000, null), new PriceV2(Boolean.TRUE, 10000, null));
        MvcResult mvcResult = this.mockMvc.perform(post("/api/v4/item-v2")
                                                       .contentType(MediaType.APPLICATION_JSON)
                                                       .content(objectMapper.writeValueAsString(item)))
                                          .andDo(print())
                                          .andExpect(status().isOk())
                                          .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        ItemV4 responseItem = objectMapper.readValue(contentAsString, ItemV4.class);
        assertEquals(item.getName(), responseItem.getName());
        assertEquals(item.getBuyPrice().getMax(), responseItem.getBuyPrice().getMax());
        assertEquals(item.getRentPrice().getMax(), responseItem.getRentPrice().getMax());
    }

    @Test
    void addValidatedInnerPriceTest_bad_request() throws Exception{
        ItemV4 item = new ItemV4("itemA", new PriceV2(Boolean.FALSE, null, 200000), new PriceV2(Boolean.TRUE, null, 20000));
        this.mockMvc.perform(post("/api/v4/item-v2")
                                                       .contentType(MediaType.APPLICATION_JSON)
                                                       .content(objectMapper.writeValueAsString(item)))
                                          .andDo(print())
                                          .andExpect(status().isBadRequest())
                                          .andReturn();
    }

}