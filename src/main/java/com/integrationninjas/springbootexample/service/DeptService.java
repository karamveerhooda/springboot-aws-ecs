package com.integrationninjas.springbootexample.service;

import com.integrationninjas.springbootexample.dto.DeptDto;
//import com.integrationninjas.springbootexample.entity.User;

import java.util.List;

public interface DeptService {

    String createDept(DeptDto deptDto);

    List<DeptDto> getDept();
}
