import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame(){
        this.setVisible(true);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel b1 = new JPanel();

        Dimension dimension = new Dimension(200, 600);
        b1.setPreferredSize(dimension);

        this.add(new JScrollPane(b1), BorderLayout.WEST);
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.red);
        this.add(mainPanel, BorderLayout.CENTER);

    }
}
