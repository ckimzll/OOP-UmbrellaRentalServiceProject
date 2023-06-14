import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;

public class MapList extends JFrame implements ActionListener
{
    JPanel			mappanel, menupanel, listpanel;
	JLabel			maplabel;
    JButton			reservation, menu;
	JButton			menub1, menub2, menub3,
					conlist1, conlist2, conlist3, conlist4, conlist5;
	JButton			conroad1, conroad2, conroad3, conroad4, conroad5;
	Color			color1, color2;
	ImageIcon		mapview;
	Font			font1, font2, font3;

	JPanel			navpanel;
	JLabel			navlabel, slabel, flabel, iconlabel;
	ImageIcon		icon, nav1, nav2, nav3, nav4, nav5;

	public MapList() {
		font1 = new Font("맑은 고딕", Font.BOLD, 23);
		font2 = new Font("맑은 고딕", Font.PLAIN, 15);
		font3 = new Font("맑은 고딕", Font.BOLD, 13);

		color1 = new Color(12, 113, 174);
		color2 = new Color(217, 217, 217);

		menu = new JButton(new ImageIcon("Images\\menu.png"));
		// 이미지 파일을 만들어서 한 파일에 저장
		menu.setBounds(350, 15, 50, 50);
		menu.addActionListener(this);

		maplabel = new JLabel();
		mapview = new ImageIcon("Images\\map.png");
		maplabel.setIcon(mapview);
		maplabel.setBounds(0, 85, 420, 575);

		reservation = new JButton("검색하기");
		reservation.setBackground(color1);
		reservation.setForeground(Color.white);
		reservation.setFont(font1);
		reservation.setBounds(0, 670, 430, 120);
		reservation.addActionListener(this);

		mappanel = new JPanel(null);
		listpanel = new JPanel(null);
		menupanel = new JPanel(null);
		navpanel = new JPanel(null); // navigation

		mappanel.setBackground(Color.white);
		mappanel.setBounds(0, 0, 430, 932);

		mappanel.add(menu);
		mappanel.add(maplabel);
		mappanel.add(reservation);

		add(mappanel);

		setLayout(null);
		setTitle("Map & Convenience Store List");
        setVisible(true);
        setSize(430, 932);
		setLocationRelativeTo(null);
        setResizable(false); // no size change
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == reservation) {
			if (reservation.getText().equals("검색하기")) {
				maplabel.setVisible(false);
				reservation.setText("예약하기");
				
				// 편의점 리스트
				conlist1 = new JButton("GS25 숙대학생회관점");
				conlist2 = new JButton("GS25 효창점");
				conlist3 = new JButton("GS25 숙대점");
				conlist4 = new JButton("이마트24 숙대도서관점");
				conlist5 = new JButton("CU 숙대원룸점");

				conlist1.setFont(font2);
				conlist2.setFont(font2);
				conlist3.setFont(font2);
				conlist4.setFont(font2);
				conlist5.setFont(font2);

				conlist1.setBackground(Color.white);
				conlist2.setBackground(Color.white);
				conlist3.setBackground(Color.white);
				conlist4.setBackground(Color.white);
				conlist5.setBackground(Color.white);

				conlist1.setBounds(5, 0, 320, 107);
				conlist2.setBounds(5, 117, 320, 107);
				conlist3.setBounds(5, 234, 320, 107);
				conlist4.setBounds(5, 351, 320, 107);
				conlist5.setBounds(5, 468, 320, 107);

				conlist1.addActionListener(this);
				conlist2.addActionListener(this);
				conlist3.addActionListener(this);
				conlist4.addActionListener(this);
				conlist5.addActionListener(this);

				// 길찾기 버튼
				conroad1 = new JButton("길찾기");
				conroad2 = new JButton("길찾기");
				conroad3 = new JButton("길찾기");
				conroad4 = new JButton("길찾기");
				conroad5 = new JButton("길찾기");

				conroad1.setFont(font3);
				conroad2.setFont(font3);
				conroad3.setFont(font3);
				conroad4.setFont(font3);
				conroad5.setFont(font3);

				conroad1.setBackground(color1);
				conroad2.setBackground(color1);
				conroad3.setBackground(color1);
				conroad4.setBackground(color1);
				conroad5.setBackground(color1);
				conroad1.setForeground(Color.white);
				conroad2.setForeground(Color.white);
				conroad3.setForeground(Color.white);
				conroad4.setForeground(Color.white);
				conroad5.setForeground(Color.white);

				conroad1.addActionListener(this);
				conroad2.addActionListener(this);
				conroad3.addActionListener(this);
				conroad4.addActionListener(this);
				conroad5.addActionListener(this);

				conroad1.setBounds(330, 30, 80, 40);
				conroad2.setBounds(330, 150, 80, 40);
				conroad3.setBounds(330, 265, 80, 40);
				conroad4.setBounds(330, 380, 80, 40);
				conroad5.setBounds(330, 500, 80, 40);
				
				listpanel.setBackground(Color.white);
				listpanel.setBounds(0, 85, 420, 575);
				listpanel.add(conlist1);
				listpanel.add(conroad1);
				listpanel.add(conlist2);
				listpanel.add(conroad2);
				listpanel.add(conlist3);
				listpanel.add(conroad3);
				listpanel.add(conlist4);
				listpanel.add(conroad4);
				listpanel.add(conlist5);
				listpanel.add(conroad5);

				mappanel.add(listpanel);
			} 
			else if (reservation.getText().equals("뒤로가기")) {
				menupanel.setVisible(false);
				navpanel.removeAll();
				listpanel.setVisible(true);
				reservation.setText("예약하기");
			}
				
		} else if (e.getSource() == menu) {
			maplabel.setVisible(false);
			navpanel.setVisible(false);
			listpanel.setVisible(false);
			reservation.setText("뒤로가기");

			menub1 = new JButton("마이페이지");
			menub2 = new JButton("지점 확인");
			menub3 = new JButton("로그아웃");

			menub1.setFont(font2);
			menub2.setFont(font2);
			menub3.setFont(font2);

			menub1.setBackground(Color.white);
			menub2.setBackground(Color.white);
			menub3.setBackground(Color.white);

			menub1.setBounds(50, 0, 320, 107);
			menub2.setBounds(50, 117, 320, 107);
			menub3.setBounds(50, 234, 320, 107);

			menub1.addActionListener(this); // 해당페이지로 이동
			menub2.addActionListener(this);
			menub3.addActionListener(this);
			
			menupanel.setBackground(Color.white);
			menupanel.setBounds(0, 85, 420, 575);

			menupanel.add(menub1);
			menupanel.add(menub2);
			menupanel.add(menub3);

			mappanel.add(menupanel);
			menupanel.setVisible(true);

		} else if (e.getSource() == conlist1 || e.getSource() == conlist2 ||
			e.getSource() == conlist3 || e.getSource() == conlist4 ||
			e.getSource() == conlist5) {
			conlist1.setBackground(Color.white); // 하얀색으로 초기화
			conlist2.setBackground(Color.white);
			conlist3.setBackground(Color.white);
			conlist4.setBackground(Color.white);
			conlist5.setBackground(Color.white);

			JButton selectedButton = (JButton) e.getSource(); // 선택된 버튼만 색 변경
			selectedButton.setBackground(color2);

			reservation.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
					RentalUmbrella RentalUmbrella = new RentalUmbrella();
					RentalUmbrella.sendText(selectedButton.getText());
					RentalUmbrella.setVisible(true);
					dispose(); 
			}
			});
		} else if (e.getSource() == conroad1 || e.getSource() == conroad2 ||
			e.getSource() == conroad3 || e.getSource() == conroad4 ||
			e.getSource() == conroad5) {
				
				listpanel.setVisible(false);
				navpanel.removeAll();
				navpanel.setVisible(true);
				reservation.setText("뒤로가기");	
				
				navpanel.setBackground(Color.white);
				navpanel.setBounds(0, 85, 420, 575);

				navlabel = new JLabel();
				iconlabel = new JLabel();
				slabel = new JLabel("");
				flabel = new JLabel("");

				slabel.setFont(font2);
				flabel.setFont(font2);

				navlabel.setBounds(0, 0, 420, 440);
				slabel.setBounds(10, 460, 420, 50);
				flabel.setBounds(10, 500, 420, 50);

				if (e.getSource() == conroad1) {
					nav1 = new ImageIcon("Images\\nav1.png");
					icon = new ImageIcon("Images\\icon.png");
					iconlabel.setBounds(140, 200, 60, 60);

					navlabel.setIcon(nav1);
					iconlabel.setIcon(icon);
					
					slabel.setText("출발지: 숙명여대 제 1캠퍼스");
					flabel.setText("도착지: GS25 숙대학생회관점");

					int startX = 140; // 시작 좌표
					int startY = 200;

					final int moveX = 7; // X축 이동속도
					final int moveY = 2; // y축 이동속도
					final int sleepTime = 100;

					java.util.List<Point> targetCoordinates = new ArrayList<>();
					targetCoordinates.add(new Point(150, 170)); // 1번째 좌표

					Navigation nav = new Navigation(navlabel, iconlabel, navpanel, targetCoordinates,
						startX, startY, moveX, moveY, sleepTime);

					Thread thread = new Thread(nav);
					thread.start();

				} else if (e.getSource() == conroad2) {
					nav2 = new ImageIcon("Images\\nav2.png");
					icon = new ImageIcon("Images\\icon.png");
					iconlabel.setBounds(140, 230, 60, 60);

					navlabel.setIcon(nav2);
					iconlabel.setIcon(icon);

					slabel.setText("출발지: 숙명여대 명신관");
					flabel.setText("도착지: GS25 효창점");

					int startX = 140; // 시작 좌표
					int startY = 230;

					final int moveX = 5; // X축 이동속도
					final int moveY = 3; // y축 이동속도
					final int sleepTime = 100;

					java.util.List<Point> targetCoordinates = new ArrayList<>();
					targetCoordinates.add(new Point(140, 170)); // 1번째 좌표
					targetCoordinates.add(new Point(100, 120)); // 2번째 좌표
					targetCoordinates.add(new Point(50, 120)); // 3번째 좌표
					targetCoordinates.add(new Point(50, 60)); // 4번째 좌표

					Navigation nav = new Navigation(navlabel, iconlabel, navpanel, targetCoordinates,
						startX, startY, moveX, moveY, sleepTime);

					Thread thread = new Thread(nav);
					thread.start();

				} else if (e.getSource() == conroad3) {
					nav3 = new ImageIcon("Images\\nav3.png");
					icon = new ImageIcon("Images\\icon.png");
					iconlabel.setBounds(40, 180, 60, 60);

					navlabel.setIcon(nav3);
					iconlabel.setIcon(icon);

					slabel.setText("출발지: 숙명여대 제 2캠퍼스");
					flabel.setText("도착지: GS25 숙대점");

					int startX = 40; // 시작 좌표
					int startY = 180;

					final int moveX = 7; // X축 이동속도
					final int moveY = 2; // y축 이동속도
					final int sleepTime = 100;

					java.util.List<Point> targetCoordinates = new ArrayList<>();
					targetCoordinates.add(new Point(130, 170)); // 1번째 좌표
					targetCoordinates.add(new Point(345, 230)); // 2번째 좌표

					Navigation nav = new Navigation(navlabel, iconlabel, navpanel, targetCoordinates,
						startX, startY, moveX, moveY, sleepTime);

					Thread thread = new Thread(nav);
					thread.start();

				} else if (e.getSource() == conroad4) {
					nav4 = new ImageIcon("Images\\nav4.png");
					icon = new ImageIcon("Images\\icon.png");
					iconlabel.setBounds(40, 110, 60, 60);

					navlabel.setIcon(nav4);
					iconlabel.setIcon(icon);

					slabel.setText("출발지: 숙명여대 제 2캠퍼스");
					flabel.setText("도착지: 이마트24 숙대도서관점");

					int startX = 40; // 시작 좌표
					int startY = 110;

					final int moveX = 7; // X축 이동속도
					final int moveY = 2; // y축 이동속도
					final int sleepTime = 100;

					java.util.List<Point> targetCoordinates = new ArrayList<>();
					targetCoordinates.add(new Point(100, 90)); // 1번째 좌표
					targetCoordinates.add(new Point(330, 140)); // 2번째 좌표
					targetCoordinates.add(new Point(330, 240)); // 3번째 좌표
					targetCoordinates.add(new Point(320, 260)); // 4번째 좌표

					Navigation nav = new Navigation(navlabel, iconlabel, navpanel, targetCoordinates,
						startX, startY, moveX, moveY, sleepTime);

					Thread thread = new Thread(nav);
					thread.start();

				} else if (e.getSource() == conroad5) {
					nav5 = new ImageIcon("Images\\nav5.png");
					icon = new ImageIcon("Images\\icon.png");
					iconlabel.setBounds(40, 10, 60, 60);
					
					navlabel.setIcon(nav5);
					iconlabel.setIcon(icon);

					slabel.setText("출발지: 숙명여대 제 2캠퍼스");
					flabel.setText("도착지: CU 숙대원룸점");

					int startX = 40; // 시작 좌표
					int startY = 10;

					final int moveX = 7; // X축 이동속도
					final int moveY = 3; // y축 이동속도
					final int sleepTime = 100;

					java.util.List<Point> targetCoordinates = new ArrayList<>();
					targetCoordinates.add(new Point(100, 0)); // 1번째 좌표
					targetCoordinates.add(new Point(200, 25)); // 2번째 좌표
					targetCoordinates.add(new Point(340, 40)); // 3번째 좌표
					targetCoordinates.add(new Point(340, 130)); // 4번째 좌표
					targetCoordinates.add(new Point(320, 205)); // 5번째 좌표
					targetCoordinates.add(new Point(250, 235)); // 6번째 좌표
					targetCoordinates.add(new Point(200, 265)); // 7번째 좌표
					targetCoordinates.add(new Point(45, 290)); // 8번째 좌표
					targetCoordinates.add(new Point(45, 335)); // 9번째 좌표

					Navigation nav = new Navigation(navlabel, iconlabel, navpanel, targetCoordinates,
						startX, startY, moveX, moveY, sleepTime);

					Thread thread = new Thread(nav);
					thread.start();
				}
				navpanel.add(iconlabel);
				navpanel.add(navlabel);
				navpanel.add(slabel);
				navpanel.add(flabel);

				mappanel.add(navpanel);
				
		} else if (e.getSource() == menub1) {
			ReturnUm ReturnUm = new ReturnUm();
			ReturnUm.setVisible(true);
			dispose();

		} else if (e.getSource() == menub2) {
			MapList MapList = new MapList();
			MapList.setVisible(true);
			dispose(); 

		} else if (e.getSource() == menub3) {
			Login login = new Login();
			login.setVisible(true);
			dispose(); 
		}
	}
}



