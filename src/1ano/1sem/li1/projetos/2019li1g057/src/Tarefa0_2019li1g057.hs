-- | Este mÃ³dulo define funÃ§Ãµes genÃ©ricas sobre vetores e matrizes, que serÃ£o Ãºteis na resoluÃ§Ã£o do trabalho prÃ¡tico.
module Tarefa0_2019li1g057 where

import Data.Fixed

-- * FunÃ§Ãµes nÃ£o-recursivas.

-- | Um ponto a duas dimensÃµes dado num referencial cartesiado (distÃ¢ncias aos eixos vertical e horizontal)
--
-- <<http://li1.lsd.di.uminho.pt/images/cartesiano.png cartesisano>>
-- , ou num referencial polar (distÃ¢ncia Ã  origem e Ã¢ngulo do respectivo vector com o eixo horizontal).
--
-- <<http://li1.lsd.di.uminho.pt/images/polar.png polar>>
data Ponto = Cartesiano Double Double | Polar Double Angulo deriving Show

-- | Um Ã¢ngulo em graus.
type Angulo = Double

-- ** FunÃ§Ãµes sobre vetores

-- | Um 'Vetor' na representaÃ§Ã£o escalar Ã© um 'Ponto' em relaÃ§Ã£o Ã  origem.
type Vetor = Ponto
-- ^ <<http://li1.lsd.di.uminho.pt/images/vetor.png vetor>>

-- *** FunÃ§Ãµes gerais sobre 'Vetor'es.

-- | Converter Polar para Cartesiano
polar2cart :: Vetor -> Vetor
polar2cart (Polar r a) = Cartesiano(r*(cos $ graus2rad a))(r*(sin $ graus2rad a))
polar2cart c@(Cartesiano _ _) = c
-- | Converter radianos em graus
rad2graus :: Double -> Double
rad2graus r = r *(180/pi)

-- | Converter graus em radianos
graus2rad :: Double -> Double
graus2rad g = g*(pi/180)

-- | Converter um vetor cartesiano num vetor polar
cart2polar :: Vetor -> Vetor
cart2polar (Cartesiano x y) = Polar (sqrt (x^2+y^2))(atan (y / x))
cart2polar p@(Polar r a) = p

-- | Soma dois 'Vetor'es.
somaVetores :: Vetor -> Vetor -> Vetor
somaVetores (Cartesiano x1 y1) (Cartesiano x2 y2) = Cartesiano (x1 + x2) (y1 + y2)
somaVetores p1 p2 = somaVetores (polar2cart p1) (polar2cart p2)

-- | Subtrai dois 'Vetor'es.
subtraiVetores :: Vetor -> Vetor -> Vetor
subtraiVetores (Cartesiano x1 y1) (Cartesiano x2 y2) = Cartesiano (x1 - x2) (y1 - y2)
subtraiVetores p1 p2 = subtraiVetores (polar2cart p1) (polar2cart p2)

-- | Multiplica um escalar por um 'Vetor'.
multiplicaVetor :: Double -> Vetor -> Vetor
multiplicaVetor x (Cartesiano x1 x2) = Cartesiano (x*x1) (x*x2)
multiplicaVetor x p = multiplicaVetor x (polar2cart p)

-- ** FunÃ§Ãµes sobre rectas.

-- | Um segmento de reta Ã© definido por dois pontos.
type Reta = (Ponto,Ponto)

-- | Testar se dois segmentos de reta se intersetam.
--
-- __NB:__ Aplique as equaÃ§Ãµes matemÃ¡ticas bem conhecidas, como explicado por exemplo em <http://www.cs.swan.ac.uk/~cssimon/line_intersection.html>.
intersetam :: Reta -> Reta -> Bool
intersetam ((Cartesiano x1 y1), (Cartesiano x2 y2)) ((Cartesiano x3 y3), (Cartesiano x4 y4)) =
    let ta = ((y3-y4)*(x1-x3) + (x4-x3)*(y1-y3))/d
        tb = ((y1-y2)*(x1-x3) + (x2-x1)*(y1-y3))/d
        d = (x4-x3)*(y1-y2) - (x1-x2)*(y4-y3)
    in (0.0 <= ta && ta <= 1.0) && (0.0 <= tb && tb <= 1.0)
intersetam (p1,p2) (p3,p4) = intersetam (polar2cart p1, polar2cart p2) (polar2cart p3, polar2cart p4)

-- | Calcular o ponto de intersecao entre dois segmentos de reta.
--
-- __NB:__ Aplique as equaÃ§Ãµes matemÃ¡ticas bem conhecidas, como explicado por exemplo em <http://www.cs.swan.ac.uk/~cssimon/line_intersection.html>.
intersecao :: Reta -> Reta -> Ponto
intersecao ((Cartesiano x1 y1), (Cartesiano x2 y2)) ((Cartesiano x3 y3), (Cartesiano x4 y4)) =
    if intersetam ((Cartesiano x1 y1), (Cartesiano x2 y2)) ((Cartesiano x3 y3), (Cartesiano x4 y4))
        then let ta = ((y3-y4)*(x1-x3) + (x4-x3)*(y1-y3))/((x4-x3)*(y1-y2) - (x1-x2)*(y4-y3))
             in somaVetores (Cartesiano x1 y1) (multiplicaVetor ta (subtraiVetores (Cartesiano x2 y2) (Cartesiano x1 y1)))
        else error "As retas nao se intersetam."
intersecao (p1,p2) (p3,p4) = intersecao (polar2cart p1, polar2cart p2) (polar2cart p3, polar2cart p4)

-- ** FunÃ§Ãµes sobre listas

-- *** FunÃ§Ãµes gerais sobre listas.
--
-- FunÃ§Ãµes nÃ£o disponÃ­veis no 'Prelude', mas com grande utilidade.

