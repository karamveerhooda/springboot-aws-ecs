package com.integrationninjas.springbootexample.service.impl;

import com.integrationninjas.springbootexample.dao.DeptDao;
//import com.integrationninjas.springbootexample.dto.UserDto;
import com.integrationninjas.springbootexample.dto.DeptDto;
//import com.integrationninjas.springbootexample.entity.User;
import com.integrationninjas.springbootexample.entity.Dept;
import com.integrationninjas.springbootexample.service.DeptService;
//import com.integrationninjas.springbootexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    
    @Autowired
    DeptDao deptDao;
    
    @Override
    public String createDept(DeptDto deptDto) {
        Dept dept = new Dept();
        dept.setDeptID(deptDto.getDeptID());
        dept.setDeptName(deptDto.getDeptName());
       // user. setLastName(userDto.getLastName());
       // dept.setEmail(userDto.getEmail());
        deptDao.saveAndFlush(dept);
        return "Department Added Successfully";
    }

    @Override
    public List<DeptDto> getDept() {
        List<Dept> deptList = deptDao.findAll();
        List<DeptDto> dtoList = new ArrayList<>();
        if (!deptList.isEmpty()) {
            deptList.forEach(dept -> {
                DeptDto dto = new DeptDto();
                dto.setDeptID(dept.getDeptID());
                dto.setDeptName(dept.getDeptName());
               // dto.setLastName(user.getLastName());
               // dto.setEmail(user.getEmail());
                dtoList.add(dto);
            });
        }
        return dtoList;
    }
}
