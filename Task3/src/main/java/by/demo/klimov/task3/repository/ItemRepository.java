package by.demo.klimov.task3.repository;

import by.demo.klimov.task3.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
