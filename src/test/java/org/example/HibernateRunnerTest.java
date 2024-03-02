package org.example;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.UserEntity;
import org.example.entityOneToMany.ProductType;
import org.example.util.MyHibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;


import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


@Slf4j
class HibernateRunnerTest {

    @Test
    void checkReflectionApi() throws SQLException, IllegalAccessException {
//        UserEntity user = UserEntity.builder()
//                .userName("Masha01")
//                .firstName("updateName")
//                .lastName("Sokolova")
//                .birthDay(LocalDate.of(2000, 8, 16))
//                .age(23)
//                .build();
//
//
//
//        String sql = """
//                insert
//                into %s
//                (%s)
//                values
//                (%s)
//                """;
//
//        String tableName = Optional.ofNullable(user.getClass().getAnnotation(Table.class))
//                .map(table -> table.schema() + "." + table.name())
//                .orElse(user.getClass().getName());
//        Field[] declaredFields = user.getClass().getDeclaredFields();
//        String columnNames = Arrays.stream(declaredFields)
//                .map(field -> Optional.ofNullable(field.getAnnotation(Column.class))
//                        .map(column -> column.name()).orElse(field.getName())
//                ).collect(Collectors.joining(", "));
//        String columnValues = Arrays.stream(declaredFields)
//                .map(field -> "?").collect(Collectors.joining(", "));
//        System.out.println(sql.formatted(tableName, columnNames, columnValues));
//        Connection connection = null;
//        PreparedStatement preparedStatement = connection.prepareStatement(sql.formatted(tableName, columnNames, columnValues));
//        for (Field field:declaredFields){
//            field.setAccessible(true);
//            preparedStatement.setObject(1, field.get(user));
//        }
    }

    @Test
    public void getProductTypeTest(){
        @Cleanup SessionFactory sessionFactory = MyHibernateConfiguration.buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();

        ProductType productType = session.get(ProductType.class, 1);
        log.info("Fetch product type: {}", productType);
        log.info("Fetch products: {}", productType.getListOfProducts());
    }
}