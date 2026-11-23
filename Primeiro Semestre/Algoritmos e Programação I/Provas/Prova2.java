import java.util.Random;
import java.util.Scanner;

public class Prova2 {
    // VÁRIAVEIS GLOBAIS
    // Vetores pararelos para informações
    static int qtdJogadores;
    static String nomeJogador[];
    static int[] idadeJogador, qtdPontos, qtdPartidas, qtdVitorias, qtdDerrotas;
    // Ferramentas Java
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    /**
     * Função para determinar a quantidade de jogadores que serão armazenados e, com essa informação,
     * será feita a criação de todos os respectivos vetores com o tamanho correto
     */
    public static void configuracaoInicial() {
        System.out.println("----- INICIANDO CONFIGURAÇÃO INICIAL ----- ");

        System.out.println("Quantos jogadores serão cadastrados? ");
        System.out.println("Min. 1000 e Max. 5000");
        do { 
            qtdJogadores = sc.nextInt();
            if (qtdJogadores < 1000) {
                System.err.println("A quantidade mínima são 1000 jogadores. Digite um novo número");
            }
            if (qtdJogadores > 5000) {
                System.err.println("A quantidade máxima são 5000 jogadores, Digite um novo número");
            }
        } while (qtdJogadores < 1000 || qtdJogadores > 5000);

        nomeJogador = new String[qtdJogadores];
        idadeJogador = new int[qtdJogadores];
        qtdPontos = new int[qtdJogadores];
        qtdPartidas = new int[qtdJogadores];
        qtdVitorias = new int[qtdJogadores];
        qtdDerrotas = new int[qtdJogadores];

        System.out.println("----- CONFIGURAÇÃO INICIAL CONCLUÍDA! ----- ");
    }

    /**
     * Função para preencher todos os vetores com informações aleatórias enquanto respeita a validação dos dados
     */
    public static void cadastroJogadores() {
        System.out.println("----- REALIZANDO CADASTRO DOS JOGADORES ----- ");

        for (int i = 0; i < qtdJogadores; i++) {
            nomeJogador[i] = "Jogador " + (i + 1); 
            idadeJogador[i] = rand.nextInt(12, 71);
            qtdPontos[i] = rand.nextInt(0, 10001); 
            qtdPartidas[i] = rand.nextInt(501); // Usaremos um máximo de 500 partidas já que não foi pedido um limite específico
            qtdVitorias[i] = rand.nextInt(qtdPartidas[i] + 1); 
            qtdDerrotas[i] = qtdPartidas[i] - qtdVitorias[i];
            System.out.printf("Jogador %d cadastrado com sucesso!\n", i + 1);
        }
        System.out.println("----- CADASTRO DOS JOGADORES CONCLUÍDO! ----- ");
    }

    /**
     * Função para listar todos os jogadores e suas respectivas informações em forma de grade
     */
    public static void listarJogadores() {
        System.out.println("\n----- INICIANDO LISTAGEM DE TODOS OS JOGADORES -----");

        System.out.printf("%-25s %-10s %-12s %-15s %-15s %-15s\n", "Nome do Jogador", "Idade", "Pontuação", "Partidas", "Vitórias", "Derrotas");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (int i = 0; i < qtdJogadores; i++) {
            System.out.printf("%-25s %-10d %-12d %-15d %-15d %-15d\n", nomeJogador[i], idadeJogador[i], qtdPontos[i], qtdPartidas[i], qtdVitorias[i], qtdDerrotas[i]);
        }
        
        System.out.println("\n----- LISTAGEM DE TODOS OS JOGADORES CONCLUÍDA -----");
        System.out.println("Aperte Enter para voltar para o menu principal...");
        sc.nextLine();
        sc.nextLine();
    }

