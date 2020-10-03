import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class race extends JFrame implements ActionListener {

    private JButton b;
    private JPanel p;
    private JLabel l1, l2;
    private Paard jan = new Paard("jan weerd");
    private Paard vis = new Paard("jan Visscher");

    public static void main(String[] args){
        race f = new race();
        f.setSize(500,500);
        f.createGUI();
        f.setVisible(true);
    }
    void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        b = new JButton("start");
        p = new JPanel();
        l1 = new JLabel("de bovenste lijn is Jan Weerd\n de onderste lijn is jan visscher");
        p.setPreferredSize(new Dimension(550,540));
        window.add(b);
        window.add(l1);
        window.add(p);
        b.addActionListener(this);
    }

    public void racestart(){
        while (jan.getAfstand()< 500 && vis.getAfstand()<500){
            jan.loop();
            vis.loop();
            pause(200);
            Graphics paper = p.getGraphics();
            paper.clearRect(0,0,500,500);
            paper.fillRect(0,150, jan.getAfstand(), 10);
            paper.drawRect(0,300, vis.getAfstand(),10);
            paper.drawLine(500,400, 500,100);

        }
        if (jan.getAfstand() > vis.getAfstand()){
            System.out.println("jan weerd is de winner!");}
        else if(vis.getAfstand() > jan.getAfstand()) {
            System.out.println("jan Visscher is de winner");}
    }
    public void pause(int mSec) {
        try {
            Thread.sleep(mSec);
        } catch (InterruptedException e) {
            System.out.println("pauze");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        racestart();
    }
}
