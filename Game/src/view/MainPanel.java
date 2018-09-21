package view;

import java.awt.*;

public class MainPanel extends BasePanel {
    private PlayingGamePanel playingGamePanel;
    private BeginingGamePanel beginingGamePanel;
    @Override
    public void initContainer() {
        setBackground(Color.BLACK);
        setLayout(new CardLayout());

    }

    @Override
    public void initComponent() {
        playingGamePanel = new PlayingGamePanel();
        beginingGamePanel = new BeginingGamePanel();
        beginingGamePanel.setMainPanel(this);
        playingGamePanel.setMainPanel(this);
        add(beginingGamePanel);                 // add thang nao vao truoc thi hien thi truoc
        add(playingGamePanel);
    }

    @Override
    public void registerListener() {

    }
    public void showPlayingGamePanel(){
        playingGamePanel.setVisible(true);
    }

    public void showStartingGamePanel(){
        beginingGamePanel.setVisible(true);
    }
}
