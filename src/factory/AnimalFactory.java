package factory;

import animals.AbsAnimal;
import animals.pets.Cat;
import animals.pets.Dog;
import animals.pets.birds.Duck;
import data.AnimalTypeData;
import data.ColorData;

public class AnimalFactory {

    private String name = "";

    private int age = -1;

    private int weight = -1;

    private ColorData color = null;


    public AnimalFactory(String name, int age, int weight, ColorData color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public AbsAnimal create(AnimalTypeData animalTypeData) {
        switch (animalTypeData) {
            case CAT: {
                return new Cat(name, age, weight, color);
            }
            case DUCK: {
                return new Duck(name, age, weight, color);
            }
            case DOG: {
                return new Dog(name, age, weight, color);
            }
        }
        throw new RuntimeException(String.format("Animal %s not supported", animalTypeData.name().toLowerCase()));
    }
}
