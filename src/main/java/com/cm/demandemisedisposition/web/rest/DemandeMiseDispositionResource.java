package com.cm.demandemisedisposition.web.rest;

import com.cm.demandemisedisposition.domain.DemandeMiseDisposition;
import com.cm.demandemisedisposition.domain.Voiture;
import com.cm.demandemisedisposition.service.DemandeMiseDispositionService;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.cm.demandemisedisposition.domain.DemandeMiseDisposition}.
 */
@RestController
@RequestMapping("/api")
public class DemandeMiseDispositionResource {

    private final Logger log = LoggerFactory.getLogger(DemandeMiseDispositionResource.class);

    private static final String ENTITY_NAME = "demandemisdispositionDemandeMiseDisposition";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DemandeMiseDispositionService demandeMiseDispositionService;
    private ModelMapper modelmapper;

    public DemandeMiseDispositionResource(DemandeMiseDispositionService demandeMiseDispositionService,ModelMapper modelMapper) {
        this.demandeMiseDispositionService = demandeMiseDispositionService;
        this.modelmapper=modelMapper;
    }

    /**
     * {@code POST  /demande-mise-dispositions} : Create a new demandeMiseDisposition.
     *
     * @param demandeMiseDisposition the demandeMiseDisposition to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new demandeMiseDisposition, or with status {@code 400 (Bad Request)} if the demandeMiseDisposition has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/demande-mise-dispositions")
    public ResponseEntity<DemandeMiseDisposition> createDemandeMiseDisposition(@RequestBody DemandeMiseDisposition demandeMiseDisposition) throws URISyntaxException {
        log.debug("REST request to save DemandeMiseDisposition : {}", demandeMiseDisposition);
//        if (demandeMiseDisposition.getId() != null) {
//           throw new BadRequestAlertException("A new demandeMiseDisposition cannot already have an ID", ENTITY_NAME, "idexists");
//        }
        DemandeMiseDisposition result = demandeMiseDispositionService.save(demandeMiseDisposition);
        return ResponseEntity.created(new URI("/api/demande-mise-dispositions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /demande-mise-dispositions} : Updates an existing demandeMiseDisposition.
     *
     * @param demandeMiseDisposition the demandeMiseDisposition to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated demandeMiseDisposition,
     * or with status {@code 400 (Bad Request)} if the demandeMiseDisposition is not valid,
     * or with status {@code 500 (Internal Server Error)} if the demandeMiseDisposition couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/demande-mise-dispositions")
    public ResponseEntity<DemandeMiseDisposition> updateDemandeMiseDisposition(@RequestBody DemandeMiseDisposition demandeMiseDisposition) throws URISyntaxException {
        log.debug("REST request to update DemandeMiseDisposition : {}", demandeMiseDisposition);
//        if (demandeMiseDisposition.getId() == null) {
//          throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
        DemandeMiseDisposition result = demandeMiseDispositionService.save(demandeMiseDisposition);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, demandeMiseDisposition.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /demande-mise-dispositions} : get all the demandeMiseDispositions.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of demandeMiseDispositions in body.
     */
    @GetMapping("/demande-mise-dispositions")
    public ResponseEntity<List<DemandeMiseDisposition>> getAllDemandeMiseDispositions(Pageable pageable) {
        log.debug("REST request to get a page of DemandeMiseDispositions");
        Page<DemandeMiseDisposition> page = demandeMiseDispositionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /demande-mise-dispositions/:id} : get the "id" demandeMiseDisposition.
     *
     * @param id the id of the demandeMiseDisposition to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the demandeMiseDisposition, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/demande-mise-dispositions/{id}")
    public ResponseEntity<DemandeMiseDisposition> getDemandeMiseDisposition(@PathVariable Long id) {
        log.debug("REST request to get DemandeMiseDisposition : {}", id);
        Optional<DemandeMiseDisposition> demandeMiseDisposition = demandeMiseDispositionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(demandeMiseDisposition);
    }

    /**
     * {@code DELETE  /demande-mise-dispositions/:id} : delete the "id" demandeMiseDisposition.
     *
     * @param id the id of the demandeMiseDisposition to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/demande-mise-dispositions/{id}")
    public ResponseEntity<Void> deleteDemandeMiseDisposition(@PathVariable Long id) {
        log.debug("REST request to delete DemandeMiseDisposition : {}", id);
        demandeMiseDispositionService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
    @GetMapping("/demande-mise-dispositions-by-date/{date}")
    public List<DemandeMiseDisposition> getDemandebyDate(@PathVariable LocalDate date){
        return demandeMiseDispositionService.getDemandebydate(date);
    }
    @GetMapping("/demande-mise-dispoitions-by-lieu")
    public List<DemandeMiseDisposition> getDemandebyLieu(@RequestParam  String lieuarrive){
        return demandeMiseDispositionService.getDemandebylieu(lieuarrive);
    }
    @GetMapping("/demande-mise-disposition")
    public List<DemandeMiseDisposition> getDemandebyLieuanddate(@RequestParam LocalDate date,@RequestParam String lieuarrive){
        return demandeMiseDispositionService.getDemandebydatelieu(date,lieuarrive);
    }
    @GetMapping("/voitures")
    public Flux<Voiture> getVoiture(){
        return demandeMiseDispositionService.getVoiture();
    }

    @GetMapping("/voitures1/{matricule}")
    public Mono<Voiture> getVoiture(@PathVariable String matricule){
        return demandeMiseDispositionService.getVoiture(matricule);
    }
    @PutMapping("/voitures1")
    public Mono<Voiture> ubdateStatus(@RequestBody Voiture voiture){
        return demandeMiseDispositionService.ubdateStatus(voiture);
    }

    }

