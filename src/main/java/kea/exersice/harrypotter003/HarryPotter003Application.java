package kea.exersice.harrypotter003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import kea.exersice.harrypotter003.app.InitData;

@SpringBootApplication
public class HarryPotter003Application {

	public static void main(String[] args) {
		SpringApplication.run(HarryPotter003Application.class, args);
		System.out.println("Harry Potter and the REST-API is running");
//		InitData initData = new InitData();
//        initData.run();

	}

}
