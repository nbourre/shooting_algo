package com.nicolasbourre.shootingalgo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameObject   {

	protected GraphicObject graphicObject;
	
	boolean isActive;

	boolean facingLeft = false;
	
	Boundary boundaries;
	boolean hasBoundaries = false;
	
	Vector2 position;

	Vector2 velocity;
	Vector2 acceleration;
	
	Vector2 offset;
	


	public GameObject(Texture texture) {
		if (graphicObject == null)
			graphicObject = new GraphicObject(texture);
		
		isActive = true;

		boundaries = new Boundary();
		position = new Vector2();
		velocity = new Vector2();
		acceleration = new Vector2();
		offset = new Vector2();
		
	}
	
	public Vector2 getOffset() {
		return offset;
	}

	public void setOffset(Vector2 offset) {
		this.offset = offset;
	}
	
	public void setOffset(float x, float y) {
		if (offset == null)
			offset = new Vector2();
		
		offset.x = x;
		offset.y = y;
	}
	
	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}
	
	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;	
	}
	
	public void setVelocity (float x, float y) {
		if (this.velocity == null)
			this.velocity = new Vector2();
		
		this.velocity.x = x;
		this.velocity.y = y;
	}
	
	public Vector2 getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(Vector2 acceleration) {
		this.acceleration = acceleration;
	}
	
	public Rectangle getBoundaries() {
		return boundaries;
	}

	public void setBoundaries(Boundary boundaries) {
		this.boundaries = boundaries;
	}
	
	public void setSize(float width, float height) {
		graphicObject.width = width;
		graphicObject.height = height;
	}

	public void update(float deltaTime) {
		
		//velocity.add(acceleration);
		
		position.x += velocity.x * deltaTime;
		position.y += velocity.y * deltaTime;
		
		acceleration.x = 0;
		acceleration.y = 0;

		
		if ((position.x) > (boundaries.x + boundaries.width))
			this.isActive = false;
	}
	
	
	public void draw (SpriteBatch batch) {
		batch.draw(graphicObject.getTexture(), position.x + offset.x, position.y + offset.y,
				graphicObject.width, graphicObject.height);
	}



	public void setPosition(float i, float j) {
		if (this.position == null)
			this.position = new Vector2();
		
		this.position.x = i;
		this.position.y = j;
		
	}



}
