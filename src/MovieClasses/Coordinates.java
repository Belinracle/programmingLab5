package MovieClasses;


public class Coordinates{
    private Integer x; //Значение поля должно быть больше -928, Поле не может быть null
    private float y; //Максимальное значение поля: 982
    public Coordinates(){
    }

    public float getY() {
        return y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer i){
        x=i;
    }
    public void setY(float f){
        y=f;
    }
    @Override
    public String toString() {
    return "x= "+x+ "\n"+
            "y= "+y;
    }
}

