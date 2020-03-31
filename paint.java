
import java.awt.Color;
import static java.awt.Color.red;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

class paint extends JFrame implements MouseMotionListener, ActionListener {

    JButton red = new JButton("RED");
    JButton blue = new JButton("BLUE");
    JButton green = new JButton("GREEN");
    JButton eraser = new JButton("Eraser");

    Color c;

    public paint() {

        red.setBounds(50, 8, 80, 25);
        blue.setBounds(150, 8, 80, 25);
        green.setBounds(250, 8, 80, 25);
        eraser.setBounds(350, 8, 80, 25);
        red.setBackground(Color.RED);
        blue.setBackground(Color.BLUE);
        green.setBackground(Color.GREEN);
        eraser.setBackground(Color.white);

        red.addActionListener(this);
        blue.addActionListener(this);
        green.addActionListener(this);
        eraser.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 40, 500, 360);
        add(panel);
        add(red);
        add(blue);
        add(green);
        add(eraser);
        setTitle("Simple Paint");
        setSize(500, 400);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        addMouseMotionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new paint();
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        Graphics g = getGraphics();
        g.setColor(c);
        if (me.getY() > 61) {
            g.fillOval(me.getX(), me.getY(), 7, 7);
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == red) {
            c = Color.RED;
        } else if (ae.getSource() == blue) {
            c = Color.BLUE;
        } else if (ae.getSource() == green) {
            c = Color.GREEN;
        } else if (ae.getSource() == eraser) {
            c = Color.WHITE;
        }
    }
}
