package org.springContext.Config;

import org.springContext.domain.product;
import org.springframework.context.annotation.Bean;

public class config {
    @Bean("productBean1")
    public product getProduct1(){
       product p1=new product();
       p1.setProductId(101);
       p1.setProductName("abc");
       p1.setGetProductprice(120);
       return p1;
    }
    @Bean("productBean2")
    public product getProduct2(){
        return new product(102,"xyz",150);
    }
}
