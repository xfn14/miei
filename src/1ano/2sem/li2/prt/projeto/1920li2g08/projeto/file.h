/**
@file file.h
Definição do
*/
#ifndef SRC_FILE_H
#define SRC_FILE_H

#include "stdio.h"
#include <string.h>
#include "data.h"
#include "estado.h"
#include "jogada.h"

/**
\brief Esta função lê o Estado atual e grava o tabuleiro correspondente num ficheiro.
@param file_name O nome do ficheiro
@param estado O estado atual
*/
void gr(char *file_name, ESTADO *estado);
/**
\brief Esta função lê um ficheiro e verifica o Estado do tabuleiro.
@param file_name O nome do ficheiro
@param estado O estado atual
*/
void ler(char *file_name, ESTADO *estado);

#endif //SRC_FILE_H
