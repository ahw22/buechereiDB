package at.bbrz.buechereidb.controller;

import at.bbrz.buechereidb.model.Medium;
import at.bbrz.buechereidb.service.MediumService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class MediumController {

    @Autowired
    MediumService service;

    @Autowired
    ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<String> saveAll(@RequestBody List<Medium> mediumList) {
        try {
            service.saveAll(mediumList);
            return ResponseEntity.ok().body("Mediums were saved!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong!");
        }
    }

    @GetMapping
    public ResponseEntity<String> fetchAll() {
        try {
            ResponseEntity<String> responseEntity = ResponseEntity.ok().body(objectMapper.writeValueAsString(service.fetchAll()));
            return responseEntity;
        } catch (JsonProcessingException e) {
            return ResponseEntity.badRequest().body("Something went wrong!" + e.getMessage());
        }
    }

}
