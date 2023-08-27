# floodfill_grupo11
# Algoritmo Flood Fill com Fila em Java

Este programa em Java implementa o algoritmo Flood Fill em uma matriz 2D. O algoritmo começa preenchendo uma área na matriz a partir de um ponto de partida escolhido pelo usuário. A região é preenchida com uma nova cor, substituindo a cor original do ponto de partida e se espalhando para pontos adjacentes que possuam a mesma cor original.

## Como Funciona

1. **Definição da Classe `Fila`**: A classe `Fila` é uma implementação simples de uma fila, usada para armazenar os pontos que precisam ser processados no algoritmo Flood Fill. Ela inclui métodos para adicionar, remover, verificar se está vazia e verificar se está cheia.

2. **Matriz e Cores**: A matriz bidimensional chamada `matriz` representa a área a ser preenchida. Os valores na matriz representam cores, onde 0 é uma cor vazia, 1 é uma cor original e 2 é a nova cor de preenchimento.

3. **Função `main` e Inicialização**: O programa começa com a função `main`. Ela imprime a matriz inicial e solicita ao usuário as coordenadas x e y do ponto de partida para o Flood Fill.

4. **Função `floodFill`**: Esta função é responsável pelo algoritmo de Flood Fill. Ela começa com o ponto de partida fornecido pelo usuário. Enquanto a fila de pontos a serem processados não estiver vazia, ela retira um ponto da fila, verifica sua cor na matriz original e, se necessário, muda para a nova cor e enfileira os pontos adjacentes para processamento posterior.

5. **Função `imprimirMatriz`**: Esta função imprime a matriz atualizada, usando cores no terminal para destacar as áreas preenchidas.

6. **Loop Principal e Processamento**: A função `floodFill` utiliza um loop principal que continua até que a fila esteja vazia. Em cada iteração, um ponto é retirado da fila, sua cor é verificada e, se necessário, a nova cor é atribuída. Além disso, pontos adjacentes (cima, baixo, esquerda, direita) são enfileirados.

7. **Execução e Saída**: Ao ser executado, o programa solicita ao usuário as coordenadas do ponto de partida. A partir desse ponto, ele preenche a área conectada na matriz com a nova cor de preenchimento. A matriz é impressa a cada iteração para mostrar o progresso do preenchimento.

## Como Executar

1. Compile o programa Java: `javac FloodFillFila.java`
2. Execute o programa compilado: `java FloodFillFila`

Siga as instruções na tela para fornecer o ponto de partida para o Flood Fill e observe o algoritmo em ação.

## Exemplo

Um exemplo de matriz está disponível na array `matriz` dentro do código. Você pode modificar esta matriz ou criar uma própria para ver como o algoritmo se comporta em diferentes cenários.

# Algoritmo Flood Fill com Pilha em Java

Este programa em Java implementa o algoritmo Flood Fill utilizando uma abordagem de pilha em uma matriz 2D. O algoritmo permite preencher uma área na matriz a partir de um ponto de partida escolhido pelo usuário. A região é preenchida com uma nova cor, substituindo a cor original do ponto de partida e se espalhando para pontos adjacentes que possuam a mesma cor original.

## Como Funciona

1. **Definição da Classe `Pilha`**: A classe `Pilha` é uma implementação básica de uma pilha, usada para armazenar os pontos que precisam ser processados no algoritmo Flood Fill. Ela inclui métodos para adicionar e remover elementos da pilha, além de verificar se está vazia.

2. **Matriz e Cores**: A matriz bidimensional chamada `matriz` continua representando a área que será preenchida. Os valores na matriz ainda representam cores, onde 0 é uma cor vazia, 1 é a cor original e 2 é a nova cor de preenchimento.

3. **Função `main` e Inicialização**: O programa começa com a função `main`, que imprime a matriz inicial e solicita ao usuário as coordenadas x e y do ponto de partida para o Flood Fill.

4. **Função `floodFill`**: Essa função é responsável pelo algoritmo de Flood Fill utilizando pilha. Ela começa com o ponto de partida fornecido pelo usuário e, enquanto a pilha de pontos a serem processados não estiver vazia, ela desempilha um ponto, verifica sua cor original na matriz e, se necessário, altera para a nova cor. Além disso, os pontos adjacentes (cima, baixo, esquerda, direita) são empilhados para processamento posterior.

5. **Função `imprimirMatriz`**: Similar à versão anterior, essa função imprime a matriz atualizada, com destaque para as áreas preenchidas.

6. **Loop Principal e Processamento**: A função `floodFill` possui um loop principal que continua enquanto a pilha não está vazia. Em cada iteração, um ponto é desempilhado, sua cor é verificada e, se necessário, a nova cor é atribuída. Pontos adjacentes são empilhados para serem processados posteriormente.

7. **Execução e Saída**: Após a execução, o programa solicita ao usuário as coordenadas do ponto de partida. A partir desse ponto, ele preenche a área conectada na matriz com a nova cor de preenchimento. A matriz é impressa a cada iteração para mostrar o progresso do preenchimento.

Esse programa também demonstra interativamente o funcionamento do algoritmo Flood Fill, porém, desta vez, usando uma abordagem de pilha em vez de uma fila. Isso ilustra como diferentes estruturas de dados podem ser empregadas para alcançar o mesmo objetivo.

## Como Executar

1. Compile o programa Java: `javac FloodFillPilha.java`
2. Execute o programa compilado: `java FloodFillPilha`

Siga as instruções na tela para fornecer o ponto de partida para o Flood Fill e observe o algoritmo em ação.

## Exemplo

Um exemplo de matriz está disponível na array `matriz` dentro do código. É possível modificar esta matriz ou criar uma própria para ver como o algoritmo se comporta em diferentes cenários.

## Integrantes do Grupo

1. João Pedro Corrêa Santos
2. Rodrigo Kenji
3. Enzo Singer

## Disciplina: Resolução de Problemas Estruturados em Computação
