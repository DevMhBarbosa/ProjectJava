import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Tarefa {
    private String titulo;
    private boolean concluida;

    public Tarefa(String titulo) {
        this.titulo = titulo;
        this.concluida = false; // Por padrão, a tarefa começa não concluída
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void concluir() {
        this.concluida = true;
        System.out.println("Tarefa \"" + titulo + "\" marcada como concluída.");
    }

    public void remover() {
        System.out.println("Tarefa \"" + titulo + "\" removida.");
    }

    @Override
    public String toString() {
        return (concluida ? "[Concluída] " : "[Pendente] ") + titulo;
    }
}

class GerenciadorTarefas {
    private List<Tarefa> tarefas;

    public GerenciadorTarefas() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String titulo) {
        tarefas.add(new Tarefa(titulo));
        System.out.println("Tarefa \"" + titulo + "\" adicionada.");
    }

    public void removerTarefa(String titulo) {
        Tarefa tarefaARemover = null;
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {
                tarefaARemover = tarefa;
                break;
            }
        }
        if (tarefaARemover != null) {
            tarefas.remove(tarefaARemover);
            tarefaARemover.remover();
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    public void concluirTarefa(String titulo) {
        Tarefa tarefaAConcluir = null;
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {
                tarefaAConcluir = tarefa;
                break;
            }
        }
        if (tarefaAConcluir != null) {
            tarefaAConcluir.concluir();
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            System.out.println("Lista de Tarefas:");
            for (Tarefa tarefa : tarefas) {
                System.out.println(tarefa);
            }
        }
    }

    public void listarTarefasPendentes() {
        boolean encontrou = false;
        for (Tarefa tarefa : tarefas) {
            if (!tarefa.isConcluida()) {
                System.out.println(tarefa);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Não há tarefas pendentes.");
        }
    }

    public void listarTarefasConcluidas() {
        boolean encontrou = false;
        for (Tarefa tarefa : tarefas) {
            if (tarefa.isConcluida()) {
                System.out.println(tarefa);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Não há tarefas concluídas.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Remover tarefa");
            System.out.println("3. Concluir tarefa");
            System.out.println("4. Listar todas as tarefas");
            System.out.println("5. Listar tarefas pendentes");
            System.out.println("6. Listar tarefas concluídas");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o newline

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título da tarefa: ");
                    String titulo = scanner.nextLine();
                    gerenciador.adicionarTarefa(titulo);
                    break;
                case 2:
                    System.out.print("Digite o título da tarefa para remover: ");
                    titulo = scanner.nextLine();
                    gerenciador.removerTarefa(titulo);
                    break;
                case 3:
                    System.out.print("Digite o título da tarefa para concluir: ");
                    titulo = scanner.nextLine();
                    gerenciador.concluirTarefa(titulo);
                    break;
                case 4:
                    gerenciador.listarTarefas();
                    break;
                case 5:
                    gerenciador.listarTarefasPendentes();
                    break;
                case 6:
                    gerenciador.listarTarefasConcluidas();
                    break;
                case 7:
                    continuar = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }
}
