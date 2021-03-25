{-|
Module      : Tarefa2_2019li1g057
Description : Este módulo define funções comuns da Tarefa 2 do trabalho prático.
Copyright   : André Vaz <a93221@alunos.uminho.pt;
              Ricardo Lopes <a93195@alunos.uminho.pt>
-}

-- Este módulo define funções comuns da Tarefa 2 do trabalho prático.
module Tarefa2_2019li1g057 where

import LI11920
import Tarefa0_2019li1g057
import Tarefa1_2019li1g057

-- * Testes

-- | Testes unitários da Tarefa 2.
--
-- Cada teste é um triplo (/identificador do 'Jogador'/,/'Jogada' a efetuar/,/'Estado' anterior/).
testesT2 :: [(Int,Jogada,Estado)]
testesT2 =[(0,(Movimenta E),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 75 0)),(Jogador 1 0 0 5 (Chao True))])),
           (0,(Dispara),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 75 0)),(Jogador 1 0 0 5 (Chao True))])),
           (1,(Dispara),(Estado (gera 2 100 4) [(Jogador 0 (1.5) 3 5 (Ar 3 75 0)),(Jogador 1 (1.5) 0 5 (Chao True))])),
           (0,(Movimenta D),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 (-80) 0)),(Jogador 1 0 0 5 (Chao True))])),
           (0,(Movimenta E),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 60 0)),(Jogador 1 0 0 5 (Chao True))])),
           (1,(Movimenta E),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 60 0)),(Jogador 1 0 0 5 (Chao True))])),
           (0,(Movimenta D),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 75 0)),(Jogador 1 0 0 5 (Chao True))])),
           (0,(Movimenta C),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 75 0)),(Jogador 1 0 0 5 (Chao True))])),
           (0,(Movimenta C),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 75 0)),(Jogador 1 (3.5) 0 5 (Chao True))])),
           (0,(Movimenta B),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 75 0)),(Jogador 0 (3.5) 0 5 (Chao True))])),
           (0,(Movimenta B),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 75 0)),(Jogador 1 0 0 5 (Chao True))])),
           (0,(Movimenta B),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 75 0)),(Jogador 0 (5.5) 0 5 (Chao True))])),
           (0,(Acelera),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 75 0)),(Jogador 1 0 0 5 (Chao True))])),
           (0,(Desacelera),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 75 0)),(Jogador 1 0 0 5 (Chao True))])),
           (1,(Movimenta C),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 75 0)),(Jogador 1 0 0 5 (Chao True))])),
           (1,(Dispara),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 75 0)),(Jogador 1 (10.8) 1 5 (Chao True))])),
           (1,(Movimenta C),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 75 0)),(Jogador 1 (10.8) 1 5 (Chao True))])),
           (1,(Movimenta C),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 75 0)),(Jogador 1 (13.5) 1 5 (Chao True))])),
           (1,(Movimenta B),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 75 0)),(Jogador 0 (10.8) 1 5 (Chao True))])),
           (1,(Dispara),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 75 0)),(Jogador 0 (13.5) 1 5 (Chao True))])),
           (1,(Dispara),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 75 0)),(Jogador 0 (17.5) 1 5 (Chao True))])),
           (1,(Dispara),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 75 0)),(Jogador 0 (13.5) 1 0 (Chao True))])),
           (1,(Movimenta B),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 75 0)),(Jogador 0 (13.5) 1 5 (Chao True))])),
           (1,(Movimenta B),(Estado (gera 3 100 4) [(Jogador 0 0 3 5 (Ar 3 75 0)),(Jogador 1 0 0 5 (Chao True))])),
           (1,(Acelera),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 75 0)),(Jogador 1 0 0 5 (Chao True))])),
           (1,(Desacelera),(Estado (gera 2 100 4) [(Jogador 0 0 3 5 (Ar 3 75 0)),(Jogador 1 0 0 5 (Chao True))]))]

-- * Funções principais da Tarefa 2.

-- | Efetua uma jogada.
jogada :: Int -- ^ O identificador do 'Jogador' que efetua a jogada.,
       -> Jogada -- ^ A 'Jogada' a efetuar.
       -> Estado -- ^ O 'Estado' anterior.
       -> Estado -- ^ O 'Estado' resultante após o jogador efetuar a jogada.

jogada i jogada@(Acelera) estado@(Estado mapa jogadores) =
    let jogador@(Jogador pista distancia velocidade cola estadoJogador) = jogadores!!i
    in if isChao estadoJogador
        then (Estado mapa (atualizaIndiceLista i (Jogador pista distancia velocidade cola (Chao True)) jogadores))
        else estado
jogada i jogada@(Desacelera) estado@(Estado mapa jogadores) =
    let jogador@(Jogador pista distancia velocidade cola estadoJogador) = jogadores!!i
    in if isChao estadoJogador
        then (Estado mapa (atualizaIndiceLista i (Jogador pista distancia velocidade cola (Chao False)) jogadores))
        else estado

jogada i jogada@(Dispara) estado@(Estado m j) =
    let jogador@(Jogador p dist v c eJ) = j!!i
        pAnt = encontraPosicaoMatriz (p, (floor dist) - 1) m
    in if c > 0 && (floor dist) >= 1 && isChao eJ
        then (Estado (atualizaPosicaoMatriz (p, (floor dist) - 1) (putCola pAnt) m) (atualizaIndiceLista i (Jogador p dist v (c-1) eJ) j))
        else estado

