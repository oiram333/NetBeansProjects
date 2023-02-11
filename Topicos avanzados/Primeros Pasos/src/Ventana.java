import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana extends JFrame {
    public Ventana(){
        setSize(500,500);//tamaño de a ventana
        setTitle("TecNM en Celaya");// nombrar el titulo de la ventana
        setLocation(100,200);// establecemos la posición de la ventana
        setBounds(100,200,500,500);// x e y equivale a los pixeles, y los ostros dos son el ancho y largo de la ventana

        setLocationRelativeTo(null);//Establecemos la ventana en el centro

        setMinimumSize(new Dimension(200,200));//establece el tamaño minimo de una ventana

        //this.getContentPane().setBackground(Color.BLUE);//pintamos nuestra ventana

        

        setDefaultCloseOperation(EXIT_ON_CLOSE);//cuando finalice la ventana, el programa termina

    }
}
  