package com.JpaMySql.CRUD_Demo.UserCRUDapp.serivces;

import com.JpaMySql.CRUD_Demo.UserCRUDapp.domain.User;
import com.JpaMySql.CRUD_Demo.UserCRUDapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User updateUser(User user, String email) {
        Optional<User> opuser=userRepository.findById(email);
        if(opuser.isEmpty()){
            return null;
        }
        User existinguser=opuser.get();
        if(user.getFirstName()!=null){
            existinguser.setFirstName(user.getFirstName());
        }
        if(user.getLastName()!=null){
            existinguser.setLastName(user.getLastName());
        }
        if(user.getPassword()!=null){
            existinguser.setPassword(user.getPassword());
        }
        return userRepository.save(existinguser);
    }

    @Override
    public boolean deleteUserByEmail(String email) {
        userRepository.deleteById(email);
        return true;
    }

    @Override
    public List<User> getUserByLastName(String LastName) {
        return (List<User>) userRepository.findBylastname(LastName);
    }
}
