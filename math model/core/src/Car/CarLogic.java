package Car;

import com.badlogic.gdx.math.Vector2;

public class CarLogic {

	public Vector2 radiousH = new Vector2();
	public Vector2 radiousS = new Vector2();
	float rotation;
	
	public CarLogic(Car car,Car car1){
		radiousH.x=64;
		radiousH.y=0;
		if(isInRadious(car.vec,car1.vec)== true )
		{
			rotation = car.vec.angle();
			if(rotation > 90)
			{
				car.velocity.setAngle(rotation + 90);			
				car1.velocity.setAngle(rotation - 90);
			}
			else
			{
				car.velocity.setAngle(rotation + 90);
				car.velocity.setAngle(360-rotation);
			}
		}
		car.vec.add(car1.vec);
	}
	
	private boolean isInRadious(Vector2 centr1, Vector2 center2)
	{
		if(centr1.sub(center2).len() < radiousH.len())
		{
			
			return true;
		}
		else
		{
			
			return false;
		}
	}
	
	public void setVec( Vector2 vec){
		
	}
	
	
}
