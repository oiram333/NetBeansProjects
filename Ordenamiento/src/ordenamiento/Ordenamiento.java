package ordenamiento;

public class Ordenamiento {

    public static void main(String[] args) {
         MetodosOrdenamiento orden=new MetodosOrdenamiento();
         Arreglo arreglo = new Arreglo();
          
        //System.out.println("Arreglo desordenado: ");
        //orden.mostArreglo(arreglo.extrArreglo());
        System.out.println("Arreglo ordenado por el metodo Quicksort: ");
        //orden.mostArreglo(orden.quicksort(arreglo.genArreglos(), 0, arreglo.genArreglos().length-1));
        //System.out.println("Arreglo ordenado por el metodo Burbuja: ");
        orden.mostArreglo(orden.burbuja(arreglo.genArreglos()));
        
    }
}
