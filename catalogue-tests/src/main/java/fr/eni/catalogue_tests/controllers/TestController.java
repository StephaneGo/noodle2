package fr.eni.catalogue_tests.controllers;

import fr.eni.catalogue_tests.bll.TestService;
import fr.eni.common.dto.TestRequest;
import fr.eni.common.dto.TestResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tests")
public class TestController {
    private final TestService testService;

    @GetMapping("/ping")
    public String ping(){
        return "Coucou";
    }


        @PostMapping()
    public ResponseEntity<TestResponse> creerTest(@Valid @RequestBody TestRequest request, BindingResult validationResult)
    {
        if(validationResult.hasErrors())
        {
            return ResponseEntity.badRequest().build();
        }
        TestResponse testResponse = testService.creerTest(request);

        return ResponseEntity.ok(testResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestResponse> findTestById(@PathVariable Long id){

        TestResponse response = null;
        try{
            response = testService.findTestById(id);
        } catch (RuntimeException e) {
            //TODO : changer RuntimeException en exception personalisée : DataNotFoundException
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(response);
    }
}