package com.example.employeemgmt.services.implement;

import com.example.employeemgmt.exceptions.PasswordIsIncorrectException;
import com.example.employeemgmt.exceptions.UsernameDoesNotExistException;
import com.example.employeemgmt.exceptions.WrongCredentialsException;
import com.example.employeemgmt.repositories.LoginRepository;
import com.example.employeemgmt.models.User;
import com.example.employeemgmt.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;

    @Override
    public Optional<User> findByUsernameAndPassword(String username, String password) {
        Optional<User> optionalUser = loginRepository.findByUsernameAndPassword(username, password);

        if (optionalUser.isEmpty()){
            throw new WrongCredentialsException("Wrong Credentials!");
        }

        return optionalUser;
    }

    @Override
    public Boolean findByUserName(String username) {
        boolean doesExist = loginRepository.existsByUsername(username);
        if (!doesExist) {
            throw new UsernameDoesNotExistException("Username does not exist");
        }
        return true;
    }

    @Override
    public Boolean checkPassword(String password) {
        boolean isCorrect = loginRepository.existsByPassword(password);
        if (!isCorrect) {
            throw new PasswordIsIncorrectException("Password Incorrect");
        }
        return true;
    }

    @Override
    public Optional<User> findByFirstName(String firstName) {
        Optional<User> name = loginRepository.findByFirstName(firstName);
        return name;
    }

    //new add


}
