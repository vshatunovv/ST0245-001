//Nota: Hacen falta algunas partes de las lineas de codigo, estas estan indicadas con una linea, ¡debes completarlas!
import java.util.Scanner;
public class FechaSegundoPunto {
    int dia1, mes1, anio1,dia2,mes2,anio2;
    long anioD,mesD,total,total1,total2;
    

    public long fecha1(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Fecha 1");
    System.out.println("año?");
    anio1 = scan.nextInt();
    System.out.println("mes?");
    mes1= scan.nextInt();
    System.out.println("dia?");
    dia1= scan.nextInt();
    scan.nextLine();
    anioD = anio1*365;
    if (mes1 == 1 | mes1 == 3| mes1 ==5 |mes1 == 7 | mes1 == 8 |
    mes1 == 10 | mes1 == 12 ){
    mesD = 31;
    }
    if (mes1 == 4 | mes1 == 6 | mes1 == 9 | mes1== 11){
    mesD=30;
    }
    if (mes1 ==2 ){
    mesD = 29;
    }
    total1 = anioD+mesD+dia1;
    
    return total1;
    }
    public long fecha2(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Fecha 2");
    System.out.println("año?");
    anio2 = scan.nextInt();
    System.out.println("mes?");
    mes2 = scan.nextInt();
    System.out.println("dia?");
    dia2 = scan.nextInt();
    scan.nextLine();
    anioD = anio2*365;
    if (mes2 == 1 | mes2 == 3| mes2 ==5 |mes2 == 7 | mes2 == 8 |
    mes2 == 10 | mes2 == 12 ){
    mesD = 31;
    }
    if (mes2 == 4 | mes2 == 6 | mes2 == 9 | mes2== 11){
    mesD=30;
    }
    if (mes2 ==2 ){
    mesD = 29;
    }
    total2 = anioD+mesD+dia2;
    
    return total2;
    }
    
    

    // -1 si esta fecha es anterior a la otra
    // 0 si son iguales
    // 1 si esta fecha es posterior a la otra
    public int comparar() {
        if (total1 < total2){
            return -1;
        }
        if (total1 > total2){
            return 1;
        }
        if (total1==total2){
        return 0;
        }
        return comparar();
    }

    public String toString() {
        
        String texto = "Fecha: " +dia1+ "/" +mes1+ "/" +anio1;
        if (comparar()== 1){
        texto = texto + " es posterior a la fecha: " +dia2+"/"+mes2+"/"+anio2;
    }else if (comparar()==-1){
    texto = texto + " es anterior a la fecha: " +dia2+"/"+mes2+"/"+anio2;
    
    }else{
    texto = texto + " es igual a la fecha: " +dia2+"/"+mes2+"/"+anio2;
    }
    
        return texto;
    }
}
