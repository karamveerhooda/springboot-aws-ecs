package com.integrationninjas.springbootexample.dao;

import com.integrationninjas.springbootexample.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptDao extends JpaRepository<Dept, Long> {
}
