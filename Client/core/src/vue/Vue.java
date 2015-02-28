package vue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Vue
{
	ShapeRenderer shapeRenderer;
	
	public Vue()
	{
		shapeRenderer = new ShapeRenderer();
	}
	
	public void afficherCercle(float x, float y)
	{
		Gdx.graphics.getGL20().glClearColor( 1, 1, 1, 1 );
		Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(Color.RED);
		shapeRenderer.circle(x, y, 10);
		shapeRenderer.end();
	}
	
	public void clearScreen()
	{
		Gdx.graphics.getGL20().glClearColor( 1, 1, 1, 1 );
		Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
	}
}
