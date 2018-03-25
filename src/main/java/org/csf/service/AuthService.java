package org.csf.service;

import org.csf.domain.Employee;
import org.csf.dto.LoginData;
import org.csf.repository.EmployeeRepository;
import org.csf.utils.HashHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author Andrew Boytsov
 * @date 25.03.2018
 */

@Service
public class AuthService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee login(LoginData loginData) {
        if (loginData == null || loginData.isEmpty()) {
            return null;
        }
        return employeeRepository.findByLoginAndPassword(loginData.getLogin(), HashHelper.encodeSha256(loginData.getPassword()));
    }

    public Employee getEmployeeByToken(String token) {
        return !StringUtils.isEmpty(token) ? employeeRepository.findByToken(token) : null;
    }
}
