package com.easylearn.usermicroservice.services;

import com.easylearn.usermicroservice.dtos.UserDTO;
import com.easylearn.usermicroservice.mappers.UserDTOMapper;
import com.easylearn.usermicroservice.persistence.UserEntity;
import com.easylearn.usermicroservice.persistence.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepositary userRepositary;
    @Autowired
    UserDTOMapper userDTOMapper;
    @Autowired
    MongoTemplate mongoTemplate;
    public UserService(UserRepositary userRepositary){
        this.userRepositary = userRepositary;
    }
    public UserEntity createUser(UserDTO userDTO){
        Date date = new Date();
        UserEntity user = userDTOMapper.mapUserDTOtoEntity(userDTO);
        user.setCreated_at(date);
        user.setUpdated_at(date);
        user.setRole("user");
        return userRepositary.save(user);
    }
    public UserDTO getUser(Long id){
        Optional<UserEntity> optionalUserEntity = userRepositary.findByUserId(id);
        if (optionalUserEntity.isEmpty()){
            return null;
        }
        UserEntity user = optionalUserEntity.get();
        return userDTOMapper.mapUserEntityToDTO(user);
    }
    public List<UserDTO> getAllUsers(){
        Iterable<UserEntity> userEntities = userRepositary.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for(UserEntity userEntity: userEntities){
            userDTOS.add(userDTOMapper.mapUserEntityToDTO(userEntity));
        }
        if(userDTOS.isEmpty()){
            return null;
        }
        return userDTOS;
    }
    public UserEntity updateUser(Long id, UserDTO userDTO){
        userRepositary.deleteUserEntityByUserId(id);
        UserEntity user = userDTOMapper.mapUserDTOtoEntity(userDTO);
        user.setUserId(id);
        user.setUpdated_at(new Date());
        userRepositary.save(user);
        return user;
    }
    public void deleteUser(Long id){
        userRepositary.deleteUserEntityByUserId(id);
    }


}
