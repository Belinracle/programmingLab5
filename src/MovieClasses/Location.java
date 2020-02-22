package MovieClasses;

public class Location {
    private long x;
    private int y;
    private Float z; //Поле не может быть null
    private String name; //Поле может быть null
    public Location(long x, int y, Float z, String name){
        this.x=x;
        this.y=y;
        this.z=z;
        this.name=name;
    }
}
