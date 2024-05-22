package com.example.productservice_proxy.Security;

import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class JwtObject {
    String email;
    Long userId;
    Date CreatedAt;
    Date ExpiryAt;
    List<Role> role = new ArrayList<>();

}