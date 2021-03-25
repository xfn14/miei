module Ficha1 where

-- Exercício 1.a
perimetro :: Double -> Double
perimetro raio = 2 * pi * raio

-- Exercício 1.b
dist :: (Double,Double) -> (Double,Double) -> Double
dist (x1,y1) (x2,y2) = sqrt ((x1+x2)^2 + (y1+y2)^2)

-- Exercício 1.c
primUlt :: [a] -> (a,a)
primUlt l = (head l, last l)

-- Exercício 1.d
multiplo :: Int -> Int -> Bool
multiplo m n
    | (m % n) == 0 = True
    | otherwise = False

-- Exercício 1.e
truncaImpar :: [a] -> [a]
truncaImpar l
    | (length l) % 2 == 0 = l
    | otherwise = tail l

-- Exercício 1.f
max2 :: Int -> Int -> Int
max2 x y
    | x > y = x
    | otherwise = y

-- Exercício 1.g
max3 :: Int -> Int -> Int -> Int
max3 x y z  = max2 (max2 x y) z


-- Exercício 2
calcDelta :: Double -> Double -> Double -> Double
calcDelta a b c = b^2 - 4*a*c

-- Exercício 2.a
nRaizes :: Double -> Double -> Double -> Int
nRaizes a b c
    | delta > 0 = 2
    | delta == 0 = 1
    | otherwise = 0
    where 
        delta = calcDelta a b c

-- Exercício 2.b
raizes :: Double -> Double -> Double -> [Double]
raizes a b c
    | numRaizes == 2 =
        [((-b)+delta)/(2*a),
         ((-b)-delta)/(2*a)]
    | numRaizes == 1 =
        [(-b)/(2*a)]
    | otherwise = []
    where 
        delta = calcDelta a b c
        numRaizes = nRaizes a b c


-- Exercício 3
type Hora = (Int,Int)

-- Exercício 3.a
horaValida :: Hora -> Bool
horaValida (h,m)
    | 0 <= h && h <= 23 && 0 <= m && m <= 23 = True
    | otherwise = False

-- Exercício 3.b
fstHora :: Hora -> Hora -> Hora
fstHora hora1@(h1,m1) hora2@(h2,m2)
    | h1 < h2 = hora1
    | h2 > h1 = hora2
    | otherwise =
        if m1 < m2
            then hora1
            else hora2

-- Exercício 3.c
hora2min :: Hora -> Int
hora2min (h,m) = h*60 + m

-- Exercício 3.d
min2hora :: Int -> Hora
min2hora m = (m `div` 60,m % 60)

-- Exercício 3.e
difHora :: Hora -> Hora -> Int
difHora h1 h2 = abs ((hora2min h1) - (hora2min h2))

-- Exercício 3.f
addMin :: Int -> Hora -> Hora
addMin m h = min2hora ((hora2min h) + m)


-- Exercício 4
data HoraD
    = H Int Int
    deriving (Show,Eq)

-- Exercício 4.a
horaValida' :: HoraD -> Bool
horaValida' (H h m)
    | 0 <= h && h <= 23 && 0 <= m && m <= 23 = True
    | otherwise = False

-- Exercício 4.b
fstHora' :: HoraD -> HoraD -> Hora
fstHora' hora1@(H h1 m1) hora2@(H h2 m2)
    | h1 < h2 = hora1
    | h2 > h1 = hora2
    | otherwise =
        if m1 < m2
            then hora1
            else hora2

-- Exercício 4.c
hora2min' :: HoraD -> Int
hora2min' (H h m) = h*60 + m

-- Exercício 4.d
min2hora' :: Int -> HoraD
min2hora' m = H (m `div` 60) (m % 60)

-- Exercício 4.e
difHora' :: HoraD -> HoraD -> Int
difHora' h1 h2 = abs ((hora2min' h1) - (hora2min' h2))

-- Exercício 4.f
addMin' :: Int -> HoraD -> HoraD
addMin' m h = min2hora' ((hora2min' h) + m)


-- Exercício 5
data Semaforo
    = Verde
    | Amarelo
    | Vermelho
    deriving (Show,Eq)

-- Exercício 5.a
next :: Semaforo -> Semaforo
next Verde = Amarelo
next Amarelo = Vermelho
next Vermelho = Verde

-- Exercício 5.b
stop :: Semaforo -> Bool
stop Vermelho = True
stop _ = False

-- Exercício 5.c
safe :: Semaforo -> Semaforo -> Bool
safe s1 s2 = s1 == Vermelho || s2 == Vermelho


-- Exercício 6
data Ponto
    = Cartesiano Double Double
    | Polar Double Double
    deriving (Show,Eq)

-- Exercício 6.a
posx :: Ponto -> Double
posx (Cartesiano x _) = x
posy (Polar r a) = r * (cos a)

-- Exercício 6.b
posy :: Ponto -> Double
posy (Cartesiano _ y) = y
posy (Polar r a) = r * (sin a)

-- Exercício 6.c
raio :: Ponto -> Double
raio (Cartesiano x y) = sqrt (x^2 + y^2)
raio polar =
    raio (Cartesiano x y)
    where
        x = posx polar
        y = posy polar

-- Exercício 6.d
angulo :: Ponto -> Double
angulo (Cartesiano x y)
    | x < 0 = pi + angulo
    | otherwise = angulo
    where
        angulo = atan (y/x)
angulo (Polar _ a) = a