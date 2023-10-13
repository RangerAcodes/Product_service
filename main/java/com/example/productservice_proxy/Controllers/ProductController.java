package com.example.productservice_proxy.Controllers;


import com.example.productservice_proxy.DTOs.ProductDto;
import com.example.productservice_proxy.Models.Product;
import org.springframework.web.bind.annotation.*;

//This controller will always answer products
@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("")
    public String getAllProducts(){
        return "Getting all the Products";

    }

    @GetMapping("/{productId}")
    public String getSingleProduct(@PathVariable("productId") Long productId){
        return "Returning Single Product with id " + productId;

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
