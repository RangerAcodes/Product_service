package com.example.productservice_proxy.Controllers;

import com.example.productservice_proxy.DTOs.ProductDto;
import com.example.productservice_proxy.DTOs.SearchRequestDto;
import com.example.productservice_proxy.Models.Categories;
import com.example.productservice_proxy.Models.Product;
import com.example.productservice_proxy.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    SearchService searchService;

    public SearchController (SearchService searchService){
        this.searchService = searchService;
    }

    @PostMapping
    public List<ProductDto> searchProducts(@RequestBody SearchRequestDto searchRequestDto){
        List<Product> result = searchService.searchProducts(searchRequestDto.getQuery(),
                searchRequestDto.getPageNumber(),searchRequestDto.getSizeOfPage(), searchRequestDto.getSortParamList());
        List<ProductDto> shareableResult = new LinkedList<>();
        for(Product product: result){
            shareableResult.add(getProduct(product));
        }
        return shareableResult;
    }
    private ProductDto getProduct(Product p) {
        ProductDto product = new ProductDto();
        product.setId(p.getId());
        product.setTitle(p.getTitle());
        product.setPrice(p.getPrice());
        return product;
    }
}