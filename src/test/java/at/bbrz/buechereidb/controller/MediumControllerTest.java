package at.bbrz.buechereidb.controller;

import at.bbrz.buechereidb.model.Medium;
import at.bbrz.buechereidb.service.MediumService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;


import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MediumController.class)
class MediumControllerTest {

    @Autowired
    MockMvc mockMvc;


    @MockitoBean
    MediumService service;

    @Autowired
    ObjectMapper objectMapper;

    String jsonData;

    @BeforeEach
    void setUp() {
        try {
            jsonData = Files.readString(new ClassPathResource("mediums.json").getFile().toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void saveAll_shouldReturnSuccess() throws Exception {
        List<Medium> media = objectMapper.readValue(jsonData, new TypeReference<List<Medium>>() {});

        Mockito.doNothing().when(service).saveAll(media);

        mockMvc.perform(post("/api/v1/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonData))
                .andExpect(status().isOk())
                .andExpect(content().string("4 Mediums were saved!"));
    }
}