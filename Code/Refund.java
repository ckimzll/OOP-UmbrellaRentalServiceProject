import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;

class refundPanel extends JPanel
{
	Rectangle2D.Double	rect;
	Font 	font1, font2, font3;

	public refundPanel()
	{

		font1 = new Font("맑은 고딕", Font.BOLD, 23);
		font2 = new Font("맑은 고딕", Font.PLAIN, 15);
		font3 = new Font("맑은 고딕", Font.BOLD, 13);

		rect = new Rectangle2D.Double(60,60,800,800);

		JLabel lb1 = new JLabel("환급받으시겠습니까?");
        lb1.setBounds(110,310,200,50);
		lb1.setFont(font2);
        add(lb1);

		Font lf = lb1.getFont();
		float fs = lf.getSize() + 5f;
		Font bf = lf.deriveFont(fs);
		lb1.setFont(bf);


		JLabel lb2 = new JLabel("보증금: 5000원");
        lb2.setBounds(130,350,200,50);
		lb2.setFont(font3);
        add(lb2);

		JButton refund = new JButton("환급");
		refund.setForeground(Color.WHITE);
		refund.setBackground(Color.decode("#0C71AE"));
		refund.setBounds(130, 420, 60,30);
		refund.setFont(font3);
		add(refund);

		//반납 팝업에 확인 클릭 시 Refund 프레임 삭제
		refund.addActionListener(e -> {
			int result = JOptionPane.showConfirmDialog(this, "반납이 완료되었습니다.", "확인", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(refundPanel.this);
				frame.dispose();
			}
		});


		JButton cancel = new JButton("취소");
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.decode("#0C71AE"));
		cancel.setBounds(200, 420, 60,30);
		cancel.setFont(font3);
		add(cancel);

		//취소버튼 클릭하면 Refund 프레임 삭제
		cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(refundPanel.this);
                frame.dispose();
            }
        });
    }
	public void paintComponent(Graphics g){
		super.paintComponent(g);

        // Draw a gray rectangle
        g.setColor(Color.decode("#D9D9D9"));
        g.fillRect(10, 300, 400, 200);

	}
}


public class Refund extends JFrame {

    public Refund() {
        setTitle("Refund");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(430, 932);
        setLocationRelativeTo(null);

        JPanel panel = new refundPanel();
        panel.setLayout(null);


        add(panel);
    }
}