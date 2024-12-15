package com.hritik.to_do.list.api.repository;

import com.hritik.to_do.list.api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
