module Juicy where

import Codec.Picture.Types as Juicy
import Codec.Picture as Juicy
import Graphics.Gloss (Picture)
import Graphics.Gloss.Juicy (fromDynamicImage)

sobeImage :: Pixel a => Int -> a -> Image a -> Image a
sobeImage n p i@(Image w h xs) = generateImage gen w (h*(succ n))
    where
    gen x y = if y' > 0 && y' < h then pixelAt i x y' else p
        where
        y' = y - (w - x) * n
        
sobeDynamicImage :: Int -> DynamicImage -> DynamicImage
sobeDynamicImage n i = ImageRGBA8 $ sobeImage n alphaPixelRGBA8 $ convertRGBA8 i

desceImage :: Pixel a => Int -> a -> Image a -> Image a
desceImage n p i@(Image w h xs) = generateImage gen w (h*(succ n))
    where
    gen x y = if y' > 0 && y' < h then pixelAt i x y' else p
        where
        y' = y - x * n

desceDynamicImage :: Int -> DynamicImage -> DynamicImage
desceDynamicImage n i = ImageRGBA8 $ desceImage n alphaPixelRGBA8 $ convertRGBA8 i

transparentDynamicImage :: DynamicImage -> DynamicImage
transparentDynamicImage i = ImageRGBA8 $ pixelMap transparentPixelRGBA8 $ convertRGBA8 i

transparentPixelRGBA8 (PixelRGBA8 r g b a) = PixelRGBA8 r g b (a `div` 2)

alphaPixelRGBA8 = PixelRGBA8 0 0 0 0

loadJuicyWith :: FilePath -> (DynamicImage -> DynamicImage) -> IO Picture
loadJuicyWith file f = do
    Right i <- readImage file
    let Just pic = fromDynamicImage (f i)
    return pic

--main :: IO ()
--main = do
--    Right i <- readImage "../resources/terra150png.png"
--    let i' = desceDynamicImage 3 i
--    savePngImage "relvasobe.png" i'