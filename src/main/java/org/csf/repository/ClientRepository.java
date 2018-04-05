package org.csf.repository;

import org.csf.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Andrew Boytsov
 * @date 06.04.2018
 */

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByPhoneNumber(String phoneNumber);

}
