package geekbrains.lesson_4.homework;


import java.util.*;

public class Main {
    public static void main(String[] args) {

        String[] names = new String[]{"Даниил", "Даниил", "Петр", "Александр", "Даниил", "Иван", "Иван", "Виктор", "Константин", "Виктор"};

        Set<String> stringSet = new HashSet<>(Arrays.asList(names));
        System.out.println(stringSet);

        // подсчет повторяющихся слов
        List<String> stringList = new ArrayList<>(Arrays.asList(names));
        Map<String, Integer> countNames = new HashMap<>();

        for (String s : stringList) {
            countNames.put(s, countNames.get(s) != null ? countNames.get(s) + 1 : 1);
        }
        System.out.println(countNames.toString());

        Phonebook phonebook = new Phonebook();
        phonebook.add("Bobrov",7777);
        phonebook.add("Sidorov",7779);
        phonebook.add("Bobrov",7776);
        phonebook.add("Ivanov",4353);

        phonebook.get("Bobrov");
        phonebook.get("Ivanov");




    }
}



