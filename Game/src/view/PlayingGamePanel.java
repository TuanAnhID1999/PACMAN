package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayingGamePanel extends BasePanel implements ActionListener{
    private GamePanel gamePanel;
    private MainPanel mainPanel;

    private JButton btnStartGame;
//    private JButton btnBackMenuGame;

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    @Override
    public void initContainer() {
        setBackground(Color.BLACK);
        setLayout(null);
    }

    @Override
    public void initComponent() {
        Font fontStartButton = new Font("Comic Sans MS",Font.BOLD,12);

        btnStartGame = new JButton("Start");
        btnStartGame.setFont(fontStartButton);
        btnStartGame.setBackground(new Color(0x11C86F));
        btnStartGame.setBounds((Gui.WIDTH_FRAME - 70) / 2, 20, 70, 30);
        btnStartGame.setActionCommand("OK");
        add(btnStartGame);

        gamePanel = new GamePanel();
        add(gamePanel);

    }

    @Override
    public void registerListener() {
        btnStartGame.addActionListener(this);
//        btnBackMenuGame.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "OK":
                btnStartGame.setVisible(false);
                gamePanel.requestFocusInWindow();               // gamePanel.requestFocus();
                gamePanel.startGame();
                break;

            default:
                break;
        }
    }
}
