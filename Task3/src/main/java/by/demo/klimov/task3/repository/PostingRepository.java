package by.demo.klimov.task3.repository;

import by.demo.klimov.task3.model.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostingRepository extends JpaRepository<Posting, Long> {
}
