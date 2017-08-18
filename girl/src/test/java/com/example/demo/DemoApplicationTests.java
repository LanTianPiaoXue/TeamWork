package com.example.demo;

import org.hibernate.mapping.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		Thread run = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("run------------ ");
			}
		});

		run.start();

		Thread thread = new Thread(){
			@Override
			public void run() {
				System.out.println("thread---");
			}
		};

		thread.start();

	}


}
