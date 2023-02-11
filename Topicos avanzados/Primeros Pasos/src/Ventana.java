import java.awt.Dimension;
import javax.swing.JFrame;

public class Ventana extends JFrame {
    public Ventana(){
        setSize(500,500);
        setTitle("TecNM en Celaya");
        setLocation(100,200);
        setBounds(100,200,500,500);

        setLocationRelativeTo(null);

        setMinimumSize(new Dimension(200,200));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
  