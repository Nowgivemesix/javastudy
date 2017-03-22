package improve;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;

public class Snake implements SnakeFeature {
	public LinkedList<SnakeNode> L = new LinkedList<>();
	public int unit = 20;
	public int width = 20;
	public int height = 20;
	private int Direction;
	public int length;
	private int speed;
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public LinkedList<SnakeNode> getL() {
		return L;
	}
	public void setSnakeNode(SnakeNode node) {
		L.addFirst(node);
	}
	public int getDirection() {
		return Direction;
	}
	public void setDirection(int direction) {
		Direction = direction;
	}
	/*
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	*/
	SnakeNode s = new SnakeNode(1,1,Color.BLUE);
	public void Move(int Direction){
		int direction = 0;
		SnakeNode S = L.getFirst();
		int x = S.getX();
		int y = S.getY();
		switch(Direction){
			case 1:  
				x++;
				break;
			case -1:
				x--;
				break;
			case 2:
				y++;
				break;
			case -2:
				y--;
				break;
			default :
				break;
		}
			if(x > 600 - 1 || x < 0 || y > 600 - 1 || y < 0){
				return;
			}
			for(int i = 0;i < length;i++){
				if(x == L.get(i).getX()&&y == L.get(i).getY()){
					return;
				}
			}
			if(x == s.getX()&&y == s.getY()){
				eat();
				creatNode();
				return;
			}
			Color color = L.getLast().getColor();
			L.removeLast();
			L.addFirst(new SnakeNode(x,y,color));
			//repaint();
	}
	public void eat(){
		length++;
		L.addLast(new SnakeNode(s.getX(),s.getY(),s.getColor()));
	}
	public void creatNode(){
		int x1 = 0;
		int y1 = 0;
		boolean flag = true;
		while(flag){
			x1 = new Random().nextInt(20);
			y1 = new Random().nextInt(30);
			for(int i = 0;i < length;i++){
				if(x1 == L.get(i).getX()&&y1 == L.get(i).getY())
					break;
			}
			flag = false;
		}
		Color color = new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255));
		s.setColor(color);
		s.setX(x1);
		s.setY(y1);
	}

}
