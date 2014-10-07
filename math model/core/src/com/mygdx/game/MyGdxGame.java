package com.mygdx.game;

import java.util.ArrayList;

import Car.Car;
import Car.CarLogic;
import MapOjects.Map;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;

import editorstuff.Editor;

public class MyGdxGame extends ApplicationAdapter {
	
	public	SpriteBatch batch;
	BitmapFont font;
	String string;
	Texture tex;
	public TextureRegion reg,reg1;
	float zoom=1.5f;
	OrthographicCamera cam;
	ArrayList<Car> cars = new ArrayList<Car>();
	//CarLogic logic;
	boolean isModefied = false;
	boolean isMapon = false;
	public Texture texture;
	float time,time2;
	public Map map;
	Editor ed;
	
	@Override
	public void create(){
		batch = new SpriteBatch();
		font = new BitmapFont();
		string = new String();
		string="Points";
		tex = new Texture(Gdx.files.internal("aut.png"));
		font.setColor(1, 0, 0, 1);
		texture = new Texture(Gdx.files.internal("data/jun.png"));
		map = new Map(this);
		//для одной машинки
		ed = new Editor(this);
		
		setCars();
		
		cam = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		cam.position.x=Gdx.graphics.getWidth()/2;
		cam.position.y = Gdx.graphics.getHeight()/2;
		reg = new TextureRegion(tex,tex.getWidth(),tex.getHeight());
		reg1 = new TextureRegion(new Texture(Gdx.files.internal("arrow.png")),10,24);
	}

	public void setCars()
	{
		
		int i=0;
		while(i<=10)//car amount
		{	
			Car car = new Car();
			car.vec.x=i*128;
			car.vec.y=0;
			i++;
			cars.add(car);
		}
	}
	
	public void destroyCars()
	{
		cars.clear();
	}
	
	public void setCarsonMap()
	{
		
	}
	
	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		cam.update();
		batch.begin();
		batch.setProjectionMatrix(cam.combined);
		
		for(Car car:cars){
			batch.draw(reg1, car.vec.x+11, car.vec.y+32, 5, 0, 10, 100, 1, 1, car.rotation);
			batch.draw(reg, car.vec.x, car.vec.y, tex.getWidth()/2, tex.getHeight()/2, tex.getWidth(), tex.getHeight(), 1, 1, car.rotation);
		}
		
		batch.end();
		
		if(isMapon)
		{
			map.render();
		}
		if(isModefied)
		{
			ed.render();
		}
		if(Gdx.input.isTouched())
		{
			for(Car car : cars)
			{
				car.vloc.x = MathUtils.random(0,Gdx.graphics.getWidth());
				car.vloc.y = MathUtils.random(0, Gdx.graphics.getHeight());
				car.vloc.sub(car.vec);
			}
		}
		
		//cars.items[i];
		for(Car car : cars)
		{
			for(int i=0;i<=10;i++)
			{	
				Car car1 = cars.get(i);
				if(car != car1)
				{
					new CarLogic(car,car1);
				}
			}
		}
		
		
		for(Car car : cars)
		{
			car.Logic();
		}
		
		if(Gdx.input.isKeyPressed(Keys.M)&&TimeUtils.nanoTime()-time>100000000)
		{
			time = TimeUtils.nanoTime();
			if(isMapon)
			{
				setCars();
				isMapon = false;
			}
			else
			{
				destroyCars();
				isMapon = true;
				
			}
		}
		
		if(Gdx.input.isKeyPressed(Keys.E))
		{
			
			if(!isModefied)
			{
				isModefied = true;
				destroyCars();
				map.clear();
			}
			
		}
		
		cam.zoom = zoom;
		/*if( (car.vec.x  < car1.vec.x && car.vec.x+32 > car1.vec.x)  || (car.vec.y  < car1.vec.y && car.vec.y+64 > car1.vec.y)  )
			Gdx.app.log("collisions", "collide");*/
	}
	
	public void update()
	{
		//car.update();
		//car1.update();
	}
}
