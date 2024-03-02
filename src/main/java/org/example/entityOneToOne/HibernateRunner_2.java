package org.example.entityOneToOne;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.example.entityOneToOne.SocialMediaUser;
import org.example.entityOneToOne.UserProfile;
import org.example.util.MyHibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Slf4j
public class HibernateRunner_2 {
    public static void main(String[] args) {


        try {
            @Cleanup SessionFactory sessionFactory = MyHibernateConfiguration.buildSessionFactory();
            @Cleanup Session session = sessionFactory.openSession();

            session.beginTransaction();
            SocialMediaUser user = SocialMediaUser.builder()
                    .userName("justinSun")
                    .build();
            UserProfile userProfile = UserProfile.builder()
                    .email("sun@mail.ru")
                    .build();
            userProfile.setUser(user);
            session.persist(user);

            session.getTransaction().commit();
        }catch (Exception exception){
            log.error("Error occurred: ", exception);
        }
    }
}
