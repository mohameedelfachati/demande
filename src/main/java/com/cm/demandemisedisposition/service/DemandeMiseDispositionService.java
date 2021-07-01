package com.cm.demandemisedisposition.service;

import com.cm.demandemisedisposition.domain.DemandeMiseDisposition;
import com.cm.demandemisedisposition.domain.Voiture;
import com.cm.demandemisedisposition.repository.DemandeMiseDispositionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link DemandeMiseDisposition}.
 */
@Service
@Transactional
public class DemandeMiseDispositionService {

    private final Logger log = LoggerFactory.getLogger(DemandeMiseDispositionService.class);
    private ConnectionApi connectionApi;
    private final DemandeMiseDispositionRepository demandeMiseDispositionRepository;


    public DemandeMiseDispositionService(DemandeMiseDispositionRepository demandeMiseDispositionRepository, ConnectionApi connectionApi) {
        this.demandeMiseDispositionRepository = demandeMiseDispositionRepository;
        this.connectionApi=connectionApi;

    }

    /**
     * Save a demandeMiseDisposition.
     *
     * @param demandeMiseDisposition the entity to save.
     * @return the persisted entity.
     */
    public DemandeMiseDisposition save(DemandeMiseDisposition demandeMiseDisposition) {
        log.debug("Request to save DemandeMiseDisposition : {}", demandeMiseDisposition);
        demandeMiseDispositionRepository.save(demandeMiseDisposition);
        Voiture voiture = connectionApi.getVoiture(demandeMiseDisposition.getMatricule()).block();
        voiture.setStatus("occupe");
        connectionApi.ubdateStatus(voiture).subscribe();

        return demandeMiseDisposition;
    }

    /**
     * Get all the demandeMiseDispositions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<DemandeMiseDisposition> findAll(Pageable pageable) {
        log.debug("Request to get all DemandeMiseDispositions");
        return demandeMiseDispositionRepository.findAll(pageable);
    }


    /**
     * Get one demandeMiseDisposition by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<DemandeMiseDisposition> findOne(Long id) {
        log.debug("Request to get DemandeMiseDisposition : {}", id);
        return demandeMiseDispositionRepository.findById(id);
    }

    /**
     * Delete the demandeMiseDisposition by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete DemandeMiseDisposition : {}", id);
        demandeMiseDispositionRepository.deleteById(id);
    }

    public List<DemandeMiseDisposition> getDemandebydate(LocalDate date){
        return demandeMiseDispositionRepository.findDemandeMiseDispositionByDatedemande(date);
    }
    public List<DemandeMiseDisposition> getDemandebylieu(String lieuarrive){
        return  demandeMiseDispositionRepository.findDemandeMiseDispositionByLieuarrive(lieuarrive);
    }
    public  List<DemandeMiseDisposition> getDemandebydatelieu(LocalDate date, String lieuarrive){
        return demandeMiseDispositionRepository.findDemandeMiseDispositionByDatedemandeAndLieuarrive(date, lieuarrive);
    }
    public Flux<Voiture> getVoiture(){
        return connectionApi.getVoiture();
    }

    public Mono<Voiture> getVoiture(String matricule){
        return connectionApi.getVoiture(matricule);
    }

    public Mono<Voiture> ubdateStatus(Voiture voiture){
        return connectionApi.ubdateStatus(voiture);
    }
}
