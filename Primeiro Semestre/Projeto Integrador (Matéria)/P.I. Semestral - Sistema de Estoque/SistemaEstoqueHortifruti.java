import java.text.Normalizer;
import java.util.Scanner;

public class SistemaEstoqueHortifruti {
    // Vetores paralelos
    static String produto[] = new String[500];
    static String categoria[] = new String[500];
    static int quantidade[] = new int[500];
    static double preco[] = new double[500];
    // Variáveis de controle
    static int produtosCadastrados = 0;
    static int tamanhoEstoque = 500; 
    // Ferramentas Java
    static Scanner sc = new Scanner(System.in);

    // ---------- OPÇÕES DO MENU ----------
    /**
     * Lista todos os produtos do estoque (ou de determinada categoria) com suas respectivas informações.
     */
    public static void consultarEstoque() {
        if (produtosCadastrados == 0) {
            System.out.println("O estoque está vazio! Voltando para o menu...");
            return;
        }
        System.out.println("----- CONSULTA DO ESTOQUE -----");
        System.out.println("Deseja consultar todo o estoque ou apenas uma categoria específica?");
        System.out.println("1 - Todo o estoque");
        System.out.println("2 - Somente frutas");
        System.out.println("3 - Somente legumes");
        System.out.println("4 - Somente verduras");
        System.out.print("Opção:");
        int opcao = 0;
        while (opcao < 1 || opcao > 4) { 
            opcao = sc.nextInt();
            if (opcao < 1 || opcao > 4) {
                System.out.print("Opção inválida! Digite novamente: ");
            }
        }
        String listagem;
        switch (opcao) {
            case 1 -> listagem = "Tudo";
            case 2 -> listagem = "Frutas";
            case 3 -> listagem = "Legumes";
            case 4 -> listagem = "Verduras";
            default -> {
                System.out.println("Ocorreu um erro inesperado...");
                System.out.println("Voltando para o menu.");
                return;
            }
        }

        switch (listagem) {
            case "Tudo" -> {
                System.out.println("=".repeat(75)); // Repete tal caracter sem ter que escrever ele x vezes
                System.out.printf("%-5s %-18s %-15s %10s %12s%n", "ID", "PRODUTO", "CATEGORIA", "QTD.", "PREÇO (R$)");
                System.out.println("-".repeat(75));
                for (int i = 0; i < produtosCadastrados; i++) {
                    System.out.printf("%-5d %-18s %-15s %10d %12.2f%n", i + 1, produto[i], categoria[i], quantidade[i], preco[i]);
                }   System.out.println("=".repeat(75));
            }
            case "Frutas" -> {
                System.out.println("=".repeat(75));
                System.out.printf("%-5s %-18s %-15s %10s %12s%n", "ID", "PRODUTO", "CATEGORIA", "QTD.", "PREÇO (R$)");
                System.out.println("-".repeat(75));
                for (int i = 0; i < produtosCadastrados; i++) {
                    if (categoria[i].equals("Frutas")) {
                        System.out.printf("%-5d %-18s %-15s %10d %12.2f%n", i + 1, produto[i], categoria[i], quantidade[i], preco[i]);
                    }
                }   System.out.println("=".repeat(75));
            }
            case "Legumes" -> {
                System.out.println("=".repeat(75));
                System.out.printf("%-5s %-18s %-15s %10s %12s%n", "ID", "PRODUTO", "CATEGORIA", "QTD.", "PREÇO (R$)");
                System.out.println("-".repeat(75));
                for (int i = 0; i < produtosCadastrados; i++) {
                    if (categoria[i].equals("Legumes")) {
                        System.out.printf("%-5d %-18s %-15s %10d %12.2f%n", i + 1, produto[i], categoria[i], quantidade[i], preco[i]);
                    }
                }   System.out.println("=".repeat(75));
            }
            case "Verduras" -> {
                System.out.println("=".repeat(75));
                System.out.printf("%-5s %-18s %-15s %10s %12s%n", "ID", "PRODUTO", "CATEGORIA", "QTD.", "PREÇO (R$)");
                System.out.println("-".repeat(75));
                for (int i = 0; i < produtosCadastrados; i++) {
                    if (categoria[i].equals("Verduras")) {
                        System.out.printf("%-5d %-18s %-15s %10d %12.2f%n", i + 1, produto[i], categoria[i], quantidade[i], preco[i]);
                    }
                }   System.out.println("=".repeat(75));
            }
            default -> {
                System.out.println("Ocorreu um erro inesperado...");
                System.out.println("Voltando para o menu.");
                return;
            }
        }
        System.out.println("----- CONSULTA FINALIZADA! -----");
    }

