package com.vrubizha.eduspace.configuration.general;

import java.util.*;
import java.util.stream.Collectors;


public class StreamsPractice {
    public static void main(String[] args) {

    List<Integer> integers=Arrays.asList(4,3,2);
        System.out.println(total(integers));

    }

    private static int total(List<Integer> nums) {

     return nums.parallelStream()
             .reduce(2,Integer::sum,(p,q)->p+q);



    }


}


///**
// * Sample 1 Convert Map to List using Stream map()
// */
//Map<Integer, String> map = new HashMap<>();
//        map.put(111, "Lalkrishna");
//        map.put(154, "Atal");
//        map.put(30, "Narendra");
//        map.put(200, "Amit");
//
//    List<User> list = map.entrySet().stream()
//            .sorted(Comparator.comparing(e -> e.getKey()))
//            .map(e -> new User(e.getKey(), e.getValue()))
//            .collect(Collectors.toList());
//
//        list.forEach(l -> System.out.println("Id: "+ l.getId()+", Name: "+ l.getName()));
//}
//}
//class User {
//    private int id;
//    private String name;
//    public User(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//    public int getId() {
//        return id;
//    }
//    public String getName() {
//        return name;
//    }


// Sample 2 Convert List to another List using Stream map()

//    Person p1 = new Person(1, "Mohan", "student");
//    Person p2 = new Person(2, "Sohan", "teacher");
//    Person p3 = new Person(3, "Dinesh", "student");
//    List<Person> personList = Arrays.asList(p1, p2, p3);
//
//    List<Student> stdList = personList.stream().filter(p -> p.getPersonType().equals("student"))
//            .map(p -> new Student(p.getId(), p.getName()))
//            .collect(Collectors.toList());
//
//		stdList.forEach(e -> System.out.println("Id:"+ e.getId()+ ", Name: "+ e.getName()));
//}
//}
//class Person {
//    private int id;
//    private String name;
//    private String personType;
//    public Person(int id, String name, String personType) {
//        this.id = id;
//        this.name = name;
//        this.personType = personType;
//    }
//    public int getId() {
//        return id;
//    }
//    public String getName() {
//        return name;
//    }
//    public String getPersonType() {
//        return personType;
//    }
//}
//class Student {
//    private int id;
//    private String name;
//    public Student(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//    public int getId() {
//        return id;
//    }
//    public String getName() {
//        return name;
//    }
//


//    List<String> list = Arrays.asList("Mukesh", "Vishal", "Amar","Zakhar");
//    String result = list.parallelStream().collect(StringBuilder::new,
//            (response, element) -> response.append(" ").append(element),
//            (response1, response2) -> response1.append(",").append(response2.toString()))
//            .toString();
//        System.out.println("Result: " + result);
