package com.example.productservice_proxy.Controllers;


import com.example.productservice_proxy.DTOs.ProductDto;
import com.example.productservice_proxy.Models.Product;
import com.example.productservice_proxy.ProductServiceProxyApplication;
import com.example.productservice_proxy.services.ProductService;
import com.example.productservice_proxy.services.iProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//This controller will always answer products
@RestController
@RequestMapping("/products")
public class ProductController {



    iProductService productService;
    public ProductController(iProductService productService){
        this.productService = productService;
    }

    @GetMapping"")
    public String getAllProducts(){
        return "Getting all the Products";

    }

    @GetMapping("/{productId}")
    public String getSingleProduct(@PathVariable("productId") Long productId){
    productService.getSingleProduct(productId);
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
