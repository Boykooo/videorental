package org.csf.service;

import org.csf.domain.Cassette;
import org.csf.domain.Client;
import org.csf.dto.CostComputeDto;
import org.csf.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * @author Andrew Boytsov
 * @date 06.04.2018
 */

@Service
public class RentalService {

    @Autowired
    private ClientService clientService;

    @Autowired
    private CassetteService cassetteService;

    private final double discount = 0.15;
    private final double daysModifier = 0.05;

    public Double costCompute(CostComputeDto dto) {
        if (dto.isAllEmpty()) {
            return null;
        }
        Client client = clientService.getClient(dto.getPhoneNumber());
        Cassette cassette = cassetteService.getCassetteById(dto.getCassetteId());
        long days = DateUtils.getDifferenceDays(new Date(), dto.getEndDate());
        double cost = cassette.getCost() * days * daysModifier;
        return Objects.nonNull(client) ? client.getDiscountCost(cost, discount) : cost;
    }
}
