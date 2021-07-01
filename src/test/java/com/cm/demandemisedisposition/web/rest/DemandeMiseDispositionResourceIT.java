package com.cm.demandemisedisposition.web.rest;

import com.cm.demandemisedisposition.DemandemisdispositionApp;
import com.cm.demandemisedisposition.domain.DemandeMiseDisposition;
import com.cm.demandemisedisposition.repository.DemandeMiseDispositionRepository;
import com.cm.demandemisedisposition.service.DemandeMiseDispositionService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link DemandeMiseDispositionResource} REST controller.
 */
@SpringBootTest(classes = DemandemisdispositionApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class DemandeMiseDispositionResourceIT {

    private static final String DEFAULT_MATRICULE = "AAAAAAAAAA";
    private static final String UPDATED_MATRICULE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATEDEMANDE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATEDEMANDE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATEDEBUTMISEDISPOSITION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATEDEBUTMISEDISPOSITION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATEFINMISEDISPOSITION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATEFINMISEDISPOSITION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_HEURDEBUT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_HEURDEBUT = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_HEURFIN = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_HEURFIN = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_MOTIF = "AAAAAAAAAA";
    private static final String UPDATED_MOTIF = "BBBBBBBBBB";

    private static final String DEFAULT_TYPEVEHICULE = "AAAAAAAAAA";
    private static final String UPDATED_TYPEVEHICULE = "BBBBBBBBBB";

    private static final String DEFAULT_LIEUDEPART = "AAAAAAAAAA";
    private static final String UPDATED_LIEUDEPART = "BBBBBBBBBB";

    private static final String DEFAULT_LIEUARRIVE = "AAAAAAAAAA";
    private static final String UPDATED_LIEUARRIVE = "BBBBBBBBBB";

    private static final String DEFAULT_DIVISION = "AAAAAAAAAA";
    private static final String UPDATED_DIVISION = "BBBBBBBBBB";

    private static final String DEFAULT_SERVICES = "AAAAAAAAAA";
    private static final String UPDATED_SERVICES = "BBBBBBBBBB";

    private static final Integer DEFAULT_NOMBREBENIFICIAIRE = 1;
    private static final Integer UPDATED_NOMBREBENIFICIAIRE = 2;

    private static final String DEFAULT_BENEFICIAIRE = "AAAAAAAAAA";
    private static final String UPDATED_BENEFICIAIRE = "BBBBBBBBBB";

    private static final byte[] DEFAULT_PIECEJOINTES = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_PIECEJOINTES = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_PIECEJOINTES_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_PIECEJOINTES_CONTENT_TYPE = "image/png";

    private static final String DEFAULT_STATUTDIS = "AAAAAAAAAA";
    private static final String UPDATED_STATUTDIS = "BBBBBBBBBB";

    @Autowired
    private DemandeMiseDispositionRepository demandeMiseDispositionRepository;

    @Autowired
    private DemandeMiseDispositionService demandeMiseDispositionService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDemandeMiseDispositionMockMvc;

    private DemandeMiseDisposition demandeMiseDisposition;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DemandeMiseDisposition createEntity(EntityManager em) {
        DemandeMiseDisposition demandeMiseDisposition = new DemandeMiseDisposition()
            .matricule(DEFAULT_MATRICULE)
            .datedemande(DEFAULT_DATEDEMANDE)
            .datedebutmisedisposition(DEFAULT_DATEDEBUTMISEDISPOSITION)
            .datefinmisedisposition(DEFAULT_DATEFINMISEDISPOSITION)
            .heurdebut(DEFAULT_HEURDEBUT)
            .heurfin(DEFAULT_HEURFIN)
            .motif(DEFAULT_MOTIF)
            .typevehicule(DEFAULT_TYPEVEHICULE)
            .lieudepart(DEFAULT_LIEUDEPART)
            .lieuarrive(DEFAULT_LIEUARRIVE)
            .division(DEFAULT_DIVISION)
            .services(DEFAULT_SERVICES)
            .nombrebenificiaire(DEFAULT_NOMBREBENIFICIAIRE)
            .beneficiaire(DEFAULT_BENEFICIAIRE)
            .piecejointes(DEFAULT_PIECEJOINTES)
            .piecejointesContentType(DEFAULT_PIECEJOINTES_CONTENT_TYPE)
            .statutdis(DEFAULT_STATUTDIS);
        return demandeMiseDisposition;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DemandeMiseDisposition createUpdatedEntity(EntityManager em) {
        DemandeMiseDisposition demandeMiseDisposition = new DemandeMiseDisposition()
            .matricule(UPDATED_MATRICULE)
            .datedemande(UPDATED_DATEDEMANDE)
            .datedebutmisedisposition(UPDATED_DATEDEBUTMISEDISPOSITION)
            .datefinmisedisposition(UPDATED_DATEFINMISEDISPOSITION)
            .heurdebut(UPDATED_HEURDEBUT)
            .heurfin(UPDATED_HEURFIN)
            .motif(UPDATED_MOTIF)
            .typevehicule(UPDATED_TYPEVEHICULE)
            .lieudepart(UPDATED_LIEUDEPART)
            .lieuarrive(UPDATED_LIEUARRIVE)
            .division(UPDATED_DIVISION)
            .services(UPDATED_SERVICES)
            .nombrebenificiaire(UPDATED_NOMBREBENIFICIAIRE)
            .beneficiaire(UPDATED_BENEFICIAIRE)
            .piecejointes(UPDATED_PIECEJOINTES)
            .piecejointesContentType(UPDATED_PIECEJOINTES_CONTENT_TYPE)
            .statutdis(UPDATED_STATUTDIS);
        return demandeMiseDisposition;
    }

    @BeforeEach
    public void initTest() {
        demandeMiseDisposition = createEntity(em);
    }

    @Test
    @Transactional
    public void createDemandeMiseDisposition() throws Exception {
        int databaseSizeBeforeCreate = demandeMiseDispositionRepository.findAll().size();
        // Create the DemandeMiseDisposition
        restDemandeMiseDispositionMockMvc.perform(post("/api/demande-mise-dispositions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(demandeMiseDisposition)))
            .andExpect(status().isCreated());

        // Validate the DemandeMiseDisposition in the database
        List<DemandeMiseDisposition> demandeMiseDispositionList = demandeMiseDispositionRepository.findAll();
        assertThat(demandeMiseDispositionList).hasSize(databaseSizeBeforeCreate + 1);
        DemandeMiseDisposition testDemandeMiseDisposition = demandeMiseDispositionList.get(demandeMiseDispositionList.size() - 1);
        assertThat(testDemandeMiseDisposition.getMatricule()).isEqualTo(DEFAULT_MATRICULE);
        assertThat(testDemandeMiseDisposition.getDatedemande()).isEqualTo(DEFAULT_DATEDEMANDE);
        assertThat(testDemandeMiseDisposition.getDatedebutmisedisposition()).isEqualTo(DEFAULT_DATEDEBUTMISEDISPOSITION);
        assertThat(testDemandeMiseDisposition.getDatefinmisedisposition()).isEqualTo(DEFAULT_DATEFINMISEDISPOSITION);
        assertThat(testDemandeMiseDisposition.getHeurdebut()).isEqualTo(DEFAULT_HEURDEBUT);
        assertThat(testDemandeMiseDisposition.getHeurfin()).isEqualTo(DEFAULT_HEURFIN);
        assertThat(testDemandeMiseDisposition.getMotif()).isEqualTo(DEFAULT_MOTIF);
        assertThat(testDemandeMiseDisposition.getTypevehicule()).isEqualTo(DEFAULT_TYPEVEHICULE);
        assertThat(testDemandeMiseDisposition.getLieudepart()).isEqualTo(DEFAULT_LIEUDEPART);
        assertThat(testDemandeMiseDisposition.getLieuarrive()).isEqualTo(DEFAULT_LIEUARRIVE);
        assertThat(testDemandeMiseDisposition.getDivision()).isEqualTo(DEFAULT_DIVISION);
        assertThat(testDemandeMiseDisposition.getServices()).isEqualTo(DEFAULT_SERVICES);
        assertThat(testDemandeMiseDisposition.getNombrebenificiaire()).isEqualTo(DEFAULT_NOMBREBENIFICIAIRE);
        assertThat(testDemandeMiseDisposition.getBeneficiaire()).isEqualTo(DEFAULT_BENEFICIAIRE);
        assertThat(testDemandeMiseDisposition.getPiecejointes()).isEqualTo(DEFAULT_PIECEJOINTES);
        assertThat(testDemandeMiseDisposition.getPiecejointesContentType()).isEqualTo(DEFAULT_PIECEJOINTES_CONTENT_TYPE);
        assertThat(testDemandeMiseDisposition.getStatutdis()).isEqualTo(DEFAULT_STATUTDIS);
    }

    @Test
    @Transactional
    public void createDemandeMiseDispositionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = demandeMiseDispositionRepository.findAll().size();

        // Create the DemandeMiseDisposition with an existing ID
        demandeMiseDisposition.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDemandeMiseDispositionMockMvc.perform(post("/api/demande-mise-dispositions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(demandeMiseDisposition)))
            .andExpect(status().isBadRequest());

        // Validate the DemandeMiseDisposition in the database
        List<DemandeMiseDisposition> demandeMiseDispositionList = demandeMiseDispositionRepository.findAll();
        assertThat(demandeMiseDispositionList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllDemandeMiseDispositions() throws Exception {
        // Initialize the database
        demandeMiseDispositionRepository.saveAndFlush(demandeMiseDisposition);

        // Get all the demandeMiseDispositionList
        restDemandeMiseDispositionMockMvc.perform(get("/api/demande-mise-dispositions?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(demandeMiseDisposition.getId().intValue())))
            .andExpect(jsonPath("$.[*].matricule").value(hasItem(DEFAULT_MATRICULE)))
            .andExpect(jsonPath("$.[*].datedemande").value(hasItem(DEFAULT_DATEDEMANDE.toString())))
            .andExpect(jsonPath("$.[*].datedebutmisedisposition").value(hasItem(DEFAULT_DATEDEBUTMISEDISPOSITION.toString())))
            .andExpect(jsonPath("$.[*].datefinmisedisposition").value(hasItem(DEFAULT_DATEFINMISEDISPOSITION.toString())))
            .andExpect(jsonPath("$.[*].heurdebut").value(hasItem(DEFAULT_HEURDEBUT.toString())))
            .andExpect(jsonPath("$.[*].heurfin").value(hasItem(DEFAULT_HEURFIN.toString())))
            .andExpect(jsonPath("$.[*].motif").value(hasItem(DEFAULT_MOTIF)))
            .andExpect(jsonPath("$.[*].typevehicule").value(hasItem(DEFAULT_TYPEVEHICULE)))
            .andExpect(jsonPath("$.[*].lieudepart").value(hasItem(DEFAULT_LIEUDEPART)))
            .andExpect(jsonPath("$.[*].lieuarrive").value(hasItem(DEFAULT_LIEUARRIVE)))
            .andExpect(jsonPath("$.[*].division").value(hasItem(DEFAULT_DIVISION)))
            .andExpect(jsonPath("$.[*].services").value(hasItem(DEFAULT_SERVICES)))
            .andExpect(jsonPath("$.[*].nombrebenificiaire").value(hasItem(DEFAULT_NOMBREBENIFICIAIRE)))
            .andExpect(jsonPath("$.[*].beneficiaire").value(hasItem(DEFAULT_BENEFICIAIRE)))
            .andExpect(jsonPath("$.[*].piecejointesContentType").value(hasItem(DEFAULT_PIECEJOINTES_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].piecejointes").value(hasItem(Base64Utils.encodeToString(DEFAULT_PIECEJOINTES))))
            .andExpect(jsonPath("$.[*].statutdis").value(hasItem(DEFAULT_STATUTDIS)));
    }
    
    @Test
    @Transactional
    public void getDemandeMiseDisposition() throws Exception {
        // Initialize the database
        demandeMiseDispositionRepository.saveAndFlush(demandeMiseDisposition);

        // Get the demandeMiseDisposition
        restDemandeMiseDispositionMockMvc.perform(get("/api/demande-mise-dispositions/{id}", demandeMiseDisposition.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(demandeMiseDisposition.getId().intValue()))
            .andExpect(jsonPath("$.matricule").value(DEFAULT_MATRICULE))
            .andExpect(jsonPath("$.datedemande").value(DEFAULT_DATEDEMANDE.toString()))
            .andExpect(jsonPath("$.datedebutmisedisposition").value(DEFAULT_DATEDEBUTMISEDISPOSITION.toString()))
            .andExpect(jsonPath("$.datefinmisedisposition").value(DEFAULT_DATEFINMISEDISPOSITION.toString()))
            .andExpect(jsonPath("$.heurdebut").value(DEFAULT_HEURDEBUT.toString()))
            .andExpect(jsonPath("$.heurfin").value(DEFAULT_HEURFIN.toString()))
            .andExpect(jsonPath("$.motif").value(DEFAULT_MOTIF))
            .andExpect(jsonPath("$.typevehicule").value(DEFAULT_TYPEVEHICULE))
            .andExpect(jsonPath("$.lieudepart").value(DEFAULT_LIEUDEPART))
            .andExpect(jsonPath("$.lieuarrive").value(DEFAULT_LIEUARRIVE))
            .andExpect(jsonPath("$.division").value(DEFAULT_DIVISION))
            .andExpect(jsonPath("$.services").value(DEFAULT_SERVICES))
            .andExpect(jsonPath("$.nombrebenificiaire").value(DEFAULT_NOMBREBENIFICIAIRE))
            .andExpect(jsonPath("$.beneficiaire").value(DEFAULT_BENEFICIAIRE))
            .andExpect(jsonPath("$.piecejointesContentType").value(DEFAULT_PIECEJOINTES_CONTENT_TYPE))
            .andExpect(jsonPath("$.piecejointes").value(Base64Utils.encodeToString(DEFAULT_PIECEJOINTES)))
            .andExpect(jsonPath("$.statutdis").value(DEFAULT_STATUTDIS));
    }
    @Test
    @Transactional
    public void getNonExistingDemandeMiseDisposition() throws Exception {
        // Get the demandeMiseDisposition
        restDemandeMiseDispositionMockMvc.perform(get("/api/demande-mise-dispositions/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDemandeMiseDisposition() throws Exception {
        // Initialize the database
        demandeMiseDispositionService.save(demandeMiseDisposition);

        int databaseSizeBeforeUpdate = demandeMiseDispositionRepository.findAll().size();

        // Update the demandeMiseDisposition
        DemandeMiseDisposition updatedDemandeMiseDisposition = demandeMiseDispositionRepository.findById(demandeMiseDisposition.getId()).get();
        // Disconnect from session so that the updates on updatedDemandeMiseDisposition are not directly saved in db
        em.detach(updatedDemandeMiseDisposition);
        updatedDemandeMiseDisposition
            .matricule(UPDATED_MATRICULE)
            .datedemande(UPDATED_DATEDEMANDE)
            .datedebutmisedisposition(UPDATED_DATEDEBUTMISEDISPOSITION)
            .datefinmisedisposition(UPDATED_DATEFINMISEDISPOSITION)
            .heurdebut(UPDATED_HEURDEBUT)
            .heurfin(UPDATED_HEURFIN)
            .motif(UPDATED_MOTIF)
            .typevehicule(UPDATED_TYPEVEHICULE)
            .lieudepart(UPDATED_LIEUDEPART)
            .lieuarrive(UPDATED_LIEUARRIVE)
            .division(UPDATED_DIVISION)
            .services(UPDATED_SERVICES)
            .nombrebenificiaire(UPDATED_NOMBREBENIFICIAIRE)
            .beneficiaire(UPDATED_BENEFICIAIRE)
            .piecejointes(UPDATED_PIECEJOINTES)
            .piecejointesContentType(UPDATED_PIECEJOINTES_CONTENT_TYPE)
            .statutdis(UPDATED_STATUTDIS);

        restDemandeMiseDispositionMockMvc.perform(put("/api/demande-mise-dispositions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedDemandeMiseDisposition)))
            .andExpect(status().isOk());

        // Validate the DemandeMiseDisposition in the database
        List<DemandeMiseDisposition> demandeMiseDispositionList = demandeMiseDispositionRepository.findAll();
        assertThat(demandeMiseDispositionList).hasSize(databaseSizeBeforeUpdate);
        DemandeMiseDisposition testDemandeMiseDisposition = demandeMiseDispositionList.get(demandeMiseDispositionList.size() - 1);
        assertThat(testDemandeMiseDisposition.getMatricule()).isEqualTo(UPDATED_MATRICULE);
        assertThat(testDemandeMiseDisposition.getDatedemande()).isEqualTo(UPDATED_DATEDEMANDE);
        assertThat(testDemandeMiseDisposition.getDatedebutmisedisposition()).isEqualTo(UPDATED_DATEDEBUTMISEDISPOSITION);
        assertThat(testDemandeMiseDisposition.getDatefinmisedisposition()).isEqualTo(UPDATED_DATEFINMISEDISPOSITION);
        assertThat(testDemandeMiseDisposition.getHeurdebut()).isEqualTo(UPDATED_HEURDEBUT);
        assertThat(testDemandeMiseDisposition.getHeurfin()).isEqualTo(UPDATED_HEURFIN);
        assertThat(testDemandeMiseDisposition.getMotif()).isEqualTo(UPDATED_MOTIF);
        assertThat(testDemandeMiseDisposition.getTypevehicule()).isEqualTo(UPDATED_TYPEVEHICULE);
        assertThat(testDemandeMiseDisposition.getLieudepart()).isEqualTo(UPDATED_LIEUDEPART);
        assertThat(testDemandeMiseDisposition.getLieuarrive()).isEqualTo(UPDATED_LIEUARRIVE);
        assertThat(testDemandeMiseDisposition.getDivision()).isEqualTo(UPDATED_DIVISION);
        assertThat(testDemandeMiseDisposition.getServices()).isEqualTo(UPDATED_SERVICES);
        assertThat(testDemandeMiseDisposition.getNombrebenificiaire()).isEqualTo(UPDATED_NOMBREBENIFICIAIRE);
        assertThat(testDemandeMiseDisposition.getBeneficiaire()).isEqualTo(UPDATED_BENEFICIAIRE);
        assertThat(testDemandeMiseDisposition.getPiecejointes()).isEqualTo(UPDATED_PIECEJOINTES);
        assertThat(testDemandeMiseDisposition.getPiecejointesContentType()).isEqualTo(UPDATED_PIECEJOINTES_CONTENT_TYPE);
        assertThat(testDemandeMiseDisposition.getStatutdis()).isEqualTo(UPDATED_STATUTDIS);
    }

    @Test
    @Transactional
    public void updateNonExistingDemandeMiseDisposition() throws Exception {
        int databaseSizeBeforeUpdate = demandeMiseDispositionRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDemandeMiseDispositionMockMvc.perform(put("/api/demande-mise-dispositions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(demandeMiseDisposition)))
            .andExpect(status().isBadRequest());

        // Validate the DemandeMiseDisposition in the database
        List<DemandeMiseDisposition> demandeMiseDispositionList = demandeMiseDispositionRepository.findAll();
        assertThat(demandeMiseDispositionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteDemandeMiseDisposition() throws Exception {
        // Initialize the database
        demandeMiseDispositionService.save(demandeMiseDisposition);

        int databaseSizeBeforeDelete = demandeMiseDispositionRepository.findAll().size();

        // Delete the demandeMiseDisposition
        restDemandeMiseDispositionMockMvc.perform(delete("/api/demande-mise-dispositions/{id}", demandeMiseDisposition.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<DemandeMiseDisposition> demandeMiseDispositionList = demandeMiseDispositionRepository.findAll();
        assertThat(demandeMiseDispositionList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
