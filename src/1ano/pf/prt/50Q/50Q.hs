{-|
Module      : Cinquenta
Description : Resolução das 50 questões para PF
License     : MIT
Maintainer  : me@andreubita.com
-}

module Cinquenta where

-- * Exercício 1
myEnumFromTo :: Int -- Elemento inicial da lista
             -> Int -- Elemento final da lista
             -> [Int] -- Lista resultante
myEnumFromTo x y =
    if x == y then [x]
    else x:myEnumFromTo (x+1) y

-- * Exercício 2
myEnumFromThenTo :: Int -- Primeiro elemento da lista
                 -> Int -- Segundo elemento da lista. Marca o espaço entre os números
                 -> Int -- Elemento final
                 -> [Int] -- Lista resultante
myEnumFromThenTo x y z =
    if x >= z then [x | x == z] -- Caso 'x == z' devolve lista [x] senao devolve lista vazia
    else x:myEnumFromThenTo y (2*y-x) z

-- * Exercício 3
myConcat :: [a] -- Primeira lista
         -> [a] -- Segunda lista
         -> [a] -- Lista unida
myConcat [] l = l
myConcat (h:t) l =
    h:myConcat t l

-- * Exercício 4
myGetElem :: [a]
          -> Int
          -> a
myGetElem [] _ = errorWithoutStackTrace "Invalid list. (List is empty)"
myGetElem (h:t) n =
    if n <= 0 then
        if n == 0 then h
        else error "Invalid index."
    else myGetElem t (n-1)

-- * Exercício 5
myReverse :: [a]
          -> [a]
myReverse (h:t) =
    myReverse t ++ [h]
