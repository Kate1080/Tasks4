 import java.util.ArrayList;
import java.util.Arrays;

 public class tasks4 {

    public static void main(String[] args) {
        System.out.println("Задание 1");
        System.out.println(essay(10,7, "hello my name is Bessie and this is my essay"));


        System.out.println("Задание 2");
        String[] result1 = split("()()()");
        System.out.println(Arrays.toString(result1));
        String[] result2 = split("((()))");
        System.out.println(Arrays.toString(result2));
        String[] result3 = split("((()))(())()()(()())");
        System.out.println(Arrays.toString(result3));


        System.out.println("Задание 3");
        System.out.println(changeString("hello_edabit"));
        System.out.println(changeString("helloEdabit"));
        System.out.println(changeString("is_modal_open"));
        System.out.println(changeString("getColor"));

        System.out.println("Задание 4");
        double[] mas1 = {9, 17, 30, 1.5};
        System.out.println(overTime(mas1));
        double[] mas2 = {16, 18, 30, 1.8};
        System.out.println(overTime(mas2));
        double[] mas3 = {13.25, 15, 30, 1.5};
        System.out.println(overTime(mas3));


        System.out.println("Задание 5");
        System.out.println(BMI("205 pounds", "73 inches"));
        System.out.println(BMI("55 kilos", "1.65 meters"));
        System.out.println(BMI("154 pounds", "2 meters"));


        System.out.println("Задание 6");
        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4));


        System.out.println("Задание 7");
        System.out.println(toStarShorthand("abbccc"));
        System.out.println(toStarShorthand("77777geff"));
        System.out.println(toStarShorthand("abc"));
        System.out.println(toStarShorthand(""));


        System.out.println("Задание 8");
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println(doesRhyme("You are off to the races", "a splendid day."));
        System.out.println(doesRhyme("and frequently do?", "you gotta move."));


        System.out.println("Задание 9");
//        System.out.println(trouble(451999277, 41177722899));
        System.out.println(trouble(1222345, 12345));
        System.out.println(trouble(666789, 12345667));
        System.out.println(trouble(33789, 12345337));


        System.out.println("Задание 10");
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.println(countUniqueBooks("ZZABCDEF", 'Z'));

    }

//    Если Бесси набирает Слово, и это слово может поместиться в текущей строке, поместите
//    его в эту строку. В противном случае поместите слово на следующую строку и
//    продолжайте добавлять к этой строке. Конечно, последовательные слова в одной строке
//    все равно должны быть разделены одним пробелом. В конце любой строки не должно
//    быть места.
    public static String essay(int n, int k, String s) {
        String[] words = s.split(" ");
        StringBuilder answer = new StringBuilder();
        int cur_len = 0;

        for (String word : words) {
            if (word.length() + cur_len <= k) {
                if (cur_len == 0) { answer.append(word);}
                else { answer.append(" ").append(word);}
                cur_len += word.length();
            }

            else {
                cur_len = word.length();
                answer.append("\n").append(word);
            }
        }

        return answer.toString();
    }


    //    Напишите функцию, которая группирует строку в кластер скобок. Каждый кластер
//    должен быть сбалансирован.
    public static String[] split(String s) {
        StringBuilder cur_str = new StringBuilder();
        int opened = 0;
        int closed = 0;
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                opened += 1;
                cur_str.append(s.charAt(i));
            }

            if (s.charAt(i) == ')') {
                closed += 1;
                cur_str.append(s.charAt(i));
            }

            if (opened == closed) {
                result.add(cur_str.toString());
                cur_str.delete(0, cur_str.length());
            }
        }
        String[] answer = new String[result.size()];
        for (int l = 0; l < result.size(); l++) {
            answer[l] = result.get(l);
        }
        return answer;
    }

    //    Создайте две функции toCamelCase () и toSnakeCase (), каждая из которых берет
//    одну строку и преобразует ее либо в camelCase, либо в snake_case.
    public static String changeString(String s) {
        if (s.indexOf('_') == -1) {
            return toSnakeCase(s);
        }

        return toCamelCase(s);
    }


    public static String toCamelCase(String s) {
        StringBuilder buffer = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (flag) {
                buffer.append(s.substring(i, i + 1).toUpperCase());
                flag = false;
            } else if (s.charAt(i) == '_') {
                flag = true;
            } else {
                buffer.append(s.charAt(i));
            }
        }

        return buffer.toString();
    }


    public static String toSnakeCase(String s) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                buffer.append('_').append(s.substring(i, i + 1).toLowerCase());
            } else {
                buffer.append(s.charAt(i));
            }
        }
        return buffer.toString();
    }

    //    Напишите функцию, которая вычисляет сверхурочную работу и оплату, связанную
//    с сверхурочной работой.
    public static String overTime(double[] data) {
        if (data[1] > 17) {
            return "$" + String.format("%.2f", (17 - data[0]) * data[2] + (data[1] - 17) * data[2] * data[3]);
        } else {
            return "$" + String.format("%.2f", (data[1] - data[0]) * data[2]);
        }
    }

    //    Индекс массы тела (ИМТ) определяется путем измерения вашего веса в
