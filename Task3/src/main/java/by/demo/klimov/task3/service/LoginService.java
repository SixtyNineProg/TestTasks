package by.demo.klimov.task3.service;

import by.demo.klimov.task3.model.Login;

import java.util.List;

public interface LoginService {
    long create(Login login);

    List<Long> create(List<Login> logins);
}
