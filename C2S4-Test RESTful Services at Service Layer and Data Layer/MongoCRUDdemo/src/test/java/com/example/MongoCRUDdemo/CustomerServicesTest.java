package com.example.MongoCRUDdemo;

import com.example.MongoCRUDdemo.repository.CustomerRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CustomerServicesTest {
    @Mock
    private CustomerRepository customerRepository;
    
}
