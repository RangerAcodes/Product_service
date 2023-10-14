package com.example.productservice_proxy.Controllers;


import com.example.productservice_proxy.DTOs.ProductDto;
import com.example.productservice_proxy.Models.Product;
import com.example.productservice_proxy.services.IProductService;
import org.springframework.web.bind.annotation.*;

//This controller will always answer products
@RestController
@RequestMapping("/products")
public class ProductController {

    IProductService productService;
    public ProductController(IProductService productService){
        this.productService = productService;
    }

    @GetMapping("")
    public String getAllProducts(){
        return "Getting all the Products";

    }

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long productId){
    Product product = productService.getSingleProduct(productId);
        return product;
    }

    @PostMapping()
    public String addNewProduct(@RequestBody ProductDto productDto){
        return "Adding new product " +productDto;
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId){
        return "Updating product";

    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId")Long productId){
            return "Deleting a product with id" + productId;
    }


}
