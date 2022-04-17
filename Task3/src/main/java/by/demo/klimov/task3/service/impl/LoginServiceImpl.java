package by.demo.klimov.task3.service.impl;

import by.demo.klimov.task3.constants.Constants;
import by.demo.klimov.task3.model.Login;
import by.demo.klimov.task3.repository.LoginRepository;
import by.demo.klimov.task3.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;

    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public int create(List<Login> logins) {
        log.info(logins.size() + " " + Constants.LOGINS_SAVED);
        loginRepository.saveAll(logins);
        return logins.size();
    }
}