    /**
     * Adiciona um produto e suas respectivas informações ao estoque
     */
    public static void adicionarProduto() {
        if (produtosCadastrados == tamanhoEstoque) {
            System.out.println("Estoque cheio! Não é possível cadastrar mais nenhum produto...");
            return;
        }
        System.out.println("----- CADASTRO DE NOVO PRODUTO -----");
        System.out.println("Digite o nome do produto: ");
        produto[produtosCadastrados] = sc.next();
        sc.nextLine(); // Limpando buffer de entrada

        System.out.println("Qual categoria esse produto pertence? ");
        System.out.println("1 - Frutas ");
        System.out.println("2 - Legumes ");
        System.out.println("3 - Verduras ");
        System.out.print("Opção: ");
        int opcao = 0;
        while (opcao < 1 || opcao > 3) { 
            opcao = sc.nextInt();
            if (opcao < 1 || opcao > 3) {
                System.out.print("Opção inválida! Digite novamente: ");
            }
        }
        String pertence;
        switch (opcao) {
            case 1 -> pertence = "Frutas";
            case 2 -> pertence = "Legumes";
            case 3 -> pertence = "Verduras";
            default -> {
                System.out.println("Ocorreu um erro inesperado...");
                System.out.println("Voltando para o menu.");
                return;
            }
        }
        categoria[produtosCadastrados] = pertence;

        System.out.print("Digite a quantidade disponível deste produto: ");
        quantidade[produtosCadastrados] = sc.nextInt();
        while (quantidade[produtosCadastrados] < 0) {
            System.out.print("Quantidade inválida! Digite um valor positivo: ");
            quantidade[produtosCadastrados] = sc.nextInt();
        }
        sc.nextLine(); // Limpando buffer

        System.out.print("Digite o preço deste produto: ");
        // Abaixo o "sc.nextLine" recebe dado como tipo String, o "Double.parseDouble" é para converter esse dado para tipo double
        preco[produtosCadastrados] = Double.parseDouble(sc.nextLine().replace(",", ".")); // Permite aceitar tanto "10,50" como "10.50" por exemplo
        while (preco[produtosCadastrados] < 0) {
            System.out.print("Preço inválido! Digite um valor positivo: ");
            preco[produtosCadastrados] = Double.parseDouble(sc.nextLine().replace(",", "."));
        }
    
        System.out.printf("Produto: %s | Categoria: %s | Quantidade: %d | Preço unitário: R$ %.2f%n",
        produto[produtosCadastrados], categoria[produtosCadastrados], quantidade[produtosCadastrados], preco[produtosCadastrados]);
        produtosCadastrados++;
        System.out.println("----- CADASTRO FINALIZADO! -----");
    }

    /**
     * Remove um produto e suas respectivas informações do estoque
     */
    public static void removerProduto() {
        if (produtosCadastrados == 0) {
            System.out.println("O estoque está vazio! Voltando para o menu...");
            return;
        }
        System.out.println("----- REMOVER PRODUTO -----");
        // Exibindo todos os produtos cadastrados para consulta de ID's (facilita na entrada de dados)
        System.out.println("=".repeat(75));
        System.out.printf("%-5s %-18s %-15s %10s %12s%n", "ID", "PRODUTO", "CATEGORIA", "QTD.", "PREÇO (R$)");
        System.out.println("-".repeat(75));
        for (int i = 0; i < produtosCadastrados; i++) {
            System.out.printf("%-5d %-18s %-15s %10d %12.2f%n", i + 1, produto[i], categoria[i], quantidade[i], preco[i]);
        }
        System.out.println("-".repeat(75));

        System.out.print("Digite o ID do produto que deseja remover: ");
        int id = sc.nextInt();
        if (id < 1 || id > produtosCadastrados) {
            System.out.println("ID inválido! Nenhum produto foi removido.");
            return;
        }
        int indice = id - 1;
        System.out.printf("Produto selecionado: %s%n", produto[indice]);
        // Deslocando os elementos dos vetores para preencher a posição removida
        for (int i = indice; i < produtosCadastrados - 1; i++) {
            produto[i] = produto[i + 1];
            categoria[i] = categoria[i + 1];
            quantidade[i] = quantidade[i + 1];
            preco[i] = preco[i + 1];

        }
        produtosCadastrados--;
        System.out.println("Produto removido com sucesso!");
        System.out.println("----- REMOÇÃO FINALIZADA! -----");
    }   

