package com.api.rest_code.repository;
import com.api.rest_code.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User customFindByEmail(String email) {
        Session session = entityManager.unwrap(Session.class);
        Query<User> query = session.createQuery(
                "FROM User WHERE email = :email", User.class);
        query.setParameter("email", email);
        return query.uniqueResultOptional().orElse(null);
    }
}