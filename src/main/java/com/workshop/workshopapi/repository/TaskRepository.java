package com.workshop.workshopapi.repository;

import com.workshop.workshopapi.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
