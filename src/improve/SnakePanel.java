package improve;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;



public class SnakePanel extends JPanel {
	Snake s1 = new Snake();
	Timer timer = new Timer(125,new ThingListener());
	public SnakePanel()
	{
		s1.L.add(new SnakeNode(s1.width / 2,s1.height / 2,Color.BLACK));
		s1.L.add(new SnakeNode(s1.width / 2,s1.height / 2 + 1,Color.BLUE));
		s1.L.add(new SnakeNode(s1.width / 2,s1.height / 2 + 2,Color.RED));
		s1.setDirection(1);
		s1.length = 3;
		s1.creatNode();
		timer.start();
		
		this.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				int direction = 0;
				switch(e.getKeyCode()){
					case KeyEvent.VK_DOWN :
						direction = 2;
						break;
					case KeyEvent.VK_UP :
						direction = -2;
						break;
					case KeyEvent.VK_LEFT :
						direction = -1;
						break;
					case KeyEvent.VK_RIGHT :
						direction = 1;
						break;
					default : break;
				}
				if(direction + s1.getDirection() != 0){
					 s1.setDirection(direction);
					s1.Move(s1.getDirection());
					repaint();
				}
			}
		});
	}
	public void draweat(){
		s1.eat();
		repaint();
		s1.creatNode();
	}
	class ThingListener implements ActionListener {//设置一个监听器事件
        public void actionPerformed(ActionEvent e) {
            s1.Move(s1.getDirection());
            repaint();
        }
    }
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
        g.setColor(s1.s.getColor());
        g.fillOval(s1.s.getX()*s1.unit, s1.s.getY()*s1.unit, s1.unit, s1.unit);
        g.setColor(s1.s.getColor());
		for(int i = 0; i < s1.length; i++){
			g.setColor(s1.L.get(i).getColor());
			g.fillOval(s1.L.get(i).getX()*s1.unit,s1.L.get(i).getY()*s1.unit, s1.unit, s1.unit);
		}
	}
}