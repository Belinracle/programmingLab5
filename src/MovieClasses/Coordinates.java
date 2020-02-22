package MovieClasses;

public class Coordinates{
    private Integer x; //Значение поля должно быть больше -928, Поле не может быть null
    private float y; //Максимальное значение поля: 982
    public Coordinates(Integer x, float y){
        this.x=x;
        this.y=y;
    }
    @Override
    public String toString() {
    return "x="+x+", y="+y;
    }
}