    /**
     * Função para verificar e informar qual jogador tem a maior pontuação dentre todos
     */
    public static void melhorJogador() {
        System.out.println("\n----- INICIANDO VERIFICAÇÃO DO MELHOR JOGADOR -----");
        String melhorJogador = nomeJogador[0];
        int melhorPontuacao = qtdPontos[0];
        for (int i = 0; i < qtdJogadores; i++) {
            if (i == 0) {
                continue;
            }
            if (qtdPontos[i] > melhorPontuacao) {
                melhorJogador = nomeJogador[i];
                melhorPontuacao = qtdPontos[i];
            }
        }
        System.out.printf("\nO melhor jogador é o %s com %d pontos.\n ", melhorJogador, melhorPontuacao);

        System.out.println("\n----- VERIFICAÇÃO DO MELHOR JOGADOR CONCLUÍDA -----");
        System.out.println("Aperte Enter para voltar para o menu principal...");
        sc.nextLine();
        sc.nextLine();
    }

    /**
     * Função para verificar e informar qual jogador tem a menor pontuação dentre todos
     */
    public static void piorJogador() {
        System.out.println("\n----- INICIANDO VERIFICAÇÃO DO PIOR JOGADOR -----");
        String piorJogador = nomeJogador[0];
        int piorPontuacao = qtdPontos[0];
        for (int i = 0; i < qtdJogadores; i++) {
            if (i == 0) {
                continue;
            }
            if (qtdPontos[i] < piorPontuacao) {
                piorJogador = nomeJogador[i];
                piorPontuacao = qtdPontos[i];
            }
        }
        System.out.printf("\nO pior jogador é o %s com %d pontos.\n ", piorJogador, piorPontuacao);

        System.out.println("\n----- VERIFICAÇÃO DO PIOR JOGADOR CONCLUÍDA -----");
        System.out.println("Aperte Enter para voltar para o menu principal...");
        sc.nextLine();
        sc.nextLine();
    }

    /**
     * Função para verificar e informar qual a média das pontuações
     */
    public static void mediaPontuacao() {
        System.out.println("\n----- INICIANDO VERIFICAÇÃO DA MÉDIA DE PONTUAÇÕES -----");

        double media = 0;
        for (int i = 0; i < qtdJogadores; i++) {
            media += qtdPontos[i];
        }
        media /= qtdJogadores;
        System.out.printf("\nA média da pontuação dos jogadores é de %.2f pontos.\n ", media);

        System.out.println("\n----- VERIFICAÇÃO DA MÉDIA DE PONTUAÇÕES CONCLUÍDA-----");
        System.out.println("Aperte Enter para voltar para o menu principal...");
        sc.nextLine();
        sc.nextLine();
    }

    /**
     * Função para verificar e informar quais jogadores estão acima da média
     */
    public static void jogadoresAcimaDaMediaPontuacao() {
        System.out.println("\n----- INICIANDO VERIFICAÇÃO DOS JOGADORES ACIMA DA MÉDIA -----");

        // Não reutilizei a função anterior por causa do scanners nela contidas
        double media = 0;
        for (int i = 0; i < qtdJogadores; i++) {
            media += qtdPontos[i];
        }
        media /= qtdJogadores;
        System.out.printf("\nA média dos jogadores é de %.2f e será usada como base para determinar quais jogadores serão mostrados...\n", media);
        System.out.println("Pressione Enter para iniciar a listagem");
        sc.nextLine();
        sc.nextLine();
        System.out.printf("%-25s %-10s %-12s %-15s %-15s %-15s\n", "Nome do Jogador", "Idade", "Pontuação", "Partidas", "Vitórias", "Derrotas");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (int i = 0; i < qtdJogadores; i++) {
            if (qtdPontos[i] > media) {
                System.out.printf("%-25s %-10d %-12d %-15d %-15d %-15d\n", nomeJogador[i], idadeJogador[i], qtdPontos[i], qtdPartidas[i], qtdVitorias[i], qtdDerrotas[i]);
            }
        }

        System.out.println("\n----- VERIFICAÇÃO DOS JOGADORES ACIMA DA MÉDIA CONCLUÍDA -----");
        System.out.println("Aperte Enter para voltar para o menu principal...");
        sc.nextLine();
    }

