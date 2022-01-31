package ru.java.courses;

import java.util.*;

public class Lesson10_CollectionsLists {

    /**
     * В этом методе необходимо реализовать:
     * 1. На вход получаем список чисел
     * 2. Удаляем все дубли
     * 3. Сортируем список по возрастанию
     * 4. Преобразуем числа в строки
     * <p>
     * Подсказки:
     * Collections.sort() - сортировка
     * Удалять элементы из итерируемого списка нельзя - выпадет исключение
     */
    public static List<String> task1(List<Integer> source) {
        //System.out.println(source[0]);
        Collections.sort(source);
        List<String> result = new ArrayList<>();
        int tmp = source.get(0);
        result.add(Integer.toString(tmp));

        for(int i: source){
            if(tmp != i){
                result.add(Integer.toString(i));
            }
            tmp = i;
        }

        return result;
    }

    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. Получаем на входе массив чисел
     * 2. Преобразовываем его к списку
     * 4. Все четные числа увеличиваем на единицу
     * 5. Возвращаем кусок списка с 3-го по 7-й элемент
     * <p>
     * Подсказка: на входе может быть любое количество чисел
     */
    public static List<Integer> task2(Integer... array) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(array));
        if(arr.size() <= 3) {
            return null;
        }

        for(int i=0;i<arr.size();i++){
            Integer val = arr.get(i);
            if(val % 2 == 0){
                arr.set(i, val + 1);
            }
        }

        if(arr.size()>=8) {
            return arr.subList(3, 8);
        }else if(arr.size() >= 4){
            return arr.subList(3, arr.size());
        }else {
            return null;
        }

    }
}
