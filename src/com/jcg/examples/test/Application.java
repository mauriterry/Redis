package com.jcg.examples.test;


import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.jcg.examples.bean.Person;
import com.jcg.examples.bean.Person.Gender;
import com.jcg.examples.repo.PersonRepo;


public class Application
{
		public static void main(String[] args)
		{
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new ClassPathResource("resources/spring-config.xml").getPath());
				PersonRepo personRepo = (PersonRepo)context.getBean("personRepo");
				
				Person person = new Person();
				person.setId("1");
				person.setAge(55);
				person.setGender(Gender.Female);
				person.setName("Oracle");
				
				personRepo.save(person);
				
				Person person2 = new Person();
				person2.setId("2");
				person2.setAge(60);
				person2.setGender(Gender.Male);
				person2.setName("TheArchitect");
				
				personRepo.save(person2);
				
				Person person3 = new Person();
				person3.setId("3");
				person3.setAge(25);
				person3.setGender(Gender.Male);
				person3.setName("TheOne");
				
				personRepo.save(person3);
				
				Person person4 = new Person();
				person4.setId("4");
				person4.setAge(225);
				person4.setGender(Gender.Male);
				person4.setName("TheOne1");
				
				personRepo.save(person4);
				
				System.out.println("Finding the One : "+personRepo.find("1"));
				System.out.println("Finding the One : "+personRepo.find("3"));
				System.out.println("Finding the One : "+personRepo.find("4"));
				System.out.println("Finding the One : "+personRepo.find("2"));
				context.close();

		}
}
