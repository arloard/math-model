package editorstuff;

import Car.Car;
import MapOjects.Junction;
import MapOjects.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.MyGdxGame;

public class Editor {
	Stage stage;
	SpriteBatch batch;
	Table table;
	TextButton junc ;
	TextButton destr;
	TextButton car;
	TextButton exite;
	Map map;
	Junction jun;
	TextureRegion tex;
	TextureRegion c;
	Car care;
	boolean isjunc,iscar;
	
	public Editor(MyGdxGame game)
	{
		batch = game.batch;
		TextButtonStyle style = new TextButtonStyle();
		style.font = new BitmapFont();
		style.fontColor = new Color(1,0,0,1);
		style.downFontColor = new Color(0,0,0,1);
		junc = new TextButton(" junc ",style);
		destr = new TextButton(" destr ",style);
		car = new TextButton(" car ",style);
		exite = new TextButton(" exite ",style);
		stage = new Stage();
		tex = new TextureRegion(game.texture);
		c = game.reg;
		map = game.map;
		junc.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
			{
				jun = new Junction(Gdx.input.getX(),Gdx.graphics.getHeight()-Gdx.input.getY());
				isjunc = true;
				return true;
			}
		});
		car.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
			{
				care = new Car();
				care.vec.set(Gdx.input.getX(),Gdx.graphics.getHeight()-Gdx.input.getY());
				iscar = true;
				return true;
			}
		});
		
		table = new Table();
		table.setFillParent(false);
		table.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight() - 30);
		table.setWidth(50f);
		table.setHeight(20f);
		table.add(junc);
		table.add(car);
		stage.addActor(table);
	    Gdx.input.setInputProcessor(stage);
	}
	
	public void render()
	{
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		batch.begin();
		
		if(isjunc)
		{
			batch.draw(tex, Gdx.input.getX(), Gdx.graphics.getHeight()-Gdx.input.getY(),jun.width/2,jun.height/2,jun.width,jun.height,1,1,0);
		}
		if(iscar)
		{
			//batch.draw(c,Gdx.input.getX(), Gdx.graphics.getHeight()-Gdx.input.getY());
		}
		if(isjunc && !Gdx.input.isTouched())
		{
			isjunc = false;
			jun.setJunction( Gdx.input.getX(), Gdx.graphics.getHeight()-Gdx.input.getY()); 
			map.Add(jun);
		}
		batch.end();
		if(!map.ismapEmpty())
			map.render();
		//map.render();
		
		
		
		
		
	}
	
}
