package task1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var cats = Cat.makeCats(10);
        Printer.print(cats);

        // А сюда добавьте код, который будет сортировать коллекцию котов
        // используйте лямбда-выражения и ссылки на методы
        //cats.sort(?);
        //Printer.print(cats);

        System.out.println("""
                Select an action:
                  Sort by breed - 1;
                  Sort by name - 2;
                  Sort by age - 3;
                  Remove cats of the selected color - 4;
                  Remove cats if their age is more than five - 5;
                  """);

        int action = getNumber(1, 5);

        switch (action) {
            case 1:
                cats.sort(Cat::byBreed);
                Printer.print(cats);
                break;
            case 2:
                cats.sort(Cat::byName);
                Printer.print(cats);
                break;
            case 3:
                cats.sort((x, y) -> Integer.compare(x.getAge(), y.getAge()));
                Printer.print(cats);
                break;
            case 4:
                System.out.println(Arrays.toString(Cat.Color.values()));
                System.out.print("Select the color by number: ");
                int color = getNumber(1, 6);
                if (color == 1) {
                    cats.removeIf(cat -> cat.getColor().equals(Cat.Color.TABBY));
                } else if (color == 2) {
                    cats.removeIf(cat -> cat.getColor().equals(Cat.Color.SILVER));
                } else if (color == 3) {
                    cats.removeIf(cat -> cat.getColor().equals(Cat.Color.GRAY));
                } else if (color == 4) {
                    cats.removeIf(cat -> cat.getColor().equals(Cat.Color.PEACH));
                } else if (color == 5) {
                    cats.removeIf(cat -> cat.getColor().equals(Cat.Color.GINGER));
                } else {
                    cats.removeIf(cat -> cat.getColor().equals(Cat.Color.TORTIE));
                }
                Printer.print(cats);
                break;

            case 5:
                cats.removeIf(cat -> 5 < cat.getName().length());
                Printer.print(cats);
                break;

            default:
                System.out.println();
        }


    }

    private static int getNumber(int start, int end) {
        int value;
        while (true) {
            try {
                value = new Scanner(System.in).nextInt();

                while (value < start || value > end) {
                    System.out.print("Invalid value. Enter from " + start + " to " + end + ": ");
                    value = new Scanner(System.in).nextInt();
                }
                return value;
            } catch (InputMismatchException e) {
                System.out.print("Invalid value. Try again: ");
            }
        }
    }

}
