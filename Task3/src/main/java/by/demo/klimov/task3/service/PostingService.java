package by.demo.klimov.task3.service;

import by.demo.klimov.task3.model.Posting;

import java.util.Date;
import java.util.List;

public interface PostingService {
    long create(Posting posting);

    List<Long> create(List<Posting> postings);

    List<Posting> read(String firstName, String lastName, Date birthDate);

    List<Posting> searchAllDirectors();
}
