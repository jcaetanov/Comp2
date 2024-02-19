import java.util.Arrays;

  public class WordGraph {
    private Graph graph;
    private static boolean isNeighbor(String a, String b) {
        int differ = 0;
        for (int i = 0; i < a.length(); i++) {
          if (a.charAt(i) != b.charAt(i)) differ++;
          if (differ>1) return false;
        }
        return true;
      }

    public WordGraph(In in) {
      String[] palavras = in.readAllStrings();
      int compr = palavras[1].length();
      Graph G = new Graph();
      for(int k=0; k<palavras.length; k++) G.addVertex(palavras[k]);
      for (int m = 0; m<compr; m++) {
          Arrays.sort(palavras);
          for (int z = 0; z < palavras.length; z++) {
            for (int v = z+1; v<palavras.length; v++) {
              if (isNeighbor(palavras[z], palavras[v])){
                for (int q = m; q > 0; q--) {
                  String Z = palavras[z];
                  String V = palavras[v];
                  palavras[z]="";
                  palavras[v] = "";
                for ( int t = 1; t<compr; t++){
                  palavras[z] = palavras[z] + Z.charAt(t);}
                  palavras[z] = palavras[z] + Z.charAt(0);
                for ( int p = 1; p <compr; p++){
                  palavras[v] = palavras[v] + V.charAt(p);}
                  palavras[v] = palavras[v] + V.charAt(0);
                }
            G.addEdge(palavras[z],palavras[v]);
            for (int q = m; q > 0; q--) {
              String Z = palavras[z];
              String V = palavras[v];
              palavras[z]="" + palavras[z].charAt(compr-1);
              palavras[v] =""+ palavras[v].charAt(compr-1);
            for ( int w = 0; w+1<compr; w++)
              palavras[z] = palavras[z] + Z.charAt(w);
            for ( int e = 0; e+1 <compr; e++){
              palavras[v] = palavras[v] + V.charAt(e);}
                          }
                      }
                  }
        String Z = palavras[z];
        palavras[z] =""+ Z.charAt(compr-1) + Z.charAt(0);
        for(int r = 1; r+1<compr; r++){
          palavras[z] = palavras[z] + Z.charAt(r);}
          }
        }
this.graph = G;
}

    

    public Graph graph() { return this.graph; }

  }