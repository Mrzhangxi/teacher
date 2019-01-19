package com.zx.teachers.Repository;

import com.zx.teachers.Entity.Root;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RootRepository extends JpaRepository<Root, Integer> {
    Root findById(int id);
}
