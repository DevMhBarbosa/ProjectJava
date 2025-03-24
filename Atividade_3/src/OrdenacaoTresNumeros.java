import java.util.Scanner;

public class OrdenacaoTresNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declaração dos três números inteiros
        int num1 = 0, num2 = 0, num3 = 0;
        boolean entradaValida = false;

        // Tratamento das entradas para os três números
        while (!entradaValida) {
            try {
                System.out.print("Digite o primeiro número inteiro: ");
                num1 = Integer.parseInt(scanner.nextLine());

                System.out.print("Digite o segundo número inteiro: ");
                num2 = Integer.parseInt(scanner.nextLine());

                System.out.print("Digite o terceiro número inteiro: ");
                num3 = Integer.parseInt(scanner.nextLine());

                // Se chegamos até aqui, significa que todos os números são válidos
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Erro: por favor, digite um número inteiro válido.");
            }
        }

        // Exibe os números na ordem fornecida
        System.out.println("\nNúmeros fornecidos na ordem:");
        System.out.println("Primeiro número: " + num1);
        System.out.println("Segundo número: " + num2);
        System.out.println("Terceiro número: " + num3);

        // Ordenando os números em ordem crescente
        int[] numeros = {num1, num2, num3};
        // Utilizando o método sort da classe Arrays para ordenar os números
        java.util.Arrays.sort(numeros);

        // Exibe os números em ordem crescente
        System.out.println("\nNúmeros em ordem crescente:");
        System.out.println(numeros[0] + " " + numeros[1] + " " + numeros[2]);

        scanner.close();
    }
}
