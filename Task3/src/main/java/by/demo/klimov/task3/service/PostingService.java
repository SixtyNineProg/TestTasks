package by.demo.klimov.task3.service;

import by.demo.klimov.task3.model.Posting;

import java.util.Date;
import java.util.List;

public interface PostingService {
    int create(List<Posting> postings);

    List<Posting> searchPostingsByDateBetween(Date dateFrom, Date dateTo);

    List<Posting> searchPostingsByDateBetweenWithAuthorizedDelivery(Date dateFrom, Date dateTo, boolean authorizedDelivery);
}
