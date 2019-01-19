package com.zx.teachers.Repository;

import com.zx.teachers.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int id);

    User findByUserName(String username);

    User deleteById(int id);
}
