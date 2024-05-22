package com.example.productservice_proxy.services;

import com.example.productservice_proxy.Models.Product;
import com.example.productservice_proxy.Models.SortParam;
//import com.example.productservice_proxy.Repositories.ProductRepo;
import com.example.productservice_proxy.ElasticsearchRepo.ProductElasticSearchRepo;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    //private ProductRepo productRepo;
    private ProductElasticSearchRepo productElasticSearchRepo;

    public SearchService(ProductElasticSearchRepo productElasticSearchRepo){//, ProductRepo productRepo) {
        //this.productRepo = productRepo;
        this.productElasticSearchRepo = productElasticSearchRepo;
    }

    public List<Product> searchProducts(String query, int pageNumber, int sizeOfPage,
                                        List<SortParam> sortParamList) {
//        Sort sort = Sort.by("title").descending()
//                .and(Sort.by("price").descending());

        Sort sort;
        if(sortParamList.get(0).getSortType().equals("ASC")) {
            sort = Sort.by(sortParamList.get(0).getParamName());
        } else {
            sort = Sort.by(sortParamList.get(0).getParamName()).descending();
        }

        for(int i = 1; i< sortParamList.size(); i++) {
            if(sortParamList.get(i).getSortType().equals("ASC")) {
                sort = sort.and(Sort.by(sortParamList.get(i).getParamName()));
            } else {
                sort = sort.and(Sort.by(sortParamList.get(i).getParamName())
                        .descending());
            }
        }

        return productElasticSearchRepo.findAllByTitleContaining(query, PageRequest.of(pageNumber, sizeOfPage, sort));
    }
}