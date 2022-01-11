package by.avp.customer_demo.service;

import by.avp.customer_demo.model.Customer;
import by.avp.customer_demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService{

//    @Autowired
    private final CustomerRepository customerRepository;

    @Override
    public Customer findById(Integer id) {
        log.info("Method getById started in class {}", getClass().getName());
        return customerRepository.findById(id).get();
    }

    @Override
    public Collection<Customer> getAll() {
        log.info("Method getAll started in class {}", getClass().getName());
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        log.info("Method save started with customer {} in class {}", customer, getClass().getName());
        customerRepository.save(customer);
    }

    @Override
    public void delete(Integer id) {
        log.info("Method save started with id {} in class {}", id, getClass().getName());
        customerRepository.deleteById(id);
    }
}
