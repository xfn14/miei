{- |
= Introdução

Na Tarefa 6 temos um funçao que define a jogada que o bot vai realizar de acordo com o Estado atual

= Objetivos

O que o bot está a realizar é detetar qual a 'Pista' que tem menos atrito geral movendo-se logo de
inicio para ela onde depois apenas 'Acelera' sempre em frente até chegar a meta ou o jogo acabar.

= Discussão e conclusão
É um bot simples porque ja nao tinhamos muito tempo para o fazer sendo que mesmo assim é eficaz.
-}

-- Este módulo define funções comuns da Tarefa 6 do trabalho prático.
module Tarefa6_2019li1g057 where

import LI11920

-- * Funções principais da Tarefa 6.

-- | Define um ro'bot' capaz de jogar autonomamente o jogo.
bot :: Int          -- ^ O identificador associado ao ro'bot'.
    -> Estado       -- ^ O 'Estado' para o qual o ro'bot' deve tomar uma decisão.
    -> Maybe Jogada -- ^ Uma possível 'Jogada' a efetuar pelo ro'bot'.
bot i (Estado mapa jogadores) =
    let ((p,u):s) = zip (map atritoPista mapa) [0..]
        melhorPista :: Double -> Int -> [(Double,Int)] -> Int
        melhorPista _ i1 [] = i1
        melhorPista t1 i1 ((t2,i2):t)
            | t2 < t1 = melhorPista t2 i2 t
            | otherwise = melhorPista t1 i1 t
        bp = melhorPista p u s
        (Jogador pista _ _ _ _) = jogadores!!i
    in
        if bp == pista
            then Just Acelera
            else
                if bp < pista
                    then Just (Movimenta C)
                    else Just (Movimenta B)

-- | Determina o atrito total de uma pista
atritoPista :: Pista -- ^ 'Pista' da qual se quer determinar o atrito total
            -> Double -- ^ O atrito total relativo a 'Pista'
atritoPista [] = 0
atritoPista (h:t) = getAtrito h + atritoPista t

-- | Determina o atrito de uma determinada 'Peca'
getAtrito :: Peca -- ^ 'Peca' da qual se vai obter o atrito
          -> Double -- ^ O atrito relativo ao piso da 'Peca'
getAtrito (Recta piso _)
    | piso == Terra = 0.25
    | piso == Relva = 0.75
    | piso == Lama = 1.50
    | piso == Boost = (-0.50)
    | otherwise = 3.00
getAtrito (Rampa piso _ _)
    | piso == Terra = 0.25
    | piso == Relva = 0.75
    | piso == Lama = 1.50
    | piso == Boost = (-0.50)
    | otherwise = 3.00