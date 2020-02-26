package MovieClasses;

public class Location {
    private long x;
    private int y;
    private Float z; //Поле не может быть null
    private String name; //Поле может быть null
    public Location(){
    }
    public void setX(long l){
            x=l;
    }
    public void setY(int i){
        y=i;
    }
    public void setZ(Float f){
        z=f;
    }
    public void setName(String name){
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
        return  "Название места: "+name+"\n"+
                "Координата Х: " +x+"\n"+
                "Координата У: " +y+"\n"+
                "Координата Z: " +z+"\n";
    }
}
