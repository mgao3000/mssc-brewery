package guru.springframework.msscbrewery.web.mapper;

import guru.springframework.msscbrewery.domain.Customer;
import guru.springframework.msscbrewery.domain.Customer.CustomerBuilder;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import guru.springframework.msscbrewery.web.model.CustomerDto.CustomerDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-13T14:17:03-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Ubuntu)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public CustomerDto customerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDtoBuilder customerDto = CustomerDto.builder();

        customerDto.id( customer.getId() );
        customerDto.name( customer.getName() );
        customerDto.createdDate( dateMapper.asLocalDateTime( customer.getCreatedDate() ) );
        customerDto.lastUpdatedDate( dateMapper.asLocalDateTime( customer.getLastUpdatedDate() ) );

        return customerDto.build();
    }

    @Override
    public Customer customerDtoToCustomer(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        CustomerBuilder customer = Customer.builder();

        customer.id( customerDto.getId() );
        customer.name( customerDto.getName() );
        customer.createdDate( dateMapper.asTimestamp( customerDto.getCreatedDate() ) );
        customer.lastUpdatedDate( dateMapper.asTimestamp( customerDto.getLastUpdatedDate() ) );

        return customer.build();
    }
}
