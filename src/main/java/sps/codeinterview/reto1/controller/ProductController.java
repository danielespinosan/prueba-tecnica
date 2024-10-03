package sps.codeinterview.reto1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import sps.codeinterview.reto1.model.Product;
import sps.codeinterview.reto1.repository.ProductRepository;

@RestController
@RequestMapping("/crud")
@Validated
public class ProductController {

	// Add the correct notations
	@Autowired
	private ProductRepository productRepository;

	// Add notation GET: /products
	@GetMapping(path = "/products")
	public List<Product> getProducts() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	// Add notation GET: /product/{id}
	@GetMapping(path = "/product/{id}")
	public Product getProductById(@PathVariable Long id) {
		Optional<Product> opProduct = productRepository.findById(id);
		Product product = null;
		if (opProduct.isPresent()) {
			product = opProduct.get();
		}
		return product;
	}

	// Add notation POST: /product
	@PostMapping(path = "/product")
	public Product createProduct(@Valid @RequestBody Product product) {
		System.out.println(product.toString());
		product = productRepository.save(product);
		return product;
	}

	// Add notation PUT: product/{id}
	@PutMapping(path = "/product/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Product product) {
		Optional<Product> opProduct = productRepository.findById(id);
		Product productBd = null;
		if (opProduct.isPresent()) {
			productBd = opProduct.get();
			productBd.setLabel(product.getLabel());
			productBd.setName(product.getName());
			productBd.setPrice(product.getPrice());
			productRepository.save(productBd);
		}
		return new ResponseEntity<>("Registro actualizado exitosamente", HttpStatus.OK);
	}

	// Add notation DELETE: product/{id}
	@DeleteMapping(path = "/product/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productRepository.deleteById(id);
		return "registro eliminado exitosamente";
	}
	
	@GetMapping(path = "/product/name/{name}")
	public List<Product> getProductsByName(@PathVariable String name){
		List<Product> products = productRepository.findByName(name);
		return products;
	}
	
	
}