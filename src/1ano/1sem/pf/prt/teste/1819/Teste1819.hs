module Teste1819 where

import System.Random

-- Exercicio 1.a
uElemIndices :: Eq a => a -> [a] -> [Int]
uElemIndices x l = aux x l 0
    where 
        aux :: Eq a => a -> [a] -> Int -> [Int]
        aux _ [] _ = []
        aux n (h:t) i
            | n == h = i:resto
            | otherwise = resto
            where
                resto = aux n t (i+1)

-- Exercicio 1.b
uIsSubsequenceOf :: Eq a => [a] -> [a] -> Bool
uIsSubsequenceOf [] _ = True
uIsSubsequenceOf _ [] = False
uIsSubsequenceOf l@(h1:t1) (h2:t2)
    | h1 == h2 = uIsSubsequenceOf t1 t2
    | otherwise = uIsSubsequenceOf l t2

-- Exercicio 2
data BTree a
    = Empty
    | Node a (BTree a) (BTree a)

-- Exercicio 2.a
lookupAP :: Ord a => a -> BTree (a,b) -> Maybe b
lookupAP _ Empty = Nothing
lookupAP i (Node (x,y) e d)
    | i == x = Just y
    | i < x = lookupAP i e
    | i > x = lookupAP i d

-- Exercicio 2.b
zipWithBT :: (a -> b -> c) -> BTree a -> BTree b -> BTree c
zipWithBT f = aux
    where
        aux Empty _ = Empty
        aux _ Empty = Empty
        aux p1@(Node n1 e1 d1) p2@(Node n2 e2 d2) =
            (Node (f n1 n2) (aux e1 e2) (aux d1 d2))

-- Exercicio 3


-- Exercicio 4
data Seq a
    = Nil
    | Cons a (Seq a)
    | App (Seq a) (Seq a)
    deriving Show

-- Exercicio 4.a
firstSeq :: Seq a -> a
firstSeq (Cons i _) = i
firstSeq (App (Nil) t) = firstSeq t
firstSeq (App h _) = firstSeq h

-- Exercicio 4.b
dropSeq :: Int -> Seq a -> Seq a
dropSeq n s
    | n == 0 = s
    | otherwise = dropSeq (n-1) (aux s)
    where
        aux :: Seq a -> Seq a
        aux Nil = Nil
        aux (App Nil Nil) = Nil
        aux (Cons _ Nil) = Nil
        aux (Cons _ c) = c
        aux (App (Nil) b) = b
        aux (App a b) = (App (aux a) b)

-- Exercicio 5
type Mat a = [[a]]

-- Exercicio 5.a
getElem :: Mat a -> IO a
getElem mat = 
    do rndLinha <- randomRIO (0, (length mat)-1)
       rndColuna <- randomRIO (0, (length (mat!!0))-1)

       return (mat!!rndLinha!!rndColuna)

-- Exercicio 5.b
magic :: Mat Int -> Bool
magic (h:t) = 