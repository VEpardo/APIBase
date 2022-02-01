package com.baseapi.restaurant.services;

import com.baseapi.restaurant.entities.Customer;
import com.baseapi.restaurant.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements BaseService<Customer>{

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public List<Customer> findAll() throws Exception {
        try{
            List<Customer> entities = customerRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Customer findById(Long id) throws Exception {
        try{
            Optional<Customer> entityOptional = customerRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Customer save(Customer entity) throws Exception {
        try{
            entity = customerRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Customer update(Long id, Customer entity) throws Exception {
        try{
            Optional<Customer> entityOptional = customerRepository.findById(id);
            Customer customer = entityOptional.get();
            customer = customerRepository.save(customer);
            return customer;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(customerRepository.existsById(id)){
                customerRepository.deleteById(id);
                return true;
            }
            else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
