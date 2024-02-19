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

public class PathFinderCC {

    // prev[v] = previous vertex on shortest path from s to v
    // dist[v] = length of shortest path from s to v
    private ST<String, String>  prev = new ST<String, String>();
    private ST<String, Integer> dist = new ST<String, Integer>();
    private SET<String> cc = new SET<String>();

    // run BFS in graph G from given source vertex s
    public PathFinderCC(Graph G, String s) {

        // put source on the queue
        Queue<String> queue = new Queue<String>();
        queue.enqueue(s);
        dist.put(s, 0);
        cc.add(s);
        // repeated remove next vertex v from queue and insert
        // all its neighbors, provided they haven't yet been visited
        while (!queue.isEmpty()) {
            String v = queue.dequeue();
            for (String w : G.adjacentTo(v)) {
                if (!dist.contains(w)) {
                    queue.enqueue(w);
                    cc.add(w);
                    //add W a SET CC
                    dist.put(w, 1 + dist.get(v));
                    prev.put(w, v);
                }
            }
        }
    }

    // is v reachable from the source s?
    public boolean hasPathTo(String v) {
        return dist.contains(v);
    }
    public SET<String> cc() {
        //Retorna CC para o SET
        return cc;
    }
    // return the length of the shortest path from v to s
    public int distanceTo(String v) {
        if (!hasPathTo(v)) return -1;
        return dist.get(v);
        }

    // return the shortest path from v to s as an Iterable
    public Iterable<String> pathTo(String v) {
        Stack<String> path = new Stack<String>();
        while (v != null && dist.contains(v)) {
            path.push(v);
            v = prev.get(v);
        }
        return path;
    }
}

    /*public static void main(String[] args) {
        String filename  = args[0];
        String delimiter = args[1];
        Graph G = new Graph(filename, delimiter);
        String s = args[2];
        PathFinderCC pf = new PathFinderCC(G, s);
        while (!StdIn.isEmpty()) {
            String t = StdIn.readLine();
            for (String v : pf.pathTo(t)) {
                StdOut.println("   " + v);


            } if(distanceTo(t) ==(-1) )
                    StdOut.println("Não conexo");
else
           
                
            StdOut.println("distance " + pf.distanceTo(t));
            
        }
    }


}

*/