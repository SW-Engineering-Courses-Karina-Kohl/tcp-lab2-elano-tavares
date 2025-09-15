import java.util.Scanner;

public class Calculadora {

    public int somar(int a, int b){
        return a + b;
    }

    public int dividir(int numerador, int denominador){
        return numerador / denominador;
    }
    
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        
        System.out.print("Primeiro valor: ");
        int one = ler.nextInt();

        System.out.print("Segundo valor: ");
        int two = ler.nextInt();

        Calculadora calc = new Calculadora();
        int opSoma = calc.somar(one, two);
        int opDividir = calc.dividir(one, two);

        System.out.println("\n--- Resultados ---");
        System.out.println("Soma: " + opSoma);
        System.out.println("Divisão: " + opDividir);

        ler.close();

    }
}
