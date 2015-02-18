package com.drishticon.mercator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.drishticon.mercator.dao.CustomerRepository;
import com.drishticon.mercator.domain.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerRepository customerRepo;

	private final EntityLinks entityLinks;

	@Autowired
	public CustomerController(CustomerRepository repository, EntityLinks entityLinks) {
		this.customerRepo = repository;
		this.entityLinks = entityLinks;
	}

	@RequestMapping(method = RequestMethod.GET)
	HttpEntity<Resources<Customer>> showCustomers() {
		Resources<Customer> resources = new Resources<Customer>(this.customerRepo.findAll());
		resources.add(this.entityLinks.linkToCollectionResource(Customer.class));
		return new ResponseEntity<Resources<Customer>>(resources, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	HttpEntity<Resource<Customer>> showCustomer(@PathVariable Long id) {
		Resource<Customer> resource = new Resource<Customer>(this.customerRepo.findOne(id));
		resource.add(this.entityLinks.linkToSingleResource(Customer.class, id));
		return new ResponseEntity<Resource<Customer>>(resource, HttpStatus.OK);
	}

	@RequestMapping("/")
	public Iterable<Customer> getAll() {
		return customerRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Customer create(@RequestBody Customer customer) {
		return customerRepo.save(customer);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable Long id) {
		customerRepo.delete(id);
		logger.info("deleted : ", id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Customer update(@PathVariable Long id, @RequestBody Customer customer) {
		Customer updateCustomer = customerRepo.findOne(id);
		BeanUtils.copyProperties(customer, updateCustomer);
		return customerRepo.save(updateCustomer);
	}

}
