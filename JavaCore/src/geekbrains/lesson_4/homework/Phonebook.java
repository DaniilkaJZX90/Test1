package geekbrains.lesson_4.homework;

import java.util.HashMap;
import java.util.HashSet;

public class Phonebook {
    private final HashMap<String, HashSet<Integer>> phoneBook; // уникальный ключ "фамилия" и уникальное значение "телефон"

    public Phonebook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String lastName, int phone) {
        if (phoneBook.get(lastName) == null) {
            phoneBook.put(lastName, new HashSet<>());
        }
        phoneBook.get(lastName).add(phone);
    }

    public  void get(String lastName){
        if(phoneBook.get(lastName) != null){
            System.out.println(lastName + " " + phoneBook.get(lastName).toString());
        }else{
            System.out.println("number not found");
        }
    }
}

