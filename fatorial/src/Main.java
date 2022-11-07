import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número para fazer a conta: ");
        int num = scanner.nextInt();
        int fatorial = 1;

        for (int i = 1;i <= num ; i ++ ) {
            fatorial *= i;

            System.out.println("Fatorial de " +i+"=" +fatorial);
        }
    }
}
