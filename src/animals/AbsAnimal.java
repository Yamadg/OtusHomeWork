package animals;

import data.ColorData;

public abstract class AbsAnimal {

    private String name = "";

    private int age = -1;

    private int weight = -1;

    private ColorData color = null;


    public AbsAnimal(String name, int age, int weight, ColorData color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }


    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    public int getWeight() {
        return weight;
    }


    public ColorData getColor() {
        return color;
    }


    public void say() {
        System.out.println("Я говорю!");
    }


    public void go() {
        System.out.println("Я иду!");
    }


    public void drink() {
        System.out.println("Я пью!");
    }


    public void eat() {
        System.out.println("Я ем!");
    }


    public String toString(){
         return String.format("Привет! Меня зовут %s, мне %d %s, я вешу - %d кг, мой цвет - %s", name, age, checkPadezh(), weight, color.getColor());

    }

    public String checkPadezh(){
        int lastDigit = age % 10;
        int lastTwoDigits = age % 100;

        if (lastDigit == 1 && lastTwoDigits != 11){
            return "год";
        } else if ((lastDigit >= 2 && lastDigit <= 4) && (lastTwoDigits < 12 || lastTwoDigits > 14)){
            return "года";
        } else {
            return "лет";
        }
    }
}
