package king.ide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class IdeApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdeApplication.class, args);
	}

}
