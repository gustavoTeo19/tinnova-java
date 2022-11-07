import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calc calc = new Calc();
        System.out.println("Digite um número para ser alcançado: ");
        int num = scanner.nextInt();
        int resultado = calc.calcular(num);

        System.out.println("O resultado é " + resultado);

    }
}
