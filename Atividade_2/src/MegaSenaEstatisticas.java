import java.util.Scanner;

public class MegaSenaEstatisticas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Vetor para armazenar a quantidade de vezes que cada número foi sorteado
        int[] contagem = new int[60]; // De 1 a 60, então temos 60 posições

        // Solicitar a quantidade de sorteios
        System.out.print("Quantos sorteios você deseja verificar? ");
        int numeroDeSorteios = 0;
        boolean entradaValida = false;

        // Verificando se a entrada é válida
        while (!entradaValida) {
            try {
                String entrada = scanner.nextLine();
                numeroDeSorteios = Integer.parseInt(entrada);

                if (numeroDeSorteios <= 0) {
                    System.out.println("Por favor, insira um número positivo maior que zero.");
                } else {
                    entradaValida = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
            }
        }

        // Processar os sorteios
        for (int sorteio = 1; sorteio <= numeroDeSorteios; sorteio++) {
            System.out.println("\nInforme os números sorteados no sorteio " + sorteio + ":");
            int[] numerosSorteados = new int[6];
            for (int i = 0; i < 6; i++) {
                boolean numeroValido = false;
                while (!numeroValido) {
                    try {
                        String entrada = scanner.nextLine();
                        int numero = Integer.parseInt(entrada);

                        // Verificar se o número está no intervalo válido (1 a 60)
                        if (numero >= 1 && numero <= 60) {
                            // Verificar se o número não foi repetido
                            boolean repetido = false;
                            for (int j = 0; j < i; j++) {
                                if (numerosSorteados[j] == numero) {
                                    repetido = true;
                                    break;
                                }
                            }
                            if (repetido) {
                                System.out.println("Número repetido. Digite outro número.");
                            } else {
                                numerosSorteados[i] = numero;
                                contagem[numero - 1]++; // Incrementa a contagem do número sorteado
                                numeroValido = true;
                            }
                        } else {
                            System.out.println("Número fora do intervalo (1-60). Tente novamente.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                    }
                }
            }
        }

        // Exibir a quantidade de vezes que cada número foi sorteado
        System.out.println("\nQuantidade de vezes que cada número foi sorteado:");
        for (int i = 0; i < 60; i++) {
            System.out.println("Número " + (i + 1) + ": " + contagem[i] + " vez(es)");
        }

        // Encontrar os números com menor e maior quantidade de sorteios
        int menorQuantidade = Integer.MAX_VALUE;
        int maiorQuantidade = Integer.MIN_VALUE;
        int numeroMenor = -1;
        int numeroMaior = -1;

        for (int i = 0; i < 60; i++) {
            if (contagem[i] < menorQuantidade) {
                menorQuantidade = contagem[i];
                numeroMenor = i + 1;
            }
            if (contagem[i] > maiorQuantidade) {
                maiorQuantidade = contagem[i];
                numeroMaior = i + 1;
            }
        }

        System.out.println("\nNúmero menos sorteado: " + numeroMenor + " (sorteado " + menorQuantidade + " vez(es))");
        System.out.println("Número mais sorteado: " + numeroMaior + " (sorteado " + maiorQuantidade + " vez(es))");

        scanner.close();
    }
}