    /**
     * Função para exibir as seguintes informações:
	* - Jogador mais velho
	* - Jogador mais novo
	* - Média de idade dos jogadores
	* - Total de vitórias
	* - Total de derrotas  
	* - Percentual de jogadores com mais de 7000 pontos
     */
    public static void estatisticas() {
        System.out.println("\n----- INICIANDO VERIFICAÇÃO E LISTAGEM DAS ESTATÍSTICAS -----");
        
        int maiorIdade = 0, menorIdade = 100, totalVitorias = 0, totalDerrotas = 0, qtdJogadoresLocal = 0;
        double mediaIdade = 0, porcentagem;
        for (int i = 0; i < qtdJogadores; i++) {
            if (idadeJogador[i] > maiorIdade) {
                maiorIdade = idadeJogador[i];
            } else if (idadeJogador[i] < menorIdade) {
                menorIdade = idadeJogador[i];
            }
            if (qtdPontos[i] > 7000) {
                qtdJogadoresLocal++;
            }
            mediaIdade += idadeJogador[i];
            totalVitorias += qtdVitorias[i];
            totalDerrotas += qtdDerrotas[i];
        }
        porcentagem = ((double) qtdJogadoresLocal / qtdJogadores) * 100;
        mediaIdade /= qtdJogadores;

        System.out.printf("\nJogador mais velho: %d\n", maiorIdade);
        System.out.printf("Jogador mais novo: %d\n", menorIdade);
        System.out.printf("Média das idades: %.2f\n", mediaIdade);
        System.out.printf("Total de vitórias: %d\n", totalVitorias);
        System.out.printf("Total de derrotas: %d\n", totalDerrotas);
        System.out.printf("Jogadores com mais de 7000 pontos: %d (%.2f%%)\n", qtdJogadoresLocal, porcentagem);

        System.out.println("\n----- VERIFICAÇÃO E LISTAGEM DAS ESTATÍSTICAS CONCLUÍDA -----");
        System.out.println("Aperte Enter para voltar para o menu principal...");
        sc.nextLine();
        sc.nextLine();
    }

    /**
     * Função para buscar um jogador pelo seu nome e verificar se o mesmo existe, em caso positivo,
     * exibe as informações do mesmo
     */
    public static void buscarJogadorTitulo() {
        System.out.println("\n----- INICIANDO BUSCA DE JOGADOR VIA NOME -----");

        sc.nextLine();
        boolean encontrado = false;
        System.out.println("\nDigite o nome do jogador no qual procura: ");
        String busca = sc.nextLine(); // Exemplo de busca: "Jogador 680"
        for (int i = 0; i < qtdJogadores; i++) {
            if (busca.equalsIgnoreCase(nomeJogador[i])) {
                System.out.println("Jogador encontrado!\n");
                System.out.printf("%-25s %-10s %-12s %-15s %-15s %-15s\n", "Nome do Jogador", "Idade", "Pontuação", "Partidas", "Vitórias", "Derrotas");
                System.out.printf("%-25s %-10d %-12d %-15d %-15d %-15d\n", nomeJogador[i], idadeJogador[i], qtdPontos[i], qtdPartidas[i], qtdVitorias[i], qtdDerrotas[i]);
                encontrado = true;
                break;
            } 
        }
        if (!encontrado) {
            System.out.println("\nJogador não encontrado...");
        }
        
        System.out.println("\n----- BUSCA DE JOGADOR VIA NOME CONCLUÍDA -----");
        System.out.println("Aperte Enter para voltar para o menu principal...");
        sc.nextLine();
    }

    public static void main(String[] args) {
        System.out.println("========== SISTEMA CLUBE ==========");
        configuracaoInicial();
        cadastroJogadores();
        int opcao;
        do { 
            System.out.println("\n---------- MENU ----------");
            System.out.println("O que deseja verificar agora?");
            System.out.println(" 1- Listar todos os jogadores");
            System.out.println(" 2- Melhor jogador");
            System.out.println(" 3- Pior jogador");
            System.out.println(" 4- Média de pontuação");
            System.out.println(" 5- Jogadores acima da média de pontuação");
            System.out.println(" 6- Estatísticas");
            System.out.println(" 7- Buscar jogador pelo nome");
            System.out.println(" 0 - Encerrar");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1 -> listarJogadores();
                case 2 -> melhorJogador();
                case 3 -> piorJogador();
                case 4 -> mediaPontuacao();
                case 5 -> jogadoresAcimaDaMediaPontuacao();
                case 6 -> estatisticas();
                case 7 -> buscarJogadorTitulo();
                case 0 -> System.out.println("Encerrando o programa...");
                default -> System.out.print("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
