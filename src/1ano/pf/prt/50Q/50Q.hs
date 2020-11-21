{-|
Module      : Cinquenta
Description : Resolução das 50 questões para PF
License     : MIT
Maintainer  : me@andreubita.com
-}

module Cinquenta where

-- * Exercício 1
-- >>> myEnumFromTo 2 8
-- [2,3,4,5,6,7,8]
myEnumFromTo :: Int -- Elemento inicial da lista
             -> Int -- Elemento final da lista
             -> [Int] -- Lista resultante
myEnumFromTo x y =
    if x == y then [x]
    else x:myEnumFromTo (x+1) y

-- * Exercício 2
-- >>> myEnumFromThenTo 1 3 11
-- [1,3,5,7,9,11]
myEnumFromThenTo :: Int -- Primeiro elemento da lista
                 -> Int -- Segundo elemento da lista. Marca o espaço entre os números
                 -> Int -- Elemento final
                 -> [Int] -- Lista resultante
myEnumFromThenTo x y z =
    if x >= z then [x | x == z] -- Caso 'x == z' devolve lista [x] senao devolve lista vazia
    else x:myEnumFromThenTo y (2*y-x) z

-- * Exercício 3
-- >>> myConcat [1,2,3] [4,5,6]
-- [1,2,3,4,5,6]
myConcat :: [a] -- Primeira lista
         -> [a] -- Segunda lista
         -> [a] -- Lista unida
myConcat [] l = l
myConcat (h:t) l =
    h:myConcat t l

-- * Exercício 4
-- >>> myGetElem [1,2,3,4] 1
-- 2
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
-- >>> myReverse [1,2,3,4,5]
-- [5,4,3,2,1]
myReverse :: [a] -- ^ Lista para inverter
          -> [a] -- ^ Lista inversa
myReverse [] = []
myReverse (h:t) =
    myReverse t ++ [h]

-- * Exercício 6
-- >>> myTake 2 [1,2,3]
-- [1,2]
myTake :: Int -- ^ Numero de elementos a pegar
       -> [a] -- ^ Lista de onde pegar os elementos
       -> [a] -- ^ Primeiros n elemento da lista
myTake _ [] = []
myTake n (h:t) =
    if n <= 0 then []
    else h:myTake (n-1) t

-- * Exercício 7
-- >>> myDrop 2 [1,2,3,4,5]
-- [3,4,5]
myDrop :: Int -- ^ Numero de elementos a remover
       -> [a] -- ^ Lista de onde remover os elementos
       -> [a] -- ^ Lista sempre os primeiros n elementos
myDrop _ [] = []
myDrop n (_:t) =
    if n == 1 then t
    else myDrop (n-1) t

-- * Exercício 8
-- >>> myZip [1,2,3] [10,20,30,40]
-- [(1,10),(2,20),(3,30)]
-- >>> myZip [1,2,3,4] [10,20,30]
-- [(1,10),(2,20),(3,30)]
myZip :: [a] -- ^ Lista com os elementos da esquerda 
      -> [b] -- ^ Lista com os elementos da direita
      -> [(a,b)] -- ^ Lista com os pares gerados das duas listas
myZip [] _ = []
myZip _ [] = []
myZip (h1:t1) (h2:t2) =
    (h1,h2):myZip t1 t2

-- * Exercício 9
-- >>> myElem 20 [10,20,30]
-- True
-- >>> myElem 2 [10,20,30]
-- False
myElem :: Eq a 
       => a -- ^ Elemento para ver se existe na lista
       -> [a] -- ^ Lista com os elementos
       -> Bool
myElem _ [] = False
myElem n (h:t) =
    if n == h then True
    else myElem n t
-- >>> myElem' 2 [1,2,3]
-- True
myElem' :: Eq a 
        => a 
        -> [a]
        -> Bool
myElem' _ [] = False
myElem' n (h:t) = n == h || myElem' n t

-- * Exercício 10
-- >>> myReplicate 3 10
-- [10,10,10]
myReplicate :: Int -- ^ Numero de vezes para colocar o elemento
            -> a -- ^ Elemento a colocar
            -> [a] -- ^ Lista resultante
myReplicate n x =
    if n == 0 then []
    else x:myReplicate (n-1) x

-- * Exercício 11
-- >>> myIntersperce 1 [10,20,30]
-- [10,1,20,1,30]
myIntersperce :: a -- ^ Elemento para colocar no meio
              -> [a] -- ^ Lista para ser colocado o elemento
              -> [a] -- ^ Lista resultante
myIntersperce _ [] = []
myIntersperce _ [x] = [x]
myIntersperce n (h:t) = [h,n] ++ myIntersperce n t

-- * Exercício 12
-- >>> myGroup [1,2,2,3,4,4,4,5,4]
-- [[1],[2,2],[3],[4,4,4],[5],[4]]
myGroup :: Eq a 
        => [a] -- ^ Lista desagrupada
        -> [[a]] -- ^ Lista agrupada
myGroup [] = []
myGroup (h:t) =
    (h:takeWhile (==h) t):(myGroup $ dropWhile (== h) t)

-- * Exercício 13
-- >>> myConcat' [[1],[2,2],[3],[4,4,4],[5],[4]]
-- [1,2,2,3,4,4,4,5,4]
myConcat' :: [[a]]
         -> [a]
myConcat' [] = []
myConcat' (h:t) = h ++ myConcat' t

-- * Exercício 14
-- >>> myInits [11,21,13]
-- [[],[11],[11,21],[11,21,13]]
myInits :: [a]
        -> [[a]]
myInits [] = [[]]
myInits l = (myInits $ init l) ++ [l]

-- * Exercício 15
-- >>> myTails [1,2,3]
-- [[1,2,3],[2,3],[3],[]]
myTails :: [a]
        -> [[a]]
myTails [] = [[]]
myTails l@(_:t) = [l] ++ (myTails t)