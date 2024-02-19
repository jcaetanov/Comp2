/* ***************************************************************************
 *
 * CCM128 - Computação II
 * Aluno: João Victor Caetano
 * Numero USP: 10739674
 * Tarefa: Exercicio 7
 * Data: 12/5/2019
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
import java.util.NoSuchElementException;

public class HashingProfile {
	private static boolean dale = false;
	private static int m=1;
	private static int M;
	private static int t2=0;
	
	private  static ST<String, Integer> st = new ST<String, Integer>();
	private static ST<Integer, SET<String>> hax= new ST<Integer, SET<String>>();
	  private  static int[] primes = {
	1, 2, 3, 7, 13, 31, 61, 127, 251, 509, 1021, 2039, 4093, 8191, 16381,
	32749, 65521, 131071,
	262139, 524287, 1048573, 2097143, 4194301, 8388593, 16777213, 33554393,
	67108859, 134217689, 268435399, 536870909, 1073741789, 2147483647
    };


	//Calculo M em potencias de 2
	public static int HashingProfile(int l){
		for(int i=0; i<l; i++){
			m = (2*m);
		}
		return m;
		
	}
//funcao hash
private  static int hash(String key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    //funcao hashu
	private  static int hashU(String key) {
	int h = 0, a = 31415, b = 27183;
	String s = key;
	//StdOut.println("teste 2");
	for (int i = 0; i < s.length(); i++, a = a*b % (M-1))
	    h = ((a*h + s.charAt(i)) & 0x7fffffff) % M;
	return h;
    }

    
//Separação para usar HashU e hash!!
    public static void coc(String a){
    	int q;
    	
    	if(dale==true){
    		 q = hashU(a);
    	}
    	else q = hash(a);
    	SET<String> set = new SET<String>();
    	if(!hax.contains(q)) hax.put(q, set);
    	if(hax.get(q).isEmpty()){
    		set.add(a);
    		 hax.put(q, set);}
    	else {
    		set = hax.get(q);
    		set.add(a);
    		hax.put(q,set);
    	}

    }
    //Função click chamada na main
    public static  void click(String key) {
        int count = count(key);
        st.put(key, count + 1);
    }
    //Função count chamada na click
    public static int count(String key) {
        if (!st.contains(key)) return 0;
        else return st.get(key);
    }
     public static void plotLines(double[] a,int t2) {
        //Plot do histograma
        int n = a.length;
        StdDraw.setPenRadius(0.08);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setXscale(-1, n);
        StdDraw.setYscale(-1,t2+1);
        for (int i = 0; i < n; i++) {
            StdDraw.filledRectangle(i, a[i]/2, 0.25, a[i]/2);
        }
    }
   
    
      public static void main(String[] args) { 
    

        //Primeiro item a ser considerado na entrada
        int l = Integer.parseInt(args[0]);
        M = HashingProfile(l);
        //A segunda entrada pode variar entre um int e p(primos) 
        //Varia como o programa rodará
        if(args[1].equals("-p")==true){
        	for(int i=0; i<primes.length; i++){
        		if(M<primes[i]) {M=primes[i-1];
        		break;}
        		else ;
        		
        	}
        }
        //Segunda entrada em int
         //use numeros primos
        //Terceira entrada com separação de -u e -s hash e hashU
        if(args[2].equals("-u")==true){
        	dale = true;
        } //
        String p = args[2]; //
        double ln = M*Math.log(M);

            while(!StdIn.isEmpty()) {
        	
            String key = StdIn.readString();
            click(key);
            coc(key);
        }
        int N= st.size();
       
        StdOut.println("M"+""+"="+""+M);
        StdOut.println("M log M"+"="+""+ln);
        StdOut.println("N"+""+"="+""+ N);
        StdOut.println("N/M"+""+"="+""+(double)N/M);
        int top=0;
        if(args.length > 4 ==true){
        for (int s : hax.keys()){
        if(hax.get(s).isEmpty());  	
        else {StdOut.println("[" + hax.get(s).size() + "] "+ s );
        for(String d : hax.get(s)){
        StdOut.println(d);
         }}}}
         for(int w :hax.keys()){
         if(!hax.get(w).isEmpty())top++;  }
         double[] v = new double[M]; int t1=0; int t2=0;
         for(int t: hax.keys()){
         	v[t] = hax.get(t).size();
         	t1 = (int)v[t];
         	if(t1>t2) t2 = t1;
         }
         //System.out.println(t2);
         if(args.length>3 ==true){
         	plotLines(v,t2);}

       StdOut.println("Hits"+ ""+"="+top);
    }




}