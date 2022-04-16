package by.demo.klimov.task3.service.impl;

import by.demo.klimov.task3.constants.Constants;
import by.demo.klimov.task3.model.Login;
import by.demo.klimov.task3.repository.LoginRepository;
import by.demo.klimov.task3.service.LoginService;
import by.demo.klimov.task3.utils.ObjectToJson;
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
    public long create(Login login) {
        log.info(Constants.LOGIN_SAVED, ObjectToJson.toJson(login));
        loginRepository.save(login);
        return login.getId();
    }

    @Override
    public List<Long> create(List<Login> logins) {
        return null;
    }
}
