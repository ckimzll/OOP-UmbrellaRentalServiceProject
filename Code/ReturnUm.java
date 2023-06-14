import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;

class UmPanel extends JPanel {
    Rectangle2D.Double rect;
    BufferedImage img;
    TexturePaint texture;
    Rectangle imgRect;
	Font 	font1, font2, font3;

    public UmPanel() {

		font1 = new Font("맑은 고딕", Font.BOLD, 23);
		font2 = new Font("맑은 고딕", Font.PLAIN, 15);
		font3 = new Font("맑은 고딕", Font.BOLD, 13);

        rect = new Rectangle2D.Double(60, 60, 800, 800);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image im = toolkit.getImage("Images\\um.jpg");
        MediaTracker t = new MediaTracker(this);
        t.addImage(im, 0);
        try {
            t.waitForAll();
        } catch (Exception e) {
            System.out.println("MediaTracker error");
        }
        setBackground(Color.WHITE);

        img = new BufferedImage(im.getWidth(this), im.getHeight(this), BufferedImage.TYPE_INT_RGB);
        Graphics2D d2 = img.createGraphics();
        d2.drawImage(im, 0, 0, this);
        imgRect = new Rectangle(0, 0, im.getWidth(this), im.getHeight(this));
        texture = new TexturePaint(img, imgRect);

        JLabel lb1 = new JLabel("편의점 지점 명");
        lb1.setBounds(20, 240, 100, 50);
		lb1.setFont(font3);
        add(lb1);

        JLabel lb2 = new JLabel("GS25 숙대점");
        lb2.setBounds(20, 255, 150, 50);
        lb2.setForeground(Color.GRAY);
		lb2.setFont(font3);
        add(lb2);

        JLabel lb3 = new JLabel("대여일: 2023.06.08");
        lb3.setBounds(20, 300, 150, 50);
		lb3.setFont(font3);
        add(lb3);

        JLabel lb4 = new JLabel("반납기한: 2023.07.08");
        lb4.setBounds(20, 320, 150, 50);
		lb4.setFont(font3);
        add(lb4);

        JLabel lb5 = new JLabel("보증금 : 5000원");
        lb5.setBounds(20, 340, 150, 50);
		lb5.setFont(font3);
        add(lb5);

        JButton btn = new JButton("반납");
        btn.setForeground(Color.WHITE);
        btn.setBackground(Color.decode("#0C71AE"));
		btn.setFont(font3);
        btn.setBounds(120, 380, 60, 30);

        // Hide the UmPanel
        UmPanel umPanel = this;
        btn.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(this, "반납이 완료되었습니다.", "확인", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                umPanel.setVisible(false);
                ReturnUm returnUm = (ReturnUm) SwingUtilities.getWindowAncestor(this);
                returnUm.showMenuButton();
            }
        });
        add(btn);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw a gray rectangle
        g.setColor(Color.decode("#D9D9D9"));
        g.fillRect(10, 70, 300, 350);

        // Draw a circular shape
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(70, 90, 160, 160);
        g2d.setPaint(texture);
        g2d.fill(circle);
    }
}

public class ReturnUm extends JFrame implements ActionListener {
    private JButton menuButton, myPageButton, mapButton,rentalButton,logoutButton, cancelButton;
    private JPanel menupanel;
    private JPanel currentPanel;
    private JButton allBtn;
    private JButton refundBtn;
	Font 	font1, font2, font3;

    public ReturnUm() {
        setTitle("Mypage - Return Umbrella");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(430, 932);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

		font1 = new Font("맑은 고딕", Font.BOLD, 23);
		font2 = new Font("맑은 고딕", Font.PLAIN, 15);
		font3 = new Font("맑은 고딕", Font.BOLD, 13);

        UmPanel panel = new UmPanel();
        panel.setLayout(null);

        // menubar
        menuButton = new JButton(new ImageIcon("Images\\menu.png"));
        menuButton.setBounds(350, 15, 50, 50);
        menuButton.addActionListener(this);
        add(menuButton);

        allBtn = new JButton("전체 반납");
        allBtn.setForeground(Color.WHITE);
        allBtn.setBackground(Color.decode("#0C71AE"));
        allBtn.setBounds(100, 700, 120, 50);
		allBtn.setFont(font3);

        // Hide the UmPanel
        UmPanel umPanel = (UmPanel) panel;
        allBtn.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(this, "반납이 완료되었습니다.", "확인", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                umPanel.setVisible(false);
                showMenuButton();
                showButtons();
            }
        });
        add(allBtn);

        refundBtn = new JButton("보증금 환급");
        refundBtn.setForeground(Color.WHITE);
        refundBtn.setBackground(Color.decode("#0C71AE"));
        refundBtn.setBounds(230, 700, 120, 50);
		refundBtn.setFont(font3);

        refundBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Refund refund = new Refund();
                refund.setVisible(true);
            }
        });

        add(refundBtn);

        currentPanel = panel;
        add(currentPanel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuButton) {

            // Create the menu panel
            menupanel = new JPanel();
            menupanel.setLayout(null);
            menupanel.setBounds(0, 85, 420, 575);
            menupanel.setBackground(Color.white);

            // Create the "마이페이지" button = 뒤로가기 버튼
            myPageButton = new JButton("마이페이지");
            myPageButton.setBounds(50, 100, 320, 107);
            myPageButton.addActionListener(this);
            myPageButton.setBackground(Color.white);
			myPageButton.setFont(font2);
            menupanel.add(myPageButton);

            // Create the "우산 대여 가능 지점 확인하기" button -> MapList.java
            mapButton = new JButton("지점 확인");
            mapButton.setBounds(50, 217, 320, 107);
            mapButton.addActionListener(this);
            mapButton.setBackground(Color.white);
			mapButton.setFont(font2);
            menupanel.add(mapButton);

            // Create the "로그아웃" button -> Login.java
            logoutButton = new JButton("로그아웃");
            logoutButton.setBounds(50, 334, 320, 107);
            logoutButton.addActionListener(this);
            logoutButton.setBackground(Color.white);
			logoutButton.setFont(font2);
            menupanel.add(logoutButton);

			//Create the "뒤로가기" button -> ReturnUm.java
			cancelButton = new JButton("뒤로가기");
			cancelButton.setBackground(Color.decode("#0C71AE"));
			cancelButton.setForeground(Color.white);
			cancelButton.setBounds(0, 670, 430, 120);
			cancelButton.setFont(font1);
			cancelButton.addActionListener(this);
			menupanel.add(cancelButton);

            add(menupanel);

            menupanel.add(myPageButton);
            menupanel.add(mapButton);
            menupanel.add(logoutButton);

            menupanel.setVisible(true);

            currentPanel.setVisible(false);
            allBtn.setVisible(false);
            refundBtn.setVisible(false);
        }else if (e.getSource() == myPageButton || e.getSource() == cancelButton) {
			menupanel.setVisible(false);
			currentPanel.setVisible(true);
			allBtn.setVisible(true);
			refundBtn.setVisible(true);
		 }else if (e.getSource() == mapButton) {
			MapList MapList = new MapList();
			MapList.setVisible(true);
			dispose(); 
		 }else if (e.getSource() == logoutButton) {
			Login login = new Login();
			login.setVisible(true);
			dispose(); 
		 }
    }

    public void showMenuButton() {
        menuButton.setVisible(true);
    }
	public void showButtons(){
		allBtn.setVisible(true);
        refundBtn.setVisible(true);
	}

    public void hideButtons() {
        allBtn.setVisible(false);
        refundBtn.setVisible(false);
    }
}
