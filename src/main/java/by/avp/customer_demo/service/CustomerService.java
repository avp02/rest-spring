package by.avp.customer_demo.service;

import by.avp.customer_demo.model.Customer;

import java.util.Collection;

public interface CustomerService {

    Customer findById(Integer id);

    Collection<Customer> getAll();

    void save(Customer customer);

    void delete(Integer id);
}
