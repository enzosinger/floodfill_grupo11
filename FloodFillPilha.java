import java.util.Scanner;
class Pilha {
    int topo;
    int tamanho; //tamanho max. da pilha
    int pilha[][];

    public Pilha(int tam) {

        topo = -1; //indica que a pilha está vazia
        tamanho = tam;
        pilha = new int[tamanho][2]; // Cada posição da pilha armazena um par (x, y)
    }

    public boolean estaVazia() {
        //Retorna true quando vazia, false quando não
        return topo == -1;
    }

    public void adicionar(int[] ponto) { //recebe como parâmetro as coordenadas do ponto
        //garante que a pilha não está cheia
        if (topo < tamanho - 1) {
            topo++; //soma 1 ao topo para indicar que a fila está 1 elemento maior
            //atribui as coordenadas recebidas ao topo da pilha
            pilha[topo] = ponto;
        }
    }

    public int[] remover() {
        //verifica se esta vazia a pilha
        if (!estaVazia()) {
            int[] pontoRemovido = pilha[topo];//obtém o ponto do topo da pilha
            topo--;//diminui 1 do valor do topo da pilha
            return pontoRemovido; //retorna o ponto a ser removido
        }
        return null;
    }
}

public class FloodFillPilha {

    static int[][] matriz = {
            {0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
            {0, 0, 1, 1, 0, 0, 0, 1, 1, 1},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    static int corMudar = 0; //cor que queremos que mude
    static int novaCor = 2; //cor que será usada pra preencher

    static Pilha pilha = new Pilha(1000); //tamanho da pilha

    public static void main(String[] args) {
        iniciar();
    }

    static void iniciar() {
        System.out.println("\nFlood Fill \n");
        imprimirMatriz();

        //solicita o ponto de partida para o FloodFill atuar
        Scanner scanner = new Scanner(System.in);
        System.out.println("\u001B[0mDigite as coordenadas x e y (separadas por espaço):");
        int pontoInicialY = scanner.nextInt();
        int pontoInicialX = scanner.nextInt();

        floodFill(pontoInicialX, pontoInicialY);
    }

    static void floodFill(int x, int y) {
        //cria uma array que armazena coordenadas x e y, onde começará o FloodFill
        int[] pontoInicial = {x, y};
        pilha.adicionar(pontoInicial);

        Scanner cm = new Scanner(System.in);
        System.out.println("\u001B[0mDigite a cor que deseja mudar (0,1,2): ");
        int corMudar = cm.nextInt();

        Scanner nc = new Scanner(System.in);
        System.out.println("\u001B[0mDigite a nova cor desejada (0,1,2): ");
        int novaCor = nc.nextInt();

        //loop continua enquanto a pilha nao está vazia
        while (!pilha.estaVazia()) {
            //remove o ponto da pilha, pois vai ser processado
            int[] ponto = pilha.remover();
            x = ponto[0];
            y = ponto[1];

            //verifica se o ponto não está fora da matriz
            if (x < 0 || x >= matriz.length || y < 0 || y >= matriz[0].length) {
                continue;
            }

            //verifica sea cor do ponto é diferente da cor a ser mudada
            if (matriz[x][y] != corMudar) {
                continue;
            }

            matriz[x][y] = novaCor; //altera a cor na matriz para a nova cor

            //criando arrays com as coordenadas dos 4 lados do ponto e adicionando na pilha, para que sejam checados
            int[] esquerda = {x, y - 1};
            int[] direita = {x, y + 1};
            int[] cima = {x - 1, y};
            int[] baixo = {x + 1, y};

            pilha.adicionar(esquerda);
            pilha.adicionar(direita);
            pilha.adicionar(cima);
            pilha.adicionar(baixo);

            //imprime a matriz após pintar um ponto
            imprimirMatriz();
        }
    }

    static void imprimirMatriz() {
        String cor;
        // Loop que percorre as linhas da matriz
        for (int i = 0; i < matriz.length; i++) {
            // Loop que percorre as colunas da matriz
            for (int j = 0; j < matriz[i].length; j++) {
                // Define a cor do texto com base no valor da matriz
                if (matriz[i][j] == 1) {
                    cor = "\u001B[34m"; // Azul (cor do 1)
                } else if (matriz[i][j] == 2) {
                    cor = "\u001B[31m"; // Vermelho (cor do 2)
                } else {
                    cor = "\u001B[0m"; // Reset (cor padrão)
                }

                System.out.print(cor + matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
