module Tester where

d1 :: Dinheiro
d1 = (D 10 99)    

d2 :: Dinheiro
d2 = (D 10 27)   

d3 :: Dinheiro
d3 = (D 2 2)

data Dinheiro = 
    D Int Int
    deriving(Show, Eq) -- Para o ghci conseguir mostrar no terminal a data.
adicionaDinheiro :: Dinheiro -- ^ Dinheiro a acrescentar
                 -> Dinheiro -- ^ Dinheiro Base
                 -> Dinheiro -- ^ Dinheiro Final
adicionaDinheiro (D e1 c1) (D e2 c2) =
    if (c1+c2) >= 100
    then (D (e1+e2+1) (c1+c2-100))
    else (D (e1+e2) (c1+c2))