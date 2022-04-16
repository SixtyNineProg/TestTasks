package by.demo.klimov.task3.service.impl;

import by.demo.klimov.task3.model.Posting;
import by.demo.klimov.task3.service.PostingService;

import java.util.Date;
import java.util.List;

public class PostingServiceImpl implements PostingService {
    @Override
    public long create(Posting posting) {
        return 0;
    }

    @Override
    public List<Long> create(List<Posting> postings) {
        return null;
    }

    @Override
    public List<Posting> read(String firstName, String lastName, Date birthDate) {
        return null;
    }

    @Override
    public List<Posting> searchAllDirectors() {
        return null;
    }
}
