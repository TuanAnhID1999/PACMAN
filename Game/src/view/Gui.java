package view;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame implements IViewInitializer {               // getContentPanel() => lay panel mac dinh co tren Gui(Frame)
    public static final int WIDTH_FRAME = GamePanel.WIDTH_GAMEPANEL;
    public static final int HEIGHT_FRAME = GamePanel.HEIGHT_GAMEPANEL;

    private MainPanel mainPanel;

    public Gui() {
        initContainer();
        initComponent();
        registerListener();
    }

    @Override
    public void initContainer() {
        setTitle("Pacman");
        Image icon = new ImageIcon(Gui.class.getResource("/res/drawable/icon/pacman.png")).getImage();
        setIconImage(icon);
//        setSize(WIDTH_FRAME,HEIGHT_FRAME);
        getContentPane().setPreferredSize(new Dimension(WIDTH_FRAME,HEIGHT_FRAME));
        setResizable(false);                                                            // bat buoc nam o giua 2 dong lenh tren
        pack();

        setLocationRelativeTo(null);
        setBackground(Color.GRAY);
        setLayout(new CardLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void initComponent() {
//        gamePanel = new GamePanel();
//        add(gamePanel);
//        gamePanel.startGame();
//
//        scorePanel = new AchievementGamePanel();
//        add(scorePanel);

//        playingGamePanel = new PlayingGamePanel();
//        add(playingGamePanel);
        mainPanel = new MainPanel();
        add(mainPanel);
    }

    @Override
    public void registerListener() {

    }
}
