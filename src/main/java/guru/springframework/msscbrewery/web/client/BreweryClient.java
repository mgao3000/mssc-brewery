package guru.springframework.msscbrewery.web.client;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {
    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";

    private String apihost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDto getCustomerById(@NotNull UUID customerId) {
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + customerId.toString(),
                CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto) {
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1,
                customerDto);
    }

    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + customerId.toString(),
                customerDto);
    }

    public void deleteCustomerById(UUID customerId) {
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + customerId);
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
