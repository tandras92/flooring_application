package org.sg.flooring.service;

import org.sg.flooring.dtos.Customer;
import org.sg.flooring.exceptions.MasteryPersistenceException;
import org.sg.flooring.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service("customerServiceImpl")
@Transactional
public class CustomerServiceImpl implements CustomerService{

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

//    @Autowired
//    private CustomerDao customerDao;
      @Autowired
      private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) throws MasteryPersistenceException {
        LOGGER.info("Adding new customer to system: " + customer);
        return customerRepository.save(customer);    }

    @Override
    @Transactional(readOnly = true)
    public Customer findCustomerByCustomerId(long customerId) {
        Customer customer = customerRepository.findCustomerByCustomerId(customerId);

        if(customer != null) {
            return customer;
        }
        throw new RuntimeException("Unknown Customer with id: " + customerId);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> getCustomers() {
        LOGGER.info("Retrieving CUSTOMER list");
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> getCustomers(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return customerRepository.findAll();
        } else {
            return customerRepository.search(stringFilter);
        }
    }

    @Override
    public Customer findCustomerByLastName(String lastName) {
        Customer customer = customerRepository.findCustomerByLastName(lastName);

        if (customer != null) {
            return customer;
        }
        throw new RuntimeException("Unknown Customer with last name: " + lastName);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(long customerId) {
        customerRepository.deleteById(customerId);
    }

    /**
     * Generate test data to populate database
     */
//    @PostConstruct
//    @Override
//    public void populateTestData() {
//        if (customerRepository.count() == 0) {
//            customerRepository.saveAll(
//                    Stream.of("Tiny Tim", "Daisy Johnson",
//                            "Doc McStuffins")
//                    .map(name -> {
//                        String[] split = name.split(" ");
//                        Customer customer = new Customer();
//                        customer.setFirstName(split[0]);
//                        customer.setLastName(split[1]);
//                        String email = (customer.getFirstName() + "." +
//                                customer.getLastName() + "@testUserData.com")
//                                .replaceAll("[\\s-]", "")
//                                .toLowerCase();
//                        customer.setEmail(email);
//                        return customer;
//                    }).collect(Collectors.toList()));
//        }
//    }
}
