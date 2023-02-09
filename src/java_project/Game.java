package java_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JFrame {
    Image background = new ImageIcon((Main.class.getResource("../images/main_background.jpg"))).getImage();
    Image screenImage;
    Graphics screenGraphic;

    Image imageIcon1 = new ImageIcon(Main.class.getResource("../images/main_start.png")).getImage();   //이미지 주소 가져오기
    Image btn1 = imageIcon1.getScaledInstance(170, 52, 0);	//imageIcon1 크기 지정
    ImageIcon image1 = new ImageIcon(btn1);
    JButton button1 = new JButton(image1);

    Image imageIcon2 = new ImageIcon(Main.class.getResource("../images/main_rule.png")).getImage();
    Image btn2 = imageIcon2.getScaledInstance(147,52,0);
    ImageIcon image2 = new ImageIcon(btn2);
    JButton button2 = new JButton(image2);

    Image imageIcon3 = new ImageIcon(Main.class.getResource("../images/main_exit.png")).getImage();
    Image btn3 = imageIcon3.getScaledInstance(128,52,0);
    ImageIcon image3 = new ImageIcon(btn3);
    JButton button3 = new JButton(image3);

    public Game() {
        setUndecorated(true); //타이틀바 여부
        setTitle("Game");   //타이틀바 이름
        setSize(1280, 720); //화면 크기 지정
        setLocationRelativeTo(null);	//화면의 위치가 가운데로 오게 함
        setVisible(true);   //화면 보이는 여부
        setBackground(new Color(0,0,0,0));  //투명색
        setLayout(null);

        button1.setBounds(555, 450,170,52); //x = 화면 가로 길이의 반(640) - 버튼 가로 길이의 반
        button1.setBorderPainted(false);
        button1.setContentAreaFilled(false);
        button1.setFocusPainted(false);
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Start");
            }   //게임 화면으로 전환

            @Override
            public void mouseEntered(MouseEvent e) {    //마우스가 버튼 안에 들어왔을 때
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) { //마우스가 버튼 밖으로 나갔을 때
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        add(button1);

        button2.setBounds(567, 526,147,52);
        button2.setBorderPainted(false);
        button2.setContentAreaFilled(false);
        button2.setFocusPainted(false);
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Rule");
            }   //방법 화면으로 전환

            @Override
            public void mouseEntered(MouseEvent e) {    //마우스가 버튼 안에 들어왔을 때
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) { //마우스가 버튼 밖으로 나갔을 때
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        add(button2);

        button3.setBounds(576, 612,128,52);
        button3.setBorderPainted(false);
        button3.setContentAreaFilled(false);
        button3.setFocusPainted(false);
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Exit");
                System.exit(0); //프로그램 종료
            }

            @Override
            public void mouseEntered(MouseEvent e) {    //마우스가 버튼 안에 들어왔을 때
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) { //마우스가 버튼 밖으로 나갔을 때
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        add(button3);
    }

    public void paint(Graphics g) {
        screenImage = createImage(1280, 720);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }

    private void screenDraw(Graphics g) {
        g.drawImage(background , 0, 0, null);
        paintComponents(g);
        this.repaint();
    }
}
