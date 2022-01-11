package by.avp.customer_demo.rest;

import by.avp.customer_demo.model.Customer;
import by.avp.customer_demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerRestControllerV1 {

//    @Autowired
    private final CustomerService customerService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> saveCustomer(@RequestBody @Validated Customer customer) {
        HttpHeaders headers = new HttpHeaders();

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.customerService.save(customer);
        return new ResponseEntity<>(customer, headers, HttpStatus.CREATED);
    }

//    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Customer> updateCustomer(@RequestBody @Validated Customer customer, UriComponentsBuilder builder) {
//        HttpHeaders headers = new HttpHeaders();
//
//        if (customer == null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        this.customerService.save(customer);
//        return new ResponseEntity<>(customer, headers, HttpStatus.OK);
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Integer id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<Customer>> getAllCustomers() {
        Collection<Customer> customers = customerService.getAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
