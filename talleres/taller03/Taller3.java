import java.util.ArrayList;
public class Taller3 {

    public static void torresDeHannoi(int n) {
        torresDeHannoiAux(n, 1, 2, 3);
    }

    private static void torresDeHannoiAux(int n, int origen, int intermedio, int destino) {
        if(n == 1)
        {   
            System.out.println("Disk 1 from "+ origen + " to "+ destino);
        }
        else {
            torresDeHannoiAux(n-1, origen, destino, intermedio);
            System.out.println("Disk "+ n + " from "+ origen + " to "+ destino);
            torresDeHannoiAux(n - 1, intermedio, origen, destino);
        }
    }

    

    public static void combinations(String s) { 
        combinationsAux("", s); 
    }

    /**
     *
     * El método combinationsAux es el core del proceso, en el se busca conseguir
     * las posibles permutaciones que puede tener la cadena s 
     * @param s es la cadena a permutar
     * @param prefix cadena auxiliar donde se guarda la cadena de salida
     *
     * Las cadenas de salida tienes una longitud desde 0 hasta el lenght de la cadena s
     * por simplicidad del ejercicio no se repiten letras y el orden de la secuencia 
     * no supone importancia, es decir, la cadena AB es igual a la cadena BA.
     * Ej: para la cadena ABC se tiene la salida: { A, AB, ABC, AC, B, BC, C}
     *
     */
    private static void combinationsAux(String prefix, String s) {  
        if (s.length() > 0) { 
            System.out.println(prefix + s.charAt(0));   
            combinationsAux(prefix + s.charAt(0), s.substring(1)); 
            combinationsAux( prefix , s.substring(1));
            
        }
    }
       public static void permutation(String str) {
    permutationAux("", str , str.length() ); 
    }
    
    /**
     *
     * El método permutationAux es el core del proceso, en el se busca conseguir
     * las posibles permutaciones que puede tener la cadena str 
     * @param str es la cadena a permutar
     * @param prefix cadena auxiliar donde se guarda la cadena de salida
     *
     * Las cadenas de salida tienes una longitud de lenght de la cadena s
     * Ej: para la cadena AB se tiene la salida: { ABC,ACB,BAC,BCA,CAB,CBA }
     * donde los caracteres no se repiten pero el orden tiene un papel importante.
     *
     */
    private static void permutationAux(String respuesta, String pregunta, int i)
    {
        
        ArrayList<String> preguntas;
        preguntas.add(pregunta);
        if (i == 0){
                    System.out.println(respuesta);
                    System.out.println(AdvancedEncryptionStandard.desencriptarArchivo(respuesta));
                }
                else

                    for ( i = 0; i < pregunta.length(); i++)
                        permutationAux(respuesta+pregunta[i],//""+pregunta[i],
                                       pregunta, i-1);
    }
}