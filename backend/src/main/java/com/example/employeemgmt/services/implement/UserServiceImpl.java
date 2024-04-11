package com.example.employeemgmt.services.implement;

import com.example.employeemgmt.models.User;
import com.example.employeemgmt.models.UserSearchRequest;
import com.example.employeemgmt.repositories.UserRepository;
import com.example.employeemgmt.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User saveEmployee(User user) {
        if (Objects.isNull(user.getId())) {
            boolean doesUsernameExist = userRepository.existsByUsername(user.getUsername());
            boolean doesEmailExist = userRepository.existsByEmail(user.getEmail());
            if (doesUsernameExist) {
                throw new IllegalArgumentException("Username already exists");
            }
            if (doesEmailExist) {
                throw new IllegalArgumentException("Email already exists");
            }
        } else {
            Optional<User> existingUser = userRepository.findById(user.getId());
            if (existingUser.isEmpty()) {
                throw new RuntimeException("User not exist");
            } else {
                user.setAdmin(existingUser.get().isAdmin());
            }
        }
        return userRepository.save(user);
    }

    @Override
    public Page<User> searchEmployees(UserSearchRequest userSearchRequest) {
        String searchKey = userSearchRequest.getSearchKey();
        String searchValue = userSearchRequest.getSearchValue();

        Pageable pageRequest = PageRequest.of(userSearchRequest.getOffset(), userSearchRequest.getLimit(), Sort.by(userSearchRequest.getSortBy()));

        if (searchKey != null && !searchKey.isEmpty()) {
            return switch (searchKey) {
                case "firstName" -> userRepository.findByFirstName(searchValue, pageRequest);
                case "username" -> userRepository.findByUsername(searchValue, pageRequest);
                case "email" -> userRepository.findByEmail(searchValue, pageRequest);
                case "lastName" -> userRepository.findByLastName(searchValue, pageRequest);
                case "joinDate" -> userRepository.findByJoinDate(searchValue, pageRequest);
                default -> userRepository.findAll(pageRequest);
            };
        } else {
            return userRepository.findAll(pageRequest);
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        boolean doesExist = userRepository.existsById(id);
        if (!doesExist) {
            throw new IllegalArgumentException("Id does not exist");
        }
        userRepository.deleteById(id);
    }

    /**
     * @param username
     * @param password
     * @return
     */
    @Override
    public Optional<User> findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

}