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
        // Create a Hibernate session
        Session session = entityManager.unwrap(Session.class);

        // HQL query to find user by email
        Query<User> query = session.createQuery(
                "FROM User WHERE email = :email", User.class);
        query.setParameter("email", email);

        // Return the result or null if no user found
        return query.uniqueResultOptional().orElse(null);
    }

    @Override
    public boolean existsByEmail(String email) {
        // Create a Hibernate session
        Session session = entityManager.unwrap(Session.class);

        // HQL query to count users with the given email
        Query<Long> query = session.createQuery(
                "SELECT COUNT(u) FROM User u WHERE u.email = :email", Long.class);
        query.setParameter("email", email);

        // Check if the count is greater than 0, indicating existence
        Long count = query.uniqueResult();
        return count != null && count > 0;
    }
}
