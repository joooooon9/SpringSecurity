package com.example.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.lang.String;
import com.example.security.UserEntity;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
	UserEntity findById(String id);
	
	long count();
	
	@Query("SELECT u FROM UserEntity u WHERE u.id = :id")
	UserEntity findUserById(@Param("id") String id);
	
	@Query(value = "SELECT * FROM users where id = :id", nativeQuery = true)
	UserEntity findUserByIdNativequery(@Param("id") String id);
	
	@Query("SELECT b FROM BoardEntity b RIGHT JOIN fetch b.user WHERE b.user.id = :id")
	UserEntity findUserAndBoard(@Param("id") String id);
}
