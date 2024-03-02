package org.example.util;

import lombok.experimental.UtilityClass;
import org.example.entityOneToOne.test.BankCredential;
import org.example.entityOneToOne.test.NewEmployee;
import org.example.entity.converter.BirthdayConverter;
import org.example.entity.converter.DepartmentConverter;
import org.example.manyToMany.MyChat;
import org.example.manyToMany.MyUser;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class MyHibernateConfiguration {
    public static SessionFactory buildSessionFactory(){
        Configuration configuration = new Configuration();
        // we indicated which class hibernate can mapping
//        configuration.addAnnotatedClass(UserEntity.class);
//        configuration.addAnnotatedClass(Employee.class);

//        configuration.addAnnotatedClass(NewEmployee.class);
//        configuration.addAnnotatedClass(BankCredential.class);
//
        configuration.addAnnotatedClass(MyUser.class);
        configuration.addAnnotatedClass(MyChat.class);
        // convert Birthday class -> SQL Format
        configuration.addAttributeConverter(new BirthdayConverter());
        configuration.addAttributeConverter(new DepartmentConverter());
        configuration.configure();
//        // convert JSONB from SQL to String
//        configuration.registerTypeOverride(new JsonBinaryType());
        return configuration.buildSessionFactory();
    }
}
