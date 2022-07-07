package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

    // код можно менять только в особо отмеченных местах этого файла.
    // то есть там, где написаны три знака вопроса "???"
    // так же возможно вам понадобится добавить что-то в
    // блок import и поменять имя пакета
    // в остальных местах этого файла код менять не разрешается.

public final class ActiveCat {
    private static final Random r = new Random();
    private static final List<String> names = List.of("Peach", "Ginger", "Toby", "Seth", "Tibbles", "Tabby", "Poppy", "Millie", "Daisy", "Jasper", "Misty", "Minka");
    private final String name;

    private Replica action;

    public ActiveCat(Replica action) {
        name = names.get(r.nextInt(names.size()));
        this.action = action;
    }

    public final String getName() {
        return name;
    }

    public void doAction() {
        System.out.printf("I'm %s. %s%n", name, action.perform());
    }

    /*****/
    // Действия доступные для котов

    public static String jump() {
        return "I'm jumping!";
    }

    public static String sleep() {
        return "I'm sleeping!";
    }

    public static String eat() {
        return "I'm eating!";
    }

    public static String hunt() {
        return "I'm hunting!";
    }

    public static String play() {
        return "I'm playing!";
    }

    public static String walk() {
        return "I'm walking!";
    }
    /*****/
}
