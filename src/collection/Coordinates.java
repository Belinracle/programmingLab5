package collection;

import java.util.Scanner;

public class Coordinates implements Fillable {
    private Integer x; //Значение поля должно быть больше -928, Поле не может быть null
    private float y; //Максимальное значение поля: 982
    public Coordinates(Integer x, float y){
        this.x=x;
        this.y=y;
    }

    public Coordinates(){
    }
    @Override
    public String toString() {
    return "x="+x+", y="+y;
    }
    public void setX(Integer x){
        this.x=x;
    }
    public void setY(float y){
        this.y=y;
    }

    @Override
    public <T> T fill(Scanner scan) {
        System.out.println("Введите значение координаты Y");
        setY(scan.nextFloat());
        System.out.println("Введите значение координаты Y");
    }
}

