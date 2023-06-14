import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.event.*;

public class RentalUmbrella extends JFrame implements ActionListener
{
	BufferedImage img1, img2, img3, img4;
	JPanel 	rentalpanel, menupanel;
	JPanel 	explainpanel1, explainpanel2, explainpanel3, explainpanel4;
	JButton menubutton, rentalbutton, resetbutton, backbutton;
	JButton myPageButton, mapButton, logoutButton, cancelButton;
	JLabel	clabel, un1;
	Color 	color1, color2;
	Font 	font1, font2;
		
	public RentalUmbrella() {	
		font1 = new Font("맑은 고딕", Font.BOLD, 23);
		font2 = new Font("맑은 고딕", Font.PLAIN, 15);
		
		color1 = new Color(12, 113, 174);
		color2 = new Color(217, 217, 217);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image im1 = toolkit.getImage("Images\\umbrella1.jpg");
		Image im2 = toolkit.getImage("Images\\umbrella2.jpg");
		Image im3 = toolkit.getImage("Images\\umbrella3.jpg");
		Image im4 = toolkit.getImage("Images\\umbrella4.jpg");
		MediaTracker t = new MediaTracker(this);
		t.addImage(im1, 0);
		t.addImage(im2, 0);
		t.addImage(im3, 0);
		t.addImage(im4, 0);
		try {
			t.waitForAll();
		} catch (Exception e) {
			System.out.println("MediaTracker error");
		}
		img1 = new BufferedImage(im1.getWidth(this),
				im1.getHeight(this), BufferedImage.TYPE_INT_RGB);
		img2 = new BufferedImage(im2.getWidth(this),
				im1.getHeight(this), BufferedImage.TYPE_INT_RGB);
		img3 = new BufferedImage(im3.getWidth(this),
				im1.getHeight(this), BufferedImage.TYPE_INT_RGB);
		img4 = new BufferedImage(im4.getWidth(this),
				im1.getHeight(this), BufferedImage.TYPE_INT_RGB);
		Graphics2D d1 = img1.createGraphics();
		Graphics2D d2 = img2.createGraphics();
		Graphics2D d3 = img3.createGraphics();
		Graphics2D d4 = img4.createGraphics();
		d1.drawImage(im1, 0, 0, this);
		d2.drawImage(im2, 0, 0, this);
		d3.drawImage(im3, 0, 0, this);
		d4.drawImage(im4, 0, 0, this);
		
		// 선택한 편의점명 보여주기
		clabel = new JLabel("");
		clabel.setFont(font1);
		clabel.setBounds(10, 10, 250, 50);
		
		// 우산 대여 패널
		rentalpanel = new JPanel();
		rentalpanel.setLayout(null);
		rentalpanel.setBackground(Color.white);
		rentalpanel.setBounds(0, 0, 430, 932);
		
		// 메뉴 목록 버튼
		menubutton = new JButton(new ImageIcon("Images\\menu.png"));
		menubutton.setBounds(360, 10, 50, 50);
		menubutton.addActionListener(this);
		
		// 우산 개수 선택 JComboBox 만들기
		Integer number[] = {0, 1, 2, 3};
		
		explainpanel1 = new JPanel(); // 첫번째 우산
		explainpanel1.setLayout(null);
		explainpanel1.setBackground(color2);
		explainpanel1.setBounds(5, 90, 200, 320);
		
		JLabel us1 = new JLabel("우산 종류 : 장우산");
		us1.setFont(font2);
		us1.setBounds(10, 160, 130, 30);
		JLabel ur1 = new JLabel("반납 기한 : 2023. 07. 08");
		ur1.setFont(font2);
		ur1.setBounds(10, 200, 200, 30);
		JLabel uf1 = new JLabel("보증금 : 5000원");
		uf1.setFont(font2);
		uf1.setBounds(10, 220, 200, 30);	
		JComboBox numbersel1 = new JComboBox<>(number);
		numbersel1.setBounds(75, 270, 50, 30);
		explainpanel1.add(us1);
		explainpanel1.add(ur1);
		explainpanel1.add(uf1);
		explainpanel1.add(numbersel1);
		
		explainpanel2 = new JPanel(); // 두번째 우산
		explainpanel2.setLayout(null);
		explainpanel2.setBackground(color2);
		explainpanel2.setBounds(210, 90, 200, 320);
		
		JLabel us2 = new JLabel("우산 종류 : 단우산");
		us2.setFont(font2);
		us2.setBounds(10, 160, 130, 30);
		JLabel ur2 = new JLabel("반납 기한 : 2023. 07. 08");
		ur2.setFont(font2);
		ur2.setBounds(10, 200, 200, 30);
		JLabel uf2 = new JLabel("보증금 : 3000원");
		uf2.setFont(font2);
		uf2.setBounds(10, 220, 200, 30);	
		JComboBox numbersel2 = new JComboBox<>(number);
		numbersel2.setBounds(75, 270, 50, 30);
		explainpanel2.add(us2);
		explainpanel2.add(ur2);
		explainpanel2.add(uf2);
		explainpanel2.add(numbersel2);
	
		explainpanel3 = new JPanel(); // 세번째 우산
		explainpanel3.setLayout(null);
		explainpanel3.setBackground(color2);
		explainpanel3.setBounds(5, 415, 200, 320);
		
		JLabel us3 = new JLabel("우산 종류 : 단우산");
		us3.setFont(font2);
		us3.setBounds(10, 160, 130, 30);
		JLabel ur3 = new JLabel("반납 기한 : 2023. 07. 08");
		ur3.setFont(font2);
		ur3.setBounds(10, 200, 200, 30);
		JLabel uf3 = new JLabel("보증금 : 3000원");
		uf3.setFont(font2);
		uf3.setBounds(10, 220, 200, 30);	
		JComboBox numbersel3 = new JComboBox<>(number);
		numbersel3.setBounds(75, 270, 50, 30);
		explainpanel3.add(us3);
		explainpanel3.add(ur3);
		explainpanel3.add(uf3);
		explainpanel3.add(numbersel3);
		
		explainpanel4 = new JPanel(); // 네번째 우산
		explainpanel4.setLayout(null);
		explainpanel4.setBackground(color2);
		explainpanel4.setBounds(210, 415, 200, 320);
		
		JLabel us4 = new JLabel("우산 종류 : 장우산");
		us4.setFont(font2);
		us4.setBounds(10, 160, 130, 30);
		JLabel ur4 = new JLabel("반납 기한 : 2023. 07. 08");
		ur4.setFont(font2);
		ur4.setBounds(10, 200, 200, 30);
		JLabel uf4 = new JLabel("보증금 : 5000원");
		uf4.setFont(font2);
		uf4.setBounds(10, 220, 200, 30);	
		JComboBox numbersel4 = new JComboBox<>(number);
		numbersel4.setBounds(65, 270, 50, 30);
		explainpanel4.add(us4);
		explainpanel4.add(ur4);
		explainpanel4.add(uf4);
		explainpanel4.add(numbersel4);
		
		rentalbutton = new JButton("대여");
		rentalbutton.setBackground(color1);
		rentalbutton.setForeground(Color.white);
		rentalbutton.setFont(font2);
		rentalbutton.setBounds(85, 750, 80, 35);
		rentalbutton.addActionListener(e -> {
int result = JOptionPane.showConfirmDialog(this, "대여하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) { // 보증금 계산하기
					int selectedLongCount = (int)numbersel1.getSelectedItem() + (int)numbersel4.getSelectedItem();
					int selectedShortCount = (int)numbersel2.getSelectedItem() + (int)numbersel3.getSelectedItem();
				
					int longDeposit = 5000;
					int shortDeposit = 3000;
					int totalDeposit = (longDeposit * selectedLongCount) + (shortDeposit * selectedShortCount);
					if (totalDeposit == 0) { // 하나도 선택하지 않았을 경우
						JOptionPane.showMessageDialog(this, "개수를 선택해주세요.");
					}else { // 하나라도 선택했을 경우
						dispose();
						PayLoan payLoan = new PayLoan(totalDeposit);
						payLoan.setVisible(true);	
					}				
				}
			}
		);
	
		resetbutton = new JButton("초기화"); // 선택한 개수 값을 다 0으로 만들기
		resetbutton.setBackground(color1);
		resetbutton.setForeground(Color.white);
		resetbutton.setFont(font2);
		resetbutton.setBounds(170, 750, 80, 35);
		resetbutton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	numbersel1.setSelectedIndex(0);
	numbersel2.setSelectedIndex(0);
	numbersel3.setSelectedIndex(0);
	numbersel4.setSelectedIndex(0);
}
});
		
		backbutton = new JButton("이전");
		backbutton.setBackground(color1);
		backbutton.setForeground(Color.white);
		backbutton.setFont(font2);
		backbutton.setBounds(255, 750, 80, 35);
		backbutton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	MapList MapList = new MapList();
	MapList.setVisible(true);
	dispose();
}
});
		
		rentalpanel.add(menubutton);
		rentalpanel.add(explainpanel1);
		rentalpanel.add(explainpanel2);
		rentalpanel.add(explainpanel3);
		rentalpanel.add(explainpanel4);
		rentalpanel.add(rentalbutton);
		rentalpanel.add(resetbutton);
		rentalpanel.add(backbutton);
		
		add(clabel);
		add(rentalpanel);
				
		setLayout(null);
		setTitle("Rental Umbrella");
		setVisible(true);
		setSize(430, 932);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
	 g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
		g2.setColor(Color.decode("#D9D9D9"));
		g2.fillRect(10, 100, 410, 10);	
		// 우산 사진 넣기
		Shape clipShape = new Ellipse2D.Double(65, 140, 100, 100);
		g2.setClip(clipShape);
		g2.drawImage(img1, 65, 140, null);
		clipShape = new Ellipse2D.Double(270, 140, 100, 100);
		g2.setClip(clipShape);
		g2.drawImage(img2, 270, 140, null);
		clipShape = new Ellipse2D.Double(65, 470, 100, 100);
		g2.setClip(clipShape);
		g2.drawImage(img3, 65, 470, null);
		clipShape = new Ellipse2D.Double(270, 470, 100, 100);
		g2.setClip(clipShape);
		g2.drawImage(img4, 270, 470, null);
	}
	
	public void actionPerformed(ActionEvent e) {
	 if (e.getSource() == menubutton) { // 메뉴 패널 만들기
	 menupanel = new JPanel();
	 menupanel.setLayout(null);
	 menupanel.setBounds(0 , 0, 430, 932);
	 menupanel.setBackground(Color.white);
	 myPageButton = new JButton("마이페이지");
	 myPageButton.setFont(font2);
	 myPageButton.setBounds(50, 100, 320, 107);
	 myPageButton.addActionListener(this);
	 myPageButton.setBackground(Color.white);
	 menupanel.add(myPageButton);
	 mapButton = new JButton("지점 확인");
	 mapButton.setFont(font2);
	 mapButton.setBounds(50, 217, 320, 107);
	 mapButton.addActionListener(this);
	 mapButton.setBackground(Color.white);
	 menupanel.add(mapButton);
	 logoutButton = new JButton("로그아웃");
	 logoutButton.setFont(font2);
	 logoutButton.setBounds(50, 334, 320, 107);
	 logoutButton.addActionListener(this);
	 logoutButton.setBackground(Color.white);
	 menupanel.add(logoutButton);
	 cancelButton = new JButton("뒤로가기");
	 cancelButton.setBackground(color1);
	 cancelButton.setForeground(Color.white);
	 cancelButton.setFont(font1);
	 cancelButton.setBounds(0, 670, 430, 120);	
	 cancelButton.addActionListener(this);
	 menupanel.add(cancelButton);
	 menupanel.add(myPageButton);
	 menupanel.add(mapButton);
	 menupanel.add(logoutButton);
	
	 add(menupanel);
	
	 clabel.setVisible(false);
	 rentalpanel.setVisible(false);
	 menupanel.setVisible(true);
	 }else if (e.getSource() == myPageButton) { // 각자 값에 맞는 페이지로 이동
				ReturnUm returnum = new ReturnUm();
				returnum.setVisible(true);
				dispose();
	 }else if (e.getSource() == mapButton) {
				MapList MapList = new MapList();
				MapList.setVisible(true);
				dispose();
	 }else if (e.getSource() == cancelButton) {
				RentalUmbrella rentalumbrella = new RentalUmbrella();
				rentalumbrella.setVisible(true);
				dispose();
	 }else if (e.getSource() == logoutButton) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
	 }
	 }
	
	public void sendText(String text){ // 선택한 편의점명 보여주기
	 clabel.setText(text);
	}
}


