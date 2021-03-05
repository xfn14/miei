# Ficha 5

## 1

> Dez por cento da população tem sangue do tipo B. Numa amostra aleatória de 20 pessoas encontre a probabilidade de encontrar com o tipo B

### 1.a

###### Enunciado

> Exatamente três pessoas?

###### Resposta

```
B(20;0,1) 

P(x=3) = 0.1901
```

### 1.b

###### Enunciado

> Mais de cinco pessoas?

###### Resposta

```
B(20;0,1)

P(x>5) = 1 - P(x<=5) =
       = 1 - 0.9887 =
       = 0.0113
```

### 1.c

###### Enunciado

> Menos de duas pessoas?

###### Resposta

```
B(20;0,1)

P(x<2) = P(x<=1) = 
       = 0.3917
```

## 2

> Para admissão a um concurso para uma vaga de secretária exige-se uma prova de conhecimentos que consiste em 16 questões. Cada questão tem cinco escolhas, uma correta e quatro erradas. Uma das candidatas questiona-se acerca das probabilidades se responder à sorte a cada uma das questões colocadas.

### 2.a

###### Enunciado

> Qual a probabilidade de obter três respostas corretas?

###### Resposta

```
B(16;0.2)

P(x=3) = 0.2463
```

### 2.b

###### Enunciado

> Qual a probabilidade de obter duas ou mais questões corretas?

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

> Se 50 candidatas fizessem o exame e se todas respondessem à sorte, qual seria a média de respostas certas?

###### Resposta

```
B(16;0.2)

media = n*prob =
      = 16*0.2 =
      = 3.2
```

## 3

> Quando uma determinada máquina funciona devidamente apenas 1% das peças produzidas são defeituosas. Assuma o funcionamento correto da máquina.

### 3.a

###### Enunciado

> Se forem examinadas, duas peças qual a probabilidade de 1 ser defeituosa?

###### Resposta

```
B(2;0,01)

P(x=1) = 0.0198
```

### 3.b

###### Enunciado

> Se forem examinadas 5 peças, qual a probabilidade de nenhuma ser defeituosa?

###### Resposta

```
B(5;0,01)

P(x=0) = 0.9510
```

### 3.c

###### Enunciado

> Qual o número esperado de peças defeituosas numa produção de 200?

###### Resposta

```
B(200;0,01)

lambda = 200*0.01 =
       = 2
```

### 3.d

###### Enunciado

> Qual o desvio padrão das peças defeituosas numa amostra de 200?

###### Resposta

```
B(200;0,01)

(ro)^2 = 200*0.01*(1-0.01)
       = 1.98

ro = +- 1.407
```

## 4

> Os sistemas de deteção de mísseis e radares militares permitem avisar contra ataques inimigos. Uma questão importante está relacionada com a capacidade do sistema em identificar e avisar corretamente um ataque. Assuma que um sistema particular de deteção tem 90% de probabilidades de detetar um ataque de míssil.

### 4.a

###### Enunciado

> Qual a probabilidade de que um único sistema detete o ataque?

###### Resposta

```
B(1;0,9)

P(x=1) = 0.9
```

### 4.b

###### Enunciado

> Se na mesma área forem instalados dois sistemas de deteção com funcionamento independente, qual a probabilidade de pelo menos um deles detetar o ataque?

###### Resposta

```
B(2;0,9)

P(x>=1) = 1 - P(x<1) =
        = 1 - P(x<=0) =
        = 1 - 0.0100
        = 0.99
```

### 4.c

###### Enunciado

> Se forem instalados três sistemas, qual a probabilidade de pelo menos um deles detetar o ataque?

###### Resposta

```
B(3;0,9)

P(x>=1) = 1 - P(x<1) =
        = 1 - P(x<=0) =
        = 1 - 0.0010
        = 0.999
```

## 5

> Sabe-se que com um determinado tratamento administrado a doentes em condições bem definidas se consegue 70% de curas. Se esse tratamento for aplicado a 20 doentes nas mesmas condições, qual a probabilidade de obter:

### 5.a

