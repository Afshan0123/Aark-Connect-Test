package com.example.springbootaark.Repo;

import com.example.springbootaark.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.pid=:pid")
    Product findByPid(Long pid);

}
