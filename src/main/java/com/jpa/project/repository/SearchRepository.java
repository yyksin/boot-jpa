package com.jpa.project.repository;

import com.jpa.project.model.T_SEARCH;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by IMC021 on 2017. 9. 6..
 */
public interface SearchRepository extends JpaRepository<T_SEARCH, Integer>{


    @Query("SELECT CONCAT(IFNULL(SUBJECT,''),' ',MEMO) AS MEMO  FROM T_SEARCH")
    List<T_SEARCH> findAllMemo();

    List<T_SEARCH> findByMemo(String memo);

}
