package by.demo.klimov.task3.service.impl;

import by.demo.klimov.task3.constants.Constants;
import by.demo.klimov.task3.model.Posting;
import by.demo.klimov.task3.repository.PostingRepository;
import by.demo.klimov.task3.service.PostingService;
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
    public int create(List<Posting> postings) {
        log.info(postings.size() + " " + Constants.LOGINS_SAVED);
        postingRepository.saveAll(postings);
        return postings.size();
    }

    @Override
    public List<Posting> searchPostingsByDateBetween(Date dateFrom, Date dateTo) {
        List<Posting> postings = postingRepository.findPostingsByPstngDateBetween(dateFrom, dateTo);
        log.info(Constants.SEARCH_RESULT, postings.size());
        return postings;
    }

    @Override
    public List<Posting> searchPostingsByDateBetweenWithAuthorizedDelivery(
            Date dateFrom, Date dateTo, boolean authorizedDelivery) {
        List<Posting> postings = postingRepository.findPostingsByPstngDateBetweenAndAuthorizedDelivery(
                dateFrom, dateTo, authorizedDelivery);
        log.info(Constants.SEARCH_RESULT, postings.size());
        return postings;
    }


}