    /**
     * Permite editar as informações de um produto específico do estoque
     */
    public static void editarProduto() {
        if (produtosCadastrados == 0) {
            System.out.println("O estoque está vazio! Voltando para o menu...");
            return;
        }
        System.out.println("----- EDITAR PRODUTO -----");
        // Exibindo todos os produtos cadastrados para consulta de ID's (facilita na entrada de dados)
        System.out.println("=".repeat(75));
        System.out.printf("%-5s %-18s %-15s %10s %12s%n", "ID", "PRODUTO", "CATEGORIA", "QTD.", "PREÇO (R$)");
        System.out.println("-".repeat(75));
        for (int i = 0; i < produtosCadastrados; i++) {
            System.out.printf("%-5d %-18s %-15s %10d %12.2f%n", i + 1, produto[i], categoria[i], quantidade[i], preco[i]);
        }
        System.out.println("-".repeat(75));

        System.out.print("Digite o ID do produto que deseja editar: ");
        int id = sc.nextInt();
        if (id < 1 || id > produtosCadastrados) {
            System.out.println("ID inválido! Nenhum produto foi editado.");
            return;
        }
        int indice = id - 1;
        // Informações atuais do produto
        System.out.println("\n----- PRODUTO SELECIONADO -----");
        System.out.printf("Produto: %s%n", produto[indice]);
        System.out.printf("Categoria: %s%n", categoria[indice]);
        System.out.printf("Quantidade: %d%n", quantidade[indice]);
        System.out.printf("Preço unitário: R$ %.2f%n", preco[indice]);
        // Menu de edição
        System.out.println("\nO que deseja editar?");
        System.out.println("1 - Nome do produto");
        System.out.println("2 - Categoria");
        System.out.println("3 - Quantidade");
        System.out.println("4 - Preço");
        System.out.println("5 - Todas as informações");
        System.out.println("0 - Cancelar edição");
        System.out.print("Opção: ");
        int opcao = sc.nextInt();
        sc.nextLine(); // Limpando buffer de entrada
        switch (opcao) {
            case 1 -> {
                System.out.print("Digite o novo nome do produto: ");
                produto[indice] = sc.nextLine();
            }
            case 2 -> {
                System.out.println("Selecione a nova categoria:");
                System.out.println("1 - Frutas");
                System.out.println("2 - Legumes");
                System.out.println("3 - Verduras");
                System.out.print("Opção: ");
                int novaCategoria = sc.nextInt();
                switch (novaCategoria) {
                    case 1 -> categoria[indice] = "Frutas";
                    case 2 -> categoria[indice] = "Legumes";
                    case 3 -> categoria[indice] = "Verduras";
                    default -> {
                        System.out.println("Categoria inválida!");
                        return;
                    }
                }
            }
            case 3 -> {
                System.out.print("Digite a nova quantidade: ");
                quantidade[indice] = sc.nextInt();
                while (quantidade[indice] < 0) {
                    System.out.print("Quantidade inválida! Digite um valor positivo: ");
                    quantidade[indice] = sc.nextInt();
                }
            }
            case 4 -> {
                System.out.print("Digite o novo preço: R$ ");
                preco[indice] = Double.parseDouble(sc.nextLine().replace(",", "."));
                while (preco[indice] < 0) {
                    System.out.print("Preço inválido! Digite um valor positivo: ");
                    preco[indice] = Double.parseDouble(sc.nextLine().replace(",", "."));
                }
            }
            case 5 -> {
                System.out.print("Digite o novo nome do produto: ");
                produto[indice] = sc.nextLine();

                System.out.println("Selecione a nova categoria:");
                System.out.println("1 - Frutas");
                System.out.println("2 - Legumes");
                System.out.println("3 - Verduras");
                System.out.print("Opção: ");
                int novaCategoria = sc.nextInt();
                switch (novaCategoria) {
                    case 1 -> categoria[indice] = "Frutas";
                    case 2 -> categoria[indice] = "Legumes";
                    case 3 -> categoria[indice] = "Verduras";
                    default -> {
                        System.out.println("Categoria inválida!");
                        return;
                    }
                }

                System.out.print("Digite a nova quantidade: ");
                quantidade[indice] = sc.nextInt();
                while (quantidade[indice] < 0) {
                    System.out.print("Quantidade inválida! Digite um valor positivo: ");
                    quantidade[indice] = sc.nextInt();
                }
                sc.nextLine();

                System.out.print("Digite o novo preço: R$ ");
                preco[indice] = Double.parseDouble(sc.nextLine().replace(",", "."));
                while (preco[indice] < 0) {
                    System.out.print("Preço inválido! Digite um valor positivo: ");
                    preco[indice] = Double.parseDouble(sc.nextLine().replace(",", "."));
                }
            }
            case 0 -> {
                System.out.println("Edição cancelada!");
                return;
            }
            default -> {
                System.out.println("Opção inválida! Nenhuma informação foi alterada.");
                return;
            }
        }
        // Informações atualizadas
        System.out.println("\n----- INFORMAÇÕES ATUALIZADAS -----");
        System.out.printf("Produto: %s%n", produto[indice]);
        System.out.printf("Categoria: %s%n", categoria[indice]);
        System.out.printf("Quantidade: %d%n", quantidade[indice]);
        System.out.printf("Preço unitário: R$ %.2f%n", preco[indice]);
        System.out.println("----- EDIÇÃO FINALIZADA! -----");
    }

