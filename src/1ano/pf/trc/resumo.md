# PF - Haskell

- ghc (compiler)
- stack (package manager)
- cabal (package manager)

## Tipos

- Int    -- ^ Inteiros
- Float  -- ^ Decimais mais preciso (mais casas decimais)
- Double -- ^ Decimais menos preciso
- Char   -- ^ Caracteres
- Bool   -- ^ Asserção (V/F)
- String -- ^ [Char]

## Assinatura

É a definição do tipo de valores usados na função

$ f(x) = 2x+10 $

```hs
f :: Float
  -> Float
```

## Definir a função

$ f(x) = 2x+10 $

```hs
f x = 2*x+10
```

```hs
f :: Float -- ^ Abcissa da função f(x)
  -> Float -- ^ Ordenada da função f(x)
f x = 
    2*x+10 -- Calculo da ordenada
```

### Exemplo

f(x) =
    (x^2)+1, x<2
    (x^3)-4*x, x>=2

```hs
f :: Float
  -> Float
f x =
    if x<2 then (x^2)+1
    else (x^3)-4*x
```

```hs
f :: Float
  -> Float
f x =
    | x<2 =  (x^2)+1
    | otherwise = (x^3)-4*x
```

## Definir valores

- let
- where

Ambos servem para definir valores/funções(auxilares)

### Exemplo

```
f :: Int
  -> Int
f x =
    let
        quadrado = x^2
    in x * quadrado
```

```
f :: Int
  -> Int
f x =
    x * quadrado
    where
        quadrado = x^2
```

## Operadores

- <, >: menor e maior
- <=, >=: menor e igual e maior e igual
- ==: igual

## Criar Tipos

- type: criar um sinonimo de outro tipo
- data: é para criar um tipo novo

```hs
type Hora = (Int,Int,Int)
horaAtual :: Hora
horaAtual = (12,29,30)

data Hora' = Hora Int Int Int
horaAtual' :: Hora'
horaAtual' = Hora 12 29 30
```

### Exemplo

```hs
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
```


## Recursividade

### Exemplo (a)

Obter o ultimo elemento da lista

```hs
last :: [a] -- ^ Lista fornecida
     -> a   -- ^ Ultimo elemento da lista
last [] = undefined
last [x] = x
last (h:t) = last t
```

```hs
last :: [a] -- ^ Lista fornecida
     -> a   -- ^ Ultimo elemento da lista
last l =
    case l of
        [x] -> x
        (h:t) -> last t
        _ -> error "A lista é invalida." -- Caso a lista seja vazia.
```

### Exemplo (b)

Obter maior elemento da lista

```hs
biggest :: [a] -- ^ Lista inicial
        -> a   -- ^ Maior elemento encontrado ate ao momento
        -> a   -- ^ Maior numero da lista
biggest [] n = n
biggest (h:t) n =
    | n<h = biggest t h
    | otherwise = biggest t n
```

```hs
biggest :: [a]
        -> a
biggest l@(h:t) =
    biggestAux t h
    where
        biggest :: [a] -- ^ Lista inicial
                -> a   -- ^ Maior elemento encontrado ate ao momento
                -> a   -- ^ Maior numero da lista
        biggest [] n = n
        biggest (h:t) n =
            | n<h = biggest t h
            | otherwise = biggest t n
```

```hs
desc :: [a]
     -> String
desc l =
    "A lista é" ++
    case l of
        [] -> "vazia"
        [x] -> "com 1 elemento"
        _ -> "comprida."
```