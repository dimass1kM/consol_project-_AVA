import java.util.stream.IntStream;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void printMenu() {
        System.out.println("========== МЕНЮ ==========");
        System.out.println("1. Проверить, целое ли число");
        System.out.println("2. Найти числа в диапазоне 1..150, содержащие цифру");
        System.out.println("3. Фильтрация множества по условию (<, >, <=, >=)");
        System.out.println("0. Выход");
        System.out.println("==========================");
    }

    public static void numInteger(double num) {
        if (num % 1 == 0) {
            System.out.println("Число является целым. ");
        } else {
            System.out.println("Число не является целым");
        }
    }

    public static void rangeNum(int num) {
        int start = 1;
        int end = 150;

        String numStr = String.valueOf(num);

        int count = 0;
        for (int i = start; i <= end; i++) {
            String curr = String.valueOf(i);
            if (curr.contains(numStr)) {
                System.out.print(i + " ");
                count ++;
            }
        }
        System.out.println();

        if (count == 0) {
            System.out.println("числа не найдены. ");
        } else {
            System.out.println("Числа содержащие цифру:" + count);
        }
    }

    public static void choice(Scanner scanner) {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(-5,0,5,10,15));

        System.out.println("Введите ограничение для поиска: ");

        String condition = scanner.nextLine().trim();
        scanner.close();

        Set<Integer> result = new HashSet<>();
        String operator = "";
        int targetVal = 0;

        if (condition.startsWith("<=")) {
            operator = "<=";
        } else if (condition.startsWith(">=")) {
            operator = ">=";
        } else if (condition.startsWith("<")) {
            operator = "<";
        } else if (condition.startsWith(">")) {
            operator = ">";
        }

        if (operator.isEmpty()) {
            System.out.println("Условие должно начинаться с <, >, <= или >=.");
            return;
        }

        targetVal = Integer.parseInt(condition.substring(operator.length()).trim());

        for (int num : numbers) {
            if (operator.equals(">") && num > targetVal) result.add(num);
            else if (operator.equals("<") && num < targetVal) result.add(num);
            else if (operator.equals(">=") && num >= targetVal) result.add(num);
            else if (operator.equals("<=") && num <= targetVal) result.add(num);
        }

        System.out.println("Под условие подошли: " + result);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            printMenu();
            System.out.print("Выберите пункт: ");

            String choiceMenu = scanner.nextLine().trim();

            switch (choiceMenu) {
                case"1": //целое число
                    System.out.println("Введите число: ");
                    Double number = scanner.nextDouble();
                    scanner.nextLine();

                    numInteger(number);
                    break;

                case"2": //все числа
                    System.out.println("Введите число. Диапазон чисел проверки (1;150): ");
                    int numRange = scanner.nextInt();

                    scanner.nextLine();

                    rangeNum(numRange);
                    break;

                case"3": //выбор ограничений
                    choice(scanner);
                    break;

                case"0":
                    System.out.println("Выход.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Нет такого пункта. Попробуйте снова.");
            }
        }

    }
}
