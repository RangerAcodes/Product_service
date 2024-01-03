package com.example.productservice_proxy.DTOs;

import com.example.productservice_proxy.Models.SortParam;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchRequestDto {
    private String query;
    private int pageNumber;
    private int sizeOfPage;
    private List<SortParam> sortParamList;
}