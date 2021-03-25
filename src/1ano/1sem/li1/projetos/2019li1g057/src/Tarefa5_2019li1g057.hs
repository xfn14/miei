{- |
= Introdução

Na Tarefa 5 criamos a parte gráfica do jogo e foi onde conseguimos dar o nosso prório estilo a este projeto,
tendo desenvolvido texturas e criado um interface gráfica do nosso agrado

= Objetivos

Tivemos o proposito de criar o jogo com um design intuitivo e minimalista de forma a que seja facil de jogar
e de perceber o objetivo principal. Deste modo, o jogo em cima tem pouco texto o menu é composto apenas de
doi botões e os controles são basicos. Assim qualquer um pode simplesmente pegar no jogo pela primeira vez e
aprender de forma rapida como são as suas mecanicas.
O jogo é constituido apenas de dois modos de jogo: Singleplayer e Multiplayer.
No Singleplayer (apenas um jogador) o player joga contra mais 3 bots enquanto que no Multiplayer, é um jogo
de quatro jogadores em que partilham o mesmo teclado para jogar, tendo cada um os seus comandos.
O principal objetivo ao desenvolver esta tarefa foi abrangir todas as possibilidades de modo que seja facil
de fazer as alterações necessarias de modo a que para adicionar novas features nao seja necessario fazer
muitas alteraçoes. Por efeito, o codigo torna-se muito mais universal porque todas as possibilidades de mapa
conseguem ser interpretadas pelas nossas funções.

= Discussão e conclusão
Gostamos bastante daquilo que conseguimos alcançar mas infelizmente ficamos incapacidados devido as limitações
do Haskell achando que podiamos fazer um codigo muito mais apelativo, limpo e avançado se o jogo tivesse sido
feito noutra linguagem.
-}
module Main where

import LI11920
import Tarefa1_2019li1g057
import Tarefa2_2019li1g057
import Tarefa4_2019li1g057
import Tarefa6_2019li1g057
import Graphics.Gloss
import Graphics.Gloss.Juicy
import Graphics.Gloss.Interface.Pure.Game
import Graphics.Gloss.Interface.Environment
import Codec.Picture.Types
import Codec.Picture
import GHC.Float
import System.Random
import Data.List (sortBy)
import Data.Ord (comparing)
import Juicy

-- | Mapas e jogadores usados para testes

mapa1 :: Mapa
mapa1 = [[Recta Terra 0, Rampa Boost 0 1, Rampa Relva 1 2,Recta Terra 2,Rampa Cola 2 1,Rampa Boost 1 0]]

jogadores0 :: [Jogador]
jogadores0 = [Jogador 0 0 0 4 (Chao False),
              Jogador 1 0 0 4 (Chao False),
              Jogador 2 0 0 4 (Chao False),
              Jogador 3 0 0 4 (Chao False)]

jogadores1 :: [Jogador]
jogadores1 = [Jogador 0 5.5 0 4 (Chao False),
              Jogador 1 5 0 4 (Chao False),
              Jogador 0 5 0 4 (Chao False),
              Jogador 3 5 0 4 (Chao False)]

jogadores2 :: [Jogador]
jogadores2 = [Jogador 0 5.5 0 4 (Chao False),
              Jogador 1 8 0 4 (Chao False),
              Jogador 0 3 0 4 (Chao False),
              Jogador 3 2 0 4 (Chao False)]

-- | 'Estado' no qual o jogo será iniciado, no qual gera uma mapa com uma seed random.

estadoInicial :: Int -> Estado
estadoInicial seed = Estado (gera 4 comprimentoPista seed) jogadores0

-------------------
--  desenhaEstado
-------------------

-- | 'desenhaEstado' @estado gfx (x,y) x1@ tem como funcionalidade de
-- desenhar o 'Estado' atual nas coordenadas @x y@ e com um offset de @x1@
-- sendo desenhador apartir da função 'desenhaMapa'
desenhaEstado :: Estado -- ^ 'Estadp' a ser desenhado
              -> [DynamicImage] -- ^ Lista de texturas
              -> (Int,Int) -- ^ Localização onde começar a desenhar o 'Mapa'
              -> Int -- ^ Animação do mapa (offset de desenho)
              -> [Picture] -- ^ Lista de 'Picture's resultante da converção do 'Mapa'
