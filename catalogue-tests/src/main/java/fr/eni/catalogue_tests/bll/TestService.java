package fr.eni.catalogue_tests.bll;

import fr.eni.common.dto.TestRequest;
import fr.eni.common.dto.TestResponse;

public interface TestService {
    TestResponse creerTest(TestRequest request);

    TestResponse findTestById(Long id);
}