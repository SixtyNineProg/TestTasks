package by.demo.klimov.task3.service;

import by.demo.klimov.task3.model.Login;

import java.util.List;

public interface LoginService {
    long create(Login login);

    int create(List<Login> logins);
}
