package data;

public enum ColorData {

    WHITE("белый"),

    BLACK("черный"),

    YELLOW("желтый");

    private final String color;

    ColorData(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }

}





