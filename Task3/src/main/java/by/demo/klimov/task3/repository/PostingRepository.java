package by.demo.klimov.task3.repository;

import by.demo.klimov.task3.model.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PostingRepository extends JpaRepository<Posting, Long> {
    List<Posting> findPostingsByPstngDateBetween(Date dateFrom, Date dateTo);

    List<Posting> findPostingsByPstngDateBetweenAndAuthorizedDelivery(Date dateFrom, Date dateTo, boolean authorizedDelivery);
}
