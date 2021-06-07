package com.project.scrapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class ScrapperApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(getNumber("11,191 ratings"));
	}

	private long getNumber(String text) {
		System.out.println(text);
		return Long.parseLong(text.replaceAll("[^\\d.]", ""));
	}

}
