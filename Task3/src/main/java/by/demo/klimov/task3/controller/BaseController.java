package by.demo.klimov.task3.controller;

import by.demo.klimov.task3.model.Posting;
import by.demo.klimov.task3.service.PostingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Slf4j
@RestController
public class BaseController {

    private final PostingService postingService;
    private final ObjectMapper mapper;

    public BaseController(PostingService postingService, ObjectMapper mapper) {
        this.postingService = postingService;
        this.mapper = mapper;
        mapper.setTimeZone(TimeZone.getDefault());
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping(path = "/search_postings_between_date")
    public ResponseEntity<?> readPostingsBetweenDate(
            @RequestParam(value = "date_from")
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFrom,
            @RequestParam(value = "date_to")
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTo,
            @RequestParam(required = false, value = "authorized_delivery") Boolean authorizedDelivery) {
        if (authorizedDelivery == null) {
            List<Posting> postings = postingService.searchPostingsByDateBetween(dateFrom, dateTo);
            String str = listPostingsToJson(postings);
            return ResponseEntity.ok(str);
        } else {
            List<Posting> postings = postingService.searchPostingsByDateBetweenWithAuthorizedDelivery(
                    dateFrom, dateTo, authorizedDelivery);
            return ResponseEntity.ok(listPostingsToJson(postings));
        }
    }

    private String listPostingsToJson(List<Posting> list) {
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(posting -> {
            try {
                stringBuilder.append(mapper.writeValueAsString(posting));
            } catch (JsonProcessingException e) {
                log.info("Exception create Json", e);
            }
        });
        return stringBuilder.toString();
    }
}
