package com.example.user.remember_me.ModeloDAO.Interface;

import com.example.user.remember_me.ModeloVO.TaskVO;
import com.example.user.remember_me.ModeloVO.UserVO;

import java.util.ArrayList;

public interface IUserDAO {
    // Buscar por id
    UserVO getUser();
   // add User
    boolean addUser(UserVO user);
    int updateUser(UserVO user);
}
