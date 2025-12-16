/*

    SIDNEI CORREIA JUNIOR [2510102122]
    ADRIANO MOISES [2510101615]

    INTERFACE MADE BY:
    SIDNEI CORREIA JUNIOR [2510102122]
*/ 


import javax.swing.*;
import java.awt.*;
import javax.lang.model.element.Element;

public class Window extends JFrame implements Elements{
    private JPanel panel;


    public Window(){
        super();
        configurarJanela();
        bg_Panel();
        repaint();
    }
    
    private void configurarJanela(){
        getContentPane().setBackground(new Color(250,250,250));
        setTitle("Corre Cabrito");
        setSize(900,680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        Elements.menu_game.add(Elements.menu_volume);
        Elements.menu_volume.addActionListener(Logic.volume_Control());
        Elements.menu_game.add(Elements.menuItem_restart);
        Elements.menu_game.add(Elements.menu_authors);
        Elements.menu_authors.addActionListener(Logic.show_authors());

        Elements.menu.add(Elements.menu_game);
        Elements.menuItem_restart.addActionListener(Logic.restart_game(this));
        
        Elements.menu.add(Elements.menu_exit);
        Elements.menu_exit.addMouseListener(Logic.exit_game());

        setJMenuBar(Elements.menu);

        setVisible(true);
    }

    private void bg_Panel(){
        panel = new JPanel();

        panel.setBounds(0,0,900,700);
        panel.setLayout(null);

        panel.add(Elements.line1);
        panel.add(Elements.line2);
        panel.add(Elements.line3);
        panel.add(Elements.line4);
        panel.add(Elements.line5);
        panel.add(Elements.line6);
        panel.add(Elements.line7);
        panel.add(Elements.line8);

        Elements.circle1.setName("c1");
        Elements.circle2.setName("c6");
        Elements.circle3.setName("c2");
        Elements.circle4.setName("c5");
        Elements.circle5.setName("c4");
        Elements.circle6.setName("c3");

        ((Circle) Elements.circle1).setLetter("C");
        ((Circle) Elements.circle4).setLetter("A");

        panel.add(Elements.circle1);
        panel.add(Elements.circle2);
        panel.add(Elements.circle3);
        panel.add(Elements.circle4);
        panel.add(Elements.circle5);
        panel.add(Elements.circle6);
        
        Elements.circle1.addMouseListener(Logic.Clicked( Elements.circle1));
        Elements.circle2.addMouseListener(Logic.Clicked( Elements.circle2));
        Elements.circle3.addMouseListener(Logic.Clicked( Elements.circle3));
        Elements.circle4.addMouseListener(Logic.Clicked( Elements.circle4));
        Elements.circle5.addMouseListener(Logic.Clicked( Elements.circle5));
        Elements.circle6.addMouseListener(Logic.Clicked( Elements.circle6));

        panel.setVisible(true);
        add(panel);
        statusPanel();
    }

    public void statusPanel(){

        status.setBounds(0, 580, 900, 50);
        status.setBackground(new Color(55,55,55));
        status.setLayout(new BorderLayout(20, 0)); // Use BorderLayout with a horizontal gap
        status.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 80)); // Add padding (top, left, bottom, right)

        plays.setText("Jogadas: 0");
        plays.setFont(new Font("Arial", Font.PLAIN, 22));
        plays.setForeground(Color.white);

        player.setText("Jogador atual: Cabrito");
        player.setFont(new Font("Arial", Font.PLAIN, 22));
        player.setForeground(Color.white);



        status.add(plays, BorderLayout.WEST);
        status.add(player, BorderLayout.EAST);
        
        panel.add(status);
    }
}
