package by.demo.klimov.task3.service.impl;

import by.demo.klimov.task3.constants.Constants;
import by.demo.klimov.task3.model.Posting;
import by.demo.klimov.task3.repository.PostingRepository;
import by.demo.klimov.task3.service.PostingService;
import by.demo.klimov.task3.utils.ObjectToJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service
@Slf4j
public class PostingServiceImpl implements PostingService {

    private final PostingRepository postingRepository;

    public PostingServiceImpl(PostingRepository postingRepository) {
        this.postingRepository = postingRepository;
    }

    @Override
    public long create(Posting posting) {
        log.info(Constants.POSTING_SAVED, ObjectToJson.postingToJson(posting));
        postingRepository.save(posting);
        return posting.getId();
    }

    @Override
    public int create(List<Posting> postings) {
        log.info(postings.size() + " " + Constants.LOGINS_SAVED);
        postingRepository.saveAll(postings);
        return postings.size();
    }

    @Override
    public List<Posting> read(String firstName, String lastName, Date birthDate) {
        return null;
    }

    @Override
    public List<Posting> searchAll() {
        return null;
    }
}
