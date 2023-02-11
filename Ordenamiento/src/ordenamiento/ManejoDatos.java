package ordenamiento;

import java.io.*;

public class ManejoDatos {
    public static void createFile(String nameFile){
        File archivo = new File(nameFile);
        
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Archivo "+nameFile+" creado con exito.");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }
    public static void writeToFile(String nameFile, int contenido){
        File archivo = new File(nameFile);
        
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo,true));
            salida.println(contenido);
            salida.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static String readToFile(String nameFile){
        File archivo = new File(nameFile);
        String numeros=null;
        try {
            BufferedReader entrada =new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            numeros=lectura;
            while(lectura != null){
                    lectura = entrada.readLine();
                    numeros+=","+lectura;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return numeros;
    }
    
    public static void deleteFile(String nameFile){
        File archivo = new File(nameFile);
        
        System.out.println(archivo.exists());
        archivo.delete();
        System.out.println("El archivo "+archivo+" fue eliminado exitosamente.");
    }
}
