package org.csf.repository;

import org.csf.domain.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Andrew Boytsov
 * @date 06.04.2018
 */

public interface RentalRepository extends JpaRepository<Rental, Long> {

    int countByClientId(Long client_id);

}
