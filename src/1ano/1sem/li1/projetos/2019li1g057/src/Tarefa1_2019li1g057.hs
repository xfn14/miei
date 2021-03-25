{-|
Module      : Tarefa1_2019li1g057
Description : Este módulo define funções comuns da Tarefa 1 do trabalho prático.
Copyright   : André Vaz <a93221@alunos.uminho.pt;
              Ricardo Lopes <a93195@alunos.uminho.pt>
-}

-- Este módulo define funções comuns da Tarefa 2 do trabalho prático.
module Tarefa1_2019li1g057 where

import LI11920
import System.Random
import Data.List.Split

-- * Testes

-- | Testes unitários da Tarefa 1.
--
-- Cada teste é um triplo (/número de 'Pista's/,/comprimento de cada 'Pista' do 'Mapa'/,/semente de aleatoriedades/).
testesT1 :: [(Int,Int,Int)]
testesT1 = [(2,5,1),(2,100,4),(3,50,10),(6,70,4),(4,100,3),(4,1,5)]

-- * Funções pré-definidas da Tarefa 1.

-- | Gera uma lista de números aleatórios
geraAleatorios :: Int -- ^ Número de elementos que se pertende formar
               -> Int -- ^ Semente de aleatoriedade
               -> [Int] -- ^ Lista de números aleatórios
geraAleatorios n seed = take n (randomRs (0,9) (mkStdGen seed))

-- * Funções principais da Tarefa 1.

-- | Esta função gera um 'Mapa', fornecendo o
-- | /número de 'Pista's/,/comprimento de cada 'Pista' do 'Mapa'/ e uma /semente de aleatoriedades/
gera :: Int -- ^ Número de 'Pista's
     -> Int -- ^ Comprimento da 'Pista'
     -> Int -- ^ Semente da 'Pista'
     -> Mapa -- ^ 'Mapa' resultante
gera npistas comprimento semente =
    let l = chunksOf (comprimento-1) (parsePairs (geraAleatorios (npistas*comprimento*2-npistas*2) semente))
    in if comprimento == 1 && npistas > 0
        then [[Recta Terra 0]] ++ (gera (npistas-1) comprimento semente)
        else map ((Recta Terra 0):) (map (geraPista (Recta Terra 0)) l)

-- | Gerador de 'Pista's
geraPista :: Peca -- ^ 'Peca' anterior à que está a ser formada recursivamente
          -> [(Int,Int)] -- ^ Lista de gamas de cada 'Peca' da 'Pista'
          -> Pista -- 'Pista' resultante
geraPista _ [] = []
geraPista p ((f,s):t) = (geraPeca s (geraPiso f p) p):(geraPista (geraPeca s (geraPiso f p) p) t)

-- | Gerador de 'Peca's
geraPeca :: Int -- ^ Gama do tipo de 'Peca'
         -> Piso -- ^ 'Piso' da 'Peca' a ser formada
         -> Peca -- ^ 'Peca' anterior à que está a ser formada
         -> Peca -- ^ 'Peca' resultante
geraPeca i p1 (Recta p2 x) =
    if 6 <= i && i <= 9
        then (Recta p1 x)
        else if 2 <= i && i <= 5
                then if x-i+1 > 0
                        then (Rampa p1 x (x-i+1))
                        else if x == 0
                            then (Recta p1 0)
                            else (Rampa p1 x 0)
            else (Rampa p1 x (x+i+1))
geraPeca i p1 (Rampa p2 x y) =
    if 6 <= i && i <= 9
        then (Recta p1 y)
        else if 2 <= i && i <= 5
                    then if y-i+1 > 0
                            then (Rampa p1 y (y-i+1))
                            else if y == 0
                                then (Recta p1 0)
                                else (Rampa p1 y 0)
            else (Rampa p1 y (y+i+1))
-- | Gerador de 'Piso's
geraPiso :: Int -- ^ Gama do 'Piso'
         -> Peca -- ^ 'Peca' anterior à que está a ser formada
         -> Piso -- ^ 'Piso' resultante
geraPiso x (Recta p t) | x == 0 || x == 1 = Terra
                       | x == 2 || x == 3 = Relva
                       | x == 4 = Lama
                       | x == 5 = Boost
                       | otherwise = p
geraPiso x (Rampa p t y) | x == 0 || x == 1 = Terra
                         | x == 2 || x == 3 = Relva
                         | x == 4 = Lama
                         | x == 5 = Boost
                         | otherwise = p

-- | Função que transforma uma lista (na qual o seu comprimento é par)
-- | em pares de números
parsePairs :: [a] -- ^ Lista solta
           -> [(a,a)] -- ^ Lista em pares de números
parsePairs [] = []
parsePairs (f:s:t) = (f,s):(parsePairs t)