desenhaEstado (Estado mapa jogadores) gfx (w,h) x1=
    let distJg = sortDistancia jogadores
        (Jogador _ d _ _ _) = last distJg
        pecasEcra = realToFrac (w `div` 50)
        offSet = if d > pecasEcra then (d-pecasEcra)*50 else 0
    in desenhaMapa mapa jogadores 0 (fromIntegral ((-(w `div` 2)) + 25 + x1),fromIntegral (-(h `div` 2))+150) True gfx

-------------------
--  desenhaMapa
-------------------

-- | 'desenhaMapa' @mapa jogadores nPista (x,y) opacidade gfx@ server para
-- obter a lista de 'Picture's de um mapa.
-- Deste modo, passamos recursivamente as 'Pista's para a 'desenhaPista'
-- com os respetivos 'Jogador'es de cada 'Pista' de modo a receber uma
-- lista com todas as 'Pictures' que constituem um 'Mapa'
desenhaMapa :: Mapa -- ^ 'Mapa' a desenhar
            -> [Jogador] -- ^ Lista de 'Jogador'es
            -> Int -- ^ Numero da 'Pista' a ser desenhada
            -> (Float,Float) -- ^ Posição a desenhar a 'Pista'
            -> Bool -- ^ Valor da opacidade das pictures
            -> [DynamicImage] -- ^ Lista das texturas
            -> [Picture] -- ^ 'Mapa' convertido a 'Picture's
desenhaMapa [] l _ _ _ _ = []
desenhaMapa (h:t) [] i (x,y) op gfx =
    (desenhaPista h ([],[],x) (x,y) op gfx) ++
    (desenhaMapa t [] (i+1) (x,y-lP) False gfx)
desenhaMapa (h:t2) jg i (x,y) op gfx =
    let jogadores = filterJogadores jg i
        getPecas :: [(Jogador,Int)] -> Pista -> [Peca]
        getPecas [] _ = []
        getPecas (((Jogador _ a _ _ _),_):t) pista = (pista!!(floor a)):(getPecas t pista)
    in (desenhaPista h (jogadores,getPecas jogadores h,x) (x,y) op gfx) ++
       (desenhaMapa t2 jg (i+1) (x,y-lP) False gfx)

-------------------
--  desenhaPista
-------------------

-- | 'desenhaPista' @pista (jogadores,pecas,startX) (x,y) opacidade gfx@
-- serve para obter a lista de 'Picture's de uma pista.
-- Para tal efeito, primeiramente converte-se a pista toda para 'Picture's
-- através da ultilização da função 'desenhaPeca' e quando a pista for
-- toda convertida, é acrescentado os jogadores respetivos da 'Pista' de
-- modo a que nao haja sobreposição pista/jogador ou jogador/pista.
--
-- Nota: A informaçao para desenhar os jogadores com a função 'desenhaJogador'
-- pode ser encontrada o triplo (jogadores,pecas,startX) sendo o startX
-- o x inicial onde o mapa esta a ser desenhado de modo a colocar o jogador
-- no sitio correto.
desenhaPista :: Pista -- ^ 'Pista' a ser desenhada
             -> ([(Jogador,Int)],[Peca],Float) -- ^ Informações sobre os 'Jogador'es que se encontram na 'Pista'
             -> (Float,Float) -- ^ Coordenadas onde a 'Pista' vai ser desenhada
             -> Bool -- ^ Nivel de opacidade das 'Peca's da 'Pista'
             -> [DynamicImage] -- ^ Lista de texturas
             -> [Picture] -- ^ 'Pista' convertida a 'Picture's
desenhaPista [] ((j1:j2),(p1:p2),startX) (x,y) uba gfx =
    [desenhaJogador j1 p1 (startX,y) (drop 5 gfx)] ++
    (desenhaPista [] (j2,p2,startX) (x,y) uba gfx)
desenhaPista [] ([],_,_) _ _ _ = []
desenhaPista (h:t) p (x,y) op gfx =
    (desenhaPeca h (x,y) op gfx):(desenhaPista t p (x+lP,y) op gfx)


-------------------
--  desenhaPeca
-------------------

