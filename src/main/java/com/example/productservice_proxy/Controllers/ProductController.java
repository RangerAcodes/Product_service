package com.example.productservice_proxy.Controllers;


import com.example.productservice_proxy.DTOs.ProductDto;
import com.example.productservice_proxy.Models.Categories;
import com.example.productservice_proxy.Models.Product;
import com.example.productservice_proxy.Security.TokenValidator;
import com.example.productservice_proxy.clients.IClientProductDto;
import com.example.productservice_proxy.services.IProductService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//This controller will always answer products

@RestController
@RequestMapping("/products")
public class ProductController {

    IProductService productService;
    TokenValidator tokenValidator;
    ProductDto productDto;
    public ProductController(IProductService productService, TokenValidator tokenValidator) {
        this.productService = productService;
        this.tokenValidator = tokenValidator;
    }

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(this.productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long productId) {
        logger.debug("Received request for product with ID: {}", productId);
        try {
            if (productId < 1) {
                throw new IllegalArgumentException("Invalid product ID");
            }
            Product product = productService.getSingleProduct(productId);

            //ProductDto productDto = productService.getSingleProduct(productId);

            logger.debug("Returning product with ID: {}", productId);
            return new ResponseEntity<>(product, HttpStatus.OK);

        } catch (EntityNotFoundException e) {
            logger.error("Product with ID: {} not found", productId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 error code

        } catch (IllegalArgumentException e) {
            logger.error("Invalid product ID: {}", productId);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 400 error code

        } catch (Exception e) {
            logger.error("Internal server error for product ID: {}", productId, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 error code
        }
    }

    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto) {
        Product product = getProduct(productDto);
        Product savedproduct = this.productService.addNewProduct(product);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(savedproduct, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId) {
        return "Updating product";
    }

    @PatchMapping("/{productId}")
    public Product patchProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto) {

        Product product = new Product();
        product.setId(productDto.getId());
        product.setCategory(new Categories());
        product.getCategory().setName(productDto.getCategory());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        return this.productService.updateProduct(productId, product);
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        return "Deleting a product with id: " + productId;
    }

    //@ExceptionHandler({NullPointerException.class, IllegalArgumentException.class})
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("Kuch toh phat hai", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Product getProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Categories category = new Categories();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setImageUrl(productDto.getImage());
        product.setDescription(productDto.getDescription());
        return product;
    }


    //@GetMapping("/{id}")
//    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long productId) {
//        try {
//            if(productId < 1) {
//                throw new IllegalArgumentException("Something went wrong");
//            }
//            else {
////            JwtObject authTokenObj = null;
////            if(authToken != null) {
////                Optional<JwtObject> authObjectOptional = tokenValidator.validateToken(authToken);
////                if(authObjectOptional.isEmpty()) {
////                    // throw exception
////                }
////                authTokenObj = authObjectOptional.get();
////            }
////            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
////            headers.add("Accept", "application/json");
////            headers.add("Content-Type", "application/json");
////            headers.add("auth-token", "heyaccess");
//            // Apply rule based user Roles
//            // Product product = this.productService.getSingleProduct(productId, authTokenObj);
//
////            if(productId < 1) {
////                throw new IllegalArgumentException("Something went wrong");
////            }
//            return new ResponseEntity<>(productService.getSingleProduct(productId), HttpStatus.OK);
//            //Product product = this.productService.getSingleProduct(productId);
//            //ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//            //return responseEntity;
//            }
//
//        } catch (Exception e) {
//            //ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//            //return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 error code
//            throw e;
//        }
//    }
}