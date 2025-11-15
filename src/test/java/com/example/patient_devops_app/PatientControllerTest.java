package com.example.patient_devops_app;
import com.example.patient_devops_app.controller.PatientController;
import com.example.patient_devops_app.entity.Patient;
import com.example.patient_devops_app.service.PatientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PatientController.class)
class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientService service;

    @Test
    void getAllPatients_ReturnsList() throws Exception {
        Mockito.when(service.getAllPatients()).thenReturn(
                List.of(new Patient(1L, "John", 30, "Flu"))
        );

        mockMvc.perform(get("/api/patients"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John"));
    }
}
