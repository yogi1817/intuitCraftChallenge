package com.test.coding.challenge.endpoints;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
public class SampleTestIT {

    //@Mock
    //private ICustomerAdapter userFacade;
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String REGISTER_ENDPOINT = "/customer/register";
    static {
        OBJECT_MAPPER.findAndRegisterModules();
    }

    @BeforeEach
    void setup() {
        //CustomerController testSubject = new CustomerController(userFacade, registerFacade);
        //mockMvc = MockMvcBuilders.standaloneSetup((new CustomerApiController(testSubject))).build();
    }

//    @Test
//    void shouldRegisterBarberAndReturnRegisterCustomerResponse() throws Exception {
//        RegisterCustomerResponse expected = new RegisterCustomerResponse()
//                .firstName("testfirst")
//                .lastName("testlast")
//                .email("email@test.com")
//                .message("Member registered successfully");
//
//        doReturn(registerCustomerResponse)
//                .when(registerFacade)
//                .registerCustomer(registerCustomerRequest);
//
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
//                .post(REGISTER_ENDPOINT)
//                .content(OBJECT_MAPPER.writeValueAsString(registerCustomerRequest))
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON);
//
//        mockMvc.perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().json(OBJECT_MAPPER.writeValueAsString(expected)));
//
//        verify(registerFacade, times(1))
//                .registerCustomer(registerCustomerRequest);
//        verifyNoMoreInteractions(registerFacade);
//    }
}
