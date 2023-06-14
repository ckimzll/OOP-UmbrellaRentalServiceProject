import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


public class PayLoan extends JFrame implements ActionListener
{
	JPanel choosepanel, paypanel, mentpanel;
	JLabel paylabel, qlabel, sumlabel;
	JButton cardbutton, simplebutton, returnbutton, paybutton, cancelbutton;
	Color color1, color2;
	Font font1, font2, font3;
	int totalDeposit = 0;
	
	public PayLoan(int totalDeposit) {
		font1 = new Font("맑은 고딕", Font.BOLD, 23);
		font2 = new Font("맑은 고딕", Font.PLAIN, 15);
		font3 = new Font("맑은 고딕", Font.PLAIN, 12);


		color1 = new Color(12, 113, 174);
		color2 = new Color(217, 217, 217);
		
		// 결제 수단 선택 페이지
		paylabel = new JLabel("보증금 결제하기");
		paylabel.setFont(font1);
		paylabel.setBounds(115, 300, 200, 50);		
		cardbutton = new JButton("카드 결제");
		cardbutton.setBackground(color2);
		cardbutton.setFont(font2);
		cardbutton.setBounds(85, 350, 110, 40);
		cardbutton.addActionListener(this);
		simplebutton = new JButton("간편 결제");
		simplebutton.setBackground(color2);
		simplebutton.setFont(font2);
		simplebutton.setBounds(200, 350, 110, 40);
		simplebutton.addActionListener(this);
		returnbutton = new JButton("뒤로가기");
		returnbutton.setBackground(color2);
		returnbutton.setFont(font2);
		returnbutton.setBounds(85, 395, 225, 40);
		returnbutton.addActionListener(this);
		
		choosepanel = new JPanel();
		choosepanel.setLayout(null);
		choosepanel.setBackground(Color.white);
		choosepanel.setBounds(0 , 0, 430, 932);
		
		choosepanel.add(paylabel);
		choosepanel.add(cardbutton);
		choosepanel.add(simplebutton);
		choosepanel.add(returnbutton);
		
		// 결제 여부 선택 페이지
		qlabel = new JLabel("결제하시겠습니까?");
		qlabel.setFont(font1);
		qlabel.setBounds(95, 40, 200, 50);
		sumlabel = new JLabel("금액 : " + totalDeposit + "원");
		sumlabel.setFont(font2);
		sumlabel.setBounds(140, 70, 200, 40);
		paybutton = new JButton("결제");
		paybutton.setBackground(color1);
		paybutton.setForeground(Color.white);
		paybutton.setFont(font3);
		paybutton.setBounds(125, 110, 60, 35);
		paybutton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "결제가 완료되었습니다.");  // 마이페이지로 이동
            ReturnUm returnum = new ReturnUm();
			returnum.setVisible(true);
			dispose(); 
        });
		cancelbutton = new JButton("취소");
		cancelbutton.setBackground(color1);
		cancelbutton.setForeground(Color.white);
		cancelbutton.setFont(font3);
		cancelbutton.setBounds(195, 110, 60, 35);
		cancelbutton.addActionListener(this);
		
		mentpanel = new JPanel();
		mentpanel.setLayout(null);
		mentpanel.setBackground(color2);
		mentpanel.setBounds(15, 300, 385, 200);
		
		paypanel = new JPanel();
		paypanel.setLayout(null);
		paypanel.setBackground(Color.white);
		paypanel.setBounds(0 , 0, 430, 932);
		paypanel.setVisible(false);
		
		mentpanel.add(qlabel);
		mentpanel.add(sumlabel);
		mentpanel.add(paybutton);
		mentpanel.add(cancelbutton);
		paypanel.add(mentpanel);
		
		add(choosepanel);
		add(paypanel);
				
		setLayout(null);
		setTitle("Pay Loan");
		setVisible(true);
		setSize(430, 932);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent e) {  // 화면을 바꾸는 이벤트 기능
		String str = e.getActionCommand();
		if(str.equals("카드 결제")) {
			choosepanel.setVisible(false);
			paypanel.setVisible(true);			
		}else if(str.equals("간편 결제")) {
			choosepanel.setVisible(false);
			paypanel.setVisible(true);
		}else if(str.equals("뒤로가기")) {
			choosepanel.setVisible(false);
			RentalUmbrella rentalumbrella = new RentalUmbrella();
			rentalumbrella.setVisible(true);
			dispose();
		}else if(str.equals("취소")) {
			paypanel.setVisible(false);
			RentalUmbrella rentalumbrella = new RentalUmbrella();
			rentalumbrella.setVisible(true);
			dispose();
		}
	}
}


