package com.wildcodeschool.checkpoint4.Repository;

import com.wildcodeschool.checkpoint4.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String text);
}
