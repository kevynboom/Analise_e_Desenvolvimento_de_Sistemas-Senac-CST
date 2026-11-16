import java.util.Random;
import java.util.Scanner;

public class Eg11Exercicio {
    // VÁRIAVEIS GLOBAIS
    // Vetores pararelos para informações
    static int qtdLivros;
    static String nomeLivro[];
    static int[] anoPublicacao, qtdPaginas, qtdEmprestimos, qtdDevolucoes;
    // Ferramentas Java
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    /**
     * Função para determinar a quantidade de livros que serão armazenados e, com essa informação,
     * será feita a criação de todos os respectivos vetores com o tamanho correto
     */
    public static void configuracaoInicial() {
        System.out.println("----- INICIANDO CONFIGURAÇÃO INICIAL ----- ");

        System.out.println("Quantos livros serão cadastrados? ");
        System.out.println("Min. 1000 e Max. 5000");
        do { 
            qtdLivros = sc.nextInt();
            if (qtdLivros < 1000) {
                System.err.println("A quantidade mínima são 1000 livros. Digite um novo número");
            }
            if (qtdLivros > 5000) {
                System.err.println("A quantidade máxima são 5000 livros, Digite um novo número");
            }
        } while (qtdLivros < 1000 || qtdLivros > 5000);

        // Criando os vetores com a quantidade determinada
        nomeLivro = new String[qtdLivros];
        anoPublicacao = new int[qtdLivros];
        qtdPaginas = new int[qtdLivros];
        qtdEmprestimos = new int[qtdLivros];
        qtdDevolucoes = new int[qtdLivros];
        System.out.println("CONFIGURAÇÃO INICIAL CONCLUÍDA! ");
    }

    /**
     * Função para preencher todos os vetores com informações aleatórias enquanto respeita a validação dos dados
     */
    public static void cadastroLivros() {
        System.out.println("----- REALIZANDO CADASTRO DOS LIVROS ----- ");
        for (int i = 0; i < anoPublicacao.length; i++) {
            nomeLivro[i] = "Livro " + (i + 1); 
            anoPublicacao[i] = rand.nextInt(1950, 2026);
            qtdPaginas[i] = rand.nextInt(50, 1501); 
            qtdEmprestimos[i] = rand.nextInt(1001); // Usaremos um máximo de 100 empréstimos já que não foi pedido um limite específico
            qtdDevolucoes[i] = rand.nextInt(qtdEmprestimos[i] + 1); // +1 para incluir o limite final 
            System.out.printf("Livro %d cadastrado com sucesso!\n", i + 1);
        }
        System.out.println("----- CADASTRO DOS LIVROS CONCLUÍDO! ----- ");
    }

    /**
     * Função para listar todos os livros e suas respectivas informações em forma de grade
     */
    public static void listarLivros() {
        System.out.println("\n----- INICIANDO LISTAGEM DE TODOS OS LIVROS -----");
        System.out.printf("%-25s %-10s %-12s %-15s %-15s%n", "Nome do Livro", "Ano", "Páginas", "Empréstimos", "Devoluções");
        System.out.println("--------------------------------------------------------------------------------");
        for (int i = 0; i < qtdLivros; i++) {
            System.out.printf("%-25s %-10d %-12d %-15d %-15d%n", nomeLivro[i], anoPublicacao[i], qtdPaginas[i], qtdEmprestimos[i], qtdDevolucoes[i]);
        }
        System.out.println("\n----- LISTAGEM DE TODOS OS LIVROS CONCLUÍDA -----");
        System.out.println("Aperte Enter para continuar...");
        sc.nextLine();
        sc.nextLine();
    }

    /**
     * Função para verificar e informar qual livro é o mais emprestado dentre todos
     */
    public static void livroMaisEmprestado() {
        System.out.println("\n----- INICIANDO VERIFICAÇÃO DO MAIOR EMPRÉSTIMO -----");
        String livroMaisEmprestado = nomeLivro[0];
        int qtdE = qtdEmprestimos[0];
        for (int i = 0; i < qtdLivros; i++) {
            if (i == 0) {
                continue;
            }
            if (qtdEmprestimos[i] > qtdE) {
                livroMaisEmprestado = nomeLivro[i];
                qtdE = qtdEmprestimos[i];
                
            }
        }
        System.out.printf("\nO livro mais emprestado é o %s com %d empréstimos.\n ", livroMaisEmprestado, qtdE);
        System.out.println("\n----- VERIFICAÇÃO DO MAIOR EMPRÉSTIMO CONCLUÍDA -----");
        System.out.println("Aperte Enter para continuar...");
        sc.nextLine();
        sc.nextLine();
    }

    /**
     * Função para verificar e informar qual livro é o menos emprestado dentre todos
     */
    public static void livroMenosEmprestado() {
        System.out.println("\n----- INICIANDO VERIFICAÇÃO DO MENOR EMPRÉSTIMO -----");
        String livroMenosEmprestado = nomeLivro[0];
        int qtdE = qtdEmprestimos[0];
        for (int i = 0; i < qtdLivros; i++) {
            if (i == 0) {
                continue;
            }
            if (qtdEmprestimos[i] < qtdE) {
                livroMenosEmprestado = nomeLivro[i];
                qtdE = qtdEmprestimos[i];
            }
        }
        System.out.printf("\nO livro menos emprestado é o %s com %d empréstimos.\n ", livroMenosEmprestado, qtdE);
        System.out.println("\n----- VERIFICAÇÃO DO MENOR EMPRÉSTIMO CONCLUÍDA -----");
        System.out.println("Aperte Enter para continuar...");
        sc.nextLine();
        sc.nextLine();
    }

