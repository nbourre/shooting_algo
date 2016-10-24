package com.nicolasbourre.shootingalgo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GraphicObject {

	
	Texture texture;
	float width;
	float height;
	
	
	public GraphicObject(Texture texture) {
		super();
		this.texture = texture;
		
		width = texture.getWidth();
		height = texture.getHeight();

	}
	

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;		
	}
		
}
