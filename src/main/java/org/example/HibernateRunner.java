package org.example;


import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.example.entityOneToMany.Product;
import org.example.entityOneToMany.ProductType;
import org.example.util.MyHibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.HashSet;

@Slf4j
public class HibernateRunner {


    public static void main(String[] args) {
        ProductType productType = ProductType.builder()
                .productTypeName("MOBILE")
                .build();

        Product product = Product.builder()
                .productName("Samsung S22")
                .price(1990)
                .build();
        productType.addToProductTypeList(product);
        try {
            @Cleanup SessionFactory sessionFactory = MyHibernateConfiguration.buildSessionFactory();
            @Cleanup Session session = sessionFactory.openSession();
            session.beginTransaction();
//            Product product = Product.builder()
//                    .productName("Apple Iphone 14")
//                    .price(3500)
//                    .productType(productType)
//                    .build();
//            productType.addToProductTypeList(product);
            session.persist(productType);
            session.getTransaction().commit();
        }catch (Exception exception){
            log.error("Error occurred. ", exception);
            throw exception;
        }


    }
}