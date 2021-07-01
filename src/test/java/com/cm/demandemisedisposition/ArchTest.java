package com.cm.demandemisedisposition;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.cm.demandemisedisposition");

        noClasses()
            .that()
                .resideInAnyPackage("com.cm.demandemisedisposition.service..")
            .or()
                .resideInAnyPackage("com.cm.demandemisedisposition.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..com.cm.demandemisedisposition.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
