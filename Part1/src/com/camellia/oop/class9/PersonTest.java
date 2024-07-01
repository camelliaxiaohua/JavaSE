package com.camellia.oop.class9;

public class PersonTest {
    public static void main(String[] args) {
        Person person =new ChinsesPerson();
        person.greet();
        person =new EnglishPerson();
        person.greet();
    }
}
