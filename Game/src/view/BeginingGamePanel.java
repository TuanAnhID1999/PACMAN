package view;


import manager.ImageStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BeginingGamePanel extends BasePanel {
    private MainPanel mainPanel;
    private MouseAdapter mouseAdapter;
    private JLabel lbStartingGame;
    private Font font;

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
        font = new Font("Comic Sans MS",Font.BOLD,32);
        FontMetrics fontMetricsTitle = getFontMetrics(font);
        lbStartingGame = new JLabel();
        lbStartingGame.setText("CLICK TO START");
        lbStartingGame.setFont(font);
        lbStartingGame.setForeground(Color.RED);
        int widthTextTitle = fontMetricsTitle.stringWidth(lbStartingGame.getText());
        int heighTextTitle = fontMetricsTitle.getHeight();
        lbStartingGame.setBounds((Gui.WIDTH_FRAME - widthTextTitle) / 2, 450, widthTextTitle, heighTextTitle);
        add(lbStartingGame);

    }

    @Override
    public void registerListener() {
        addMouseListener(mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                mainPanel.showPlayingGamePanel();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;
        drawIcon(graphics2D);
    }

    private void drawIcon(Graphics2D graphics2D){
        graphics2D.drawImage(ImageStore.IMG_TITLE,(Gui.WIDTH_FRAME-400)/2,(Gui.HEIGHT_FRAME-200)/2,400,120,null);
    }
}
