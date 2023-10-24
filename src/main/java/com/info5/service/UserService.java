package com.info5.service;

import com.info5.UserDto;

public interface UserService {
    public UserDto saveData(UserDto userDto);
    public UserDto findDataById(long id);
    public void DeleteByid(long id);
}
