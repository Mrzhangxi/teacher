package com.zx.teachers.Repository;

import com.zx.teachers.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int id);

    User findByUserName(String username);

    User deleteById(int id);

    List<User> findAllByUserType(int typeid);

    @Query(value = "update t_user set user_title = '副教授' where id = 1", nativeQuery = true)
    void updateById();
}
