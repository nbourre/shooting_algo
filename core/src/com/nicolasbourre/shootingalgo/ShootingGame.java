package com.nicolasbourre.shootingalgo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class ShootingGame extends ApplicationAdapter {
	SpriteBatch batch;
	Random random;

	Balle balls[];
	GameObject cannon;
	int maxBalls = 3;
	float fireDelayTimer = 0;
	float fireDelay = 0.25f;

	@Override
	public void create () {
		batch = new SpriteBatch();

		random = new Random();


		setupBalls();
		setupCannon();
	}

	private void setupBalls() {
		balls = new Balle[maxBalls];
		Texture ballTexture = new Texture("beachBall.png");

		for (int i = 0; i < maxBalls; i++) {

			balls[i] = new Balle(ballTexture);

			balls[i].setPosition(new Vector2(0, random.nextFloat() * Gdx.graphics.getHeight()));
			balls[i].setSize (15, 15);
			balls[i].setOffset(25, 7);

			balls[i].setBoundaries(new Boundary(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));

			balls[i].setVelocity(new Vector2(Gdx.graphics.getWidth(), 0));
		}
	}

	private void setupCannon() {
		Texture cannonTexture = new Texture("air_cannon.png");
		cannon = new GameObject(cannonTexture);

		cannon.setPosition(0, Gdx.graphics.getHeight() / 2);
		cannon.setSize(48, 28);
		cannon.setVelocity(0, 0);
		cannon.isActive = true;

	}

	@Override
	public void render () {
		float delta = Gdx.graphics.getDeltaTime();

		update (delta);
		draw();
	}

	private void update(float deltaTime) {
		checkKeys();

		updateBalls(deltaTime);
		updateCannon(deltaTime);
	}



	private void draw () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		drawBalls();
		drawCannon();
		batch.end();
	}

	private void updateBalls(float deltaTime) {
		fireDelayTimer += deltaTime;

		for (int i = 0; i < maxBalls; i++) {
			if (balls[i].isActive)
				balls[i].update(deltaTime);
		}
	}

	private void updateCannon(float deltaTime) {
		cannon.setPosition(0, Gdx.graphics.getHeight() - Gdx.input.getY());
		cannon.update(deltaTime);
	}

	private void drawBalls() {
		for (int i = 0; i < maxBalls; i++) {
			balls[i].draw(batch);
		}
	}

	private void drawCannon() {
		cannon.draw(batch);
	}

	private void shootBalls() {
		for (int i = 0; i < maxBalls; i++) {
			if (!balls[i].isActive) {
				balls[i].shoot(0, Gdx.graphics.getHeight() - Gdx.input.getY());
				break;
			}
		}
	}

	private void checkKeys () {
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			if (fireDelayTimer > fireDelay) {
				fireDelayTimer = 0;
				shootBalls();
			}
		}

	}
}
