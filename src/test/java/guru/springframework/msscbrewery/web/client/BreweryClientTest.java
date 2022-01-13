package guru.springframework.msscbrewery.web.client;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    public void testGetCustomerById() {
        CustomerDto customerDto = breweryClient.getCustomerById(UUID.randomUUID());

        assertNotNull(customerDto);
    }

    @Test
    public void testSaveNewCustomer() {
        //Given
        CustomerDto customerDto = CustomerDto.builder()
                .name("New Customer Name")
                .build();
        URI uri = breweryClient.saveNewCustomer(customerDto);

        assertNotNull(uri);
        log.info("Returned URI from breweryClient.saveNewCustomer(customerDto) is: {}",
                uri.toString());
    }

    @Test
    public void testSaveNewCustomerWithShortName() {
        //Given
        CustomerDto customerDto = CustomerDto.builder()
                .name("ABC")
                .build();
        URI uri = breweryClient.saveNewCustomer(customerDto);

        assertNotNull(uri);
        log.info("Returned URI from breweryClient.saveNewCustomer(customerDto) is: {}",
                uri.toString());
    }

    @Test
    public void testUpdateCustomer() {
        //Given
        CustomerDto customerDto = CustomerDto.builder()
                .name("New Customer Name")
                .build();
        breweryClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    public void testDeleteCustomerById() {
        breweryClient.deleteCustomerById(UUID.randomUUID());
    }
}