package org.sg.flooring.dtos;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @NotNull(message = "{error.null.firstname}")
    @NotBlank(message = "{error.blank.firstname}")
    @NotEmpty(message = "{error.empty.firstname}")
    @Pattern(regexp = "[a-zA-Z]*", message = "{error.invalid.firstname}")
    @Column(name = "first_name", nullable = false, length = 75)
    private String firstName;

    @NotNull(message = "{error.null.lastname}")
    @NotBlank(message = "{error.blank.lastname}")
    @NotEmpty(message = "{error.empty.lastname}")
    @Pattern(regexp = "[a-zA-Z]*", message = "{error.invalid.lastname}")
    @Column(name = "last_name", nullable = false, length = 75)
    private String lastName;

    @NotNull(message = "{error.null.email}")
    @NotBlank(message = "{error.blank.email}")
    @NotEmpty(message = "{error.empty.email}")
    @Email(message = "{error.email}")
    @Lob
    @Column(name = "email_address", nullable = false, columnDefinition = "TEXT")
    private String email;

//    @Valid
//    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
////    @JoinColumn(name = "customer_address_id")
//    private Address address;
//
//    @Valid
//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer", cascade = {CascadeType.ALL})
//    private PaymentDetail paymentDetail;
//
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Order> orders = new HashSet<>(0);

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer() {

    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//    public PaymentDetail getPaymentDetail() {
//        return paymentDetail;
//    }
//
//    public void setPaymentDetail(PaymentDetail paymentDetail) {
//        this.paymentDetail = paymentDetail;
//    }
//
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getCustomerId() == customer.getCustomerId() &&
                getFirstName().equals(customer.getFirstName()) &&
                getLastName().equals(customer.getLastName()) &&
                getEmail().equals(customer.getEmail()) &&
                getOrders().equals(customer.getOrders());
//                getAddress().equals(customer.getAddress()) &&
//                getPaymentDetail().equals(customer.getPaymentDetail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getFirstName(), getLastName(), getEmail());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
        '}';
    }
}
