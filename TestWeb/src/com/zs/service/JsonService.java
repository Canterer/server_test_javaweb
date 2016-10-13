package com.zs.service;

import java.util.ArrayList;
import java.util.List;

import com.zs.beans.Person;

public class JsonService {
	public List<Person> getListPerson(){
		
		List<Person> list = new ArrayList<Person>();
		
		Person p1 = new Person(1001,"user1","password1");
		Person p2 = new Person(1002,"user2","password2");
		list.add(p1);
		list.add(p2);
		
		return list;
		
	}
}
