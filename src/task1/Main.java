package task1;

public class Main {

    public static void main(String[] args) {

        var cats = Cat.makeCats(10);
        Printer.print(cats);

        // А сюда добавьте код, который будет сортировать коллекцию котов
        // используйте лямбда-выражения и ссылки на методы
        //cats.sort(?);
        //Printer.print(cats);

        cats.sort(Cat::byBreed);
        Printer.print(cats);

        cats.sort(Cat::byName);
        Printer.print(cats);

        cats.sort((x, y) -> Integer.compare(x.getAge(), y.getAge()));
        Printer.print(cats);

        cats.removeIf(cat -> cat.getColor().equals(Cat.Color.SILVER));
        Printer.print(cats);

        cats.removeIf(cat -> 5 < cat.getName().length());
        Printer.print(cats);
    }


}
