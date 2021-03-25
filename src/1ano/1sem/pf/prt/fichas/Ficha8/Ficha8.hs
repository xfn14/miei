module Ficha8 where

-- Exercicio 1
data Frac = F Integer Integer

-- Exercicio 1.a
normaliza :: Frac -> Frac
normaliza (F a b) =
    (F (a `div` m) (b `div` m))
    where m = mdc a b

mdc :: Integer -> Integer -> Integer
mdc a b = last [n | n <- [1..(min a b)], a `mod` n == 0, b `mod` n == 0]

-- Exercicio 1.b
instance Eq Frac where
    (F a b) == (F c d) = (a*d) == (c*b)
    (F a b) /= (F c d) = (a*d) /= (c*b)

-- Exercicio 1.c
instance Ord Frac where
    (F a b) `compare` (F c d) = (a*d) `compare` (c*b)

-- Exercicio 1.d
instance Show Frac where
    show (F x y) = "(" ++ show x ++ " / " ++ show y ++ ")"

-- Exercicio 1.e
instance Num Frac where
    (F a b) + (F c d)
        | b == d = normaliza $ (F (a + c) b)
        | otherwise = normaliza $ (F (a*d + b*c) (b*d))
    x - y = x + negate y
    (F a b) * (F c d) = F (a*c) (b*d)
    negate (F a b) = F (-a) b
    abs (F a b) = F (abs a) (abs b)
    signum (F a b)
        | a == 0 = 0
        | a * b > 0 = 1
        | otherwise = (-1)
    fromInteger x = F x 1

-- Exercicio 1.f
dobroFrac :: Frac -> [Frac] -> [Frac]
dobroFrac _ [] = []
dobroFrac f@(F x y) (h:t) =
    let
        dobro = normaliza (F (x*2) (y))
        hNorm = normaliza h
        resto = dobroFrac f t
    in
        if hNorm >= dobro
            then h:resto
            else resto

-- Exercicio 2
data Exp a
    = Const a
    | Simetrio (Exp a)
    | Mais (Exp a) (Exp a)
    | Menos (Exp a) (Exp a)
    | Mult (Exp a) (Exp a)

-- Exercicio 2.a
instance Show a => Show (Exp a) where
    show (Const x) = show x -- (Const 1) = "1"
    show (Simetrico x) = "-" ++ show x -- (Simetrio (Const 1)) = "-1"
    show (Mais x y) = "(" ++ show x ++ " + " ++ show y ++ ")" -- (Mais (Const 1) (Const 2)) = "(1 + 2)"
    show (Menos x y) = "(" ++ show x ++ " - " ++ show y ++ ")" -- (Menos (Const 1) (Const 2)) = "(1 - 2)"
    show (Mult x y) = show x ++ " * " ++ show y -- (Mult (Const 1) (Const 2)) = "1 * 2"