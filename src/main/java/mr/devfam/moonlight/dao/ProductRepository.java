package mr.devfam.moonlight.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import mr.devfam.moonlight.entities.Product;

@CrossOrigin("*")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
	@RestResource(path = "/selectedProducts")
	public List<Product> findBySelectedIsTrue();

	@RestResource(path = "/dispoProducts")
	public List<Product> findByAvailableIsTrue();
	
	@RestResource(path = "/promoProducts")
	public List<Product> findByPromotionIsTrue();
	
	@RestResource(path = "/productsByKeyword")
	public List<Product> findByNameContains(@Param("mc") String mc);
} 
