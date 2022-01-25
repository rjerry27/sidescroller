import java.awt.*;
import java.awt.geom.*;
public class Hero{
	int heroX,heroY,originalY,aladdinCount=0,jumpingCount=0,count=0;
	int[][] locsAndDims,jumpLocsAndDims;
	boolean jumping=false,falling=false,onBox=false,right=false;
	public Hero(int heroX,int heroY, int[][]locsAndDims, int[][]jumpLocsAndDims){
		this.heroX=heroX;
		this.heroY=heroY;
		this.originalY=heroY;
		this.locsAndDims=locsAndDims;
		this.jumpLocsAndDims=jumpLocsAndDims;
	}
	public int getX(){
		return heroX;
	}
	public int getY(){
		return heroY;
	}
	public int getOriginalY(){
		return originalY;
	}
	public boolean isOnBox(){
		return onBox;
	}
	public boolean isAbove(Block block){
		return heroY+getHeight()-1<block.getY();
	}
	public boolean sameLevel(Block block){
		return heroY+getHeight()==block.getY()+50;
	}
	public int getHeight(){
		return locsAndDims[0][3]*2;
	}
	public void setOnBox(boolean onBox){
		this.onBox=onBox;
	}

	public boolean isJumping(){
		return jumping;
	}

	public void setJumping(boolean jumping){
		this.jumping=jumping;
	}

	public boolean isFalling(){
		return falling;
	}

	public void setFalling(boolean falling){
		this.falling=falling;
	}

	public int getAladdinCount(){
		return aladdinCount;
	}

	public int getJumpCount(){
		return jumpingCount;
	}
	public void zeroJumpCount(){
		this.jumpingCount=0;
	}

	public void updateAladdinCount(int aladdinCount){
		this.aladdinCount=aladdinCount;
			if(aladdinCount==13)
				this.aladdinCount=1;
	}

	public void updateJumping(){
		if(isJumping())
			heroY--;
		count++;

		if(count%25==0){
			jumpingCount++;
			if(jumpingCount==6){
				setJumping(false);
				setFalling(true);
			}
		}
	}
	public void updateFalling(){
		heroY++;
		count++;
		if(count%25==0){
			jumpingCount++;
			if(jumpingCount==12){
				jumpingCount=0;
			}
		}
	}
	public Rectangle2D collisionBelow(){
		return new Rectangle2D.Double(getX(),getY()+1,jumpLocsAndDims[jumpingCount][2]*2,locsAndDims[0][3]*2);
	}

	public Rectangle2D getCollisionBox(){
		return new Rectangle2D.Double(getX(),getY(),locsAndDims[aladdinCount][2]*2,locsAndDims[0][3]*2);
	}
}