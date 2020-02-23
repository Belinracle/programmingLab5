package MovieClasses;

import Exceptions.WrongRangeException;

public class Movie{
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
    public void setName(String str){
        name=str;
    }
    public String getName(){return name;}
    public void setOscarsCount(int i){oscarsCount=i;}
    public int getOscarsCount(){return oscarsCount;}
    public void setCoordinates(Coordinates coords){coordinates=coords;}
    public void setMovieGenre(MovieGenre mg){genre=mg;}
    public void setMpaaRating(MpaaRating mpaar){mpaaRating=mpaar;}
    public void setPerson(Person pers){screenwriter=pers;}

}

