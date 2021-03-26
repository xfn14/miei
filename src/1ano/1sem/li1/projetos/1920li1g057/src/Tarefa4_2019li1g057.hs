-- | Este módulo define funções comuns da Tarefa 4 do trabalho prático.
module Tarefa4_2019li1g057 where

import LI11920
import Tarefa2_2019li1g057
import Tarefa1_2019li1g057
import Tarefa0_2019li1g057
-- * Testes
-- | Testes unitários da Tarefa 4.
-- Cada teste é um par (/tempo/,/'Mapa'/,/'Jogador'/).
testesT4 :: [(Double,Mapa,Jogador)]
testesT4 = [(0.6,(gera 2 10 4),(Jogador 0 0 3 5 (Chao True))), (0.5,(gera 2 10 4),(Jogador 1 1.7 3 5 (Chao True))),
            (0.7,(gera 2 10 4),(Jogador 1 1.7 3 5 (Ar 3 20 1))), (1,(gera 2 10 4),(Jogador 1 2.6 3 5 (Chao True))),
            (0.6,(gera 2 10 4),(Jogador 0 3.5 3 5 (Chao True))), (0.6,(gera 2 10 4),(Jogador 0 0 3 5 (Ar 3 30 1))),
            (0.6,(gera 2 10 4),(Jogador 1 3.1 3 5 (Ar 2 (-35) 1)))]

-- * Funções principais da Tarefa 4.
resistenciaAr = 0.125
accelGravidade = 1

-- | Avança o estado de um 'Jogador' um 'passo' em frente, durante um determinado período de tempo.
passo :: Double -- ^ O tempo decorrido.
     -> Mapa    -- ^ O mapa utilizado.
     -> Jogador -- ^ O estado anterior do 'Jogador'.
     -> Jogador -- ^ O estado do 'Jogador' após um 'passo'.
passo t m j = move t m (acelera t m j)

-- | Altera a velocidade de um 'Jogador', durante um determinado período de tempo.
acelera :: Double -- ^ O tempo decorrido.
     -> Mapa    -- ^ O mapa utilizado.
     -> Jogador -- ^ O estado anterior do 'Jogador'.
     -> Jogador -- ^ O estado do 'Jogador' após acelerar.
acelera tempo mapa jogador@(Jogador pista distancia velocidade cola estado@(Chao accelJogador)) =
    let velocidadeNova = velocidade + (accelMota - (getAtrito peca) * velocidade)*tempo
        accelMota = if (velocidade < 2 && accelJogador) then 1 else 0
        peca = mapa!!pista!!(floor distancia)
    in (Jogador pista distancia (if velocidadeNova <= 0 then 0 else velocidadeNova) cola estado)
acelera tempo mapa jogador@(Jogador pista distancia velocidade cola estado@(Ar altura inclinacao gravidade)) =
    let velocidadeNova = velocidade - (resistenciaAr * velocidade * tempo)
        gravidadeNova = gravidade + accelGravidade * tempo
    in (Jogador pista distancia (if velocidadeNova <= 0 then 0 else velocidadeNova) cola (Ar altura inclinacao gravidadeNova))
acelera _ _ j = j

-- | Altera a posição de 'Jogador', durante um determinado período de tempo.
move :: Double -- ^ O tempo decorrido.
     -> Mapa    -- ^ O mapa utilizado.
     -> Jogador -- ^ O estado anterior do 'Jogador'.
     -> Jogador -- ^ O estado do 'Jogador' após se movimentar.
move tempo mapa jogador@(Jogador p dist v c estado@(Morto timeout))
    | (timeout - tempo) > 0 = (Jogador p dist v c (Morto (timeout - tempo)))
    | otherwise = (Jogador p dist 0 c (Chao False))

move tempo mapa jogador@(Jogador p dist v c estado@(Chao acelera))
    | mudaPeca && (iPecaSe >= iPecaA) = (Jogador p (fromIntegral $ (floor (dist+1))) v c estado)
    | mudaPeca && (iPecaSe < iPecaA) = (Jogador p (fromIntegral $ (floor (dist+1))) v c (Ar (getHPeca 0 pecaSe) iPecaA 0))
    | otherwise = (Jogador p distNova v c estado)
    where distNova = v * tempo + dist
          distPecaSeguinte = (floor (dist + 1))
          mudaPeca = (floor dist) /= (floor distNova)
          pecaAtual = mapa!!p!!(floor dist)
          pecaSe = mapa!!p!!(distPecaSeguinte)
          iPecaA = iPeca pecaAtual
          iPecaSe = iPeca pecaSe

move tempo mapa jogador@(Jogador p dist v c e@(Ar h i g))
    | mudaPeca && (distPercAr > hPecaSeguinte) = (Jogador p (fromIntegral $ floor (dist+1)) v c (Ar distPercAr i g))
    | mudaPeca && (distPercAr <= hPecaSeguinte) = (Jogador p (fromIntegral $ floor (dist+1)) v c (Ar distPercAr i g))
    | (not mudaPeca) && (distPercAr > hPecaAtual) = (Jogador p (dist + distX) v c (Ar distPercAr i g))
    | (not mudaPeca) && (distPercAr <= hPecaAtual) && (ifMorre) = (Jogador p distNova 0 c (Morto 1.0))
    | otherwise = (Jogador p distNova v c (Chao False))
    where distNova = v * tempo + dist
          distPecaSeguinte = (floor (dist + 1))
          mudaPeca = floor dist /= floor distNova
          pecaAtual = mapa!!p!!(floor dist)
          pecaSeguinte = mapa!!p!!(distPecaSeguinte)
          hPecaSeguinte = getHPeca 0 pecaSeguinte
          hPecaAtual = getHPeca (snd(properFraction dist)) pecaAtual
          iPecaAtual = iPeca pecaAtual
          ifMorre = (i-iPecaAtual) >= 45
          distX = v * tempo * cos ( i * pi / 180)
          distY = v * tempo * sin ( i * pi / 180)
          distPercAr = h + distY - g*tempo


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