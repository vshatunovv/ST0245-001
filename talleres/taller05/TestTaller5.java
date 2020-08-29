/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 


/**
 *
 * @author 
 */
public class TestTaller5 {
    
    public static boolean ejercicio1(){
        int a,b,c,d;
        a = Taller5.suma(new int[] {1,2,3,4,5,5});
        b = Taller5.suma(new int[] {12,324,43,2,3,43,2,3,43});
        c = Taller5.suma(new int[] {3,2,343,2,43,55,67,68,86,3,4});
        d = Taller5.suma(new int[] {56,7,6,45,8,4,34,8,7,5,34,7,78,9});
        if(a!=20 || b!=475 || c!=676 || d!=308)
            return false;
        return true;
    }
    
    public static void ejercicio2(){
        Taller5.mul(2);
        Taller5.mul(5);
        Taller5.mul(7);
        Taller5.mul(8);
    }
    
    public static void main(String[] args){
        //Ejercicio1
        if(ejercicio1())
            System.out.println("Ejercicio 1 Correcto");
        else
        System.out.println("Ejercicio 1 Incorrecto");
        
        //Ejercicio2
        System.out.println("");
        System.out.println("Ejercicio 2");
        ejercicio2();
    }
    
}