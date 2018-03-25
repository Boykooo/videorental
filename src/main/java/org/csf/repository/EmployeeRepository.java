package org.csf.repository;

import org.csf.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Andrew Boytsov
 * @date 25.03.2018
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByLoginAndPassword(String login, String password);

    Employee findByToken(String token);

}
