package com.jpamysql.cruddemo.usercrudapplication.repository;

import com.jpamysql.cruddemo.usercrudapplication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User,String> {
    List<User> findBylastname(String lastname);
}