    /**
     * Função para verificar e informar qual a média do número de empréstimos
     */
    public static void mediaEmprestimos() {
        System.out.println("\n----- INICIANDO VERIFICAÇÃO DA MÉDIA -----");
        double media = 0;
        for (int i = 0; i < qtdLivros; i++) {
            media += qtdEmprestimos[i];
        }
        media /= qtdLivros;
        System.out.printf("\nA média de empréstimos dos livros é de %.2f empréstimos.\n ", media);
        System.out.println("\n----- VERIFICAÇÃO DA MÉDIA CONCLUÍDA-----");
        System.out.println("Aperte Enter para continuar...");
        sc.nextLine();
        sc.nextLine();
    }

    /**
     * Função para verificar e informar quais livros estão acima da média (visto função anterior)
     */
    public static void livrosAcimaDaMediaEmprestimos() {
        System.out.println("\n----- INICIANDO VERIFICAÇÃO DOS LIVROS ACIMA DA MÉDIA -----");
        // Não reutilizei a função anterior por causa do scanners nela contidas
        double media = 0;
        for (int i = 0; i < qtdLivros; i++) {
            media += qtdEmprestimos[i];
        }
        media /= qtdLivros;
        System.out.printf("A média dos empréstimos é de %.2f e será usada como base para determinar quais livros serão mostrados...\n", media);
        System.out.println("Pressione Enter para iniciar a listagem");
        sc.nextLine();
        sc.nextLine();
        System.out.printf("%-25s %-10s %-12s %-15s %-15s%n", "Nome do Livro", "Ano", "Páginas", "Empréstimos", "Devoluções");
        for (int i = 0; i < qtdLivros; i++) {
            if (qtdEmprestimos[i] > media) {
                System.out.printf("%-25s %-10d %-12d %-15d %-15d%n", nomeLivro[i], anoPublicacao[i], qtdPaginas[i], qtdEmprestimos[i], qtdDevolucoes[i]);
            }
        }
        System.out.println("\n----- VERIFICAÇÃO DOS LIVROS ACIMA DA MÉDIA CONCLUÍDA-----");
        System.out.println("Aperte Enter para continuar...");
        sc.nextLine();
    }

    /**
     * Função para exibir as seguintes informações:
	* - Ano de publicação mais antigo
	* - Ano de publicação mais recente
	* - Média de anos de publicação
	* - Total de empréstimos realizados
	* - Total de devoluções realizadas
	* - Percentual de livros com mais de 100 empréstimos
     */
    public static void estatisticas() {
        int maiorP = 0, menorP = 5000, totalE = 0, totalD = 0, qtdLivrosLocal = 0;
        double mediaAnos = 0, porcentagem;
        for (int i = 0; i < qtdLivros; i++) {
            if (anoPublicacao[i] > maiorP) {
                maiorP = anoPublicacao[i];
            } else if (anoPublicacao[i] < menorP) {
                menorP = anoPublicacao[i];
            }
            if (qtdEmprestimos[i] > 100) {
                qtdLivrosLocal++;
            }
            mediaAnos += anoPublicacao[i];
            totalE += qtdEmprestimos[i];
            totalD += qtdDevolucoes[i];
        }
        porcentagem = ((double) qtdLivrosLocal / qtdLivros) * 100; // "(double)" para forçar o Java a fazer uma divisão com decimais com aquele váriavel
        mediaAnos /= qtdLivros;

        System.out.printf("Publicação mais antiga:  %d\n", menorP);
        System.out.printf("Publicação mais recente: %d\n", maiorP);
        System.out.printf("Média dos anos:          %.2f\n", mediaAnos);
        System.out.printf("Total de empréstimos:   %d\n", totalE);
        System.out.printf("Total de devoluções:    %d\n", totalD);
        System.out.printf("Livros com mais de 100 empréstimos: %d (%.2f%%)\n", qtdLivrosLocal, porcentagem);
    }

    /**
     * Função para buscar um livro pelo seu título e verificar se o mesmo existe
     */
    public static void buscarLivroTitulo() {
        
    }

    public static void main(String[] args) {
        System.out.println("========== SISTEMA BIBLIOTECA ==========");
        configuracaoInicial();
        cadastroLivros();
        int opcao;
        do { 
            System.out.println("\n---------- MENU ----------");
            System.out.println("O que deseja verificar agora?");
            System.out.println(" 1- Listar todos os livros do acervo");
            System.out.println(" 2- Livro mais emprestado");
            System.out.println(" 3- Livro menos emprestado");
            System.out.println(" 4- Média de empréstimos");
            System.out.println(" 5- Livros acima da média de empréstimos");
            System.out.println(" 6- Estatísticas");
            System.out.println(" 7- Buscar livro pelo título");
            System.out.println(" 0 - Encerrar");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1 -> listarLivros();
                case 2 -> livroMaisEmprestado();
                case 3 -> livroMenosEmprestado();
                case 4 -> mediaEmprestimos();
                case 5 -> livrosAcimaDaMediaEmprestimos();
                case 6 -> estatisticas();
                case 7 -> buscarLivroTitulo();
                case 0 -> System.out.println("Encerrando o programa...");
                default -> System.out.print("Opção inválida!");
            }
        } while (opcao != 0);
    }
}