package org.csf.service;

import org.csf.domain.Client;
import org.csf.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Andrew Boytsov
 * @date 06.04.2018
 */

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client getClient(String phoneNumber) {
        return clientRepository.findByPhoneNumber(phoneNumber);
    }

}
