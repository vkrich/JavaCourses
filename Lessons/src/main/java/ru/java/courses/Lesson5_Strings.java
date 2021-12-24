package ru.java.courses;

public class Lesson5_Strings {

    /**
     * Дан массив строк, необходимо удалить из него все дубли,
     * оставшиеся строки объединить в одну в порядке следования в массиве.
     *
     * <p>
     * Подсказка: массив может быть пустой
     *
     * @param strings массив строк
     *
     * @return полученную строку.
     */
    public static String task1(String[] strings) {
        if(strings.length == 0){
            return "";
        }
        StringBuilder result = new StringBuilder();

        for(int i = strings.length-1; i >= 0; i--){
            boolean flag = false;
            for(int j = i - 1; j >= 0; j--){
                if(strings[i].equals(strings[j])){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                result.insert(0, strings[i]);
            }
        }
        return result.toString();
    }

    /**
     * Дан массив пар названий книг и авторов, необходимо привести каждую пару в строку вида:
     * “Название книги” И.И.Автора
     * <p>
     * Подсказка: Кавычек может не быть, а вместо инициалов полное имя
     *
     * @param pairs массив из пар строк
     *
     * @return  массив из полученных строк отсортированный по названию книг по алфавиту.
     */
    public static String[] task2(String[][] pairs) {
        String[] result = new String[pairs.length];
        String[] author;
        String title;
        for(int i = 0; i < pairs.length; i++){
            author = pairs[i][1].split(" ");
            title = pairs[i][0].replace("\"", "");
            title = "\"" + title + "\" ";
            result[i] = title + author[0].charAt(0) + ". " + author[1].charAt(0) + ". " + author[2];
        }
        return result;
    }

    /**
     * Дана строка, необходимо найти два символа и вернуть подстроку между ними.
     * <p>
     * Подсказка: одного или обоих символов может нет быть
     *
     * @param str исходная строка
     * @param symb1 первый символ
     * @param symb2 второй символ
     *
     * @return подстроку между найденными символами
     */
    public static String task3(String str, char symb1, char symb2) {
        int index1 = str.indexOf(symb1);
        int index2 = str.indexOf(symb2);
        if (index1 != -1 && index2 != -1){
            if (index2 < index1){
                int tmp = index2;
                index2 = index1;
                index1 = tmp;
            }
            return str.substring(index1+1, index2);
        }else {
            return "";
        }

    }
}
