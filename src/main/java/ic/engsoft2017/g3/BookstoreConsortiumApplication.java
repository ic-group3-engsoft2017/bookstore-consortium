package ic.engsoft2017.g3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
public class BookstoreConsortiumApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreConsortiumApplication.class, args);
	}
}
