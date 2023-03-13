package com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication;

import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.domain.Customer;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.domain.Product;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class CustomerServicesTest {
    private Customer customer;
    private Product product;
    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setUp(){
        product =new Product("P001","p1","pd1");
        customer=new Customer("C005","c5","12345",product);
    }
    @AfterEach
    public void tearDown(){
        product=null;
        customer=null;
    }
    @Test
    @DisplayName("Test case for saving customer object")
    public void givenCustomerToSaveShouldReturnCustomer() {
        customerRepository.save(customer);
        Customer customer1 = customerRepository.findById(customer.getCustomerId()).get();
        assertNotNull(customer1);
        assertEquals(customer.getCustomerId(), customer1.getCustomerId());
    }
    @Test
    @DisplayName("Test if customer exists")
    void test2(){
        customerRepository.save(customer);
        boolean exists = customerRepository.existsById(customer.getCustomerId());
        assertEquals(true,exists);
    }

    @Test
    @DisplayName("Test case for deleting customer object")
    public void givenCustomerToDeleteShouldDeleteCustomer() {
        customerRepository.save(customer);
        Customer customer1 = customerRepository.findById(customer.getCustomerId()).get();
        customerRepository.delete(customer1);
        assertEquals(Optional.empty(), customerRepository.findById(customer.getCustomerId()));
    }
    @Test
    @DisplayName("Test if deleted customer not found")
    void test4(){
        customerRepository.save(customer);
        Customer customer1 = customerRepository.findById(customer.getCustomerId()).get();
        customerRepository.delete(customer1);
        boolean exists = customerRepository.existsById(customer.getCustomerId());
        assertEquals(false,exists);
    }

    @Test
    @DisplayName("Test case for retrieving all the  customer object")
    public void givenTrackReturnGetAllTrack() {
        customerRepository.save(customer);
        List<Customer> list = customerRepository.findAll();
        assertEquals(3, list.size());
        assertEquals("c5", list.get(2).getCustomerName());

    }
}
