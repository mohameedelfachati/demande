package com.cm.demandemisedisposition.repository;

import com.cm.demandemisedisposition.domain.DemandeMiseDisposition;

import org.hibernate.bytecode.internal.bytebuddy.BytecodeProviderImpl;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;
import java.time.LocalDate;

/**
 * Spring Data  repository for the DemandeMiseDisposition entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DemandeMiseDispositionRepository extends JpaRepository<DemandeMiseDisposition, Long> {
    List<DemandeMiseDisposition> findDemandeMiseDispositionByDatedemande(LocalDate datedemande);
    List<DemandeMiseDisposition> findDemandeMiseDispositionByLieuarrive(String lieuarrive);
    List<DemandeMiseDisposition> findDemandeMiseDispositionByDatedemandeAndLieuarrive(LocalDate datedemande , String lieuarrive);

}