//    килограммах и деления на квадрат вашего роста в метрах.
    public static String BMI(String s1, String s2) {
        String[] weight = s1.split(" ");
        String[] height = s2.split(" ");

        double correct_weight = Double.parseDouble(weight[0]);
        if (weight[1].equals("pounds")) {
            correct_weight = correct_weight * 0.453592;
            correct_weight = Math.round(correct_weight * 10.0) / 10.0;
        }

        double correct_height = Double.parseDouble(height[0]);
        if (height[1].equals("inches")) {
            correct_height = correct_height * 0.0254;
            correct_height = Math.round(correct_height * 10.0) / 10.0;
        }

        double bmi = correct_weight / (correct_height * correct_height);
//        bmi = Math.round(bmi * 10.0) / 10.0;
        if (bmi < 18.5) {
            return String.format("%.1f", bmi) + " " + "Underweight";
        } else if (18.5 <= bmi & bmi < 25) {
            return String.format("%.1f", bmi) + " " + "Normal weight";
        } else {
            return String.format("%.1f", bmi) + " " + "Overweight";
        }
    }


    //    Создайте функцию, которая принимает число и возвращает его мультипликативное
//    постоянство, которое представляет собой количество раз, которое вы должны
//    умножать цифры в num, пока не достигнете одной цифры.
//
    public static Integer forBugger(int ch) {
        String s_ch = Integer.toString(ch);
        int buffer = 1;
        for (int i = 0; i < s_ch.length(); i++) {
            buffer *= ch % 10;
            ch = ch / 10;
        }

        return buffer;

    }

    public static Integer bugger(int ch) {
        int answer = 0;
        if (ch < 10) {
            return answer;
        }

        while (ch >= 10) {
            answer += 1;
            ch = forBugger(ch);
        }

        return answer;
    }


    //    Напишите функцию, которая преобразует строку в звездную стенографию. Если
//    символ повторяется n раз, преобразуйте его в символ*n.
    public static String toStarShorthand(String s) {
        StringBuilder answer = new StringBuilder();
        boolean flag = false;
        int buf = 0;

        if (s.isEmpty()) {
            return "";
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                buf += 1;
                flag = true;
            } else if (flag) {
                String k = s.charAt(i - 1) + "*" + (buf + 1);
                answer.append(k);
                buf = 0;
                flag = false;
            } else {
                answer.append(s.charAt(i - 1));
            }
        }

        if (!(buf == 0)) {
            String k = s.charAt(s.length() - 1) + "*" + (buf + 1);
            answer.append(k);
        } else {
            answer.append(s.charAt(s.length() - 1));
        }
        return answer.toString();
    }


    //    Создайте функцию, которая возвращает true, если две строки рифмуются, и false в
//    противном случае. Для целей этого упражнения две строки рифмуются, если
//    последнее слово из каждого предложения содержит одни и те же гласные.
    public static Boolean doesRhyme(String s1, String s2) {
        String valid_symb = "aeiouyAEIOUY";
        StringBuilder new_s1 = new StringBuilder();
        StringBuilder new_s2 = new StringBuilder();
        for (int i = s1.length() - 1; i >= 0; i--) {
            if (s1.charAt(i) == ' ') {
                break;
            }
            if (!(valid_symb.indexOf(s1.charAt(i)) == -1)) {
                new_s1.append(s1.charAt(i));
            }
        }

        for (int i = s2.length() - 1; i >= 0; i--) {
            if (s2.charAt(i) == ' ') {
                break;
            }
            if (!(valid_symb.indexOf(s2.charAt(i)) == -1)) {
                new_s2.append(s2.charAt(i));
            }
        }
        return new_s1.toString().toLowerCase().equals(new_s2.toString().toLowerCase());
    }


    //    Создайте функцию, которая принимает два целых числа и возвращает true, если
//    число повторяется три раза подряд в любом месте в num1 и то же самое число
//    повторяется два раза подряд в num2.
    public static Boolean trouble(long ch1, long ch2) {
        String s_ch1 = Long.toString(ch1);
        String s_ch2 = Long.toString(ch2);

        boolean flag = false;
        char rep = 0;
        int buf = 1;

        for (int i = 1; i < s_ch1.length(); i++) {
            if (s_ch1.charAt(i) == s_ch1.charAt(i - 1)) {
                buf += 1;
                if (buf == 3) {
                    rep = s_ch1.charAt(i);
                    flag = true;
                    break;
                }
            } else {
                buf = 1;
            }
        }

        if (!(flag)) {
            return false;
        } else return (s_ch2.indexOf(rep, s_ch2.indexOf(rep) + 1) - s_ch2.indexOf(rep)) == 1;
//        buf = 0;
//        for (int i = 0; i < s_ch2.length(); i++) {
//            if (s_ch2.charAt(i) == rep) {
//                buf += 1;
//                if (buf == 2) {
//                    return true;
//                }
//            } else {
//                buf = 0;
//            }
//        }
//
//        return false;
    }


    //    Предположим, что пара одинаковых символов служит концами книги для всех
//    символов между ними. Напишите функцию, которая возвращает общее количество
//    уникальных символов (книг, так сказать) между всеми парами концов книги.
    public static Integer countUniqueBooks(String s, char symb) {
        boolean flag = false;
        ArrayList<Character> buf = new ArrayList<>();

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == symb & !(flag)) {
                flag = true;
            }

            else if ((flag) & s.charAt(i) == symb) {
                flag = false;
            }

            else if (flag){
                if (!(buf.contains(s.charAt(i)))) {
                    buf.add(s.charAt(i));
                }
            }
        }

        return buf.size();
    }
}

