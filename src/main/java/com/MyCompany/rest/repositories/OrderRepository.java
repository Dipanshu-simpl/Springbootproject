package com.MyCompany.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MyCompany.rest.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long>
{

}