-- | 'desenhaPeca' @peca (x,y) opacidade gfx@ é a 'Picture' que se obtem
-- da 'Peca' @peca@, colocando-a nas coordenadas @x y@.
-- Para além disso, a textura a ser usada para o 'Piso' é obtida pela
-- lista @gfx@ que é composta por 'DynamicImage' das diferentes texturas.
-- A @opacidade@ é para aplicar uma opacidade de 50% à 'Peca' a ser
-- desenhada.
--
-- No caso das 'Peca's que sao retas é apenas colocada a imagem na sua
-- posiçao correta, enquanto que nas rampas ainda é aplicadas as funções
-- 'sobeDynamicImage' e 'desceDynamicImage' para rampas a subir e a descer
-- respetivamente.
desenhaPeca :: Peca -- ^ 'Peca' a ser convertida a 'Picture'
            -> (Float,Float) -- ^ Posição a ser colocada
            -> Bool -- ^ Com ou sem opacidade
            -> [DynamicImage] -- ^ Lista de texturas
            -> Picture -- ^ 'Picture' final
desenhaPeca (Recta piso hi) (x,y) op (terra:relva:lama:boost:cola:_) =
    let gfx Terra = terra
        gfx Relva = relva
        gfx Lama = lama
        gfx Boost = boost
        gfx Cola = cola
        pic = gfx piso
        Just peca = fromDynamicImage $ if op then pic else if hi == 0 then pic else pic
        offSetAltura = fromIntegral (hi*round lP)
        cor = withAlpha (if op then 1.0 else if hi == 0 then 1.0 else 0.6) (corPiso piso)
    in Pictures (
        [Translate (x-(lP/2)) y
            (Pictures [Color cor (Polygon [(0,0),(50,0),(50,offSetAltura),(0,offSetAltura)])])] ++
        [Translate (x) (y+offSetAltura+(lP/2)) peca] ++
        [Translate (x-(lP/2)) (y+offSetAltura)
            (Pictures [Color black (Line [(0,0),(lP,0)]),
                       Color black (Line [(0,lP),(lP,lP)])])])
desenhaPeca (Rampa piso hi hf) (x,y) op (terra:relva:lama:boost:cola:_) =
    let altura = fromIntegral (hf-hi)
        gfx Terra = terra
        gfx Relva = relva
        gfx Lama = lama
        gfx Boost = boost
        gfx Cola = cola
        pic = (if altura > 0 then sobeDynamicImage (round altura) (gfx piso)
                             else desceDynamicImage (round (-altura)) (gfx piso))
        Just peca = fromDynamicImage $ if op then pic else pic
        offSet = ((lP*(succ altura))/2) + fromIntegral (round lP*hi)
        cor = withAlpha (if op then 1.0 else 0.6) (corPiso piso)
    in Pictures (
        [Translate (x-(lP/2)) (y)
            (Pictures [Color cor (Polygon [(0,0),(lP,0),(lP,fromIntegral (hf*round lP)),(0,fromIntegral (hi*round lP))])])] ++
        [Translate (x) (y+offSet) peca] ++
        [Translate (x-(lP/2)) (y)
            (Pictures [Color black (Line [(0,fromIntegral (hi*round lP)),(lP,fromIntegral (hf*round lP))]),
                       Color black (Line [(0,fromIntegral (hi*round lP+50)),(lP,fromIntegral (hf*round lP+50))])])])

-------------------
--  desenhaJogador
-------------------

-- | 'desenhaJogador' @(jogador,identificador) peca (x,y) gfx@ é a 'Picture'
-- que se obtem do 'Jogador' @jogador@ com o seu respetivo @identificador@
-- e @peca@ no qual se situa.
-- Para além disso, a 'Picture' resultante usa a textura correspondente ao
-- @identificador@ do @jogador@ da lista @gfx@
--
-- Temos presente situações para os diferentes 'EstadoJogador' que é por
-- causa do diferentes offsets de altura, distancia e inclinação.
desenhaJogador :: (Jogador,Int) -- ^ 'Jogador' e seu respetivo identificador
               -> Peca -- ^ 'Peca' onde se encontra o 'Jogador'
               -> (Float,Float) -- ^ Coordenadas onde vai ser desenhado o 'Jogador'
               -> [DynamicImage] -- ^ Lista de texturas
               -> Picture -- ^ 'Picture' resultante
