package org.csf.repository;

import org.csf.domain.Cassette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Andrew Boytsov
 * @date 25.03.2018
 */

@Repository
public interface CassetteRepository extends JpaRepository<Cassette, Long> {
}
