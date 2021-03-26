module Teste1617 where

import Data.Maybe

-- Exercicio 1
type MSet a = [(a,Int)]

-- Exercicio 1.a
cardMSet :: MSet a -> Int
cardMSet [] = 0
cardMSet ((_,i):t) = i + (cardMSet t)

-- Exercicio 1.b
moda :: MSet a -> [a]
moda [] = []
moda ((i,_):t) = i:(moda t)

-- Exercicio 1.c
converteMSet :: MSet a -> [a]
converteMSet [] = []
converteMSet ((x,y):t)
    | y > 0 = x:(converteMSet ((x,y-1):t))
    | otherwise = converteMSet t

-- Exercicio 1.d
--addNcopies :: Eq a => MSet a -> a -> Int -> MSet a
--addNcopies [] z i = [(z,i)]
--addNcopies l@(h@(x,y):t) z i =
--    if elem z (map fst l)
--        then
--            let n1 = lookup z l
--                n2 = n1 + i
--            in
--                if n2 >= y
--                    then (z,n2):l
--                    else h:(addNcopies)
--        else
--            if i >= y
--                then (z,i):l
--                else h:(addNcopies t z i)

addNcopies :: Eq a => MSet a -> a -> Int -> MSet a
addNcopies mset elm num = foldr (\(x,n) -> (:) (x,n + (if x == elm then num else 0))) [] mset

-- Exercicio 2
data SReais
    = AA Double Double
    | FF Double Double
    | AF Double Double
    | FA Double Double
    | Uniao SReais SReais

-- Exercicio 2.a
instance Show SReais where
    show (AA x y) = "]" ++ show x ++ " , " ++ show y ++"["
    show (FF x y) = "[" ++ show x ++ " , " ++ show y ++"]"
    show (AF x y) = "]" ++ show x ++ " , " ++ show y ++"]"
    show (FA x y) = "[" ++ show x ++ " , " ++ show y ++"["
    show (Uniao p u) = "(" ++ show p ++ " U " ++ show u ++ ")"

-- Exercicio 2.b
pertence :: Double -> SReais -> Bool
pertence n (Uniao p u) = (pertence n p) || (pertence n u)
pertence n (AA x y) = x <  n && n <  y
pertence n (FF x y) = x <= n && n <= y
pertence n (FA x y) = x <= n && n <  y
pertence n (AF x y) = x <  n && n <= y

-- Exercicio 3
data RTree a = R a [RTree a]

-- Exercicio 3.a
percorre :: [Int] -> RTree a -> Maybe [a]
percorre [] (R p _) = Just [p]
percorre (h:t) (R p l)
    | length l >= h = Just (p:(fromJust $ percorre t (l!!(h-1))))
    | otherwise = Nothing

-- Exercicio 