package com.oralcare.webapp.repositories;

import com.oralcare.webapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Long> {
    @Query(value = "select u from User u where u.email = ?1")
    User findByEmail(String email);

}
