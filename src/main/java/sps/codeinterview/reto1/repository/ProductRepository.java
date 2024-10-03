package sps.codeinterview.reto1.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sps.codeinterview.reto1.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query(value = "select p from Product p where upper(p.name) like upper(concat('%',:name,'%')) order by p.name desc")
	List<Product> findByName(@Param("name") String name);
	
}
