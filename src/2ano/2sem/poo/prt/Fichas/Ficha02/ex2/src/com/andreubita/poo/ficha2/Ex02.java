package com.andreubita.poo.ficha2;

public class Ex02 {

    private int[][] notasTurma = new int[5][5];
    private int n_alunos = this.notasTurma.length;
    private int n_ucs = this.notasTurma[0].length;

    public static void main(String[] args) {
        Ex02 ex02 = new Ex02();
        ex02.printPauta();
        ex02.setNotasTurma(1, 2, 4);
        ex02.printPauta();
    }

    public int getNota(int aluno, int uc){
        int[][] newArr = new int[5][5];
        for (int i = 0; i < 5; i++)
            System.arraycopy(this.notasTurma[i], 0, newArr[i], 0, 5);
        return newArr[aluno][uc];
    }

    public void setNotasTurma(int aluno, int uc, int nota) {
        int[][] newArr = new int[5][5];
        for (int i = 0; i < 5; i++)
            System.arraycopy(this.notasTurma[i], 0, newArr[i], 0, 5);
        newArr[aluno][uc] = nota;
        this.notasTurma = newArr;
    }

    public int getSomaUC(int uc){
        int sum = 0;
        for(int i = 0; i < this.n_ucs; i++){
            sum += getNota(i, uc);
        }
        return sum;
    }

    public double getMediaAluno(int aluno){
        double media = 0;
        for (int i = 0; i < this.n_ucs; i++) {
            media += getNota(aluno, i);
        }
        return media/this.n_ucs;
    }

    public double getMediaUC(int uc){
        double media = 0;
        for (int i = 0; i < this.n_alunos; i++) {
            media += getNota(i, uc);
        }
        return media/this.n_alunos;
    }

    public int getMaiorNota(){
        int n = 0;
        for (int i = 0; i < this.n_alunos; i++) {
            for (int j = 0; j < this.n_ucs; j++) {
                int nota = getNota(i, j);
                if(nota > n) n = nota;
            }
        }
        return n;
    }

    public int getMenorNota(){
        int n = Integer.MAX_VALUE;
        for (int i = 0; i < this.n_alunos; i++) {
            for (int j = 0; j < this.n_ucs; j++) {
                int nota = getNota(i, j);
                if(nota < n) n = nota;
            }
        }
        return n;
    }

    public int[] getNotasAcimaDe(int valor){
        int[] notas = new int[25];
        int n = 0;
        for (int i = 0; i < this.n_alunos; i++) {
            for (int j = 0; j < this.n_ucs; j++) {
                int nota = getNota(i, j);
                if(nota > valor){
                    notas[n++] = nota;
                }
            }
        }
        return notas;
    }

    public String toString(){
        StringBuilder pauta = new StringBuilder();
        for(int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++) {
                pauta.append(getNota(i, j));
            }
            pauta.append("\n");
        }
        return pauta.toString();
    }

    public int getUcMaiorMedia(){
        int uc = -1;
        double media = 0;
        for (int i = 0; i < this.n_ucs; i++) {
            double crt_media = getMediaUC(i);
            if(crt_media > media){
                uc = i;
                media = crt_media;
            }
        }
        return uc;
    }

    public void printPauta(){
        for(int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++) {
                System.out.print(getNota(i, j));
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
