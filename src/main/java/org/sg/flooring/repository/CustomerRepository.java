package org.sg.flooring.repository;

import org.sg.flooring.dtos.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerByCustomerId(long customerID);

    Customer findCustomerByLastName(String lastName);

    /**
     * checks if the string matches the first or last name while ignoring case
     * @param stringFilter
     * @return
     */
    @Query("select c from Customer c " +
    "where lower (c.firstName) like lower (concat('%', :searchTerm, '%')) " +
    "or lower(c.lastName) like lower(concat('%', :searchTerm, '%'))")
    List<Customer> search(@Param("searchTerm") String stringFilter);
}
