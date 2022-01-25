import java.awt.*;
import java.awt.geom.*;
public class Block{
	int blockX,blockY,width,height;
	String type;

	public Block(int blockX, int blockY, int width, int height, String type){
		this.blockX=blockX;
		this.blockY=blockY;
		this.width=width;
		this.height=height;
		this.type=type;
	}
	public boolean isTopBlock()
	{
		return type.equals("B");
	}

	public int getX(){
		return blockX;
	}

	public int getY(){
		return blockY;
	}

	public void updateX(int num){
		blockX+=num;
		if(blockX==-50)
			blockX+=3500;
	}

	public Rectangle2D getCollisionBox(){
		return new Rectangle2D.Double(blockX,blockY,width,height);
	}

}