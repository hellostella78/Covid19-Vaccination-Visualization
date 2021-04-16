import java.awt.Font;

import javax.swing.*;

public class About extends JPanel {

	public About() {
		setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		
		JLabel names = new JLabel("<html>Group Members: <br><br>Shaira Alam<br>Sihyeon Kim<br>Zuy Pham<br>Aira San Agustin</html>", SwingConstants.CENTER);
		names.setFont(new Font("Arial", Font.PLAIN, 20));
		add(names);
		
	}
}
