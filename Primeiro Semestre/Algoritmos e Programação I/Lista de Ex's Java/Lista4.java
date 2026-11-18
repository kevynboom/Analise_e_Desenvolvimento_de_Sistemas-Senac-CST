import java.util.Random;
import java.util.Scanner;

public class Lista4 {
    // Variáveis Globais
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    // --- EXERCÍCIOS ---
    // 1 - Crie um método que verifica se um array de char possui um determinado valor.
    public static void ex01() {
        System.out.println("---------- EXERCÍCIO 01 ----------");
        System.out.println("Teste");
    }
    
    // 2 - Use o método anterior para preencher um array com valores não repetidos.
    public static void ex02() {

    }

    // 3 - Crie um método que procura um valor em um array bidimensional e retorna um array com a coordenada de onde o valor foi encontrado. 
    public static void ex03() {

    }

    // 4 - Preencha um array unidimensional com 100 números inteiros. Em seguida, escreva os elementos que são primos e suas respectivas posições.
    public static void ex04() {

    }

    // 5 - Preencha um array bidimensional de 5 x 5 com números reais. Em seguida, exiba os valores e posições dos números maiores que 50.
    public static void ex05() {

    }

    // 6 - Preencha um array bidimensional de 10 x 10 com números inteiros positivos em todas as posições, 
    // exceto na diagonal principal que deverá ser preenchida com o valor -1. 
    public static void ex06() {

    }

    // 7 - Prencha um array tridimensional apenas com valores pares. Em seguida, conte quantos valores são divisíveis por 5.
    public static void ex07() {

    }

    // 8 - Crie um array unidimensional com 10 valores e um outro array com 20 posições, com os números do primeiro array seguidos do dobro deste número. 
    public static void ex08() {

    }

    // 9 - Preencha um array unidimensional com 50 números inteiros. Em seguida, substitua os valores repetidos por 0.
    public static void ex09() {

    }

    // 10 - Crie um array bidimensional de 10 x 10 e guarde em um outro array o maior valor, o menor valor e a média dos valores deste array.
    public static void ex10() {

    }

    // 11 - Crie um array bidimensional de 7 x 7 e exiba a soma dos valores das colunas ímpares e a multiplicação dos valores das linhas pares deste array. 
    public static void ex11() {

    }

    // 12 - Melhore o método do exercício 1, indicando o índice inicial e o índice final da busca.
    public static void ex12() {

    }

    // 13 - Preencha um array bidimensional com as letras a e b. Nas linhas pares, a letra a e nas linhas ímpares a letra b.
    public static void ex13() {

    }

    // 14 - Preencha um array bidimensional com os números 1, 2 e 3. Nas colunas ímpares o número 1, nas colunas pares o número 2 e nas diagonais o número 3.
    public static void ex14() {

    }
    
    // --- MÉTODO PRINCIPAL (MENU) ---
    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("========== LISTA DE EXERCÍCIOS 4 ==========");
            System.out.println("Digite o número do exercício desejado (1 a 14) ou 0 para sair:");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1 -> loopEx(Lista4::ex01);
                case 2 -> loopEx(Lista4::ex02);
                case 3 -> loopEx(Lista4::ex03);
                case 4 -> loopEx(Lista4::ex04);
                case 5 -> loopEx(Lista4::ex05);
                case 6 -> loopEx(Lista4::ex06);
                case 7 -> loopEx(Lista4::ex07);
                case 8 -> loopEx(Lista4::ex08);
                case 9 -> loopEx(Lista4::ex09);
                case 10 -> loopEx(Lista4::ex10);
                case 11 -> loopEx(Lista4::ex11);
                case 12 -> loopEx(Lista4::ex12);
                case 13 -> loopEx(Lista4::ex13);
                case 14 -> loopEx(Lista4::ex14);
                case 0 -> System.out.println("Encerrando o programa...");
                default -> System.out.print("Opção inválida!");
            }
        } while (opcao != 0);
    }

    // ---------- MÉTODOS AUXILIARES ----------
    public static void loopEx(Runnable ex) {
        int opcao;
        do {
            ex.run(); 
            System.out.println("\n---------- FIM DO EXERCÍCIO ----------");
            System.out.println("O que deseja fazer agora?");
            System.out.println("1 - Repetir o último exercício escolhido");
            System.out.println("2 - Escolher outro exercício para testar"); 
            System.out.println("3 - Encerrar o programa");
            System.out.print("Resposta: ");
            opcao = sc.nextInt();
            if (opcao == 3) {
                System.out.println("Encerrando o programa...");
                System.exit(0);
            }
        } while (opcao == 1); 
    }
}