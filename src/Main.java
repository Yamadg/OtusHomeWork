import tools.NumberValidator;
import animals.AbsAnimal;
import data.AnimalTypeData;
import data.ColorData;
import data.CommandData;
import factory.AnimalFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
//    private static final NumberValidator numberValidator = new NumberValidator();

    public static void main(String[] args) {
        List<AbsAnimal> animals = new ArrayList<>();


        List<String> commandNames = new ArrayList<>();

        for (CommandData commandData : CommandData.values()) {
            commandNames.add(commandData.name().toUpperCase());
        }

        while (true) {
            System.out.printf("Введите команду: %s%n", String.join("/", commandNames));

            String userCommandConsole = scanner.next().trim().toUpperCase();

            if (!commandNames.contains(userCommandConsole)) {

                System.out.println("Вы ввели неверную команду. \n");

                continue;
            }

            CommandData userCommand = CommandData.valueOf(userCommandConsole.toUpperCase());

            switch (userCommand) {
                case ADD: {

                    List<String> animalsTypeNames = new ArrayList<>();

                    for (AnimalTypeData animalTypeData : AnimalTypeData.values()) {
                        animalsTypeNames.add(animalTypeData.name().toUpperCase());
                    }

                    AnimalTypeData animalTypeData = null;

                    while (true) {
                        System.out.printf("Введите тип животного: %s\n", String.join(",", animalsTypeNames));
                        String userAnimalTypeData = scanner.next().toUpperCase();
                        if (!animalsTypeNames.contains(userAnimalTypeData)) {
                            System.out.println("Вы несуществующий тип животного. \n");
                            continue;
                        }
                        animalTypeData = AnimalTypeData.valueOf(userAnimalTypeData.toUpperCase());
                        break;
                    }

                    System.out.println("Ввидите имя животного: ");
                    String name = scanner.next();

                    int animalAge = getAnimalAgeWeight("Введите возвраст животного: ", "Вы ввели неверный возвраст.\n");
                    int animalWeight = getAnimalAgeWeight("Введите вес животного: ", "Вы ввели неверный вес.\n");

                    List<String> animalsColor = new ArrayList<>();

                    for (ColorData colorData : ColorData.values()) {
                        animalsColor.add(colorData.name().toLowerCase());
                    }
                    ColorData colorData = null;
                    while (true) {
                        System.out.printf("Введите цвет животного: %s\n", String.join(",", animalsColor));
                        String userAnimalColor = scanner.next().toLowerCase();

                        if (!animalsColor.contains(userAnimalColor)) {
                            System.out.println("Вы ввели неверный цвет животного");
                            continue;
                        }
                        colorData = ColorData.valueOf(userAnimalColor.toUpperCase());
                        break;
                    }

                    AbsAnimal animal = new AnimalFactory(name, animalAge, animalWeight, colorData).create(animalTypeData);
                    animals.add(animal);
                }
                case LIST: {
                    for (AbsAnimal animal : animals) {
                        System.out.println(animal.toString());
                    }
                    break;
                }
                case EXIT: {
                    System.exit(0);
                }
            }

        }
    }

    private static int getAnimalAgeWeight(String consoleMsg, String errorMsg) {
        while (true) {
            System.out.println(consoleMsg);
            String userAnimalAgeWeight = scanner.next();
            if (!NumberValidator.isNumber(userAnimalAgeWeight)) {
                System.out.println(errorMsg);
                continue;
            }
            return Integer.parseInt(userAnimalAgeWeight);
        }
    }


}