desenhaJogador ((Jogador p d v c (Ar h i g)),text) peca (x,y) (j1:j2:j3:j4:_) =
    let Just pic = fromDynamicImage $ if text == 0 then j1 else if text == 1 then j2 else if text == 2 then j3 else j4
        limit = if d >= fromIntegral comprimentoPista then fromIntegral comprimentoPista else d
        startX = x+((realToFrac limit)*50)-25
    in Translate (startX) (y+realToFrac (h*50)+25)
       (Rotate (realToFrac (-i)) pic)
desenhaJogador (j@(Jogador p d v c _),text) (Recta _ h) (x,y) (j1:j2:j3:j4:j1m:j2m:j3m:j4m:_) =
    let limit = if d >= fromIntegral comprimentoPista then fromIntegral comprimentoPista else d
        Just pic = fromDynamicImage $
            if (isMorto j)
                then if text == 0 then j1m else if text == 1 then j2m else if text == 2 then j3m else j4m
                else if text == 0 then j1 else if text == 1 then j2 else if text == 2 then j3 else j4
    in Translate (x+(realToFrac limit)*lP-25) (fromIntegral ((round y)+h*50+25)) pic -- (realToFrac (x+realToFrac(d*realToFrac lP))) (fromIntegral ((round y)+h*50))
desenhaJogador (j@(Jogador p d v c _),text) peca@(Rampa _ hi hf) (x,y) (j1:j2:j3:j4:j1m:j2m:j3m:j4m:_) =
    let Just pic = fromDynamicImage $
            if (isMorto j)
                then if text == 0 then j1m else if text == 1 then j2m else if text == 2 then j3m else j4m
                else if text == 0 then j1 else if text == 1 then j2 else if text == 2 then j3 else j4
        inclinacao = realToFrac $ iPeca peca
        limit = if d >= fromIntegral comprimentoPista then fromIntegral comprimentoPista else d
        startX = x+((realToFrac limit)*50)-25
        offSetAltura = realToFrac ((getHPeca d peca)*50)
        absInclinacao = (if inclinacao < 0 then (-inclinacao) else inclinacao)
        offSetX = (lP/2) * cos((pi/2) - (graus2rad absInclinacao))
        offSetY = (lP/2) * sin((pi/2) - (graus2rad absInclinacao))
    in if hi < hf
        then Translate (startX-offSetX) (y+offSetAltura+offSetY)
             (Rotate (-inclinacao) pic)
        else Translate (startX+offSetX) (y+offSetAltura+offSetY)
             (Rotate (-inclinacao) pic)

-- | Esta lista de eventos é para quando o jogo é singleplayer
-- de modo a que o jogador se consiga movimentar
-- O 'Jogador' em questão encontra-se na primeira 'Pista'
reageEventoSp :: Event -- ^ 'Event'o ocurrido (Tecla clicada)
              -> Estado -- ^ 'Estado' em que se encontrava o jogo no momento em que o 'Event'o aconteceu
              -> Estado -- ^ 'Estado' final
reageEventoSp (EventKey (Char 'w') Down _ _) e = jogada 0 (Movimenta C) e
reageEventoSp (EventKey (Char 's') Down _ _) e = jogada 0 (Movimenta B) e
reageEventoSp (EventKey (Char 'd') Down _ _) e = jogada 0 (Movimenta D) e
reageEventoSp (EventKey (Char 'a') Down _ _) e = jogada 0 (Movimenta E) e
reageEventoSp (EventKey (Char 'q') Down _ _) e = jogada 0 (Acelera) e
reageEventoSp (EventKey (Char 'e') Down _ _) e = jogada 0 (Desacelera) e
reageEventoSp (EventKey (Char 'r') Down _ _) e = jogada 0 (Dispara) e
reageEventoSp _ estado = estado

-- | Esta lista de eventos é para quando o jogo é multiplayer
-- de modo a que os jogadores se consigam movimentar
-- No modo multiplayer é possivel controlar os 4 jogadores.
reageEventoMp :: Event -- ^ 'Event'o ocurrido (Tecla clicada)
              -> Estado -- ^ 'Estado' em que se encontrava o jogo no momento em que o 'Event'o aconteceu
              -> Estado -- ^ 'Estado' final
