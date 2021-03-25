module Ficha9 where

import System.Random

--bingo :: IO()
--bingo =
--    do rnd <- listaRandom []
--        print rnd
--
--listaRandom :: [Int] -> IO [Int]
--listaRandom l
--    | length l == 90 = do return l
--    | otherwise = do n <- randomRIO (1,90)
--                    print n
--                    getChar
--                    let x = if (elem n l) then l else (n:l)
--                    in listaRandom x

bingo :: IO()
bingo = do nl <- acumularNumeros []
           print nl

acumularNumeros :: [Int] -> IO [Int]
acumularNumeros l | length l == 90 = do return l
                  | otherwise = do v <- randomRIO (1,90)
                                   print v
                                   getChar
                                   let nl = if v `elem` l then l else v:l in acumularNumeros nl
            
