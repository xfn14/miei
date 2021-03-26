/**
@file interpretador.h
Definição do interpretador e das suas funções
*/
#ifndef SRC_INTERPRETADOR_H
#define SRC_INTERPRETADOR_H

#include <stdio.h>
#include <string.h>
#include "jogada.h"
#include "movs.h"
#include "pos.h"
#include "file.h"
#include "lista.h"
#define BUF_SIZE 1024

int quit;

/**
\brief Esta função interpreta o comando a executar e chamar a função correspondente do interface ou da lógica do programa.
@param e estado atual
@returns Retorna -1 para sair do programa, 0 nao acontece nada, 1 jogar, 2 gr, 3 ler, 4 movs, 5 pos
*/
int interpretador(ESTADO *e);

#endif //SRC_INTERPRETADOR_H
