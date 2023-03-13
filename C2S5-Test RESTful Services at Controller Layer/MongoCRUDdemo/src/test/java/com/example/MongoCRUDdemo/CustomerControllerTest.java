package com.example.MongoCRUDdemo;


import com.example.MongoCRUDdemo.controller.CustomerController;
import com.example.MongoCRUDdemo.domain.Address;
import com.example.MongoCRUDdemo.domain.Customer;
import com.example.MongoCRUDdemo.exception.CustomerAlreadyExistsException;
import com.example.MongoCRUDdemo.services.CustomerServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CustomerServiceImpl customerService;

    @InjectMocks
    private CustomerController customerController;
    private Customer customer1, customer2;
    private Address address1 , address2;
    List<Customer> customerList;

    @BeforeEach
    void setUp() {
        address1 = new Address("city1","state1","pincode1");
        customer1 = new Customer("1001","Johny","1234",address1);
        address2 = new Address("city2","state2","pincode2");
        customer2 = new Customer("1002","Harry","87654",address2);
        customerList = Arrays.asList(customer1,customer2);

        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @AfterEach
    void tearDown() {
        customer1=null;
        customer2 = null;
    }
    @Test
    public void givenCustomerToSaveReturnSavedCustomer() throws Exception {
        when(customerService.addCustomer(customer1)).thenReturn(customer1);
        mockMvc.perform(post("/api/customer/v1/addCust")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonToString(customer1)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(customerService,times(1)).addCustomer(any());

    }
    @Test
    public void givenCustomerToSaveReturnSavedCustomerFailure() throws Exception {
        when(customerService.addCustomer(any())).thenThrow(CustomerAlreadyExistsException.class);
        mockMvc.perform(post("/api/customer/v1/getCusts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonToString(customer1)))
                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
        verify(customerService,times(1)).addCustomer(any());

    }
    @Test
    public void givenCustomerIdDeleteCustomer() throws Exception {
        when(customerService.deleteCustomer(anyString())).thenReturn(true);
        mockMvc.perform(delete("/api/customer/v1/delCust/c001")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
        verify(customerService,times(1)).deleteCustomer(anyString());
    }

    private static String jsonToString(final Object ob) throws JsonProcessingException {
        String result;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonContent = mapper.writeValueAsString(ob);
            result = jsonContent;
        } catch(JsonProcessingException e) {
            result = "JSON processing error";
        }

        return result;
    }

}
