package com.nagarro.serviceproviders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceprovidersApplicationTests {

	@Test
	@DisplayName("Sample Test case 1")
	void test1() {
        String str="This is the testcase in this class";
        assertEquals("This is the testcase in this class", str);
	}
	
	@Test
	@DisplayName("Sample Test case 2")
	void contextLoads2() {
        String str="Th is the testcase in this class";
        assertNotEquals("This is the testcase in this class", str);
	}

}
