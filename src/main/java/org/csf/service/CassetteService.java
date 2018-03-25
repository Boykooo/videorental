package org.csf.service;

import org.csf.domain.Cassette;
import org.csf.repository.CassetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Andrew Boytsov
 * @date 25.03.2018
 */

@Service
public class CassetteService {

    @Autowired
    private CassetteRepository cassetteRepository;

    public List<Cassette> getAllCassettes() {
        return cassetteRepository.findAll();
    }

}
