import java.util.Scanner;

public class TextoInvertido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário para digitar um texto longo
        System.out.print("Digite um texto longo: ");
        String texto = scanner.nextLine();

        // Inverte o texto usando String.charAt()
        System.out.println("\nTexto invertido:");
        for (int i = texto.length() - 1; i >= 0; i--) {
            System.out.print(texto.charAt(i));  // Exibe o caractere na posição i
        }

        scanner.close();
    }
}
