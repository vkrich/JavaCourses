package ru.java.courses;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javax.swing.tree.TreeCellEditor;

public class Lesson11to12_SetMap {

    public static class User {

        private String name;
        private int age;
        private String phone;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public User(String phone) {
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return age == user.age && name.equals(user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

    }

    /**
     * В этом методе необходимо реализовать:
     * 1. На вход получаем коллекцию пользователей
     * 2. Удаляем все дубли (одинаковое имя и возраст)
     * 3. Сортируем по имени и возрасту
     * 4. Возвращаем последнего пользователя
     */
    public static User task1(Collection<User> source) {
        HashSet<User> users_set = new HashSet<>(source);
        List<User> users_list = new ArrayList<>(users_set);
        users_set.clear();
        users_list.sort(Comparator.comparing(User::getName).thenComparing(User::getAge));
        return users_list.get(users_list.size()-1);
    }

    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем коллекцию пользователей
     * 2. Преобразовываем его в справочник [номер телефона -> пользователь]
     * 3. Один номер телефона на одного пользователя
     * 4. Вернуть количество записей в справочнике
     */
    public static int task2(Collection<User> source) {
        HashMap<String, User> users = new HashMap<>();
        for (User u: source){
            users.put(u.getPhone(), u);
        }
        return users.size();
    }


    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем список названий книг
     * 2. Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг
     * 3. Все книги должны быть отсортированы по алфавиту с первой до последней полки
     * 4. Количество полок константное - 5 штук
     * 5. Вернуть книги распределенные по полкам
     *
     * Нумерация полок начинается с единицы!
     */
    public static Map task3(Collection<String> source) {
        final int n = 5;
        HashMap<Integer, List<String>> books = new HashMap<>();
        List<String> books_source = new ArrayList<>(source);
        Collections.sort(books_source);

        int book_index = 0;
        for(int i = 1; i<n; i++){
            List<String> polka = new ArrayList<>();
            books.put(i, polka);
            for(int j = 0;j < books_source.size()/n; j++){
                books.get(i).add(books_source.get(book_index));
                book_index++;
            }
        }
        List<String> polka = new ArrayList<>();
        books.put(n, polka);
        for(int i = book_index; i < books_source.size(); i++){
            books.get(n).add(books_source.get(i));
        }
        return books;
    }


    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем книги, распределенные по полкам
     * 5. Вернуть справочник [название книги -> номер полки]
     */
    public static Map task4(Map<Integer, String> source) {
        HashMap<String, Integer> books = new HashMap<>();
        for(Integer key: source.keySet()){
           books.put(source.get(key), key);
        }
        return books;
    }
}
