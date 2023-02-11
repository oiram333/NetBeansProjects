package ordenamiento;

public class MetodosOrdenamiento {
    //metodo de ordenamiento rapido o quicksort.
        public int[] quicksort(int[] numero, int primero, int ultimo){
            if(primero>=ultimo)
                return numero;
            int i=primero, j=ultimo;
            if(primero!=ultimo){
                int pivote, auxiliar;
                pivote=primero;
                while(primero!=ultimo){
                    while(numero[ultimo]>=numero[pivote] && primero<ultimo)
                        ultimo--;
                    while(numero[primero]<numero[pivote]&&primero<ultimo)
                        primero++;
                    if(ultimo!=primero){
                        auxiliar=numero[ultimo];
                        numero[ultimo]=numero[primero];
                        numero[primero]=auxiliar;
                    }
                    if(primero==ultimo){
                        quicksort(numero,i,primero-1);
                        quicksort(numero,primero+1,j);
                    }
                }
            }else 
                return numero;
            return numero;
        }
 //metodo de ordenamiento lento o burbuja.
        public int[] burbuja(int[] numero){
            int auxiliar;
            boolean cambios=false;
            while(true){
                cambios=false;
                for(int i=1; i<numero.length;i++){
                    if(numero[i]<numero[i-1]){
                        auxiliar=numero[i];
                        numero[i]=numero[i-1];
                        numero[i-1]=auxiliar;
                        cambios=true;
                    }
                }
                if(cambios==false)
                    break;
            }
            return numero;
        }
 //metodo para mostrar el arreglo ordenado.
         public void mostArreglo(int[] dato){
        for(int k=0; k<dato.length;k++){
            System.out.print("["+dato[k]+"]"+" ");
        }
            System.out.println();
        }
  
}
