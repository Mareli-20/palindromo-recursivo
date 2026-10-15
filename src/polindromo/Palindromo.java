/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author erika
 */
public class Palindromo {

    public static boolean esPalindromo(String cadena) {
        /*
        si la cadena es nula devuelve falso, ya que no hay una cadena de texto para 
        saber si es palindromo o no 
        */
        if (cadena == null) { 
            return false;
        }
        String texto = cadena.toLowerCase().replace(" ", "");  //Normalizacion: guarda en una nueva variable la cadena sin espacios y en minusculas
        /*
        si la cadena queda vacía después de normalizar devuelve false,
        porque no hay caracteres por comparar (por ejemplo, si solo traía espacios).
        Se revisa antes de llamar al recursivo porque, de lo contrario, 
        `metodoRecursivo` recibiría índices inválidos (der = -1) y devolvería true.
        */
        if (texto.equals("")) {
            return false;
        }
        /*
        Se manda al método recursivo la cadena ya normalizada (`texto`), 
        junto con 0 (posición inicial de izq) y texto.length()-1 (posición final de der).
        Nota: `der` se calcula con `texto` y no con `cadena` porque es la versión 
        procesada que realmente se compara (sin espacios y en minúsculas).
        */
        return metodoRecursivo(texto, 0, texto.length() - 1); 
    }

    private static boolean metodoRecursivo(String texto, int izq, int der) {
        /*
        Caso base: cuando izq >= der es palíndromo, 
        ya que significa que los índices se encontraron en el centro 
        o se cruzaron sin encontrar diferencias.
        */
        if (izq >= der) {
            return true;
        }
        if (texto.charAt(izq) != texto.charAt(der)) { //si los caracteres son diferentes retorna falso 
            return false;
        }
        return metodoRecursivo(texto, izq + 1, der - 1); //el metodo se llama a si mismo haciendo que izq y der se acerquen al centro
    }

    public static void main(String[] args) {
        System.out.println("radar: " + esPalindromo("radar")); // esperado: true
        System.out.println("reconocer: " + esPalindromo("reconocer")); // esperado: true
        System.out.println("caminar: " + esPalindromo("caminar")); // esperado: false
        System.out.println("  : " + esPalindromo("  ")); // esperado: false
        System.out.println("b: " + esPalindromo("b")); // esperado: true
        System.out.println("Anita Lava La Tina: " + esPalindromo("Anita Lava La Tina")); // esperado: true
        System.out.println("oso: " + esPalindromo("oso")); // esperado: true
        System.out.println("anna: " + esPalindromo("anna"));// esperado: true
        System.out.println("miriam: " + esPalindromo("miriam")); // esperado: false
        System.out.println("Vacía: " + esPalindromo(""));  // esperado: false
        String nula = null; 
        System.out.println("Null: " + esPalindromo(nula));  // esperado: false

    }
}
