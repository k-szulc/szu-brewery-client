package xyz.itbs.szubreweryclient.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.itbs.szubreweryclient.configuration.RestTemplateClient;
import xyz.itbs.szubreweryclient.web.model.BeerDTO;
import xyz.itbs.szubreweryclient.web.model.CustomerDTO;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {CustomerClient.class, RestTemplateClient.class})
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    void getCustomerById() {
        CustomerDTO dto = customerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewCustomer() {
        CustomerDTO dto = CustomerDTO.builder().name("Tester").build();
        URI uri = customerClient.saveNewCustomer(dto);
        assertNotNull(uri);
    }

    @Test
    void updateCustomer() {
        CustomerDTO dto = CustomerDTO.builder().name("Tester").build();
        customerClient.updateCustomer(UUID.randomUUID(), dto);
    }

    @Test
    void deleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }
}