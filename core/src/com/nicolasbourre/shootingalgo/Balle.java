package com.nicolasbourre.shootingalgo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Balle extends GameObject {
	
	float elapsedTime;
	float updateInterval = 0.015f;

	public Balle(Texture texture) {
		super(texture);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(float deltaTime) {
		
		if (isActive) {
			elapsedTime += deltaTime;
		
			if (elapsedTime >= updateInterval) {
				
				elapsedTime = 0f;
				//velocity.add(acceleration);
				
				position.x += velocity.x * deltaTime;
				position.y += velocity.y * deltaTime;
				
				acceleration = Vector2.Zero;
				
			}
			
			if ((position.x) > (boundaries.x + boundaries.width))
				this.isActive = false;
		
		}
	}
	
	@Override
	public void draw (SpriteBatch batch) {
		if (isActive) {	
			batch.draw(graphicObject.getTexture(), position.x + offset.x, position.y + offset.y,
					graphicObject.width, graphicObject.height);
		}
	}
	
	public void shoot(float x, float y) {
		isActive = true;
		position.x = x;
		position.y = y;
		
	}

}
