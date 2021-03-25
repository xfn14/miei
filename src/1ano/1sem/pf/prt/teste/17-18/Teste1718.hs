module Teste1718 where

-- Exercicio 1
insert :: Ord a => a -> [a] -> [a]
insert i [] = [i]
insert i l@(h:t)
    | i <= h  = i:l
    | otherwise = h:(insert i t)

-- Exercicio 2
catMaybes :: [Maybe a] -> [a]
catMaybes [] = []
catMaybes ((Just i):t) = i:(catMaybes t)
catMaybes ((Nothing):t) = catMaybes t

-- Exercicio 3
data Exp a
    = Const a
    | Var String
    | Mais (Exp a) (Exp a)
    | Mult (Exp a) (Exp a)

instance Show a => Show (Exp a) where
    show (Const x) = show x
    show (Var y) = y
    show (Mais t b) = "(" ++ show t ++ " + " ++ show b ++ ")"
    show (Mult t b) = "(" ++ show t ++ " * " ++ show b ++ ")"

-- Exercicio 4
sortOn :: Ord b => (a -> b) -> [a] -> [a]
sortOn _ [] = []
sortOn f (h:t) =
    let
        pq = sortOn f [a | a <- t, (f a) <= (f h)]
        gd = sortOn f [a | a <- t, (f a) > (f h)]
    in pq ++ [h] ++ gd

-- Exercicio 5.a
amplitude:: [Int] -> Int
amplitude [] = 0
amplitude (h:t)
    = aux h 0 t
    where
        aux :: Int -> Int -> [Int] -> Int
        aux pq gd [] = gd - pq
        aux pq gd (h:t)
            | h < pq = aux h gd t
            | h > gd = aux pq h t
            | otherwise = aux pq gd t

-- Exercicio 6
data Imagem
    = Quadrado Int
    | Mover (Int,Int) Imagem
    | Juntar [Imagem]

-- Exercicio 6.a
conta :: Imagem -> Int
conta (Quadrado _) = 1
conta (Mover _ i) = conta i
conta (Juntar (h:t)) = foldr (+) (conta h) (map conta t)

-- Exercicio 6.b
apaga :: Imagem -> IO Imagem
apaga i =
    do  rnd <- randomIO (1,)