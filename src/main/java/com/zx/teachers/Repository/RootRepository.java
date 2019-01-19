package com.zx.teachers.Repository;

import com.zx.teachers.Entity.Root;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RootRepository extends JpaRepository<Root, Integer> {

    /**
     * 通过ID查询root管理员
     * @param id
     * @return
     */
    Root findById(int id);

}
