import java.util.Scanner;

class Fila {
    int inicio;
    int fim;
    int tamanho; //tamanho maximo da fila
    int qtdeElementos;
    int f[][];//array que armazena as coordenadas do ponto

    public Fila(int tam) {
        inicio = fim = -1; //define o inicio e fim como -1 p/ indicar que ta vazia
        tamanho = tam; //tam. maximo da fila passado como argumento quando uma fila for criada
        f = new int[tamanho][2]; //cria a array f que armazena as coordenadas do pontos a serem processados
        qtdeElementos = 0;
    }

    public boolean estaVazia() {
        //Retorna true quando vazia, false quando não
        return qtdeElementos == 0;
    }

    public void adicionar(int[] ponto) {
        //checa se a fila não está cheia antes de adicionar um novo item
        if (!estaCheia()) {
            //se inicio for -1, muda para 0 para indicar que a fila contém um elemento
            if (inicio == -1) {
                inicio = 0;
            }
            //adiciona 1 a fim para indicar onde o prox. elemento deve ser inserido
            fim ++;
            f[fim] = ponto; //armazena as coordenadas de ponto na posição fim do array f
            qtdeElementos++;
        }
    }

    public int[] remover() {
        //verifica se a fila não está vazia
        if (!estaVazia()) {
            //pega o ponto da posição inicio da fila e armazena as coordenadas na array pontoRemovido
            int[] pontoRemovido = f[inicio];
            inicio ++; //avanca o inicio p/ apontar o proximo ponto da fila
            qtdeElementos--;
            return pontoRemovido; //retorna pontoRemovido com as coordenadas do ponto
        }
        return null;
    }

    public boolean estaCheia() {
        //retorna true se a fila estiver cheia
        return qtdeElementos == tamanho;
    }
}

public class FloodFillFila {

    static int[][] matriz = {
            {0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
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

    static Fila fila = new Fila(1000); //tamanho da fila

    public static void main(String[] args) {
        iniciar();
    }

    static void iniciar() {
        System.out.println("\nFlood Fill \n");
        imprimirMatriz();

        //solicita o ponto de partida para o FloodFill atuar
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite as coordenadas x e y (separadas por espaço):");
        int pontoInicialY = scanner.nextInt();
        int pontoInicialX = scanner.nextInt();

        floodFill(pontoInicialX, pontoInicialY);
    }

    static void floodFill(int x, int y) {
        //cria uma array que armazena coordenadas x e y, onde começará o FloodFill
        int[] pontoInicial = {x, y};
        fila.adicionar(pontoInicial);

        //loop continua enquanto a fila nao está vazia
        while (!fila.estaVazia()) {
            //remove o ponto da fila, pois vai ser processado
            int[] ponto = fila.remover();
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

            //criando arrays com as coordenadas dos 4 lados do ponto e adicionando na fila, para que sejam checados
            int[] esquerda = {x - 1, y};
            int[] direita = {x + 1, y};
            int[] cima = {x, y - 1};
            int[] baixo = {x, y + 1};

            fila.adicionar(esquerda);
            fila.adicionar(direita);
            fila.adicionar(cima);
            fila.adicionar(baixo);

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
                if (matriz[i][j] == 2) {
                    cor = "\u001B[31m"; // Vermelho (cor de preenchimento)
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
