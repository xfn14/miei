# Lógica do programa

Neste módulo trata-se a lógica do jogo em si, implementando-se a função jogar, junto com outras que a suportam.

### Jogar
Esta função recebe o [*ESTADO*][estado] atual e a [*COORDENADA*][coordenada] de input do user através do interpretador.

Antes de poder-mos aplicar a [*JOGADA*][jogada] temos de a validar, tal é feito na função ***jogada_valida()***.

Caso a [*JOGADA*][jogada] seja válida, então a função muda o tabuleiro presente no [*ESTADO*][estado] devidamente, a função adicionar_jogada() é chamada, é eftuada uma troca de jogador, o tabuleiro é mostrado e caso algum jogador tenha ganho com esta [*JOGADA*][jogada], o jogo acaba e aparece uma mensagem de vitória.

### Validar Jogada
Esta função tem como objetivo determinar se uma [*JOGADA*][jogada] é valida de acordo com o [*ESTADO*][estado] atual do jogo e a [*COORDENADA*][coordenada]
de input. 

Deste modo, a [*COORDENADA*][coordenada] tem de estar em volta da *PECA* e a [*CASA*][casa] da [*COORDENADA*][coordenada] tem de ser *VAZIO*.

Se a [*JOGADA*][jogada] for inválida, a função da return de 0.

Se a [*JOGADA*][jogada] for válida, a função pode ter 3 return diferentes:
- 1 se a [*JOGADA*][jogada] permitir o jogador 1 vencer.
- 2 se a [*JOGADA*][jogada] permitir o jogador 2 vencer.
- 3 se for simplesmente uma [*JOGADA*][jogada] válida.

### Array de Jogadas
Para além de executar as [*JOGADA*][jogada]s e alterar o tabuleiro, as [*JOGADA*][jogada]s são armazenadas num array e o número de [*JOGADA*][jogada]s incrementado por 1.

Assim temos disponível todas as [*JOGADA*][jogada]s numa só array.

[jogada]: https://github.com/andreubita/li2-201920/blob/master/relatorios/guiao5/dados.md#jogada
[coordenada]: https://github.com/andreubita/li2-201920/blob/master/relatorios/guiao5/dados.md#coordenada
[casa]: https://github.com/andreubita/li2-201920/blob/master/relatorios/guiao5/dados.md#casa
[estado]: https://github.com/andreubita/li2-201920/blob/master/relatorios/guiao5/dados.md#estado