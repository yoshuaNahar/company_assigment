package com.company.assigments.postalcode.repository;

import com.company.assigments.postalcode.domain.UkPostalCode;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UkPostalCodeRepository extends JpaRepository<UkPostalCode, Long> {

  Optional<UkPostalCode> findByPostalCode(String postalCode);

}
