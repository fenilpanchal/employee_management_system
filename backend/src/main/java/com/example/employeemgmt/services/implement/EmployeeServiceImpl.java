package com.example.employeemgmt.services.implement;

import com.example.employeemgmt.exceptions.DuplicateEntryException;
import com.example.employeemgmt.exceptions.IdDoesNotExistException;
import com.example.employeemgmt.models.User;
import com.example.employeemgmt.models.UserSearchRequest;
import com.example.employeemgmt.repositories.EmployeeRepository;
import com.example.employeemgmt.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public User saveEmployee(User user) {
        boolean doesUsernameExist = employeeRepository.existsByUsername(user.getUsername());
        boolean doesEmailExist = employeeRepository.existsByEmail(user.getEmail());
        if (doesUsernameExist) {
            throw new DuplicateEntryException("Username already exists");
        }
        if (doesEmailExist) {
            throw new DuplicateEntryException("Email already exists");
        }
        return employeeRepository.save(user);
    }

    @Override
    public Page<User> searchEmployees(UserSearchRequest userSearchRequest) {
        String searchKey = userSearchRequest.getSearchKey();
        String searchValue = userSearchRequest.getSearchValue();

        Pageable pageRequest = PageRequest.of(userSearchRequest.getOffset(), userSearchRequest.getLimit(), Sort.by(userSearchRequest.getSortBy()));

        if (searchKey != null && !searchKey.isEmpty()) {
            return switch (searchKey) {
                case "firstName" -> employeeRepository.findByFirstName(searchValue, pageRequest);
                case "username" -> employeeRepository.findByUsername(searchValue, pageRequest);
                case "email" -> employeeRepository.findByEmail(searchValue, pageRequest);
                case "lastName" -> employeeRepository.findByLastName(searchValue, pageRequest);
                case "joinDate" -> employeeRepository.findByJoinDate(searchValue, pageRequest);
                default -> employeeRepository.findAll(pageRequest);
            };
        } else {
            return employeeRepository.findAll(pageRequest);
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public User updateEmployee(User user) {
        return employeeRepository.save(user);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        boolean doesExist = employeeRepository.existsById(id);
        if (!doesExist) {
            throw new IdDoesNotExistException("Id does not exist");
        }
        employeeRepository.deleteById(id);
    }

}