###### Enunciado

> Máximo 15 curas?

###### Resposta

```
B(20;0,7)

P(x<=15) = 0.7625
```

### 5.b

###### Enunciado

> 12 ou mais curas?

###### Resposta

```
B(20;0,7)

P(x>=12) = 1 - P(x<12)
         = 1 - P(x<=11)
         = 1 - 0.1133
         = 0.8867
```

### 5.c

###### Enunciado

> Entre 12 e 15 curas, inclusive?

###### Resposta

```
B(20;0,7)

P(12<=x<=15) = P(x<=15) - P(x<=11) =
             = 0.7625 - 0.1133
             = 0.6492
```

## 6

> Um determinado restaurante tem reputação de boa comida. O gerente registou que no sábado à noite os grupos de clientes chegam a uma média de 15 grupos cada meia hora.

### 6.a

###### Enunciado

> Qual a probabilidade de que passem 5 minutos sem chegar nenhum cliente?

###### Resposta

```
15 grupos | 30 min
lambda    | 5  min

lambda = 2.5

P(x=0) = 0.0821
```

### 6.b

###### Enunciado

> Qual a probabilidade de que oito grupos de clientes cheguem em 10 minutos?

###### Resposta

```
15 grupos | 30 min
lambda    | 10  min

lambda = 5

P(x=8) = 0.0653
```

### 6.c

###### Enunciado

> Qual a probabilidade de que mais de 5 grupos cheguem num período de 10 minutos?

###### Resposta

```
15 grupos | 30 min
lambda    | 10  min

lambda = 5

P(x>5) = 1 - P(x<=5) =
       = 1 - 0.1755 = 
       = 0.8245
```

## 7

> Os passageiros chegam aleatoriamente e independentemente a um grande aeroporto internacional, a uma média de 10 passageiros por minuto

### 7.a

###### Enunciado

> Qual a probabilidade de não chegar nenhum passageiro durante um minuto?

###### Resposta

```
10 grupos | 1 min
lambda    | 1  min

lambda = 10

P(x=0) = 0.0000
```

### 7.b

###### Enunciado

> Qual a probabilidade de chegarem 3 ou mais passageiros durante um minuto?

###### Resposta

```
10 grupos | 1 min
lambda    | 1  min

lambda = 10

P(x>=3) = 1 - P(x<3) =
        = 1 - P(x<=2) =
        = 1 - 0.0076 =
        = 0.9924
```

## 11

> Em certas experiências, o erro obtido na determinação da densidade de uma substância é uma variável aleatória uniforme com a=-0.015 e b=0.015. Encontre as probabilidades de tal erro de determinação:

### 11.a

###### Enunciado

> estar entre –0.002 e 0.003;

###### Resposta

```
0.015+0.015 = 0.03

f(x) = 1/0.03

integral (0.003) (-0.002) (1/0.03) = [x/0.03] (0.003) (-0.002)
                                   = 0.1 - (-0.0667)
                                   = 0.167 
```

## 16

> O intervalo de tempo que um ferry demora a fazer a travessia entre duas ilhas é normalmente distribuído com média de 2 horas e desvio padrão de 12 minutos. Nas últimas viagens, qual a proporção de vezes que o ferry fez a travessia em:


### 16.a

###### Enunciado

> Menos de 1 hora e 45 minutos?

###### Resposta

```
media = 120 min
dp = 12 min
X = 105 min
Z = (105-120)/12 = -1.25

P(x<105) = 0.1056
```

## 23

> Trinta por cento dos estudantes de uma determinada universidade frequentaram colégios particulares. Assuma uma amostra aleatória de 50 estudantes.

### 23.a

###### Enunciado

> Qual a probabilidade de exatamente 10 dos estudantes selecionados terem frequentado um colégio particular?

###### Resposta

```
50*0.3 = 15 > 5
50*(1-0.3) = 35 > 5

media = 50*0.3 = 15
dp = 50*0.3*(1-0.3) = 10.5
X = 10
Z = (10-15)/10.5 = -0.48

P(x=10) = 0.3156
```
