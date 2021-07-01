package com.cm.demandemisedisposition.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.cm.demandemisedisposition.web.rest.TestUtil;

public class DemandeMiseDispositionTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DemandeMiseDisposition.class);
        DemandeMiseDisposition demandeMiseDisposition1 = new DemandeMiseDisposition();
        demandeMiseDisposition1.setId(1L);
        DemandeMiseDisposition demandeMiseDisposition2 = new DemandeMiseDisposition();
        demandeMiseDisposition2.setId(demandeMiseDisposition1.getId());
        assertThat(demandeMiseDisposition1).isEqualTo(demandeMiseDisposition2);
        demandeMiseDisposition2.setId(2L);
        assertThat(demandeMiseDisposition1).isNotEqualTo(demandeMiseDisposition2);
        demandeMiseDisposition1.setId(null);
        assertThat(demandeMiseDisposition1).isNotEqualTo(demandeMiseDisposition2);
    }
}
