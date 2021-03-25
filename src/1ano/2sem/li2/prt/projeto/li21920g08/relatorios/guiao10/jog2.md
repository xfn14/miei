# Comando jog2

Nesta semana optamos por melhorar a função jog e passar de uma heuristica da distancia euclidiana para a heuristica 
minimax

## Heuristica minimax

Este algoritmo é utilizado quando queremos prever o que vai acontecer daqui a várias jogadas. Neste caso, 
o que se pretende é criar uma função (mais uma vez uma heurística) que avalie cada posição. Após isso, o algoritmo irá
experimentar todas as jogadas possíveis de cada um dos jogadores, até uma dada profundidade e avaliar a posição final 
em cada caso e escolher a jogada mais proveitosa para o jogador atual. Assume-se que cada jogador escolhe a
jogada mais proveitosa. A razão do algoritmo se chamar **Minimax** é que enquanto que o jogador atual tenta maximizar a 
sua posição, o adversário pretende minimizar essa vantagem.