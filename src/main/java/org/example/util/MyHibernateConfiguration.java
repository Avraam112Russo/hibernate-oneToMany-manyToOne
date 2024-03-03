package org.example.util;

import lombok.experimental.UtilityClass;
import org.example.orderBy.MyDepartment;
import org.example.orderBy.MyEmployee;
import org.example.entity.converter.BirthdayConverter;
import org.example.entity.converter.DepartmentConverter;
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
//        configuration.addAnnotatedClass(MyUser.class);
//        configuration.addAnnotatedClass(MyChat.class);

//        configuration.addAnnotatedClass(User.class);
//        configuration.addAnnotatedClass(Chat.class);
//        configuration.addAnnotatedClass(UsersChats.class);


        configuration.addAnnotatedClass(MyEmployee.class);
        configuration.addAnnotatedClass(MyDepartment.class);

        // convert Birthday class -> SQL Format
        configuration.addAttributeConverter(new BirthdayConverter());
        configuration.addAttributeConverter(new DepartmentConverter());
        configuration.configure();
//        // convert JSONB from SQL to String
//        configuration.registerTypeOverride(new JsonBinaryType());
        return configuration.buildSessionFactory();
    }
}
