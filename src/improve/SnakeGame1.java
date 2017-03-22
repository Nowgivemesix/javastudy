package improve;


import javax.swing.JFrame;

public class SnakeGame1 {
	public static void main(String[] args){
		JFrame frame = new JFrame("Ã∞≥‘…ﬂ");
		frame.setBounds(0, 0, 600, 600);
		SnakePanel wy = new SnakePanel();
		frame.add(wy);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.show();
		wy.requestFocus();
	}
}