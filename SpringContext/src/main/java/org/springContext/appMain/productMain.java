package org.springContext.appMain;

import org.springContext.Config.config;
import org.springContext.domain.product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class productMain {
    public static void main(String[] args){
        ApplicationContext context=new AnnotationConfigApplicationContext(config.class);
        product obj=(product) context.getBean("productBean2");
        System.out.println(obj);

        product p1=context.getBean("productBean1", product.class);
        System.out.println(p1);
    }
}
