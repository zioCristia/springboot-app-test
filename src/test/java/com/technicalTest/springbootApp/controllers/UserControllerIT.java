package com.technicalTest.springbootApp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.technicalTest.springbootApp.api.v1.model.UserDTO;
import com.technicalTest.springbootApp.entities.UserInformation;
import com.technicalTest.springbootApp.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class UserControllerIT {
    public static final Long ID = 1L;
    public static final String USER_NAME = "USER_NAME";
    private static final LocalDate BIRTH_DATE = LocalDate.of(2000, 1, 1);
    public static final String RESIDENCE_COUNTRY = "France";

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void should_not_create_user_without_user_name() throws Exception {
        UserDTO user = new UserDTO().builder()
                .birthDate(BIRTH_DATE)
                .residenceCountry(RESIDENCE_COUNTRY)
                .build();

        mockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    public void should_not_create_user_without_birthdate() throws Exception {
        UserDTO user = new UserDTO().builder()
                .userName(USER_NAME)
                .residenceCountry(RESIDENCE_COUNTRY)
                .build();

        mockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    public void should_not_create_user_without_residence_country() throws Exception {
        UserDTO user = new UserDTO().builder()
                .userName(USER_NAME)
                .birthDate(BIRTH_DATE)
                .build();

        mockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    public void should_not_create_user_without_correct_residence_country() throws Exception {
        UserDTO user = new UserDTO().builder()
                .userName(USER_NAME)
                .birthDate(BIRTH_DATE)
                .residenceCountry("Italy")
                .build();

        mockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    public void should_not_create_user_without_age_above_18_years() throws Exception {
        UserDTO user = new UserDTO().builder()
                .userName(USER_NAME)
                .birthDate(LocalDate.of(2023,1,1))
                .residenceCountry(RESIDENCE_COUNTRY)
                .build();

        mockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    public void should_create_user_with_all_mandatory_parameters() throws Exception {
        UserDTO user = new UserDTO().builder()
                .userName(USER_NAME)
                .birthDate(BIRTH_DATE)
                .residenceCountry(RESIDENCE_COUNTRY)
                .build();

        mockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }
}
