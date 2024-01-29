package com.example.productservice_proxy.services;

import com.example.productservice_proxy.Models.Product;
import com.example.productservice_proxy.Models.SortParam;
import com.example.productservice_proxy.Repositories.ProductRepo;
//import com.example.productservice_proxy.Repositories.ProductSearchRepo;
//import com.example.productservice_proxy.Repositories.ProductRepository;
import com.example.productservice_proxy.Repositories.ProductSearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private ProductRepo productRepo;

    private ProductSearchRepo productSearchRepo;

    public SearchService(ProductRepo productRepo, ProductSearchRepo productSearchRepo) {
        this.productRepo = productRepo;
        this.productSearchRepo = productSearchRepo;
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

        //return productRepo.findByTitleEquals(query, PageRequest.of(pageNumber, sizeOfPage, sort));

        return productSearchRepo.findAllByTitleContaining(query);

    }
}
