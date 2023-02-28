package com.technicalTest.springbootApp.api.v1.mapper;

import com.technicalTest.springbootApp.api.v1.model.UserDTO;
import com.technicalTest.springbootApp.entities.UserInformation;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class UserMapperTest {
    public static final Long ID = 1L;
    public static final String USER_NAME = "USER_NAME";
    private static final LocalDate BIRTH_DATE = LocalDate.of(2000, 1, 1);
    public static final String RESIDENCE_COUNTRY = "RESIDENCE_COUNTRY";

    UserMapper userMapper = UserMapper.INSTANCE;

    @Test
    public void userToUserDTO() throws Exception {
        //given
        UserInformation userInformation = new UserInformation().builder()
                .userName(USER_NAME)
                .birthDate(BIRTH_DATE)
                .residenceCountry(RESIDENCE_COUNTRY)
                .build();

        //when
        UserDTO userDTO = userMapper.userToUserDto(userInformation);

        //then
        assertEquals(USER_NAME, userDTO.getUserName());
        assertEquals(BIRTH_DATE, userDTO.getBirthDate());
        assertEquals(RESIDENCE_COUNTRY, userDTO.getResidenceCountry());
    }

    @Test
    public void userDtoToUser() throws Exception {
        //given
        UserDTO user = new UserDTO().builder()
                .userName(USER_NAME)
                .birthDate(BIRTH_DATE)
                .residenceCountry(RESIDENCE_COUNTRY)
                .build();

        //when
        UserInformation userInformation = userMapper.userDtoToUser(user);

        //then
        assertEquals(USER_NAME, userInformation.getUserName());
        assertEquals(BIRTH_DATE, userInformation.getBirthDate());
        assertEquals(RESIDENCE_COUNTRY, userInformation.getResidenceCountry());
    }
}