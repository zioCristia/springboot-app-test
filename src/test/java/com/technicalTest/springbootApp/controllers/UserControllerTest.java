package com.technicalTest.springbootApp.controllers;

import com.technicalTest.springbootApp.api.v1.model.UserDTO;
import com.technicalTest.springbootApp.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest extends AbstractRestControllerTest {
    public static final Long ID = 1L;
    public static final String USER_NAME = "USER_NAME";
    private static final LocalDate BIRTH_DATE = LocalDate.of(2000, 1, 1);
    public static final String RESIDENCE_COUNTRY = "RESIDENCE_COUNTRY";

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void createNewUser() throws Exception {
        //given
        UserDTO user = new UserDTO().builder()
                .userName(USER_NAME)
                .birthDate(BIRTH_DATE)
                .residenceCountry(RESIDENCE_COUNTRY)
                .build();

        UserDTO returnDTO = new UserDTO().builder()
                        .userName(user.getUserName())
                        .birthDate(user.getBirthDate())
                        .residenceCountry(user.getResidenceCountry())
                        .build();

        when(userService.createUser(user)).thenReturn(returnDTO);

        //when/then
        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(user)))
                        .andExpect(status().isCreated())
                        .andExpect(jsonPath("$.userName", equalTo(USER_NAME)))
                        .andExpect(jsonPath("$.birthDate", equalTo(BIRTH_DATE)))
                        .andExpect(jsonPath("$.residenceCountry", equalTo(RESIDENCE_COUNTRY)));
    }

    @Test
    public void testGetUserById() throws Exception {
        //given
        UserDTO user = new UserDTO().builder()
                .userName(USER_NAME)
                .birthDate(BIRTH_DATE)
                .residenceCountry(RESIDENCE_COUNTRY)
                .build();

        when(userService.findById(anyLong())).thenReturn(user);

        //when
        mockMvc.perform(get("/api/users/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userName", equalTo(USER_NAME)))
                // .andExpect(jsonPath("$.birthDate", equalTo(BIRTH_DATE)))
                .andExpect(jsonPath("$.residenceCountry", equalTo(RESIDENCE_COUNTRY)));
    }
}