-- | Verifica se o indice pertence Ã  lista.
--
-- __SugestÃ£o:__ use a funÃ§Ã£o 'length' que calcula tamanhos de listas

eIndiceListaValido :: Int -> [a] -> Bool
eIndiceListaValido x [] = False
eIndiceListaValido i l = (i >= 0) && ((length l - 1) >= i)

-- ** FunÃ§Ãµes sobre matrizes.

-- *** FunÃ§Ãµes gerais sobre matrizes.

-- | A dimensÃ£o de um mapa dada como um par (/nÃºmero de linhas/,/nÃºmero de colunhas/).
type DimensaoMatriz = (Int,Int)

-- | Uma posiÃ§Ã£o numa matriz dada como um par (/linha/,/colunha/).
-- As coordenadas sÃ£o dois nÃºmeros naturais e comeÃ§am com (0,0) no canto superior esquerdo, com as linhas incrementando para baixo e as colunas incrementando para a direita:
--
-- <<http://li1.lsd.di.uminho.pt/images/posicaomatriz.png posicaomatriz>>
type PosicaoMatriz = (Int,Int)

-- | Uma matriz Ã© um conjunto de elementos a duas dimensÃµes.
--
-- Em notaÃ§Ã£o matemÃ¡tica, Ã© geralmente representada por:
--
-- <<https://upload.wikimedia.org/wikipedia/commons/d/d8/Matriz_organizacao.png matriz>>
type Matriz a = [[a]]

-- | Calcula a dimensÃ£o de uma matriz.
--
-- __NB:__ Note que nÃ£o existem matrizes de dimensÃ£o /m * 0/ ou /0 * n/, e que qualquer matriz vazia deve ter dimensÃ£o /0 * 0/.
--
-- __SugestÃ£o:__ relembre a funÃ§Ã£o 'length', referida anteriormente.
dimensaoMatriz :: Matriz a -> DimensaoMatriz
dimensaoMatriz [[]] = (0,0)
dimensaoMatriz m =
    if (length m) == 0 || (length (m!!0)) == 0
        then if (length m) == 0
                then (0, length (m!!0))
                else (length m, 0)
        else (length m, length (m!!0))

-- | Verifica se a posiÃ§Ã£o pertence Ã  matriz.
ePosicaoMatrizValida :: PosicaoMatriz -> Matriz a -> Bool
ePosicaoMatrizValida (x,y) m =
    if x < 0 || y < 0
        then error "Posiçao Invalida"
        else (((length m) - 1) >= x) && ((length (m!!0)) - 1) >= y

-- * FunÃ§Ãµes recursivas.

-- ** FunÃ§Ãµes sobre Ã¢ngulos

-- | Normaliza um Ã¢ngulo na gama [0..360).
--  Um Ã¢ngulo pode ser usado para representar a rotaÃ§Ã£o
--  que um objecto efectua. Normalizar um Ã¢ngulo na gama [0..360)
--  consiste, intuitivamente, em extrair a orientaÃ§Ã£o do
--  objecto que resulta da aplicaÃ§Ã£o de uma rotaÃ§Ã£o. Por exemplo, Ã© verdade que:
--
-- prop> normalizaAngulo 360 = 0
-- prop> normalizaAngulo 390 = 30
-- prop> normalizaAngulo 720 = 0
-- prop> normalizaAngulo (-30) = 330

-- import Data.Fixed     div'     mod'
-- | Normaliza um angulo
normalizaAngulo :: Angulo -- ^ Angulo a normalizar
                -> Angulo -- ^ Angulo normalizado
normalizaAngulo i =
    if(0 <= i && i < 360)
        then i
        else if i < 0
            then normalizaAngulo (i+360)
            else normalizaAngulo (i-360)




-- ** FunÃ§Ãµes sobre listas.

-- | Devolve o elemento num dado Ã­ndice de uma lista.
--
-- __SugestÃ£o:__ NÃ£o use a funÃ§Ã£o (!!) :: [a] -> Int -> a :-)
encontraIndiceLista :: Int -> [a] -> a
encontraIndiceLista i l =
    if i < 0
        then error "Index tem de ser maior que 0"
        else if i == 0
            then head l
            else encontraIndiceLista (i - 1) (tail l)

-- | Modifica um elemento num dado Ã­ndice.
--
-- __NB:__ Devolve a prÃ³pria lista se o elemento nÃ£o existir.
atualizaIndiceLista :: Int -> a -> [a] -> [a]
atualizaIndiceLista _ _ [] = []
atualizaIndiceLista i novo l =
    if (length l - 1) >= i
        then if i == 0
                then novo:(tail l)
                else (head l):atualizaIndiceLista (i - 1) novo (tail l)
        else l

-- ** FunÃ§Ãµes sobre matrizes.

-- | Devolve o elemento numa dada 'Posicao' de uma 'Matriz'.
encontraPosicaoMatriz :: PosicaoMatriz -> Matriz a -> a
encontraPosicaoMatriz (a,b) m =
    if (0 <= a) && (a <= (length m - 1)) && (0 <= b) && (b <= (length (m!!0) - 1))
        then encontraIndiceLista b (encontraIndiceLista a m)
        else error "Posiçao invalida"

-- | Modifica um elemento numa dada 'Posicao'
--
-- __NB:__ Devolve a prÃ³pria 'Matriz' se o elemento nÃ£o existir.
atualizaPosicaoMatriz :: PosicaoMatriz -> a -> Matriz a -> Matriz a
atualizaPosicaoMatriz (l,c) i m =
    if length m >= l && length (m!!l) > c
        then atualizaIndiceLista l (atualizaIndiceLista c i (m!!l)) m
        else m
