package com.technicalTest.springbootApp.services;

import com.technicalTest.springbootApp.api.v1.mapper.UserMapper;
import com.technicalTest.springbootApp.api.v1.model.UserDTO;
import com.technicalTest.springbootApp.entities.UserInformation;
import com.technicalTest.springbootApp.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {
    public static final Long ID = 1L;
    public static final String USER_NAME = "USER_NAME";
    private static final LocalDate BIRTH_DATE = LocalDate.of(2000, 1, 1);
    public static final String RESIDENCE_COUNTRY = "RESIDENCE_COUNTRY";

    @Mock
    UserRepository userRepository;

    UserMapper userMapper = UserMapper.INSTANCE;
    UserServiceImpl userService;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        userService = new UserServiceImpl(userMapper, userRepository);
    }

    @Test
    public void getUserById() throws Exception {
        UserInformation userInformation = UserInformation.builder()
                .id(ID)
                .userName(USER_NAME)
                .birthDate(BIRTH_DATE)
                .residenceCountry(RESIDENCE_COUNTRY)
                .build();

        when(userRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(userInformation));

        UserDTO userDTO = userService.findById(ID);

        assertEquals(USER_NAME, userDTO.getUserName());
        assertEquals(BIRTH_DATE, userDTO.getBirthDate());
        assertEquals(RESIDENCE_COUNTRY, userDTO.getResidenceCountry());
    }

    @Test
    public void createNewUser() throws Exception {
        //given
        UserDTO userDTO = new UserDTO().builder()
                .userName(USER_NAME)
                .birthDate(BIRTH_DATE)
                .residenceCountry(RESIDENCE_COUNTRY)
                .build();

        UserInformation savedUser = new UserInformation().builder()
                .id(ID)
                .userName(userDTO.getUserName())
                .birthDate(userDTO.getBirthDate())
                .residenceCountry(userDTO.getResidenceCountry())
                .build();

        when(userRepository.save(any(UserInformation.class))).thenReturn(savedUser);

        //when
        UserDTO savedDto = userService.createUser(userDTO);

        //then
        Assert.assertEquals(userDTO.getUserName(), savedDto.getUserName());
        Assert.assertEquals(userDTO.getBirthDate(), savedDto.getBirthDate());
        Assert.assertEquals(userDTO.getResidenceCountry(), savedDto.getResidenceCountry());
    }
}
