package Car;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public  class Car {

	public Vector2 vec = new Vector2();
	public Vector2 vloc = new Vector2();
	public Vector2 velocity = new Vector2();
	public Vector2 vtmp = new Vector2();
	
	public float rotation=0;
	
	public Car(){
		
		vloc.x=vec.x;
		vloc.y=vec.x;
		
		velocity.y = 0;
		velocity.x = 4;
		
	}	
	
	public void Logic(){
		

		if(vloc.angle() >= 0 && vloc.angle() <= 180)
		{
			if(velocity.angle() >= 0 && velocity.angle() <= 180)
			{
				
				if(velocity.angle() > vloc.angle())
				{
					rotation = velocity.angle()-vloc.angle();
					if( rotation >= 45)
						velocity.setAngle(velocity.angle() - 45);
					if( rotation < 45)
						velocity.setAngle(vloc.angle());
				}
				else if(velocity.angle() < vloc.angle())
				{
					rotation = vloc.angle() - velocity.angle();
					if( rotation >= 45)
						velocity.setAngle(velocity.angle() + 45);
					if( rotation < 45)
						velocity.setAngle(vloc.angle());
				}
			}
			else if(velocity.angle() >= 180 && velocity.angle() <= 360)
			{
				rotation = velocity.angle() - vloc.angle();
				if(rotation < 45 || rotation > 315)
				{
					velocity.setAngle(vloc.angle());
				}
				if(45 >= rotation && rotation <= 315)
				{
					velocity.setAngle(vloc.angle()+45);
				}
			}
		}
		else if(vloc.angle() >= 180 && vloc.angle() <= 360)
		{
			if(velocity.angle() >= 0 && velocity.angle() <= 180)
			{
				rotation = velocity.angle() - vloc.angle();
				if(rotation < 45 || rotation > 315)
				{
					velocity.setAngle(vloc.angle());
				}
				if(45 >= rotation && rotation <= 315)
				{
					velocity.setAngle(vloc.angle()-45);
				}
			}
			else if(velocity.angle() >= 180 && velocity.angle() <= 360)
			{
				
				if(velocity.angle() > vloc.angle())
				{
					rotation = velocity.angle()-vloc.angle();
					if( rotation >= 45)
						velocity.setAngle( 45);
					if( rotation < 45)
						velocity.setAngle(vloc.angle());
				}
				else if(velocity.angle() < vloc.angle())
				{
					rotation = vloc.angle() - velocity.angle();
					if( rotation >= 45)
						velocity.setAngle( 45);
					if( rotation < 45)
						velocity.setAngle(vloc.angle());
				}
				
			}
		}
		
		vloc.sub(velocity);
		
		if(vloc.len() > velocity.len())
		{
	
			vec.add(velocity);
		}else
			vloc.setAngle(velocity.angle());
		
			
		
		rotation = velocity.angle()-90;
		
		if(vec.x > Gdx.graphics.getWidth())
			vec.x = Gdx.graphics.getWidth();
		if(vec.x < 0)
			vec.x =0;
		if(vec.y > Gdx.graphics.getHeight())
			vec.y = Gdx.graphics.getHeight();
		if(vec.y < 0)
			vec.y = 0;
	}
	
	//public abstract void update();
	
	public boolean isNow(Car car)
	{
		if(this == car)
			return true;
		else
			return false;
	}
	
	
	
	
}
