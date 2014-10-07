package MapOjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Array;

public class Road {
	Array<Junction> junction= new Array<Junction>(0);
	Array<Line> line = new Array<Line>(0);
	Array<Texture> tex;
	public void Road(int JunctionAmount,int Line[]){
		
	}
	
	public void draw(Batch batch,float x, float y){
		
	}
	
	public void addLine(Line line){
		this.line.add(line);
	}
	
	public void addJunction(Junction jun){
		junction.add(jun);
	}

}
