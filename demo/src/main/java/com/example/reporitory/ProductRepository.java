package com.example.reporitory;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entiry.Product;

@Repository
public interface ProductRepository extends JpaRepository <Product, Integer> {
	
}