    /**
     * Permite verificar todas as informações de um produto específico do estoque
     */
    public static void pesquisarProduto() {
        if (produtosCadastrados == 0) {
            System.out.println("O estoque está vazio! Voltando para o menu...");
            return;
        }
        System.out.println("----- PESQUISAR PRODUTO -----");
        sc.nextLine(); // Limpando o buffer do do menu
        System.out.print("Digite o nome do produto que deseja pesquisar: ");
        String pesquisa = normalizar(sc.nextLine()); // Utiliza do método auxiliar para facilitar a busca
        if (pesquisa.isEmpty()) {
            System.out.println("Nome inválido! Nenhuma pesquisa foi realizada.");
            return;
        }

        boolean encontrado = false;
        for (int i = 0; i < produtosCadastrados; i++) {
            if (normalizar(produto[i]).contains(pesquisa)) { // Usando "contains" digitar "ana" por exemplo, faz aparecer "banANA" (ou qualquer fruta com isso)
                if (!encontrado) {
                    System.out.println("\n----- RESULTADOS DA PESQUISA -----");
                    System.out.println("=".repeat(75));
                    System.out.printf("%-5s %-18s %-15s %10s %12s%n", "ID", "PRODUTO", "CATEGORIA", "QTD.", "PREÇO (R$)");
                    System.out.println("-".repeat(75));
                }

                System.out.printf("%-5d %-18s %-15s %10d %12.2f%n", i + 1, produto[i], categoria[i], quantidade[i], preco[i]);
                encontrado = true;
            }
        }
        if (encontrado) {
            System.out.println("=".repeat(75));
            System.out.println("Pesquisa concluída!");
        } else {
            System.out.println("Nenhum produto encontrado com o nome informado.");
        }
        System.out.println("----- PESQUISA FINALIZADA! -----");
    }

    /**
     * Lista os produtos do estoque no qual a quantidade de unidades está baixa
     * (sendo "baixo" = quantidade < 10).
     */
    public static void verificarEstoquesBaixos() {
        if (produtosCadastrados == 0) {
            System.out.println("O estoque está vazio! Voltando para o menu...");
            return;
        }   
        boolean estoqueBaixo = false;   
        System.out.println("----- VERIFICAR ESTOQUES BAIXOS -----");    
        for (int i = 0; i < produtosCadastrados; i++) {
            if (quantidade[i] < 10) {   
                if (!estoqueBaixo) {
                    System.out.println("=".repeat(75));
                    System.out.printf("%-5s %-18s %-15s %10s %12s%n", "ID", "PRODUTO", "CATEGORIA", "QTD.", "PREÇO (R$)");
                    System.out.println("-".repeat(75));
                }   
                System.out.printf("%-5d %-18s %-15s %10d %12.2f%n", i + 1, produto[i], categoria[i], quantidade[i], preco[i]);   
                estoqueBaixo = true;
            }
        }   
        if (estoqueBaixo) {
            System.out.println("=".repeat(75));
            System.out.println("Verificação concluída!");
        } else {
            System.out.println("Nenhum produto apresenta estoque baixo!");
        }   
        System.out.println("----- VERIFICAÇÃO FINALIZADA! -----");
    }

