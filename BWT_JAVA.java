import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class BWT_JAVA{

    //Posicao da palavra na matriz codificada
    private int posicao;

    String bwt(String palavra){
        int tamanho = palavra.length();
        String tabela[] = new String[tamanho];
        String palavra_aux = palavra;
        int j;
        StringBuilder nova_palavra = new StringBuilder(palavra);

        tabela[0] = palavra; //Colocando a palavra na tabela;

        for(int i = 1; i < tamanho; i++){ 
            char letra = palavra_aux.charAt(i-1);
            nova_palavra = new StringBuilder(nova_palavra);
            for(j = 0; j < tamanho-1; j++){ //Passando pra esquerda cada char do array
                char aux = nova_palavra.charAt(j+1);
                nova_palavra.setCharAt(j, aux);
            }
            nova_palavra.setCharAt(j, letra); //Colocando a letra inicial do array original (de iteracao) no final da palavra
            tabela[i] = nova_palavra.toString(); //Colocando a palavra permutada na tabela
        }


        StringBuilder palavra_retornada = new StringBuilder();
        for(int i = 0; i < tamanho; i++){ //Criando a palavra baseada na ultima coluna da tabela
            palavra_retornada.append(tabela[i].charAt(tamanho-1));
            if(tabela[i].equals(palavra)){ //Procurando a posicao da palavra dada no argumento na tabela
                posicao = i;
            }
        }

        return palavra_retornada.toString();
    }

    void bwt_reverse(String palavra_reversa){
        int tamanho = palavra_reversa.length();
        StringBuilder tabela[] = new StringBuilder[tamanho]; //Criando a tabela vazia

        //Inicializando as strings na tabela
        for(int i = 0; i< tamanho; i++){
            tabela[i] = new StringBuilder();
        }
        
        //Adicionando caracteres na tabela e organizando em forma alfabeticaa a cada iteracao 'tamanho' vezes 
        for(int j = 1; j <= tamanho; j++){
            for(int i = 0; i < tamanho; i++){//Adicionando caracteres
                tabela[i].insert(0,palavra_reversa.charAt(i));
            }
            Arrays.sort(tabela);
        }

        //Mostrando a tabela decodificada
        for(int i = 0; i < tamanho; i++){
            System.out.println(tabela[i].toString());
        }

    }

    public static void main(String[] args){
        BWT_JAVA ola = new BWT_JAVA();
        String retorno = ola.bwt("accelerate");
        System.out.println("Retorno " + retorno);
        ola.bwt_reverse(retorno);
    }
}