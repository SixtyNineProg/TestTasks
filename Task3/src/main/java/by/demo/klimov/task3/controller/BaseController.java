package by.demo.klimov.task3.controller;

import by.demo.klimov.task3.model.Login;
import by.demo.klimov.task3.model.Posting;
import by.demo.klimov.task3.service.LoginService;
import by.demo.klimov.task3.service.PostingService;
import by.demo.klimov.task3.utils.CustomCsvToBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseController {

    private final LoginService loginService;
    private final PostingService postingService;

    public BaseController(LoginService loginService, PostingService postingService) {
        this.loginService = loginService;
        this.postingService = postingService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/load/logins")
    public ResponseEntity<?> loadLogins() {
        CustomCsvToBean<Login> loginCsvToBean = new CustomCsvToBean<>();
        List<Login> logins;
        try {
            logins = loginCsvToBean.beanBuilder("csv/logins.csv", Login.class, ',');
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(loginService.create(logins));
    }

    @GetMapping("/load/postings")
    public ResponseEntity<?> loadData() {
        CustomCsvToBean<Posting> postingCsvToBean = new CustomCsvToBean<>();
        List<Posting> postings;
        try {
            postings = postingCsvToBean.beanBuilder("csv/postings.csv", Posting.class, ';');
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(postingService.create(postings));
    }
}
