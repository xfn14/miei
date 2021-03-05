# 2. Invariantes de ciclo

### 1.

###### Enunciado

```
P: x == x_0 >= 0 && y == y_0 > 0

    r = x;
    q = 0;
    while(y<=r){
        r = r-y;
        q = q+1;
    }

Q: 0 <= r < y_0 && q*y_0+r == x_0
```

###### Resposta

```
Inicializacao: 
    {x>=0 && y>0} r = x; q = 0 {I}
Preservacao: 
    {I && y<=r} r = r-y; q = q+1 {I}
Utilidade: 
    {I && y>r} => {0<=r<y_0 && q*y_0+r == x_0}
```

### 2.

###### Enunciado

```
P: n == n_0 > 0

    i = 1; r = 1; s = 0;
    while(i<n){
        r = r+s;
        s = r-s;
        i = i+1;
    }

Q: r == F(n_0)
```

###### Resposta

```
Inicializacao: 
    {n>0} i = 1; r = 1; s = 0 {I}
Preservacao: 
    {I && i<n} r = r+s; s = r-s; i = i+1; {I}
Utilidade: 
    {I && i>=n} => {r == F(n_0)}
```

### 3.

###### Enunciado

```
mdc(x,x) = x
mdc(x,y) = mdc(x+y,y) = mdc(x,x+y)

P: a == a_0 > 0 && b == b_0 > 0

    while(a!=b)
        if(a>b) a = a-b;
        else    b = b-a;

Q: a == mdc(a_0,b_0)

I: mdc(a,b) == mdc(a_0,b_0)
```

###### Reposta
<!-- TODO Add correcao total -->
```
Inicializacao: 
    {a>0 && b>0} => {mdc(a,b) == mdc(a_0,b_0)}
Preservacao: 
    {mdc(a,b) == mdc(a_0,b_0) && a!=b}
Utilidade:
    1. {mdc(a,b) == mdc(a_0,b_0) && a==b && a>b} => {mdc(a-b,b) == mdc(a_0,b_0)}
    2. {mdc(a,b) == mdc(a_0,b_0) && a==b && a<=b} => {mdc(a,b-a) == mdc(a_0,b_0)}
```
