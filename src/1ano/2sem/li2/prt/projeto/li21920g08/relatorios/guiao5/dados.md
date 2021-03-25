# Camada de Dados

Este módulo apresente a estrutura de dados do programa e as únicas funções capazes de alterar o Estado definido nesta estrutura.

### Data.h

Para isto, em primeiro lugar, criamos um ficheiro que definiu os vários tipos necessários para criar as funções essenciais para a realização do jogo.

Definimos diferentes structures e um enum:

###### Casa
```c
enum CASA {
    VAZIO, // Lugar vazio
    RASTRO, // Lugar com rastro
    PECA, // Peça do jogo
    POS1, // Posição vencedora do jogador 1
    POS2 // Posição vencedora do jogador 2
};
```
*CASA* é o tipo de peça em cada elemento do tabuleiro.

###### Coordenada
```c
struct COORDENADA {
    int coluna;
    int linha;
};
```
*COORDENADA* corresponde à posição de uma [*CASA*][casa] no tabuleiro. As *COORDENADA*s são representadas por dois números inteiros (0-7). O valor destas *COORDENADA*s corresponde à posição de determinado elemento na array bidimensional do tabuleiro.

###### Jogada
```c
struct JOGADA {
    COORDENADA jogador1;
    COORDENADA jogador2;
};
typedef JOGADA JOGADAS[32];
```
Uma *JOGADA* é constituida por um par de [*COORDENADA*][coordenada]s, uma para cada jogador. Estas *JOGADA*s são armazenadas numa lista do tipo *JOGADAS*.

###### Estado
```c
struct ESTADO{
    CASA tab[8][8];
    COORDENADA ultima_jogada;
    JOGADAS jogadas;
    int num_jogadas;
    int jogador_atual;
};
```
O *ESTADO* serve para armazenar-mos os diferentes tipos de informação de um jogo, de maneira a podermos manipulá-la de diversas maneiras.

Tais informações representam:
> tab - armazena informação sobre o tabuleiro
>
> ultima_jogada - a coordenada da última jogada
>
> jogadas - armazena informação sobre as jogadas
>
> num_jogadas - indica quantas jogadas foram efetuadas 
>
> jogador_atual - indica qual é o jogador a jogar


### Funções que alteram o Estado

Com os vários tipos de tipos da estrutura de dados agora definidos tinhamos como objetivos criar agora funções que conseguissem alterar o [*ESTADO*][estado].

Todas estas funções recebem um apontador para [*ESTADO*][estado] e modificam-o. 

Estas são as únicas funções que alteram o [*ESTADO*][estado]! Todo o resto do programa apenas modifica o [*ESTADO*][estado] através destas funções.

***inicializar_estado***:
Esta função cria um [*ESTADO*][estado] vazio (com o tabuleiro inicializado)


***obter_jogador_atual***:
Esta função permite obter o número do jogador que tem que executar a [*JOGADA*][jogada].


***obter_numero_de_jogadas***:
Esta função permite obter quantas [*JOGADA*][jogada]s foram efetuadas (cada [*JOGADA*][jogada] tem o movimento de dois jogadores)


**obter_estado_casa**
Esta função permite obter a [*CASA*][casa] em determinada [*COORDENADA*][coordenada] do tabuleiro.

[jogada]: https://github.com/andreubita/li2-201920/blob/master/relatorios/guiao5/dados.md#jogada
[coordenada]: https://github.com/andreubita/li2-201920/blob/master/relatorios/guiao5/dados.md#coordenada
[casa]: https://github.com/andreubita/li2-201920/blob/master/relatorios/guiao5/dados.md#casa
[estado]: https://github.com/andreubita/li2-201920/blob/master/relatorios/guiao5/dados.md#estado
