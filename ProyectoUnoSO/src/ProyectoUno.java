import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

public class ProyectoUno {
    public static void main(String[] args){
        List<Nodo> list = new ArrayList<>();
        int numProceso, opcion = 0, tamaño, tiempo;
        String nomProceso = null;
        
        do{
            try{
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Captura de datos.\n2. Ordenar lista por tamaño.\n3. Ordenar lista por tiempo.\n4. Ordenar lista por numero de proceso.\n5. Mostrar lista."+"\n6. Salir","Menu de opciones",1));
                
                switch(opcion){
                    case 1:
                        try{
                            numProceso = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero del proceso"));
                            nomProceso = JOptionPane.showInputDialog("Ingresa el nombre");
                            tamaño = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el tamaño del proceso"));
                            tiempo = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el tempo del proceso"));
                            list.add(new Nodo(numProceso,nomProceso,tamaño,tiempo));
                            
                        }catch(Exception e){    
                            JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
                        }
                        break;
                    case 2:   
                        Collections.sort(list,  (Nodo a, Nodo b) -> a.tamaño.compareTo(b.tamaño));
                        break;
                    case 3:
                        Collections.sort(list,  (Nodo a, Nodo b) -> a.tiempo.compareTo(b.tiempo));
                        break;
                    case 4:
                        Collections.sort(list,  (Nodo a, Nodo b) -> a.numProceso.compareTo(b.numProceso));
                        break;
                    case 5:
                        System.out.println("");
                        list.forEach(lista -> System.out.print(lista.toString()));
                        break;
                    case 6:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Option incorrecta");
                }
                
            }catch(Exception e){ 
                JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
            }
        }while(opcion!=6);
    }
}