reageEventoMp (EventKey (Char 'w') Down _ _) e = jogada 0 (Movimenta C) e
reageEventoMp (EventKey (Char 's') Down _ _) e = jogada 0 (Movimenta B) e
reageEventoMp (EventKey (Char 'd') Down _ _) e = jogada 0 (Movimenta D) e
reageEventoMp (EventKey (Char 'a') Down _ _) e = jogada 0 (Movimenta E) e
reageEventoMp (EventKey (Char 'q') Down _ _) e = jogada 0 (Acelera) e
reageEventoMp (EventKey (Char 'e') Down _ _) e = jogada 0 (Desacelera) e
reageEventoMp (EventKey (Char 'r') Down _ _) e = jogada 0 (Dispara) e
reageEventoMp (EventKey (SpecialKey KeyUp) Down _ _) e = jogada 1 (Movimenta C) e
reageEventoMp (EventKey (SpecialKey KeyDown) Down _ _) e = jogada 1 (Movimenta B) e
reageEventoMp (EventKey (SpecialKey KeyRight) Down _ _) e = jogada 1 (Movimenta D) e
reageEventoMp (EventKey (SpecialKey KeyLeft) Down _ _) e = jogada 1 (Movimenta E) e
reageEventoMp (EventKey (Char 'n') Down _ _) e = jogada 1 (Acelera) e
reageEventoMp (EventKey (Char 'm') Down _ _) e = jogada 1 (Desacelera) e
reageEventoMp (EventKey (Char ',') Down _ _) e = jogada 1 (Dispara) e
reageEventoMp (EventKey (Char 'i') Down _ _) e = jogada 2 (Movimenta C) e
reageEventoMp (EventKey (Char 'k') Down _ _) e = jogada 2 (Movimenta B) e
reageEventoMp (EventKey (Char 'l') Down _ _) e = jogada 2 (Movimenta D) e
reageEventoMp (EventKey (Char 'j') Down _ _) e = jogada 2 (Movimenta E) e
reageEventoMp (EventKey (Char 'u') Down _ _) e = jogada 2 (Acelera) e
reageEventoMp (EventKey (Char 'o') Down _ _) e = jogada 2 (Desacelera) e
reageEventoMp (EventKey (Char 'p') Down _ _) e = jogada 2 (Dispara) e
reageEventoMp (EventKey (Char '8') Down _ _) e = jogada 3 (Movimenta C) e
reageEventoMp (EventKey (Char '2') Down _ _) e = jogada 3 (Movimenta B) e
reageEventoMp (EventKey (Char '6') Down _ _) e = jogada 3 (Movimenta D) e
reageEventoMp (EventKey (Char '4') Down _ _) e = jogada 3 (Movimenta E) e
reageEventoMp (EventKey (Char '7') Down _ _) e = jogada 3 (Acelera) e
reageEventoMp (EventKey (Char '9') Down _ _) e = jogada 3 (Desacelera) e
reageEventoMp (EventKey (Char '5') Down _ _) e = jogada 3 (Dispara) e
reageEventoMp _ estado = estado

-- | Esta função aplica as mudanças ao 'Estado' á medida que o tempo vai
-- passando.
-- Caso o jogo esteja no modo singleplayer 3 dos jogadores são bots
-- da tarefa 6.
reageTempo :: Float -- ^ Tempo a passar
           -> Estado -- ^ 'Estado' atual
           -> Int -- ^ Modo de jogo atual
           -> Estado -- ^ 'Estado' resultante
reageTempo t e@(Estado mapa jogadores) screen
    | screen == 1 = (Estado mapa (aux t novoMapa novoJogadores))
    | screen == 2 = (Estado mapa (aux t mapa jogadores))
    | otherwise = e
    where (Estado novoMapa novoJogadores) = playBots 1 e (drop 1 jogadores)
          --ended = if distancia >= comprimentoPista then

          aux :: Float -> Mapa -> [Jogador] -> [Jogador]
          aux _ _ [] = []
          aux tempo mp (p:s) = (passo (float2Double tempo) mp p):(aux tempo mp s)

-- | Função que altera o 'Estado' de modo a executar jogadas nos 'Jogador'es
-- que estão a ser representados por bots
playBots :: Int -- ^ Identificador do bot
         -> Estado -- ^ 'Estado' atual
         -> [Jogador] -- ^ Lista de 'Jogaodor'es a aplicar jogadas recursivamente
         -> Estado -- ^ 'Estado' final
playBots _ e [] = e
playBots i e (h:t) =
    let Just play = bot i e
        novoEstado = jogada i play e
    in playBots (i+1) novoEstado t

