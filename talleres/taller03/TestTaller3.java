 

import java.util.ArrayList;

public class TestTaller3 {
    
    public static void ejercicio1(){
        System.out.println("Para 2 discos la secuencia debe quedar asi");
        System.out.println("Disco 1 de 1 a 2   \nDisco 2 de 1 a 3  \nDisco 1 de 2 a 3");
        Taller3.torresDeHannoi(2);


        System.out.println("Para 3 discos la secuencia debe quedar as�");
        System.out.println("Disco 1 de 1 a 3  \nDisco 2 de 1 a 2  \nDisco 1 de 3 a 2  \nDisco 3 de 1 a 3  \nDisco 1 de 2 a 1  \nDisco 2 de 2 a 3  \nDisco 1 de 1 a 3  \n");
        Taller3.torresDeHannoi(3);


        System.out.println("Para 4 discos la secuencia debe quedar as�");
        System.out.println("Disco 1 de 1 a 2  \nDisco 2 de 1 a 3  \nDisco 1 de 2 a 3  \nDisco 3 de 1 a 2  \nDisco 1 de 3 a 1  \nDisco 2 de 3 a 2  \nDisco 1 de 1 a 2  \nDisco 4 de 1 a 3  \nDisco 1 de 2 a 3  \nDisco 2 de 2 a 1  \nDisco 1 de 3 a 1  \nDisco 3 de 2 a 3  \nDisco 1 de 1 a 2  \nDisco 2 de 1 a 3  \nDisco 1 de 2 a 3  \n");
        Taller3.torresDeHannoi(4);
        
        
    }
    public static void ejercicio2(){
       Taller3 t = new Taller3();
       
        //Ejercicio2
        System.out.println("");
        System.out.println("Ejercicio 2");
        t.combinations("abcd");
        AdvancedEncryptionStandard a = new AdvancedEncryptionStandard();
        a.desencriptarArchivo("");
        

       }
     

    
    
}