    /**
     * Calcula e mostra o valor total do estoque com base em todos os produtos nele contidos
     */
    public static void calcularValorEstoque() {
        if (produtosCadastrados == 0) {
        System.out.println("O estoque está vazio! Voltando para o menu...");
        return;
        }
        double valorTotal = 0;
        for (int i = 0; i < produtosCadastrados; i++) {
            valorTotal += quantidade[i] * preco[i];
        }
        System.out.println("----- VALOR TOTAL DO ESTOQUE -----");
        System.out.printf("Valor total: R$ %.2f%n", valorTotal);
        System.out.println("----- CÁLCULO FINALIZADO! -----");
    }

    // ---------- MÉTODOS AUXILIARES ----------
    /**
     * Mensagem de boas-vindas e escolha entre estoque vazio ou exemplo
     */
    public static void configuracaoInicial() {
        System.out.println("----- BOAS-VINDAS -----");
        System.out.println("Olá caro usuário!");
        System.out.println("Este é um sistema feito para que você possa gerenciar seu estoque de frutas, legumes e verduras da sua hortifruti. ");
        System.out.println("Ele tem capacidade máxima para cadastrar 500 produtos diferentes!");
        System.out.println("\nDeseja começar com o estoque vazio ou preencher com 36 produtos de exemplo para rodar testes? ");
        System.out.println("1 - Estoque vazio");
        System.out.println("2 - Estoque exemplo");
        System.out.print("Opção: ");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> System.out.println("Você optou pelo estoque vazio.");
            case 2 -> {
                System.out.println("Você optou pelo estoque com alguns produtos de exemplo");
                usarEstoqueExemplo();
            }
            default -> System.out.println("Opção inválida! Utilizando estoque vazio...");
        }
        System.out.println("\nTudo certo, sistema pronto para utilização!");
        System.out.println("Aperte Enter para ir para o menu principal...\n");
        sc.nextLine();
        sc.nextLine();
    }

    /**
     * Estoque com informações já preenchidas, útil para aprensentações e testes
     */
    public static void usarEstoqueExemplo() {
        System.out.println("----- CADASTRANDO 36 PRODUTOS DE EXEMPLO... -----");
        // Frutas
        System.out.println("Adicionando 12 frutas...");
        produto[0] = "Maçã"; categoria[0] = "Frutas"; quantidade[0] = 45; preco[0] = 2.50;
        produto[1] = "Banana"; categoria[1] = "Frutas"; quantidade[1] = 78; preco[1] = 1.80;
        produto[2] = "Laranja"; categoria[2] = "Frutas"; quantidade[2] = 32; preco[2] = 3.20;
        produto[3] = "Mamão"; categoria[3] = "Frutas"; quantidade[3] = 10; preco[3] = 4.50;
        produto[4] = "Abacaxi"; categoria[4] = "Frutas"; quantidade[4] = 7; preco[4] = 7.90;
        produto[5] = "Melancia"; categoria[5] = "Frutas"; quantidade[5] = 14; preco[5] = 12.00;
        produto[6] = "Uva"; categoria[6] = "Frutas"; quantidade[6] = 63; preco[6] = 6.50;
        produto[7] = "Morango"; categoria[7] = "Frutas"; quantidade[7] = 89; preco[7] = 8.90;
        produto[8] = "Pera"; categoria[8] = "Frutas"; quantidade[8] = 37; preco[8] = 3.80;
        produto[9] = "Manga"; categoria[9] = "Frutas"; quantidade[9] = 52; preco[9] = 4.20;
        produto[10] = "Kiwi"; categoria[10] = "Frutas"; quantidade[10] = 26; preco[10] = 5.90;
        produto[11] = "Limão"; categoria[11] = "Frutas"; quantidade[11] = 94; preco[11] = 2.30;
        // Legumes
        System.out.println("Adicionando 12 legumes...");
        produto[12] = "Cenoura"; categoria[12] = "Legumes"; quantidade[12] = 68; preco[12] = 2.90;
        produto[13] = "Batata"; categoria[13] = "Legumes"; quantidade[13] = 91; preco[13] = 3.50;
        produto[14] = "Beterraba"; categoria[14] = "Legumes"; quantidade[14] = 43; preco[14] = 3.20;
        produto[15] = "Abobrinha"; categoria[15] = "Legumes"; quantidade[15] = 27; preco[15] = 4.10;
        produto[16] = "Chuchu"; categoria[16] = "Legumes"; quantidade[16] = 74; preco[16] = 2.20;
        produto[17] = "Pepino"; categoria[17] = "Legumes"; quantidade[17] = 56; preco[17] = 3.80;
        produto[18] = "Berinjela"; categoria[18] = "Legumes"; quantidade[18] = 6; preco[18] = 4.90;
        produto[19] = "Pimentão"; categoria[19] = "Legumes"; quantidade[19] = 82; preco[19] = 5.50;
        produto[20] = "Abóbora"; categoria[20] = "Legumes"; quantidade[20] = 35; preco[20] = 3.90;
        produto[21] = "Vagem"; categoria[21] = "Legumes"; quantidade[21] = 47; preco[21] = 6.20;
        produto[22] = "Mandioquinha"; categoria[22] = "Legumes"; quantidade[22] = 61; preco[22] = 7.50;
        produto[23] = "Nabo"; categoria[23] = "Legumes"; quantidade[23] = 29; preco[23] = 3.40;
        // Verduras
        System.out.println("Adicionando 12 verduras...");
        produto[24] = "Alface"; categoria[24] = "Verduras"; quantidade[24] = 35; preco[24] = 2.50;
        produto[25] = "Couve"; categoria[25] = "Verduras"; quantidade[25] = 17; preco[25] = 3.00;
        produto[26] = "Espinafre"; categoria[26] = "Verduras"; quantidade[26] = 18; preco[26] = 4.50;
        produto[27] = "Rúcula"; categoria[27] = "Verduras"; quantidade[27] = 82; preco[27] = 3.50;
        produto[28] = "Agrião"; categoria[28] = "Verduras"; quantidade[28] = 46; preco[28] = 3.20;
        produto[29] = "Acelga"; categoria[29] = "Verduras"; quantidade[29] = 53; preco[29] = 4.80;
        produto[30] = "Repolho"; categoria[30] = "Verduras"; quantidade[30] = 71; preco[30] = 3.60;
        produto[31] = "Almeirão"; categoria[31] = "Verduras"; quantidade[31] = 24; preco[31] = 3.90;
        produto[32] = "Escarola"; categoria[32] = "Verduras"; quantidade[32] = 39; preco[32] = 4.20;
        produto[33] = "Mostarda"; categoria[33] = "Verduras"; quantidade[33] = 4; preco[33] = 3.70;
        produto[34] = "Cebolinha"; categoria[34] = "Verduras"; quantidade[34] = 88; preco[34] = 2.80;
        produto[35] = "Salsinha"; categoria[35] = "Verduras"; quantidade[35] = 31; preco[35] = 2.60;
        produtosCadastrados = 36;
        System.out.println("----- CADASTROS FINALIZADOS! -----");
    }

    /**
     * Método para normalizar busca por texto
     */
    public static String normalizar(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "") // Ignora acentos
                .toLowerCase() // Ignora cases (capslock)
                .trim(); // Ignora espaços no começo e final
    }

    // ---------- MÉTODO PRINCIPAL/MENU ----------
    public static void main(String[] args) {
        try {
            configuracaoInicial();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro na configuração inicial. " + e.getMessage());
            System.out.println("Utilizando estoque vazio...");
            if (sc.hasNextLine()) {
                    sc.nextLine();
                }
        }
        System.out.println("===== SISTEMA DE ESTOQUE HORTIFRUTI =====");
        int opcao = -1;
        do {
            try {
                System.out.println("\n---------- MENU ----------");
                System.out.println("O que deseja fazer agora?");
                System.out.println(" 1 - Consultar estoque");
                System.out.println(" 2 - Adicionar um produto");
                System.out.println(" 3 - Remover um produto");
                System.out.println(" 4 - Editar um produto");
                System.out.println(" 5 - Pesquisar por um produto específico");
                System.out.println(" 6 - Verificar produtos com estoque baixo");
                System.out.println(" 7 - Calcular valor total do estoque");
                System.out.println(" 0 - Encerrar");
                System.out.print("Opção: ");
                opcao = sc.nextInt();
                switch (opcao) {
                    case 1 -> consultarEstoque();
                    case 2 -> adicionarProduto();
                    case 3 -> removerProduto();
                    case 4 -> editarProduto();
                    case 5 -> pesquisarProduto();
                    case 6 -> verificarEstoquesBaixos();
                    case 7 -> calcularValorEstoque();
                    case 0 -> System.out.println("Encerrando o programa...");
                    default -> System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
                if (sc.hasNextLine()) {
                    sc.nextLine();
                }
                opcao = -1;
                System.out.println("Retornando ao menu principal...");
            }
        } while (opcao != 0);
    }
}
