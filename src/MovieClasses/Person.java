package MovieClasses;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private int weight; //Значение поля должно быть больше 0
    private String passportID; //Поле не может быть null
    private Location location; //Поле не может быть null
    public Person(){
    }
    public void setPersonName(String name){ this.name=name;}
    public void setPersonWeight(int i){weight=i;}
    public void setPassportID(String str){passportID=str;}
    public void setLocation(Location loc){location=loc;}

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public Location getLocation() {
        return location;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean equals(Person anPers) {
        System.out.println("tak blya");
        boolean b=weight==anPers.weight;
        System.out.println("tak blyat");
        System.out.println(passportID);
        boolean f=passportID.equals(anPers.getPassportID());
        System.out.println("tak blya");
        boolean a=name.equals(anPers.name)&&location.getName().equals(anPers.location.getName());
        System.out.println("tak blya");
        boolean c=location.getX()==anPers.location.getX()&&location.getY()==anPers.location.getY();
        System.out.println("tak blya");
        boolean d=location.getZ().equals(anPers.location.getZ());
        System.out.println("tak blya");
        return b;
    }

    @Override
    public String toString() {
        String str="Имя сценариста:" +name+"\n"+
                "Его вес: " +weight+"\n"+
                "Его паспортный идентификатор" +passportID+"\n"+
                "Информация о его месте положения: "+location.toString() ;
        return str;
    }
}



