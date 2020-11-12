# Ficha 5

## 1

```
Dez por cento da população tem sangue do tipo B. Numa amostra aleatória de 20 pessoas encontre a probabilidade de encontrar com o tipo B
```

### 1.a

###### Enunciado

´´´
Exatamente três pessoas?
´´´

###### Resposta

```
B(20;0,1) 

P(x=3) = 0.1901
```

### 1.b

###### Enunciado

´´´
Mais de cinco pessoas?
´´´

###### Resposta

```
B(20;0,1)

P(x>5) = 1 - P(x<=5) =
       = 1 - 0.9887 =
       = 0.0113
```

### 1.c

###### Enunciado

´´´
Menos de duas pessoas?
´´´

###### Resposta

```
B(20;0,1)

P(x<2) = P(x<=1) = 
       = 0.3917
```

## 2

```
Para admissão a um concurso para uma vaga de secretária exige-se uma prova de conhecimentos que consiste em 16 questões. Cada questão tem cinco escolhas, uma correta e quatro erradas. Uma das candidatas questiona-se acerca das probabilidades se responder à sorte a cada uma das questões colocadas.
```

### 2.a

###### Enunciado

```
Qual a probabilidade de obter três respostas corretas?
```

###### Resposta

```
B(16;0.2)

P(x=3) = 0.2463
```

### 2.b

###### Enunciado

```
Qual a probabilidade de obter duas ou mais questões corretas?
```

###### Resposta

```
B(16;0.2)

P(x>=2) = 1 - P(x<2)
        = 1 - P(x<=1)
        = 1 - 0.1407
        = 0.8593
```

### 2.c

###### Enunciado

```
Se 50 candidatas fizessem o exame e se todas respondessem à sorte, qual seria a média de respostas certas?
```

###### Resposta

```
B(16;0.2)

media = n*prob =
      = 16*0.2 =
      = 3.2
```

## 3

```
Quando uma determinada máquina funciona devidamente apenas 1% das peças produzidas são defeituosas. Assuma o funcionamento correto da máquina.
```

### 3.a

###### Enunciado

```
Se forem examinadas, duas peças qual a probabilidade de 1 ser defeituosa?
```

###### Resposta

```
B(2;0,01)

P(x=1) = 0.0198
```

### 3.b

###### Enunciado

```
Se forem examinadas 5 peças, qual a probabilidade de nenhuma ser defeituosa?
```

###### Resposta

```
B(5;0,01)

P(x=0) = 0.9510
```

### 3.c

###### Enunciado

```
Qual o número esperado de peças defeituosas numa produção de 200?
```

###### Resposta

```
B(200;0,01)

lambda = 200*0.01 =
       = 2
```

### 3.d

###### Enunciado

```
Qual o desvio padrão das peças defeituosas numa amostra de 200?
```

###### Resposta

```
B(200;0,01)

(ro)^2 = 200*0.01*(1-0.01)
```