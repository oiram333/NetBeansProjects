package ordenamiento;

import static ordenamiento.ManejoDatos.*;

public class Arreglo {
    public int[] genArreglos(){
        int i=0, cantidad=1000000, rango=1000000;
        int arreglo[] = new int[cantidad];
        
        arreglo[i]=(int)(Math.random()*rango+1);
        for(i=1; i<cantidad;i++){
            arreglo[i]=(int)(Math.random()*rango+1);
            for(int j=0;j<i;j++){
                if(arreglo[i]==arreglo[j])
                    i--;
            }
        }
        return arreglo;
    }
    
    /*public int[] extrArreglo(){
        String numeros=readToFile("archivos\\pruebas");
          
          String[] Sdatos =numeros.split(",");
          int[] datos=new int[Sdatos.length-1];
          
          for(int i=0; i<Sdatos.length-1;i++){
             datos[i]=Integer.parseInt(Sdatos[i]);
          }
          return datos;
    }*/
    
    private void mostArreglo(int[] dato){
        //createFile("archivos\\pruebas");
        for(int k=0; k<dato.length;k++){
            System.out.println("["+dato[k]+"]");
            //writeToFile("archivos\\pruebas", dato[k]);
        }
        }
    
    /*public void resultado(){
       mostArreglo(genArreglos());
        //System.out.println("Archivo escrito exitosamente.");
    }*/
}