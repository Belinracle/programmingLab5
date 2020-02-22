package MovieClasses;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private int weight; //Значение поля должно быть больше 0
    private String passportID; //Поле не может быть null
    private Location location; //Поле не может быть null
    public Person(String name, int weight, String passportID, Location loc){
         this.name=name;
         this.weight=weight;
         this.passportID=passportID;
         location=loc;
    }
}



