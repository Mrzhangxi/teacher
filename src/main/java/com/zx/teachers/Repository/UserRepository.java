package com.zx.teachers.Repository;

import com.zx.teachers.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int id);

    User findByUserName(String username);

    @Transactional
    User deleteById(int id);

    List<User> findAllByUserType(int typeid);

    @Transactional//注解用于提交事务，若没有带上这句，会报事务异常提示
    @Modifying(clearAutomatically = true)//自动清除实体里保存的数据
    @Query(value = "update t_user set user_title = '副教授' where id = ?", nativeQuery = true)
    int updateById(int id);
}
