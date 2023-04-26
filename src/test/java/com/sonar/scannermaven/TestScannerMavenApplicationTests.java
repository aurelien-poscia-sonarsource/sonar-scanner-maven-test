package com.sonar.scannermaven;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestScannerMavenApplicationTests {

	public static final String lowercase_stupid_extra_long_name_43242874234982789589234568934rt69ew4gheskdfghdsfiuvbas4535734534534oh5h3o4g5hoi35hoi34h5o34ho543hoi53ho45ho34ho532oh45ho534ho53ho5ho345oh543oh5ho34o5hho345 = "TEST";
	public static final String lowercase_stupid_extra_long_name_243242874234982789589234568934rt69ew4gheskdfghdsfiuvbas4535734534534oh5h3o4g5hoi35hoi34h5o34ho543hoi53ho45ho34ho532oh45ho534ho53ho5ho345oh543oh5ho34o5hho345 = "TEST";

	@Test
	void contextLoads() {
		System.out.println("test");
		// comment
		boolean condition = true == true;
		Assertions.assertTrue(condition);
	}

}
