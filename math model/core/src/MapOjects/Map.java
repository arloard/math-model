package MapOjects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.MyGdxGame;

public class Map {
	ArrayList<Junction> juncs = new ArrayList<Junction>();
	ArrayList<Junction> roads = new ArrayList<Junction>();
	SpriteBatch batch;
	MyGdxGame game;
	Texture tex;
	TextureRegion region; 
	
	public Map(MyGdxGame game)
	{
		this.game = game;
		batch = game.batch;
		fpos();
		tex = game.texture;
		region = new TextureRegion(tex,64,64);
	}
	
	private void fpos()
	{
		Junction junc = new Junction(0,12);
		juncs.add(junc);
		junc = new Junction(128,12);
		juncs.add(junc);
		junc = new Junction(128,140);
		juncs.add(junc);
		junc = new Junction(0,140);
		juncs.add(junc);
	}
	
	public void clear()
	{
		juncs.clear();
	}
	
	public void Add(Junction jun){
		juncs.add(jun);
	}
	
	public void render()
	{
		batch.begin();
		for(Junction jun : juncs )
		{
			batch.draw(region, jun.x, jun.y, jun.width/2, jun.height/2, jun.width, jun.height, 1, 1, 0);
		}
		batch.end();
	}
	
	public boolean ismapEmpty()
	{
		if(juncs.isEmpty())
			return true;
		else
			return false;
	}
	
}