-- | Estado Gloss

type EstadoGloss = (Estado,[DynamicImage],(Picture,Float,Float,Float),(Int,Int),(Picture,Int),(Float))

estadoGlossInicial :: Int -> [DynamicImage] -> (Int,Int) -> EstadoGloss
estadoGlossInicial seed (g:mn:fx) screenSize@(w,h) =
    let Just fundo = fromDynamicImage g
        Just menu = fromDynamicImage mn
    in (estadoInicial seed,fx,(fundo,0,fromIntegral w,fromIntegral ((w `div` 2))-100),screenSize,(menu,0),0)

desenhaEstadoGloss :: EstadoGloss -> Picture
desenhaEstadoGloss (e@(Estado mapa players),gfx,(fundo,x1,x2,mapOffSet),screenSize@(w,h),(menu,screen),time)
    | screen == 0 = menu
    | screen == (-1) = let (_,i) = last $ sortDistanciaOrdered players
                           (j1:j2:j3:j4:_) = drop 5 gfx
                           Just pic = fromDynamicImage $ if i == 0 then j1 else if i == 1 then j2 else if i == 2 then j3 else j4
                       in Pictures ([jogo] ++ [Scale 5 5 pic] ++ [Translate (150) (0) (Color white (Text "WINNER"))])
    | otherwise = jogo
    where jogo = Pictures (fundoAnimado ++
                           (desenhaEstado e gfx screenSize (round mapOffSet)) ++
                           [Translate (fromIntegral (-(w `div` 2))) (300) (Color white (Text (show time)))])
          fundoAnimado = [Translate x1 (0) fundo,Translate x2 (0) fundo]

--[Translate (fromIntegral (-(w `div` 2))) (fromIntegral (-(h `div` 2)))
--    (Polygon [(0,0),(fromIntegral w, 0),(fromIntegral w,fromIntegral (h `div` 2)-150),(0,fromIntegral (h `div` 2)-150)])] ++
--[Translate (fromIntegral (-(w `div` 2))) (-180)
--    (Color (makeColorI 73 4 40 255) (Polygon [(0,0),(fromIntegral w, 0),(fromIntegral w,30),(0,30)]))] ++

reageEventoGloss :: Event -> EstadoGloss -> EstadoGloss
reageEventoGloss ev eg@(e,gfx,fundo,screenSize,(menu,screen),time)
    | screen == 1 = (reageEventoSp ev e,gfx,fundo,screenSize,(menu,screen),time)
    | screen == 2 = (reageEventoMp ev e,gfx,fundo,screenSize,(menu,screen),time)
    | otherwise = reageEventoMenu ev eg

reageEventoMenu :: Event -> EstadoGloss -> EstadoGloss
reageEventoMenu (EventKey (MouseButton LeftButton) Up _ (x,y)) (e,gfx,fundo,screenSize,(menu,_),time)
    | y > 0 = (e,gfx,fundo,screenSize,(menu,1),time)
    | otherwise = (e,gfx,fundo,screenSize,(menu,2),time)
reageEventoMenu _ estado = estado

reageTempoGloss :: Float -> EstadoGloss -> EstadoGloss
reageTempoGloss t eg@(e@(Estado mapa jogadores),gfx,(fundo,x1,x2,mapOffSet),screenSize@(w,_),(menu,screen),time)
    | screen == 0 = eg
    | otherwise =
        if (screen == (-1)) || (time >= 40) || ended
            then (reageTempo t e screen,gfx,(fundo,x1,x2,mapOffSet),screenSize,(menu,(-1)),40)
            else (reageTempo t e screen,gfx,(fundo,x1Final,x2Final,mapOffSet-mapSpeed),screenSize,(menu,screen),time+t)
    where x1Final = if x1 <= (fromIntegral (-w)) then fromIntegral (w-100) else (x1-fundoSpeed)
          x2Final = if x2 <= (fromIntegral (-w)) then fromIntegral (w-100) else (x2-fundoSpeed)
          (Jogador _ distancia _ _ _) = last $ sortDistancia jogadores
          ended = (round distancia) >= comprimentoPista

-- | Settings

-- | Comprimento em px das texturas.
lP :: Float
lP = 50

