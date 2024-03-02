package org.example.entityOneToMany;


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


        Product product = Product.builder()
                .productName("Apple Iphone")
                .price(3400)
                .build();
        try {
            @Cleanup SessionFactory sessionFactory = MyHibernateConfiguration.buildSessionFactory();
            @Cleanup Session session = sessionFactory.openSession();
            session.beginTransaction();

            ProductType productType = session.get(ProductType.class, 1);
//            productType.addToProductTypeList(product);
//            session.persist(productType);
            productType.getListOfProducts()
                    .removeIf(prod -> prod.getProductId() == 1);
            session.getTransaction().commit();
        }catch (Exception exception){
            log.error("Error occurred. ", exception);
            throw exception;
        }


    }
}