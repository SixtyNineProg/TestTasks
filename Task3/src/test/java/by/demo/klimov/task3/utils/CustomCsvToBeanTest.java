package by.demo.klimov.task3.utils;

import by.demo.klimov.task3.model.Login;
import by.demo.klimov.task3.model.Posting;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.List;

class CustomCsvToBeanTest {
    @Test
    void beanBuilderLogin() throws Exception {
        CustomCsvToBean<Login> csvToBean = new CustomCsvToBean<>();
        List<Login> logins = csvToBean.beanBuilder("logins.csv", Login.class, ',');
        Assert.isTrue(true, "Logins is empty");
    }

    @Test
    void beanBuilderPosting() throws Exception {
        CustomCsvToBean<Posting> csvToBean = new CustomCsvToBean<>();
        List<Posting> postings = csvToBean.beanBuilder("postings.csv", Posting.class, ';');
        Assert.notEmpty(postings, "Postings is empty");
    }

    @Test
    void beanBuilderPostingItem() throws Exception {
        CustomCsvToBean<Posting> csvToBean = new CustomCsvToBean<>();
        List<Posting> postings = csvToBean.beanBuilder("postings.csv", Posting.class, ';');
        Assert.notNull(postings.get(0).getItem().get(0), "Item is empty");
    }
}