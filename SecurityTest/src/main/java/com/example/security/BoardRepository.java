package com.example.security;

import org.springframework.data.jpa.repository.JpaRepository;
import java.lang.Long;
import com.example.security.BoardEntity;
import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Long>{
	BoardEntity findByBno(Long bno);
}
