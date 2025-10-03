package com.zakrzewski.eglos.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.zakrzewski.eglos.deserializer.CountryDeserializer;
import com.zakrzewski.eglos.enums.CountryEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class CustomerRegisterRequest {
    private String firstName;
    private String lastName;
    private String password;
    private String loginName;
    private String emailAddress;
    private String mobileNumber;
    private String address;
    private String city;
    @JsonDeserialize(using = CountryDeserializer.class)
    private CountryEnum country;
    @JsonDeserialize(using = CountryDeserializer.class)
    private CountryEnum countryCode;
    private String peselNumber;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateOfBirth;
}
