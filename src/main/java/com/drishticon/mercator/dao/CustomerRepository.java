package com.drishticon.mercator.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.drishticon.mercator.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByCustomerCode(@Param("customerCode") String customerCode);
	List<Customer> findByCustomerName(@Param("customerName") String customerName);

}