jogada i jogada@(Movimenta dir) estado@(Estado mapa jogadores)
    | (dir == D || dir == E) && isAr estadoJogador = inclinarJogador i dir estado
    | (dir == C && isChao estadoJogador && pista /= 0) = moverPista i dir estado
    | (dir == B && isChao estadoJogador && (pista /= length jogadores)) = moverPista i dir estado
    | otherwise = estado
    where jogador@(Jogador pista distancia velocidade cola estadoJogador) = jogadores!!i

-- | Mudar um 'Jogador' de 'Pista'
moverPista :: Int -- ^ O identificador do 'Jogador' que efetua a jogada.
           -> Direcao -- ^ 'Direcao' na qual o 'Jogador' vai mudar de 'Pista'
           -> Estado -- 'Estado' inicial
           -> Estado -- 'Estado' final com o 'Jogador' numa 'Pista' nova
moverPista n C estado@(Estado m j)
    | (-0.2) > difAlturas = (Estado m (atualizaIndiceLista n (Jogador (p-1) dist v c (Ar aPecaAtual (iPeca pecaAtual) 0)) j))
    | difAlturas > 0.2 = (Estado m (atualizaIndiceLista n (Jogador p dist 0 c (Morto 1.0)) j))
    | otherwise = (Estado m (atualizaIndiceLista n (Jogador (p-1) dist v c estadoJogador) j))
    where jogador@(Jogador p dist v c estadoJogador) = j!!n
          pecaAtual = encontraPosicaoMatriz (p, floor dist) m
          pecaCima = encontraPosicaoMatriz (p - 1, floor dist) m
          aPecaCima = getHPeca dist pecaCima
          aPecaAtual = getHPeca dist pecaAtual
          difAlturas = aPecaCima - aPecaAtual
moverPista n B estado@(Estado m j)
    | (-0.2) > difAlturas = (Estado m (atualizaIndiceLista n (Jogador (p+1) dist v c (Ar aPecaAtual (iPeca pecaAtual) 0)) j))
    | difAlturas > 0.2 = (Estado m (atualizaIndiceLista n (Jogador p dist 0 c (Morto 1.0)) j))
    | otherwise = (Estado m (atualizaIndiceLista n (Jogador (p+1) dist v c estadoJogador) j))
    where jogador@(Jogador p dist v c estadoJogador) = j!!n
          pecaAtual = encontraPosicaoMatriz (p, floor dist) m
          pecaBaixo = encontraPosicaoMatriz (p + 1, floor dist) m
          aPecaBaixo = getHPeca dist pecaBaixo
          aPecaAtual = getHPeca dist pecaAtual
          difAlturas = aPecaBaixo - aPecaAtual

-- | Altera a inclinação de um 'Jogador' numa 'Direcao' em certo 'Estado'
inclinarJogador :: Int -- ^ O identificador do 'Jogador' que efetua a jogada.
                -> Direcao -- ^ 'Direcao' na qual o 'Jogador' vai ser inclinado
                -> Estado -- ^ 'Estado' inicial
                -> Estado -- ^ 'Estado' final com o 'Jogador' inclinado
-- Inclinar para a Direita
inclinarJogador n D estado@(Estado mapa j) =
    let jogador@(Jogador p dist v c estadoJogador@(Ar altura i g)) = j!!n
    in if i > (-75)
        then (Estado mapa (atualizaIndiceLista n (Jogador p dist v c (Ar altura (i-15) g)) j))
        else (Estado mapa (atualizaIndiceLista n (Jogador p dist v c (Ar altura (-90) g)) j))
-- Inclinar para a Esquerda
inclinarJogador n E estado@(Estado mapa jogadores) =
    let jogador@(Jogador pista dist v cola estadoJogador@(Ar altura inclinacao g)) = jogadores!!n
    in if inclinacao < 75
        then (Estado mapa (atualizaIndiceLista n (Jogador pista dist v cola (Ar altura (inclinacao+15) g)) jogadores))
        else (Estado mapa (atualizaIndiceLista n (Jogador pista dist v cola (Ar altura (90) g)) jogadores))

-- | Determina a altura de uma determinada 'Peca'
getHPeca :: Double -- ^ Posiçao exata do 'Jogador' na 'Peca'
                -> Peca -- ^ 'Peca' da qual se vai obter a altura
                -> Double -- ^ A altura resultante
getHPeca x (Recta piso a) = fromIntegral a
getHPeca x (Rampa piso a b) = (fromIntegral (b-a))*(snd $ properFraction x) + fromIntegral a

-- | Determina a inclinação de uma determinada 'Peca'
iPeca :: Peca -- ^ 'Peca' da qual se vai obter a inclinação
               -> Double -- ^ A inclinação resultante em graus
iPeca (Recta p a) = 0
iPeca (Rampa p a b) = rad2graus(atan (fromIntegral(b-a)))


-- | Dado um 'EstadoJogador' a funçao determina se o jogador esta no ar ou não
isAr :: EstadoJogador -- ^ 'EstadoJogador' em questão
     -> Bool -- ^ Resultado lógico da função
isAr (Ar _ _ _) = True
isAr _ = False

-- | Dado um 'EstadoJogador' a funçao determina se o jogador esta no chão ou não
isChao :: EstadoJogador -- ^ 'EstadoJogador' em questão
       -> Bool -- ^ Resultado lógico da função
isChao (Chao _) = True
isChao _ = False

-- | Muda o 'Piso' de uma 'Peca' para 'Cola'
putCola :: Peca -- ^ 'Peca' a ser mudada
            -> Peca -- ^ 'Peca' com o 'Piso' com 'Cola'
putCola (Recta piso x) = (Recta Cola x)
putCola (Rampa piso a b) = (Rampa Cola a b)