package com.student.studregister.repository;
import com.student.studregister.model.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentrepository extends JpaRepository<student,Long> {

    }


