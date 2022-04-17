package by.demo.klimov.task3;

import by.demo.klimov.task3.model.Item;
import by.demo.klimov.task3.model.Login;
import by.demo.klimov.task3.model.Posting;
import by.demo.klimov.task3.repository.ItemRepository;
import by.demo.klimov.task3.service.LoginService;
import by.demo.klimov.task3.service.PostingService;
import by.demo.klimov.task3.utils.CustomCsvToBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Slf4j
@SpringBootApplication
public class Task3Application {
	public static void main(String[] args) {
		SpringApplication.run(Task3Application.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(ItemRepository itemRepository,
										 PostingService postingService,
										 LoginService loginService) {
		return args -> {

			itemRepository.save(new Item("Headphone"));
			itemRepository.save(new Item("Phone"));
			itemRepository.save(new Item("PC"));
			itemRepository.save(new Item("Cable"));
			itemRepository.save(new Item("Speaker"));

			CustomCsvToBean<Posting> postingCsvToBean = new CustomCsvToBean<>();
			CustomCsvToBean<Login> loginCsvToBean = new CustomCsvToBean<>();
			List<Posting> postings = null;
			List<Login> logins = null;
			try {
				postings = postingCsvToBean.beanBuilder("csv/postings.csv", Posting.class, ';');
				logins = loginCsvToBean.beanBuilder("csv/logins.csv", Login.class, ',');
			} catch (Exception e) {
				e.printStackTrace();
			}

			List<Login> finalLogins = logins;
			assert postings != null;
			for (Posting posting : postings) {
				assert finalLogins != null;
				Login login = finalLogins.stream()
						.filter(m -> m.getAppAccountName().equals(posting.getUserName()))
						.findFirst()
						.orElse(null);
				if ((login != null && login.isActive())) {
					posting.setAuthorizedDelivery(true);
				} else {
					posting.setAuthorizedDelivery(false);
				}
			}

			postingService.create(postings);
			loginService.create(logins);
		};
	}
}
