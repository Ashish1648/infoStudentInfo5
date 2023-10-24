package com.info5.service.impl;

import com.info5.Dto.AddressDto;
import com.info5.Entity.Address;
import com.info5.Entity.User;
import com.info5.UserDto;
import com.info5.exception.ResourseNotFoundException;
import com.info5.repository.AddressRepository;
import com.info5.repository.UserRepository;
import com.info5.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
            AddressRepository addressRepository;

    public UserServiceImpl(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public UserDto saveData(UserDto userDto) {
        Address address=new Address();
        address.setArea(userDto.getAddress().getArea());
        address.setLocation(userDto.getAddress().getLocation());
        address=addressRepository.save(address);
        User user=new User();
       user.setId(userDto.getId());
        user.setUserName(userDto.getUserName());
        user.setAddress(address);
        user=userRepository.save(user);
        UserDto dto=new UserDto();
        dto.setId(user.getId());
        dto.setUserName(user.getUserName());
        AddressDto addressDto=new AddressDto();
        addressDto.setLocation(address.getLocation());
        addressDto.setArea(user.getAddress().getArea());
        dto.setAddress(addressDto);
        return dto;

    }

    @Override
    public UserDto findDataById(long id) {

        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourseNotFoundException("Not present with that id")
        );
        UserDto dto=new UserDto();
        dto.setUserName(user.getUserName());
        AddressDto addressDto=new AddressDto();
        addressDto.setId(user.getAddress().getId());
        addressDto.setArea(user.getAddress().getArea());
        addressDto.setLocation(user.getAddress().getLocation());
        dto.setAddress(addressDto);
        return dto;
    }

    @Override
    public void DeleteByid(long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourseNotFoundException("not present with given id")
        );
        userRepository.deleteById(id);

    }
}
