package org.sg.flooring.service;

import org.sg.flooring.dtos.Customer;
import org.sg.flooring.exceptions.MasteryPersistenceException;

import java.util.List;

public interface CustomerService {

    Customer addCustomer(Customer customer) throws MasteryPersistenceException;

    Customer findCustomerByCustomerId(long customerId);

    List<Customer> getCustomers();

    List<Customer> getCustomers(String stringFilter);

    Customer findCustomerByLastName(String lastName);

    void saveCustomer(Customer customer);

    void deleteCustomer(long customerId);

//    void populateTestData();
}
