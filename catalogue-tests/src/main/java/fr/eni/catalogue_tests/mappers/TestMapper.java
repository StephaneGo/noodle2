package fr.eni.catalogue_tests.mappers;

import fr.eni.catalogue_tests.model.Test;
import fr.eni.common.dto.TestRequest;
import fr.eni.common.dto.TestResponse;

public class TestMapper {
    public static Test toEntity(TestRequest request){
        if(request == null){
            return null;
        }
        Test test= Test.builder()
                .nom(request.getNom())
                .build();
        return test;
    }

    public static TestResponse toResponse(Test test) {
        if(test == null){return null;}
        TestResponse testResponse = TestResponse.builder()
                .id(test.getId())
                .nom(test.getNom())
                .build();
        return testResponse;
    }
}
