import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener, FocusListener {
    private JTextField idField;
    private JTextField pwField;
    private JButton lgButton;
	Font 	font1, font2, font3;

	private String idHint = "아이디";
	private String pwHint = "비밀번호";

    public Login() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(430,932);
        setLocationRelativeTo(null);

		font1 = new Font("맑은 고딕", Font.BOLD, 23);
		font2 = new Font("맑은 고딕", Font.PLAIN, 15);
		font3 = new Font("맑은 고딕", Font.BOLD, 13);

        JPanel panel = new JPanel();
        panel.setLayout(null);

		//login label
        JLabel lgLabel = new JLabel("로그인");
		lgLabel.setBounds(100,70,100,50);
		lgLabel.setFont(font1);
        
		//id textfield
        idField = new JTextField();
		idField.setBounds(100, 130, 200,50);
		idField.setText(idHint);
		idField.addFocusListener(this);

		//password textfield
        pwField = new JTextField();
		pwField.setBounds(100, 200, 200,50);
		pwField.setText(pwHint);
		pwField.addFocusListener(this);

		//login button
        lgButton = new JButton("로그인");
		lgButton.setBounds(100, 270, 200,50);
		lgButton.setBackground(Color.decode("#0C71AE"));
		lgButton.setForeground(Color.WHITE);
		lgButton.addActionListener(this);
		lgButton.setFont(font2);
		lgButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(this, "로그인하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				dispose(); // Close the Login frame
			ReturnUm returnUm = new ReturnUm();
			returnUm.setVisible(true);}
        });
		
		
		//label go to the signup page
		JLabel suLabel = new JLabel("회원가입 하러 가기 >");
		suLabel.setBounds(140, 330, 200,50);
        suLabel.setFont(font2);
		
		//label mouse click event
	    suLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Signup signup = new Signup();
				signup.setVisible(true);	
				dispose(); 
			}
		});

        panel.add(lgLabel);
        panel.add(idField);
        panel.add(pwField);
        panel.add(lgButton);
		panel.add(suLabel);

        add(panel);
		setVisible(true);
    }

	public void actionPerformed(ActionEvent e) {
   
}

	//if textfield is not empty
	public void focusGained(FocusEvent e){
		if(e.getSource() == idField && idField.getText().equals(idHint)){
			idField.setText("");
			idField.setForeground(Color.BLACK);
		}else if(e.getSource() == pwField && pwField.getText().equals(pwHint)){
			pwField.setText("");
			pwField.setForeground(Color.BLACK);
		}
	}
	//if textfield is empty
	public void focusLost(FocusEvent e){
		if(e.getSource() == idField && idField.getText().isEmpty()){
			idField.setText(idHint);
            idField.setForeground(Color.GRAY);
		}else if (e.getSource() == pwField && pwField.getText().isEmpty()) {
            pwField.setText(pwHint);
            pwField.setForeground(Color.GRAY);
        }
	}
}



