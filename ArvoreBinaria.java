
public class ArvoreBinaria {
	  private No raiz;
	  String tab = "\t";
	  int i = 0;
	  
	  public ArvoreBinaria() {
	    this.raiz = null; 
	  }
	  
	  public void insere(long id, Object elemento) {
	    No novoNo = new No(id,elemento,null,null);
	    if (raiz == null) {
	      raiz = novoNo;
	    } else {  
	      No atual = raiz; No pai;
	      while (true) {   
	        pai = atual;   
	        if (id < atual.getId()) { 
	          atual = atual.getEsq();          
	          if (atual == null) { 
	            pai.setEsq(novoNo);
	            return;
	          } 
	        } else { 
	          atual = atual.getDir();
	          if (atual == null) { 
	            pai.setDir(novoNo);
	            return;
	          }
	        }
	      }
	    }
	  } 

	  // A)
	  
	  private void preFixado(No atual) {
		  String repete = new String(new char[i]).replace("\0", tab);
	    if (atual != null) {
		    i++;
	      System.out.println(repete + atual.getId());
	      preFixado(atual.getEsq());	  
	      preFixado(atual.getDir());
		    i--;
	    }
		  if(atual == null){
			  System.out.println(repete+"-");
		  }
	  } 

	  public void imprimeElementosArvore() {
	    preFixado(raiz);
	  } 
	  
	  private long calcAltura(No atual, long a) {
	    if (atual != null) {
	        long e,d;
	        e = calcAltura(atual.getEsq(),a)+1;
	        d = calcAltura(atual.getDir(),a)+1;
	      if (e > d) {
	        return a+e;
	      } else {
	        return a+d;
	      }
	    }
	    return a;
	  } 
	  
	  // B)

	  public long alturaArvore() {
	    long a = 0;
		System.out.println("  ");
	    return calcAltura(raiz,a);
	  } 
	  
	  private long calcEsqFest(No atual, long a) {
	    if (atual != null) {
	        long e,d;
	        e = calcEsqFest(atual.getEsq(),a)+1;
	        return a+e;

	    }
	    return a;
	  }
			
	  public long totEsquerda() {	
			long esq = 0;
			return calcEsqFest(raiz, esq); 
	  }
	}