package view;

import manager.GameManager;
import manager.PlayerWav;
import model.MapItem;
import model.Pacmann;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.BitSet;

public class GamePanel extends BasePanel implements ActionListener {
    private PlayingGamePanel playingGamePanel;
    private GameManager gameManager;
    private BitSet bitSet;
    private PlayerWav playerWavBeginning;
    public int scoreGame;

    public static final int WIDTH_GAMEPANEL = 21 * MapItem.SIZE;
    public static final int HEIGHT_GAMEPANEL = 24 * MapItem.SIZE;

    private JLabel lbScore;
    private JLabel lbHighScore;
    private JLabel lbShowScore;
    private JLabel lbShowHighScore;
    private JLabel lbGameOver;
    private JButton btnResetGame;


    public GamePanel() {

        playerWavBeginning = new PlayerWav("pacman_beginning");

    }

    @Override
    public void initContainer() {
        setBackground(Color.BLACK);
        setSize(WIDTH_GAMEPANEL, HEIGHT_GAMEPANEL);
        setLocation(0, 0);
        setFocusable(true);
        setLayout(null);
    }

    @Override
    public void initComponent() {
        Font fontScore = new Font("Comic Sans MS", Font.BOLD, 20);
        FontMetrics fontMetricsScore = getFontMetrics(fontScore);

        lbScore = new JLabel();
        lbScore.setText("SCORE");
        lbScore.setFont(fontScore);
        lbScore.setForeground(Color.WHITE);
        lbScore.setBounds(50, 15, 150, 20);
        add(lbScore);

        lbShowScore = new JLabel();
        lbShowScore.setText("000000");
        lbShowScore.setFont(fontScore);
        lbShowScore.setForeground(Color.WHITE);
        lbShowScore.setBounds(lbScore.getX(), lbScore.getY() + fontMetricsScore.getHeight(), 150, 20);
        add(lbShowScore);

        lbHighScore = new JLabel();
        lbHighScore.setText("HIGH SCORE");
        lbHighScore.setFont(fontScore);
        lbHighScore.setForeground(Color.WHITE);
        lbHighScore.setBounds(350, 15, 150, 20);
        add(lbHighScore);

        lbShowHighScore = new JLabel();
        lbShowHighScore.setText("000000");
        lbShowHighScore.setFont(fontScore);
        lbShowHighScore.setForeground(Color.WHITE);
        lbShowHighScore.setBounds(lbHighScore.getX() + 30, lbHighScore.getY() + fontMetricsScore.getHeight(), 150, 20);
        add(lbShowHighScore);

        lbGameOver = new JLabel();
        lbGameOver.setText("GAME OVER");
        lbGameOver.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lbGameOver.setForeground(Color.RED);
        lbGameOver.setBounds((Gui.WIDTH_FRAME - 100) / 2, 10, 100, 30);
        lbGameOver.setVisible(false);
        add(lbGameOver);

        btnResetGame = new JButton();
        btnResetGame.setText("Reset");
        btnResetGame.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        btnResetGame.setBackground(Color.YELLOW);
        btnResetGame.setForeground(Color.BLACK);
        btnResetGame.setBounds(lbGameOver.getX(), 45, 100, 20);
        btnResetGame.setActionCommand("RESET");
        btnResetGame.setVisible(false);
        add(btnResetGame);


        gameManager = new GameManager();
        gameManager.generateMap();
        bitSet = new BitSet();
    }

    @Override
    public void registerListener() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                bitSet.set(e.getKeyCode(), true);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                bitSet.set(e.getKeyCode(), false);
            }
        });
        btnResetGame.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "RESET":
                btnResetGame.setVisible(false);
                lbGameOver.setVisible(false);
                gameManager = new GameManager();
                gameManager.generateMap();
                break;

            default:
                break;
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        gameManager.drawReadyTitle(graphics2D);
        gameManager.drawFruit(graphics2D);
        gameManager.drawBean(graphics2D);
        gameManager.drawWalls(graphics2D);
        gameManager.drawPacman(graphics2D);
        gameManager.drawGhost(graphics2D);
    }

    public void startGame() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                playerWavBeginning.loop(0);
                playerWavBeginning.play();

                while (true) {
                    if (bitSet.get(KeyEvent.VK_UP)) {
                        gameManager.changeOrientationMyPacman(Pacmann.GO_UP);
                    } else if (bitSet.get(KeyEvent.VK_DOWN)) {
                        gameManager.changeOrientationMyPacman(Pacmann.GO_DOWN);
                    } else if (bitSet.get(KeyEvent.VK_LEFT)) {
                        gameManager.changeOrientationMyPacman(Pacmann.TURN_LEFT);
                    } else if (bitSet.get(KeyEvent.VK_RIGHT)) {
                        gameManager.changeOrientationMyPacman(Pacmann.TURN_RIGHT);
                    }
                    gameManager.moveMyPacman();
                    gameManager.moveMyGhost();
                    lbShowScore.setText(String.valueOf(gameManager.getScore()));

                    if (gameManager.isWin() == true) {
                        lbGameOver.setText("WIN");
                        add(lbGameOver);
                    }

                    if (gameManager.isStatusPacmanDie() == true) {
                        if (Integer.parseInt(lbShowHighScore.getText()) < Integer.parseInt(lbShowScore.getText())) {
                            lbShowHighScore.setText(lbShowScore.getText());
                        }
                        lbGameOver.setVisible(true);
                        btnResetGame.setVisible(true);
                    }

                    repaint();
                    gameManager.countdownCycle();
                    scoreGame = gameManager.getScore();
                    try {
                        Thread.sleep(7);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread threadPacman = new Thread(runnable);
        threadPacman.start();
    }
}
