/******************************************************************************
 *
 * CCM128 -Computação II
 * Aluno: João Victor Oliveira Caetano
 * Numero USP: 10739674
 * Tarefa: Anagrams
 * Data: 17/03/19
 *
 * Em geral foram utilizados recursos vistos em aula.
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE,
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/
 import java.util.Arrays;
    public class Anagrams{
  public static void main(String[] args){
    //Criação do ST SETstring para armazenar os codigos em fora de tabela
    ST< String, SET<String>> conjunto = new ST< String, SET<String>>();
    //Haverão 2 ST o conjunto ficará responsável por ordenar as paralas
    //o conjunto x servirá para molde na hora da impressão da saida
    //haverá uma comparação entre o conjunto x e a o fator c
    ST< String, SET<String>> conjuntox = new ST<String, SET<Srring>>();
    //Varredura do String até todos serem lidos
    //for (int i =o; s.length()>i; i++){
    for (int j = 0; !StdIn.isEmpty(); j++){
     String a=StdIn.readString();
     //Código que lê a String
     a =a.toLowerCase();
     //Função que deixa os caracteres minusculos
     char[] b=a.toCharArray();
     //criação de uma array dessas Strings
     Arrays.sort(b);
     //A função sort ordenará o array
     String c =String.copyValueOf(b);
     //Item chave para criação do elemento de conparação entre palavras,

     SET<String> sub = new SET<String>();
//criação de outro SET para a implementação do código, salvando dados nestes String
     SET<String> sud = new SET<String>();
     //Comparação entre palavras e o fator c para a verificação dos anagramas com o mesmo c
      if (!conjunto.contais(c)){
       sub.add(a);
       sud.add(a);
       conjunto.put(a,sub);
       conjuntox.put(a,sub);}
       else
       {
         sub=conjunto.get(c);
         sud=conjunto.get(c);
         sub.add(a);
         conjunto.put(c,sub);
         sud.add(a);
         conjuntox.put(conjunto.get(c).min(), sud);
         //comparação do conjuntx para impressão na ordem correta dos anagramas


     }

  }
  //Saida dos anagramas com detecção de palavras sem anagramas para não printar-la - as
  for (String s : conjuntox.keys()) {
          if (s.length() > 1 && conjuntox.get(s).size() >= 2)
                StdOut.println("*"+conjuntox.get(s));
              }
            }
          }
