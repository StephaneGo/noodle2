package fr.eni.catalogue_tests.bll;


import fr.eni.catalogue_tests.dal.TestRepository;
import fr.eni.catalogue_tests.model.Test;
import fr.eni.common.dto.TestRequest;
import fr.eni.common.dto.TestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TestServiceTest {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private TestService testService;


    @org.junit.jupiter.api.Test
    public void testCreateTestCasOk(){
        testRepository.deleteAll();
        TestRequest testRequest = TestRequest.builder()
                        .nom("test1")
                                .build();

        TestResponse testResponse = testService.creerTest(testRequest);

        assertThat(testResponse.getNom()).isEqualTo("test1");
        Optional<Test> testBd = testRepository.findByNom("test1");
        assertThat(testBd).isNotEmpty();
        assertThat(testBd.get().getNom()).isEqualTo("test1");

    }
}
