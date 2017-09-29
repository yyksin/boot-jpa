package com.jpa.project.repository;

import com.jpa.project.entity.T_USER;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by IMC021 on 2017. 9. 26..
 */
public interface UserRepository extends JpaRepository<T_USER, Integer>{


    @Query("SELECT a FROM T_USER a WHERE a.uid = :uid")
    public T_USER findOneByUid(@Param("uid") String uid);
}
