package com.company.assigments.postalcode.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// Integration Test
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UkPostalCodeControllerIT {

  @Autowired
  private MockMvc mvc;

  @Test
  public void getDistanceWithCorrectPostalCodesExpectsGetDistanceResult() throws Exception {
    String getDistanceResult = "{\"postalCode1\":{\"postalCode\":\"AB10 1XG\",\"latitude\":57.14416516,\"longitude\":-2.114847768},\"postalCode2\":{\"postalCode\":\"AB10 6RN\",\"latitude\":57.13787976,\"longitude\":-2.121486688},\"unit\":\"km\",\"distance\":0.8055408702919634}";

    mvc.perform(
        MockMvcRequestBuilders
            .get("/distance")
            .accept(MediaType.APPLICATION_JSON)
            .param("postalcode1", "AB10 1XG")
            .param("postalcode2", "AB10 6RN"))
        .andExpect(status().isOk())
        .andExpect(content().string(equalTo(getDistanceResult)));
  }

}
