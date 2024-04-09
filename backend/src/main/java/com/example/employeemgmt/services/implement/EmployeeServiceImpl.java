package com.example.employeemgmt.services.implement;

import com.example.employeemgmt.exceptions.CannotBeNullException;
import com.example.employeemgmt.exceptions.DuplicateEntryException;
import com.example.employeemgmt.exceptions.IdDoesNotExistException;
import com.example.employeemgmt.repositories.EmployeeRepository;
import com.example.employeemgmt.models.User;
import com.example.employeemgmt.models.UserSearchRequest;
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
                case "email" -> employeeRepository.findByEmail(searchValue, pageRequest);
                case "lastName" -> employeeRepository.findByLastName(searchValue, pageRequest);
                case "joinDate" -> employeeRepository.findByJoinDate(searchValue, pageRequest);
                default -> null;
            };
        }
        return null;
    }

    @Override
    public Optional<User> fetchEmployeeInfo(Long id) {
        Optional<User> employee = employeeRepository.findById(id);
        if (!employee.isPresent()) {
            throw new IdDoesNotExistException(String.format("Id %d does not exist", id));
        }
        return employee;

    }

    @Override
    public User updateEmployee( User user) {

        try {
            return employeeRepository.save(user);
        } catch (Exception e) {
            throw new CannotBeNullException("Unknown error occurred");
        }
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