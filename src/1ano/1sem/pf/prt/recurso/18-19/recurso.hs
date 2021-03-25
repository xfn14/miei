module Recurso where

-- Exercício 1.a
isSorted :: (Ord a) => [a] -> Bool
isSorted [] = True
isSorted (p:s:xs)
    | p > s = False
    | otherwise = isSorted (s:xs)

-- Exercicio 1.b
inits :: [a] -> [[a]]
inits [] = [[]]
inits [x] = [[x],[]]
inits l@(h:t) =
    [l] ++ (inits t)