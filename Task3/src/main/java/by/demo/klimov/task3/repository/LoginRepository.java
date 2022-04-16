package by.demo.klimov.task3.repository;

import by.demo.klimov.task3.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
}
