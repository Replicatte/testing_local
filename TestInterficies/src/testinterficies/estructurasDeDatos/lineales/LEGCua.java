package testinterficies.estructurasDeDatos.lineales;


public class LEGCua<E> implements Cua<E>{
    NodeLEG<E> primer,ultim;

    public LEGCua (){
	primer = ultim = null;
    }
    
    public void encuar(E e){
	NodeLEG<E> nou = new NodeLEG<E>(e,null);
	//si la llista esta buida
	if (primer == null) // o ultim == null
	    primer = ultim = nou;
	else {
	    //enxufar-lo a la llista
	    ultim.setSeg(nou);    
	    ultim = nou;
	}	
    }
    
   public E desencuar(){
       if (primer == null) // o ultim == null
	   return null;
       
       E aTornar = primer.getDada();
       primer = primer.getSeg();

       //si sols hi ha un node
       if (primer == null)
	   ultim = null;
       
       return aTornar;
   }
    
   public E primer(){
       if (primer == null) //llista buida
	   return null;
       else
	   return primer.getDada();
   }   
   public boolean esBuida(){
       return primer == null;
   }
}
