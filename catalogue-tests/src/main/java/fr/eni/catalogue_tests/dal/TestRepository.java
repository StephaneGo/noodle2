package fr.eni.catalogue_tests.dal;

import fr.eni.catalogue_tests.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestRepository extends JpaRepository<Test, Long> {
    Optional<Test> findByNom(String nom);
}

