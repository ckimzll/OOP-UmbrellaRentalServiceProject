import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener, FocusListener {
    private JTextField idField;
    private JTextField pwField;
	private JTextField pwckField;
	private JTextField nnameField;
    private JButton suButton;
	Font 	font1, font2, font3;

	private String idHint = "아이디";
	private String pwHint = "비밀번호";
	private String pwckHint = "비밀번호 확인";
	private String nnameHint = "닉네임";

    public Signup() {
        setTitle("Sign up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(430,932);
        setLocationRelativeTo(null);

		font1 = new Font("맑은 고딕", Font.BOLD, 23);
		font2 = new Font("맑은 고딕", Font.PLAIN, 15);
		font3 = new Font("맑은 고딕", Font.BOLD, 13);

        JPanel panel = new JPanel();
        panel.setLayout(null);

		//signup label
        JLabel suLabel = new JLabel("회원가입");
		suLabel.setBounds(100,70,100,50);
		suLabel.setFont(font1);
        
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

		//password check textfield
		pwckField = new JTextField();
		pwckField.setBounds(100, 270, 200,50);
		pwckField.setText(pwckHint);
		pwckField.addFocusListener(this);

		//nickname textfield
        nnameField = new JTextField();
		nnameField.setBounds(100, 340, 200,50);
		nnameField.setText(nnameHint);
		nnameField.addFocusListener(this);

		//signup button
        suButton = new JButton("회원가입");
		suButton.setBounds(100, 440, 200,50);
        suButton.addActionListener(this);
		suButton.setBackground(Color.decode("#0C71AE"));
		suButton.setForeground(Color.WHITE);
		suButton.setFont(font2);

        panel.add(suLabel);
        panel.add(idField);
        panel.add(pwField);
		panel.add(pwckField);
        panel.add(nnameField);
        panel.add(suButton);

        add(panel);
    }

    public void actionPerformed(ActionEvent e) {
    int result = JOptionPane.showConfirmDialog(this, "회원가입하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
    if (result == JOptionPane.YES_OPTION) {
        Login login = new Login();
		login.setVisible(true);
		dispose(); 
    }
}

	//if textfield is not empty
	public void focusGained(FocusEvent e){
		if(e.getSource() == idField && idField.getText().equals(idHint)){
			idField.setText("");
			idField.setForeground(Color.BLACK);
		}else if(e.getSource() == pwField && pwField.getText().equals(pwHint)){
			pwField.setText("");
			pwField.setForeground(Color.BLACK);
		}else if(e.getSource() == pwckField && pwckField.getText().equals(pwckHint)){
			pwckField.setText("");
			pwckField.setForeground(Color.BLACK);
		}else if(e.getSource() == nnameField && nnameField.getText().equals(nnameHint)){
			nnameField.setText("");
			nnameField.setForeground(Color.BLACK);
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
        }else if (e.getSource() == pwckField && pwckField.getText().isEmpty()) {
            pwckField.setText(pwckHint);
            pwckField.setForeground(Color.GRAY);
        }else if (e.getSource() == nnameField && nnameField.getText().isEmpty()) {
            nnameField.setText(nnameHint);
            nnameField.setForeground(Color.GRAY);
        }
	}
}
