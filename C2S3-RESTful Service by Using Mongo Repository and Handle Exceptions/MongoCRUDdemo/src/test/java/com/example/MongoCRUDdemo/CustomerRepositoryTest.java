//package com.example.MongoCRUDdemo;
//
//import com.example.MongoCRUDdemo.domain.Address;
//import com.example.MongoCRUDdemo.domain.Customer;
//import com.example.MongoCRUDdemo.repository.CustomerRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class CustomerRepositoryTest {
//    private Customer customer;
//    private Address address;
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @BeforeEach
//    public void setUp() {
//        address = new Address("HN102", "MGRoad", "Mumbai");
//        customer = new Customer("C700", "John Martin", "9220893036", address);
//    }
//
//    @AfterEach
//    public void clear() {
//        address = null;
//        customer = null;
//    }
//
//    @Test
//    @DisplayName("Test Case to Check Saving process")
//    void givenCustomerToSaveShouldReturnSavedCustomer() {
//        customerRepository.save(customer);
//        Customer c1 = customerRepository.findById(customer.getCustomerId()).get();
//        assertNotNull(c1);
//        assertEquals(customer.getCustomerId(), c1.getCustomerId());
//    }
//
//    @Test
//    @DisplayName("Test Case for Deleting Customer")
//    public void givenCustomertoDeleteShouldDeleteCustomer() {
////        Customer customer1 = new Customer("C9090","Reshma","8978675432",address);
////        customerRepository.insert(customer1);
//        Customer c1 = customerRepository.findById(customer.getCustomerId()).get();
//        customerRepository.delete(c1);
//        assertEquals(Optional.empty(), customerRepository.findById(c1.getCustomerId()));
//    }
//
//    @Test
//    @DisplayName("Test Case for Retrieving Customer")
//    public void givenCustomerReturnAllCustomerDetails() {
//        List<Customer> list = customerRepository.findAll();
//        assertEquals(4, list.size());
//        assertEquals("anshul", list.get(2).getCustomerName());
//    }
//}