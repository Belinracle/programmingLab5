package MovieClasses;

public class Location {
    private long x;
    private int y;
    private Float z; //Поле не может быть null
    private String name; //Поле может быть null
    public Location( String name,long x, int y, Float z){
        this.x=x;
        this.y=y;
        this.z=z;
        this.name=name;
    }

    public Float getZ() {
        return z;
    }

    public int getY() {
        return y;
    }

    public long getX() {
        return x;
    }

    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        String str =
                "Название места: "+name+"\n"+
                "Координата Х: " +x+"\n"+
                "Координата У: " +y+"\n"+
                "Координата Z: " +z+"\n";
        return str;
    }
}
