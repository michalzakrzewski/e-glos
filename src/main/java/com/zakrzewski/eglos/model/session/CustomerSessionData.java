package com.zakrzewski.eglos.model.session;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerSessionData implements CustomerData {
    private Integer customerId;
    private String sessionId;
    private String firstName;
    private String lastName;
    private String loginName;
    private String emailAddress;
    private String mobileNumber;
    private String address;
    private String city;
    private String countryCode;
    private String country;
    private LocalDateTime lastActivityTime;
}
