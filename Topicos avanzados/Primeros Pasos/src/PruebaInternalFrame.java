import java.awt.FlowLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class PruebaInternalFrame {

    public static void main(String[] args) {
        new PruebaInternalFrame();
    }

    public PruebaInternalFrame() {

        JFrame jFrame = new JFrame("Este es un JFrame");
        JDesktopPane jDesktopPane = new JDesktopPane();

        jDesktopPane.setToolTipText("Este es un JDesktopPane");
        jFrame.getContentPane().add(jDesktopPane);

        JPanel jPanel = new JPanel();

        jPanel.setToolTipText("Este es un panel");
        jPanel.setLayout(new FlowLayout());
        jPanel.add(new JLabel("Una etiqueta"));
        jPanel.add(new JTextField(10));

        JInternalFrame jInternalFrame = new JInternalFrame("Este es un JInternalFrame");
        
        jInternalFrame.add(jPanel);
        jInternalFrame.pack();
        jInternalFrame.setResizable(true); 
        jInternalFrame.setClosable(true); 
        jDesktopPane.add(jInternalFrame);
        jFrame.setSize(500, 500);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jInternalFrame.setVisible(true);

    }

}