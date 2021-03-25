{-|
Module      : Tarefa3_2019li1g057
Description : Este módulo define funções comuns da Tarefa 3 do trabalho prático.
Copyright   : André Vaz <a93221@alunos.uminho.pt;
              Ricardo Lopes <a93195@alunos.uminho.pt>

= Introdução

Na Tarefa 3, tivemos de encontrar uma forma de fornecer instrucoes aos bulldozers de maneira a que as instruçoes
coincidissem com o mapa fornecido, tentando minimizar sempre o numero de instruçoes atraves de padroes.

= Objetivos

Tivemos o proposito de encontrar padroes de forma a minimizar o numero de instrucoes, começamos por transformar
pecas em instruçoes, pistas em instruçoes e por fim o mapa numa lista de listas de instruçoes.
De seguida, procuramos por tentar comprimir as instruçoes encontrando padroes horizontais com ajuda de funcoes
predifinidas que foram estudadas nas aulas. Entao, com sucesso concluimos os padroes horizontais e apliamo-los
na funçao principal. Por fim, tentamos comprimir as intruçoes atraves dos padroes verticais e desfasados
mas sem sucesso pois davam demasiados erros, entao resolvemos focar-nos nas outras tarefas e ficamos pelos padroes
horizontais.

= Discussão e conclusão

Em retrospetiva, acreditamos que fizemos o melhor que conseguiamos com o nosso conhecimento da linguagem, apesar
de terem faltado dois pontos importantes sobre a tarefa que nao conseguimos resolver. Por outro lado, a nossa Tarefa 1
e Tarefa 2 ficaram quase perfeitas sendo assim o nosso foco e esforço para as mesmas justificado.
-}
-- Este módulo define funções comuns da Tarefa 3 do trabalho prático.
module Tarefa3_2019li1g057 where

import LI11920
import Tarefa0_2019li1g057
import Tarefa1_2019li1g057
import Data.List

-- * Testes

-- | Testes unitários da Tarefa 3.
--
-- Cada teste é um 'Mapa'.
testesT3 :: [Mapa]
testesT3 = [(gera 2 20 134),(gera 3 15 39),(gera 2 5 10),(gera 2 50 5),(gera 5 60 3),(gera 5 15 3),
            (gera 3 100 9),(gera 7 30 13)]

-- * Funções principais da Tarefa 3.

-- | Desconstrói um 'Mapa' numa sequência de 'Instrucoes'.
--
-- __NB:__ Uma solução correcta deve retornar uma sequência de 'Instrucoes' tal que,
-- para qualquer mapa válido 'm', executar as instruções '(desconstroi m)' produza o mesmo mapa 'm'.
--
-- __NB:__ Uma boa solução deve representar o 'Mapa' dado no mínimo número
-- de 'Instrucoes', de acordo com a função 'tamanhoInstrucoes'.
desconstroi :: Mapa -- ^ Mapa gerado
            -> Instrucoes -- ^ Lista de 'Instrucoes' para desconstruir o mapa
desconstroi mapa = instrucoesRepetidasH $ juntarPistas $ mapa2instrucoes (map (drop 1) mapa) 0


-- | Funcao que diminui o numero de instrucoes atraves de padroes horizontais
instrucoesRepetidasH :: Instrucoes -- ^ Lista de instruçoes a comprimir
                     -> Instrucoes -- ^ Lista de instruçoes comprimida
instrucoesRepetidasH [x] = [x]
instrucoesRepetidasH ((Repete n repInst):ins2@(Repete n2 repInst2):r)
    | (length (intersect repInst repInst2) == (length repInst)) = instrucoesRepetidasH ((Repete (n+n2) repInst):r)
    | otherwise = (Repete n repInst):(instrucoesRepetidasH (ins2:r))
instrucoesRepetidasH ((Repete n repInst):ins2:r)
    | elem ins2 repInst = instrucoesRepetidasH ((Repete (n+1) repInst):r)
    | otherwise = (Repete n repInst):(instrucoesRepetidasH (ins2:r))
instrucoesRepetidasH (ins1:ins2:r)
    | ins1 == ins2 = instrucoesRepetidasH ((Repete 2 [ins1]):r)
    | otherwise = ins1:(instrucoesRepetidasH (ins2:r))

-- | Transforma as pistas numa lista de 'Instrucoes'
mapa2instrucoes :: Mapa -- ^ Mapa constituido pelas varias pistas
                -> Int  -- ^ Indicador da 'Pista'
                -> [Instrucoes] -- ^ Lista de 'Instrucoes' final
mapa2instrucoes [] _ = []
mapa2instrucoes mapa@(pista1:t) n = (pista2instrucoes pista1 n):(mapa2instrucoes t (n+1))

-- | Transforma as pecas de uma pista em 'Instrucoes'
pista2instrucoes :: Pista -- ^ Pista a converter em 'Instrucoes'
                 -> Int -- ^ Indicador da 'Pista'
                 -> Instrucoes -- ^ Lista com as 'Instrucoes' para a pista
pista2instrucoes [] _ = []
pista2instrucoes pista@(peca:t) npista = (peca2instrucao peca npista):(pista2instrucoes t npista)

-- | Transforma cada peca de uma pista numa 'Instrucao'
peca2instrucao :: Peca -- ^ Peca para converter em 'Instrucao'
               -> Int  -- ^ Indicador da 'Pista'
               -> Instrucao -- ^ 'Instrucao' para a peca desejada
peca2instrucao peca@(Recta piso x) npista = (Anda [npista] piso)
peca2instrucao peca@(Rampa piso x y) npista
    | y > x = (Sobe [npista] piso (y-x))
    | otherwise = (Desce [npista] piso (x-y))
    | otherwise = (Desce [npista] piso (x-y))
    | otherwise = (Desce [npista] piso (x-y))

-- | Junta 'Pista's do 'Mapa'
juntarPistas :: [[a]] -- ^ 'Mapa' com 'Pista's em listas
             -> [a] -- ^ 'Mapa' com as 'Pista's separadas
juntarPistas [] = []
juntarPistas (h:t) = h ++ (juntarPistas t)
