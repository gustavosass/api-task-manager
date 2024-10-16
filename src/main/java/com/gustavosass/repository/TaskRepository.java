package com.gustavosass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gustavosass.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	@Query("SELECT t FROM tb_task t JOIN t.users u WHERE u.id = :id")
	List<Task> findTasksByUserId(@Param("id") Long id);
}
