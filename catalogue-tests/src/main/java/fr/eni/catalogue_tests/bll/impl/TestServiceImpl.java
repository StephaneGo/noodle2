package fr.eni.catalogue_tests.bll.impl;


import fr.eni.catalogue_tests.bll.TestService;
import fr.eni.catalogue_tests.dal.TestRepository;
import fr.eni.catalogue_tests.mappers.TestMapper;
import fr.eni.catalogue_tests.model.Test;
import fr.eni.common.dto.TestRequest;
import fr.eni.common.dto.TestResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;

    @Transactional
    public TestResponse creerTest(TestRequest request){
        Test test = TestMapper.toEntity(request);
        Test saved = testRepository.save(test);
        TestResponse testResponse = TestMapper.toResponse(saved);
        return testResponse;
    }

    @Override
    public TestResponse findTestById(Long id) {
        Test test = testRepository.findById(id).orElseThrow(()->new RuntimeException("Test with id" + id + " not found."));
        TestResponse testResponse = TestMapper.toResponse(test);
        return testResponse;
    }

}
