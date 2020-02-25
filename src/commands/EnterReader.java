package commands;

import java.util.Scanner;

public class EnterReader {
    public EnterReader(){
    }
    public Long readLong(Long max,Long min,String name){
        System.out.print("Введите значение типа Long "+name);
        if(max!=null){ System.out.print("  Максимальное значение=" +max); }
        if (min!=null) {System.out.println("  Минимальное значение= "+ min);}
        Scanner scan=new Scanner(System.in);
        String enteredValue=scan.nextLine().trim();
        try{
        if (!enteredValue.isEmpty()){
            long result=Long.parseLong(enteredValue);
            if (result>max){
                System.out.println("Введенное значение больше допустимого максимума ");
                readLong(max,min,name);
            }
            else if (result<min){
                System.out.println("Введенное значение меньше допустимого минимума");
                readLong(max,min,name);
            }
            else return result;
            return null;
        }
        else {readLong(max,min,name);
        return null;}}
        catch (NumberFormatException e){
            System.out.println("Неверный тип введенных данных");
            readLong(max,min,name);
            return null;
        }
    }
    public Float readFloat(Float max,Float min,String name){
        System.out.print("Введите значение типа Float "+name);
        if(max!=null){ System.out.print("  Максимальное значение=" +max); }
        if (min!=null) {System.out.println("  Минимальное значение= "+ min);}
        Scanner scan=new Scanner(System.in);
        String enteredValue=scan.nextLine().trim();
        try{
            if (!enteredValue.isEmpty()){
                float result=Long.parseLong(enteredValue);
                if (result>max){
                    System.out.println("Введенное значение больше допустимого максимума ");
                    readFloat(max,min,name);
                }
                else if (result<min){
                    System.out.println("Введенное значение меньше допустимого минимума");
                    readFloat(max,min,name);
                }else{
                scan.close();
                return result;}
                return null;
            }
            else {readFloat(max,min,name);
                return null;}}
        catch (NumberFormatException e){
            System.out.println("Неверный тип введенных данных");
            readFloat(max,min,name);
            return null;
        }
    }
}