-- | Velocidade a qual o mapa se mexe
mapSpeed :: Float
mapSpeed = 1.5

-- | Velocidade a qual o fundo se mexe
fundoSpeed :: Float
fundoSpeed = 5

-- | Comprimento do mapa
comprimentoPista :: Int
comprimentoPista = 75

-- | Frame rate
fr :: Int
fr = 30

-- | Display Settings
dm :: Display
dm = FullScreen -- Display full screen
--dm = InWindow "Excite Bikes" (1400,600) (0,0) -- Display in a window with the given game, size and position.

main :: IO ()
main = do
    Right terra <- readImage "../assets/textures/terra.png"
    Right relva <- readImage "../assets/textures/relva.png"
    Right lama <- readImage "../assets/textures/lama.png"
    Right boost <- readImage "../assets/textures/boost.png"
    Right cola <- readImage "../assets/textures/cola.png"
    Right wallpaper <- readImage "../assets/backgrounds/bg2t.jpg"
    Right menu <- readImage "../assets/menu.png"
    Right p1 <- readImage "../assets/players/p1.png"
    Right p2 <- readImage "../assets/players/p2.png"
    Right p3 <- readImage "../assets/players/p3.png"
    Right p4 <- readImage "../assets/players/p4.png"
    Right p1m <- readImage "../assets/players/p1m.png"
    Right p2m <- readImage "../assets/players/p2m.png"
    Right p3m <- readImage "../assets/players/p3m.png"
    Right p4m <- readImage "../assets/players/p4m.png"
    screenSize <- getScreenSize
    seed <- randomRIO (0,9999)
    play dm                                                   -- janela onde ira correr o jogo
        (greyN 0.0)                                           -- cor do fundo da janela
        fr                                                    -- frame rate
        (estadoGlossInicial seed [wallpaper,menu,terra,relva,lama,boost,cola,p1,p2,p3,p4,p1m,p2m,p3m,p4m] (screenSize))    -- estado inicial
        desenhaEstadoGloss                                    -- desenha o estado do jogo
        reageEventoGloss                                      -- reage a um event
        reageTempoGloss                                       -- reage ao passar do tempo


-- | Funções auxiliares

-- | Obtem a 'Color' a ser usada para desenhar as 'Peca's
corPiso :: Piso -> Color
corPiso piso =
    case piso of
        Terra -> (makeColorI 109 76 50 255)
        Relva -> (makeColorI 60 87 29 255)
        Lama -> (makeColorI 129 81 43 255)
        Cola -> (makeColorI 240 240 237 255)
        Boost -> (makeColorI 127 127 127 255)

-- | De uma lista de 'Jogador'es seleciona os pertencentes a
-- | uma determinada 'Pista' e retorna uma lista com o
-- | o proprio 'Jogador' e o seu identificador.
filterJogadores :: [Jogador] -- ^ Lista de 'Jogador'es
                -> Int -- Indice da 'Pista'
                -> [(Jogador,Int)] -- ^ Lista de pares de 'Jogador' e identificador do 'Jogador'
filterJogadores l p = filter (fl p) (zip l [0..])
  where fl i ((Jogador a _ _ _ _),_) = i == a

-- | Converter graus para radianos
graus2rad :: Float -- ^ Angulo em graus
          -> Float -- ^ Angulo em radianos
graus2rad g = g*(pi/180)

-- | Organiza uma lista de 'Jogador'es de acordo com as suas respetivas distancias
sortDistancia :: [Jogador] -- ^ Lista de 'Jogador'es inicial
              -> [Jogador] -- ^ Lista de 'Jogador'es organizada
sortDistancia = sortBy (comparing distanciaJogador)

sortDistanciaOrdered :: [Jogador] -> [(Jogador,Int)]
sortDistanciaOrdered l = sorter (zip l [0..])
    where sorter [] = []
          sorter lt@(p@((Jogador _ d _ _ _),i):t) = (sorter lesser) ++ [p] ++ (sorter greater)
              where
                  lesser = filter (\(Jogador _ t _ _ _,ola) -> t < d) t
                  greater = filter (\(Jogador _ t _ _ _,ola) -> t >= d) t

-- | Verifica se o 'EstadoJogador' de um 'Jogador' é Morto
isMorto :: Jogador -> Bool
isMorto (Jogador _ _ _ _ (Morto _)) = True
isMorto _ = False