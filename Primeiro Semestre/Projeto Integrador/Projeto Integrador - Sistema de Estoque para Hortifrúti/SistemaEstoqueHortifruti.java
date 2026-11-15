

public class SistemaEstoqueHortifruti {
    // Planejamento dos vetores do estoque:
    // 
    // Vetores paralelos
    // static int id[]
    // static String produto[]
    // static String categoria[]
    // static int quantidade[]
    // static double preco[]

    // Variáveis de controle
    // static int tamanhoEstoque; = Capacidade máxima dos vetores
    // static int quantidadeProdutos; = Quantidade de produtos cadastrados
    // static int proximoId = 1; = Identificador que será atribuído ao próximo produto 
    // (para não usarmos ID's de produtos excluídos, vou decidir se vou usar esse vetor ou não)

    // ---------- OPÇÕES DO MENU ----------

    /**
     * Método para adicionar um produto e suas respectivas informações ao estoque
     */
    public static void adicionarProduto() {

    }
    /**
     * Método para remover um produto e suas respectivas informações do estoque
     * (após exclusão deve chamar método auxiliar para organizar os vetores)
     */
    public static void removerProduto() {
        
    }
    /**
     * Lista todos os produtos do estoque com suas respectivas informações.
     * Tambem deverá ser possível listar somente produtos de uma determinada categoria (verduras, legumes ou frutas)
     */
    public static void listarProdutos() {
        
    }
    /**
     * Permite editar as informações de um produto específico do estoque
     * (a busca pelo produto específico deverá usar um dos métodos auxiliares)
     */
    public static void editarProduto() {
        
    }
    /**
     * Permite verificar todas as informações de um produto específico do estoque
     * (a busca pelo produto específico deverá usar um dos métodos auxiliares)
     */
    public static void pesquisarProduto() {
        
    }
    /**
     * Lista os produtos do estoque no qual a quantidade de unidades está baixa
     * (valor "baixo" a definir, considere 10 no momento)
     */
    public static void verificarEstoquesBaixos() {
        
    }
    /**
     * Calcula e mostra o valor total do estoque com base em todos os produtos nele contidos
     */
    public static void calcularValorEstoque() {
        
    }

    // ---------- MÉTODOS AUXILIARES ----------

    /**
     * Ao iniciar o programa pela primeira vez, definir o tamanho do estoque (e consequentemente o tamanho dos vetores), e verificar se será
     * criado um estoque do zero ou usar o de exemplo (estoque exemplo já contém vários produtos com informações completas, estoque do zero é auto-explicativo)
     */
    public static void configuracaoInicial() {
        
    }
    /**
     * Método auxiliar para configuração inicial do estoque vazio, garantindo que o primeiro produto seja adicionado após determinar o tamanho do estoque
     */
    public static void adicionarPrimeiroProduto() {
        
    }
    /**
     * Estoque com informações já preenchidas, útil para aprensentações e testes
     */
    public static void usarEstoqueExemplo() {
        
    }
    /**
     * Lógica para pesquisar e mostrar as informações de um produto específico pelo seu nome
     */
    public static int pesquisarProdutoNome(String nomePesquisa) {
        // Retorna o índice do produto encontrado.
        // Retorna -1 caso não encontre.

        return 0; // placeholder
    }
    /**
     * Lógica para pesquisar e mostrar as informações de um produto específico pelo seu ID
     */
    public static int pesquisarProdutoId(int idPesquisa) {
        // Retorna o índice do produto encontrado.
        // Retorna -1 caso não encontre.

        return 0; // placeholder
    }
    /**
     * Método auxiliar para organizar os vetores após a exclusão de um produto, garantindo que não há espaços vazios entre os mesmos
     * e deixando os vetores e ID's (se reutilizarmos) em ordem
     */
    public static void organizarVetores() {
        
    }

    // ---------- MÉTODO PRINCIPAL/MENU ----------
    public static void main(String[] args) {
        
    }
}
