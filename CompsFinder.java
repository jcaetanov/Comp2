/* ***************************************************************************
 *
 * CCM128 - Computação II
 * Aluno: João Victor Caetano
 * Numero USP: 10739674
 * Tarefa: Exercicio 5
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
 *************************************************************************** */
public class CompsFinder{
	private ST<String, SET<String>>  ab= new ST<String, SET<String>>();
    //private ST<String, Integer> dist = new ST<String, Integer>();
    private SET<String> list = new SET<String>();
    private Graph G;

//Suponha que este programa já entenda o graph temos thisG.G porque lidamos com uma variável global que será utiliozada dps
public CompsFinder(Graph G){
this.G=G;
//Varremos todos os adjacentes de um determinado ponto com pathfinder sem readicionar o mesmo ponto
for (String s : G.vertices())
	if(list.contains(s)) ;
else {
	PathFinderCC pf = new PathFinderCC(G,s);
	list = list.union(pf.cc());
	ab.put(s, pf.cc());
}
} //devolverá os componentes do graph
public int noComps(){
	return ab.size();

} //identifica os componentes atraves das chaves no exemplo sao 4
public Iterable<String> compIds() {
	return ab.keys();}

//trivial, conjunto dos véstices
public SET<String> comp(String v){
	PathFinderCC pf = new PathFinderCC(G,v);
	return pf.cc();


	} //Boolean que devolve se dois itens são da mesma componente conexa
public boolean sameComp(String v, String w){
	   PathFinderCC pf = new PathFinderCC(G,v);
	  if(pf.cc().contains(w)) return (true);
       else
        return (false);

}
/*public static void main(String[] args) {
King of the magic
        // create graph
        Graph graph = new Graph();
        while (!StdIn.isEmpty()) {
            String v = StdIn.readString();
            String w = StdIn.readString();
            graph.addEdge(v, w);
        }

        // print out graph
        StdOut.println(graph);

        // print out graph again by iterating over vertices and edges
        for (String v : graph.vertices()) {
            StdOut.print(v + ": ");
            for (String w : graph.adjacentTo(v)) {
                StdOut.print(w + " ");
            }
            StdOut.println();
        }

    } */


}