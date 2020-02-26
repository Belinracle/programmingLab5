package factories;

import MovieClasses.Location;
import MovieClasses.Person;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MoviePersonFactory {
    private Scanner scan;
    public MoviePersonFactory(){
        scan=new Scanner(System.in);
    }

    public Person createMoviePerson(){
        Person pers = new Person();
        persNameFact(pers);
        persWeightFact(pers);
        persPassIDFact(pers);
        pers.setLocation(setPersLocation());
        return pers;
    }
    private void persNameFact(Person pers){
        System.out.println("Введите имя сценариста");
        String entered = scan.nextLine().trim();
        if (!entered.isEmpty()) {
            pers.setPersonName(entered);
        } else persNameFact(pers);
    }
    private void persPassIDFact(Person pers){
        System.out.println("Введите Паспортный идентификатор сценариста");
        String entered = scan.nextLine().trim();
        if (!entered.isEmpty()) {
            pers.setPassportID(entered);
        } else persNameFact(pers);
    }
    private void persWeightFact(Person pers) {
        System.out.println("Введите вес сценариста фильма(должно быть больше 0)");
        try {
            String entered=scan.nextLine().trim();
            while (entered.isEmpty()){
                persWeightFact(pers);
            }
            int result =Integer.parseInt(entered);
            if(result<0){
                System.out.println("Введенное вами значение должно быть больше 0");
                persWeightFact(pers);
            }
            else {pers.setWeight(result);}
        }catch (NumberFormatException e){
            System.out.println("Введеное значение не того формата");
            persWeightFact(pers);
        }
    }


    private Location setPersLocation(){
        System.out.println("Заполните поля локации проживания сценариста фильма ");
        Location loc = new Location();
        setLocationName(loc);
        setLocationX(loc);
        setLocationY(loc);
        setLocFloat(loc);
        return loc;
    }
    private void setLocationX(Location loc){
        System.out.println("Введите координату Х(long)");
        try {
            String entered=scan.nextLine().trim();
            while (entered.isEmpty()){
                setLocationX(loc);
            }
            long result =Long.parseLong(entered);
            loc.setX(result);
        }catch (NumberFormatException e ){
            System.out.println("Введеное значение не того формата");
            setLocationX(loc);
        }
    }
    private void setLocationY(Location loc) {
        System.out.println("Введите координату Y(int)");
        try {
            String entered = scan.nextLine().trim();
            while (entered.isEmpty()) {
                setLocationY(loc);
            }
            int result = Integer.parseInt(entered);
            loc.setY(result);
        } catch (NumberFormatException e) {
            System.out.println("Введеное значение не того формата");
            setLocationY(loc);
        }
    }

    private void setLocationName(Location loc){
            System.out.println("Введите название локации(может быть null)");
            String entered = scan.nextLine().trim();
            loc.setName(entered);
    }
    private void setLocFloat(Location loc){
        System.out.println("Введите координату Z(float)");
        try {
            String entered = scan.nextLine().trim();
            while (entered.isEmpty()) {
                setLocFloat(loc);
            }
            float result = Float.parseFloat(entered);
            loc.setZ(result);
        } catch (NumberFormatException e) {
            System.out.println("Введеное значение не того формата");
            setLocFloat(loc);
        }
    }
}
