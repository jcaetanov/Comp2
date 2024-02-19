/* ***************************************************************************
 *
 * CCM128 - Computação II
 * Aluno: João Victor Caetano
 * Numero USP: 10739674
 * Tarefa: Exercicio 4
 * Data: 5/5/2019
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
 * Ep sem as arvores aleatórias de busca
 * 
 *
 *************************************************************************** */
 import java.util.Arrays;


  public class BTStats {
    //Programa utiliza variaveis globais
    private ST<String, int[]> pk = new ST<String,int[]>();
    public int cauda;
    private int N;
    private String TT;
    int[] h = new int[2];
private void perm2(char[] b, int n) {

    if (n == 1) {
      
     root = new Node(b[0], 0);
     TT = "";
     int value =1;
     cauda = 0;     
     for(int j=1; j<N;j++){
       root = put(root, b[j], value);
     }
     
     perm(root);
     if(pk.contains(TT)) {
      int[] h = pk.get(TT);
       h[0] = h[0] + 1;
       pk.put(TT,h);
     }//Atravez da permutações a criação das arvores binarias
     else {
       int[] h = new int[2];
       h[0] = 1;
      h[1] = cauda;
       pk.put(TT, h);
     }
     return;
    
   }
    for (int j = 0; j < n; j++) {
        swap(b, j, n-1);
        perm2(b, n-1);
        swap(b, j, n-1);
        //freq e profundd dos nos das respectivas arvores
}
}
//Forma bruta
public BTStats(int N, boolean bruteForce){
  this.N=N;
  if(bruteForce){
      char[] b = new char[N];
      for(int j = 0; j<N; j++){
        b[j] = (char)('b'+j);
      }
    int n = N;
      perm2(b,n);
     
  }
}
private void swap(char[] b, int i, int j) {
  char c = b[i];
  b[i] = b[j];
 //troca de valores char
  b[j] = c;
}
//Código visto em aula "++-++" de acordo com a arvore e criação da prox classe
public void perm(Node x){
  if(x.left!=null) perm(x.left);
else TT = TT+"+";
if(x.right!=null) perm(x.right);
else TT = TT+"+";
TT = TT + "-";

}



public long factorial(int N) {
        long thiss = 1;
        for (int factor = 2; factor <= N; factor++) {
            thiss *= factor;
        }
        return thiss;
    }

private Node root;
private class Node {
    private char key;          // sorted by key
    private Node left, right;  // left and right subtrees
    private int value;

    public Node(char key, int value) {
        this.key = key;
        this.value = value;

    }

}
private Node put(Node x, char key, int value) {
      if (x == null) { return new Node(key, value);}
       if (key > x.key){  x.right = put(x.right, key, value+1); cauda++;} 
      else if      (key < x.key){ x.left  = put(x.left,  key, value+1); cauda++;}
     
      return x;
  }

public void printDistribution(){
  for(String s: pk.keys()){
    int[] h = pk.get(s);
  System.out.println(s + h[0]);
}
}
public void plotDistribution(){
  
  int q = pk.size();int e= 0; double[] b= new double[q];
  double[] g = new double[q]; 
  StdDraw.setPenRadius(1);
  StdDraw.setPenColor(StdDraw.BLACK);
  for(String s: pk.keys()){
    int[] h = pk.get(s);
    b[e] = h[0]/1.0; 
    e++;
  }
  Arrays.sort(b);
  StdDraw.setXscale(0, q);
  StdDraw.setYscale(0,q);
  int j = 0;
    for(int p = pk.size()-1; p>=0;p--){
      g[j] = b[p];
      j++;
    }
    StdStats.plotBars(g);
  }
//calcula e retorna profundidade com peso
double soma = 0;double o = 0;
public double aDepthUBTc(){
  for(String s: pk.keys()){
    int[] b = pk.get(s);
    soma = soma + (b[1]/N);
    o++;
  }
  return ((soma*1.0)/o);
}
double som=0; int os = 0;
//plot grafico
public double aDepthBSTc(){
for(String s: pk.keys()){
  int[] b = pk.get(s);
  som = som + ((b[1]/N)*b[0]);
}
return (som*1.0/factorial(N));
}
}