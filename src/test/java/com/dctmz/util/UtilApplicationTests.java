package com.dctmz.util;

import org.junit.jupiter.api.Test;

class UtilApplicationTests {

	@Test
	void testR(){
		System.out.println(R.ok());
		System.out.println(R.ok("ok"));
		System.out.println(R.ok(new R<>()));
		System.out.println(R.error());
		System.out.println(R.error("error"));
		System.out.println(R.noAuth());
		System.out.println(R.noAuth("no auth"));
	}

}
