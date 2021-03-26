# Comando jog

Neste guião, foi-nos proposto criar uma função que fizesse com que o computador jogasse por um dos 
jogadores.

Para isso foi necessário criar um ****módulo de listas ligadas genérico****, neste módulo são criadas várias
funções relacionadas com listas e auxiliares para a criação do nosso ****comando jog****.

#### Informações sobre este novo comando

Este comando devia:

- Varrer todas as posições vizinhas da peça branca que estejam livres e armazená-las numa **lista ligada** de posições;
- Usar uma **heurística** para escolher qual é a jogada que vai ser efetuada;
- Fazer essa jogada e mudar o jogador atual.

#### Heurística

Para este guião, optamos pela heurística usando a ***distancia euclidiana*** pois está num patamar intermédio e assim 
ao longo dos próximos guiões poderemos tentar melhor para uma heurística mais avançada.
    