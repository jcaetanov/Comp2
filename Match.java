/* ***************************************************************************
 *
 * CCM128 - Computação II
 * Aluno: João Victor Caetano
 * Numero USP: 10739674
 * Tarefa: Exercicio 9
 * Data: 09/06/2019
 *
 * Baseado em programas recomendados na página do Paca relacionada ào exercício.
 * Principalmente em WordGraphPlain e WordLadders.
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE,
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 *Oi, tive muito trabalho  para desenvolver este ep
 *Tive problemas trabalhando com classes static e nonstatic pois node cria objeto
 *Ele esta funcional para uma pequena entrada, mas estoura em entradas maiores que provavelmente ocorre quando chamamos   SearchTree
 *na Node Put, achei a ideia boa, espero que entenda. c:
 *************************************************************************** */
import pieces.*;
public class Match{
  public static int[] arr;
  public static int[] match(NutsAndBolts nab){
    Nut[] nutss = nutt(nab);
    //Vetor de porcas
    Bolt[] boltss = boltt(nab);
    //Vetor de bolts.
    int lo=0;
   arr = vector(nab.N());
    //vetor de indices das porcas
    int hi = nab.N()-1;
    Bolt pivot;
    //Parafuso que sera comparado com as porcas
    int indice;
    pivot = boltss[0];
    //Primeiro elemento
    indice =  partition(arr, nutss,lo,hi, pivot);
    //Busca pelo match dele
    SearchTree(indice, nutss[indice], nab, boltss, nutss);
return arr;
}


public static Nut[] nutt(NutsAndBolts nab){
  //Vetor de porcas
  Nut[] result = new Nut[nab.N()];
  for(int i = 0; i<nab.N();i++)result[i]=nab.nuts(i);
  return result;
}

public static Bolt[] boltt(NutsAndBolts nab){
  //Vetor de porcas
  Bolt[] result = new Bolt[nab.N()];
  for(int i = 0; i<nab.N();i++)result[i]=nab.bolts(i);
  return result;
}


public static int[] vector(int N){
  //Vetor de indices {0, 1, 2, 3, 4 ,[...]}
  int[] result = new int[N];
  for(int i=0; i<N; i++)
    result[i] = i;
  return result;
  }



public static int partition(int[] arr, Nut[] nuts, int lo, int hi, Bolt pivot)
    {
//comparacao com um tipo de quicksort adaptado para comparar i e j e troca los se obedecerem a condicao
        int i = lo;
        int j = hi;


        while(true){
          if(less(nuts[i],pivot)==false&&less(nuts[j],pivot)==false) break;

          while(less(nuts[i], pivot)){
            i++;
          if(i==hi)break;
        }
        while(less(nuts[j], pivot)){
          j--;
            if(j==lo) break;

          }
          if(i>=j) break;

        }
        exch(arr, lo, j);
        j--;
        return j;
    }

    public static boolean less(Nut v, Bolt w) {
      //Compara porca com parafuso
      //retorna true se a porca for menor que o parafuso
     if (v.compareTo(w)==0) return false;
     if (v.compareTo(w)>0) return false;
     return true;
 }
 public static Node put(Node x, int key, Nut val, Bolt pivot, Nut[] nutss) {
//Coloca os valores em seus devidos nos
      if(pivot.compareTo(x.val)<0&&x.left==null) return newNode(key, val);
      if(pivot.compareTo(x.val)>0&&x.right==null) return newNode(key, val);
      if(pivot.compareTo(x.val)<0&&x.right==null) return newNode(key, val);
      if(pivot.compareTo(x.val)>0&&x.left==null) return newNode(key, val);
       if (pivot.compareTo(x.val)<0) {x.left  = put(x.left,key, val, pivot, nutss);}
       else  {  x.right = put(x.right, key, val,pivot, nutss);}
       return x;
   }

    public static void SearchTree(int indice, Nut val0, NutsAndBolts nab, Bolt[] boltss, Nut[] nutss){
        Node root;
        Bolt pivot = boltss[0];
        root = newNode(indice, val0);
        int[] lohi = new int[2];
        int lo=0;
        int hi = nab.N()-1;
        lohi[0] = lo; lohi[1] = hi;


      for(int i = 1; i<nab.N();i++){
        pivot = boltss[i];
        //Pego um parafuso
        lohi = buscaRecursiva(pivot, root, lohi, nab.N());
        //Busco os intervalos de busca.
        lo = lohi[0]; hi = lohi[1];
        indice = partition(arr, nutss,lo,hi, pivot);
        //Uso eles na funcao que busca e ordena os vetores
        root = put(root, indice, nutss[indice], pivot, nutss);
        //Coloco a posicao encontrada na arvore binaria
      }

    }

    public static int[] buscaRecursiva(Bolt pivot, Node x, int[] Padrao, int N){

      int[] loandhi = new int[2];
      Padrao[0] = 0;
      Padrao[1] = N-1;
      //Retorna o intervalo
      if(pivot.compareTo(x.val)>0) {
        if(x.right==null) { loandhi[0] = x.key; loandhi[1] = Padrao[1];
        return loandhi;
       }
        else {
          Padrao[0] = x.key;
          buscaRecursiva(pivot, x.right, Padrao, N);
        }
      }
      else {
        if(x.left==null) {
          loandhi[0] = Padrao[0];
          loandhi[1] = x.key;
          return loandhi;
        }
        Padrao[1] = x.key;
        buscaRecursiva(pivot, x.left, Padrao,N);
      }
      return loandhi;
    }
//chamada da partition
 public static void exch(int[] a, int i, int j) {
       int swap = a[i];
       a[i] = a[j];
       a[j] = swap;
   }
   //trabalhar com static e non static
  public static Node newNode(int key, Nut val){
    Node temp = new Node();
    temp.key = key;
    temp.val = val;
    temp.left = null;
    temp.right = null;
    return temp;
  }
 static class Node {
        int key;           // sorted by key
        Nut val;         // associated data
        Node left, right;  // left and right subtrees
      }





 }
