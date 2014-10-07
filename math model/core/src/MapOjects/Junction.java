package MapOjects;

import com.badlogic.gdx.math.Rectangle;


public class Junction {
	
	public int width=64,height=64;
	public float x,y;
	Rectangle shell;
	
	public Junction(float x,float y)
	{
		this.x=x;
		this.y=y;
	}
	
	public void addRoad()
	{
		
	}
	
	public void setJunction(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	public boolean isTouched(float x,float y)
	{
		if(shell.contains(x, y))
		{
			return true;
		}
		else
			return false;
	}
}
