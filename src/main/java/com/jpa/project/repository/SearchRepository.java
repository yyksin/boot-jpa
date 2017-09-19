package com.jpa.project.repository;

import com.jpa.project.model.T_SEARCH;
import org.hibernate.sql.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sun.jvm.hotspot.debugger.linux.sparc.LinuxSPARCThreadContext;

import java.util.List;

/**
 * Created by IMC021 on 2017. 9. 6..
 */
/*
int getNumber();                     //현재 페이지
int getSize();                            //페이지 크기
int getTotalPages();                 //전체 페이지 수
int getNumberOfElements();   //현재 페이지에 나올 데이터 수
long getTotalElements();         //전체 데이터 수
boolean hasPreviousPage();    //이전 페이지 여부
boolean isFirstPage();              //현재 페이지가 첫 페이지 인지 여부
boolean hasNextPage();           //다음 페이지 여부
boolean isLastPage();               //현재 페이지가 마지막 페이지 인지 여부
Pageable nextPageable();         //다음 페이지 객체, 다음 페이지가 없으면 null
Pageable previousPageable();   //다음 페이지 객체, 이전 페이지가 없으면 null
List<T> getContent();               //조회된 데이터
boolean hasContent();              //조회된 데이터 존재 여부
Sort getSort();                           //정렬정보
*/
public interface SearchRepository extends JpaRepository<T_SEARCH, Integer>{


    @Query("SELECT CONCAT(IFNULL(SUBJECT,''),' ',MEMO) AS MEMO  FROM T_SEARCH")
    List<T_SEARCH> findAllMemo();

    List<T_SEARCH> findByMemo(String memo);

    @Query("select u from T_SEARCH u  where u.memo like %:memo% OR u.subject like %:memo%")
    Page<T_SEARCH> findLikeMemo(@Param("memo")String memo, Pageable pageable);
}
