# Camada de interface
Neste módulo tratamos de duas tarefas:

> 1. Mostrar o tabuleiro
>
> 2. Criar um interpretador de comandos.

Para cada tarefa seguem se as suas descrições.

### Tabuleiro Inicial

<img src="https://github.com/andreubita/li2-201920/blob/master/relatorios/guiao5/tabuleiro_incial.png" align="center" alt="Tabuleiro Inicial">

### Mostrar o tabuleiro

***mostrar_tabuleiro***:
Função que recebe um [*ESTADO*][estado] e imprime o tabuleiro para esse [*ESTADO*][estado].
Tal é desenhado através de dois for-loop que percorrem a array bidimensional do tabuleiro presente no [*ESTADO*][estado].
Cada elemento desta array é uma [*CASA*][casa] logo através de ifs conseguimos detetar que tipo de [*CASA*][casa] é e colocar o char correto.

### Interpretador de comandos

Para o interpretador eram pedidos os seguintes tópicos:
   
> 1.Ler uma linha (usando fgets)
>
> 2.Separar a linha por espaços (por exemplo utilizando sscanf ou strtok)
>
> 3.Conforme o comando a executar, chamar a função correspondente do interface ou da lógica do programa e depois do interface.
    
***interpretador***:
Atualmente o interpretador ainda não foi desenvolvido na sua totalidade mas já tem as features essenciais.
Primeiramente, a função é chamada na main() sendo fornecido o [*ESTADO*][estado] do jogo, sendo que esta função é chamada até o
user introduzir um "q" ou o jogo acabar.
O interpretador começa por ler o input do nosso user, onde esse input é processado através de ifs para conseguirmos
determinar o seu conteúdo.
De seguida, tento o conteúdo devidamente identificado, são executadas as funções necessárias para que aconteça o que o user
pretende.
Após isto ter isso concluído, a função volta a ser chamada para que novo input seja introduzido.

[casa]: https://github.com/andreubita/li2-201920/blob/master/relatorios/guiao5/dados.md#casa
[estado]: https://github.com/andreubita/li2-201920/blob/master/relatorios/guiao5/dados.md#estado