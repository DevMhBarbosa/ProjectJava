import java.util.Scanner;

public class SalarioFuncionario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variáveis para armazenar as informações
        String nomeFuncionario = "";
        int numDependentes = 0;
        double salarioBruto = 0.0;

        // Leitura do nome do funcionário
        System.out.print("Digite o nome do funcionário: ");
        nomeFuncionario = scanner.nextLine();

        // Leitura e validação do número de dependentes
        while (true) {
            try {
                System.out.print("Digite o número de dependentes: ");
                numDependentes = Integer.parseInt(scanner.nextLine());
                if (numDependentes < 0) {
                    throw new NumberFormatException("Número de dependentes não pode ser negativo.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro válido para o número de dependentes.");
            }
        }

        // Leitura e validação do salário bruto
        while (true) {
            try {
                System.out.print("Digite o valor do salário bruto: ");
                salarioBruto = Double.parseDouble(scanner.nextLine());
                if (salarioBruto < 0) {
                    throw new NumberFormatException("O salário bruto não pode ser negativo.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido para o salário bruto.");
            }
        }

        // Cálculo do acréscimo e salário total
        double acrescimo = numDependentes * 65.00;
        double salarioTotal = salarioBruto + acrescimo;

        // Exibição dos resultados com a função System.out.printf
        System.out.printf("O funcionário %s, responsável por %d dependentes com salário mensal de %.2f, "
                        + "receberá um acréscimo de %.2f, totalizando um salário bruto de %.2f.%n",
                nomeFuncionario, numDependentes, salarioBruto, acrescimo, salarioTotal);

        scanner.close();
    }
}