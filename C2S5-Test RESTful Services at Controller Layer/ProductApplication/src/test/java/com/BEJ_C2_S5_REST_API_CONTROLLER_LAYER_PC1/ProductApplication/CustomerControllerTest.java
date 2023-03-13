package com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication;

import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.Exceptions.CustomerAlreadyExistsException;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.Exceptions.CustomerNotFoundException;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.controller.CustomerController;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.domain.Customer;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.domain.Product;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.services.CustomerServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private CustomerServiceImpl customerServices;

    @InjectMocks
    private CustomerController customerController;
    private Customer customer1,customer2;
    private Product product1,product2;
    List<Customer> customerList;

    @BeforeEach
    void setUp(){
        product1 =new Product("p001","car","prod_dis1");
        customer1 =new Customer("c001","ashish","12335",product1);
        product2 =new Product("p002","mobile","prod_dis2");
        customer2 =new Customer("c002","neha","12335",product2);
        customerList = Arrays.asList(customer1,customer2);

        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @AfterEach
    void tearDown(){
        customer1=null;
        customer2=null;
    }
    @Test
    @DisplayName("Test case for checking customer object save/add/post operation")
    public void Test1() throws Exception{
        when(customerServices.addCustomer(any())).thenReturn(customer1);
        mockMvc.perform(post("/api/customer/v1/addCustomer").contentType(MediaType.APPLICATION_JSON).content(jsonToString(customer1)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(customerServices,times(1)).addCustomer(customer1);
    }
    @Test
    @DisplayName("Test case for checking customer object save/add/post operation but Already Exist")
    public void Test2() throws Exception{
        when(customerServices.addCustomer(any())).thenThrow(CustomerAlreadyExistsException.class);
        mockMvc.perform(post("/api/customer/v1/addCustomer").contentType(MediaType.APPLICATION_JSON).content(jsonToString(customer1)))
                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
        verify(customerServices,times(1)).addCustomer(customer1);
    }
    @Test
    @DisplayName("Test case for checking get All customer")
    public void Test3() throws Exception {
        when(customerServices.getCustomer()).thenReturn(customerList);
        mockMvc.perform(get("/api/customer/v1/getCustomer").contentType(MediaType.APPLICATION_JSON).content(jsonToString(customer1)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(customerServices,times(1)).getCustomer();
    }
    @Test
    @DisplayName("Test case for checking get customer by product name")
    public void Test4() throws Exception {
        String prodName="car";
        when(customerServices.getProductByProductName(prodName)).thenReturn(customerList);
        mockMvc.perform(get("/api/customer/v1/getCustomerBySamsung/car").contentType(MediaType.APPLICATION_JSON).content(jsonToString(customer1)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(customerServices,times(1)).getProductByProductName(prodName);
    }
    @Test
    @DisplayName("Test case for checking customer object Delete")
    public void Test5() throws Exception {
        when(customerServices.deleteCustomer(anyString())).thenReturn(true);
        mockMvc.perform(delete("/api/customer/v1/deleteCustomer/c001")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonToString(customer1)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(customerServices,times(1)).deleteCustomer(anyString());
    }
    @Test
    @DisplayName("Test case for checking customer object Delete but not present")
    public void Test6() throws Exception {
        when(customerServices.deleteCustomer(anyString())).thenThrow(CustomerNotFoundException.class);
        mockMvc.perform(delete("/api/customer/v1/deleteCustomer/c001")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonToString(customer1)))
                .andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());
        verify(customerServices,times(1)).deleteCustomer(anyString());
    }

    private static  String jsonToString(final Object obj) throws JsonProcessingException {
        String result;
        try{
            ObjectMapper mapper = new ObjectMapper();
            String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        }catch (JsonProcessingException e){
            result ="JSON Processing Error";
        }
        return result;
    }
}
