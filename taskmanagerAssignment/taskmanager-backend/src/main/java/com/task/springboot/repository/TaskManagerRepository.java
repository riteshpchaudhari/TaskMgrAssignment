package com.task.springboot.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.task.springboot.entity.Task;

@Repository
public interface TaskManagerRepository extends JpaRepository<Task,Long>{

}

