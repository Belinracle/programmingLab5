package collection;

import java.util.Scanner;

public class Movie implements Fillable {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int oscarsCount; //Значение поля должно быть больше 0
    private MovieGenre genre; //Поле может быть null
    private MpaaRating mpaaRating; //Поле не может быть null
    private Person screenwriter;

    public Movie(){

    }
    @Override
    public Movie fill(Scanner scan ) {
        System.out.println("Укажите название фильма");
        setName(scan.nextLine());
        System.out.println("Укажите количество оскаров ");
        oscarsCount=scan.nextInt();
        Coordinates coordinates= new Coordinates;
        return this;
    }
    void setName(String str){
        name=str;
    }
}

