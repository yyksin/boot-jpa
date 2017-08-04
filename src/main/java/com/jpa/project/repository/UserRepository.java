package com.jpa.project.repository;

import com.jpa.project.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IMC021 on 2017. 8. 4..
 */
public interface UserRepository extends JpaRepository<Users, Integer>{
}
