#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char* bwt(char* string);
void ordenar(char** tabela, int tamanho);

int main(){

    char* banana = bwt("banana");

    printf("%s\n", banana);

    return 0;
}

char* bwt(char* string){
    int tamanho = strlen(string);
    char string_aux[tamanho];
    strcpy(string_aux, string);
    char tabela[tamanho-1][tamanho];
    char letra_1, aux;
    int j;

    strcpy(tabela[0], string); //Copiando o primeiro caracter na tabela

    for(int i = 1; i < tamanho; i++){ //Preenchendo a matriz com as permutações
        letra_1 = string_aux[0];
        for(j = 0; j < tamanho; j++){ //Criando as permutações
            aux = string_aux[j+1];
            string_aux[j] = aux;
        }
        string_aux[j] = letra_1;
        strcpy(tabela[i], string_aux); //Copiando string pra ta bela
    }
    ordenar(tabela, tamanho); //Ordenando a matriz em ordem lexicografica

    char* palavra = malloc((sizeof(char)*tamanho)+1);

    for(int i = 0; i < tamanho; i++){
        palavra[i] = tabela[i][tamanho];
    }

    palavra[tamanho] = '\0';

    return palavra;
}

void ordenar(char** tabela, int tamanho){
    char* palavra;

    for(int i = 0; i < tamanho; i++){
        for(int j = 1; j < tamanho; j++){
            if(strcmp(tabela[j-1], tabela[j]) > 0){
                strcpy(palavra, tabela[j-1]);
                strcpy(tabela[j-1], tabela[j]);
                strcpy(tabela[j], palavra);
            }
        }
    }

}
