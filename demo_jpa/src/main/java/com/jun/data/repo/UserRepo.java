package com.jun.data.repo;

import com.jun.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
    UserEntity findByName(String name);
    UserEntity findByNameAndAge(String name, Integer age);
    @Query("from UserEntity u where u.name=:name")
    UserEntity findUser(@Param("name") String name);
}
