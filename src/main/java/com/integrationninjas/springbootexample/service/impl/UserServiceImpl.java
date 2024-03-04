package com.integrationninjas.springbootexample.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.integrationninjas.springbootexample.dao.DeptDao;
import com.integrationninjas.springbootexample.dao.UserDao;
import com.integrationninjas.springbootexample.dto.UserDto;
import com.integrationninjas.springbootexample.entity.User;
import com.integrationninjas.springbootexample.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public String createUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        userDao.saveAndFlush(user);
        return "New user Added Successfully";
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> usersList = userDao.findAll();
        List<UserDto> dtoList = new ArrayList<>();
        if (!usersList.isEmpty()) {
            usersList.forEach(user -> {
                UserDto dto = new UserDto();
                dto.setId(user.getId());
                dto.setFirstName(user.getFirstName());
                dto.setLastName(user.getLastName());
                dto.setEmail(user.getEmail());
                dtoList.add(dto);
            });
        }
        return dtoList;
    }
    
}