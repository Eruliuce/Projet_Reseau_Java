package controleurs;

import vue.Vue;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ControleurPrincipal extends ApplicationAdapter
{
	InputProcessor controleurInputs;
	ControleurReseau controleurReseau;
	Vue vue;
	
	@Override
	public void create()
	{
		controleurInputs = new ControleurInputs();
		Gdx.input.setInputProcessor(controleurInputs);
		controleurReseau = new ControleurReseau();
		vue = new Vue();
		vue.clearScreen();
	}

	@Override
	public void render()
	{
		if(((ControleurInputs)controleurInputs).getClic())
			controleurReseau.emit(((ControleurInputs) controleurInputs).getX(), ((ControleurInputs) controleurInputs).getY());
		else
			controleurReseau.emit("none");
		if(controleurReseau.getNone())
			vue.clearScreen();
		else
			vue.afficherCercle(controleurReseau.getX(), controleurReseau.getY());
	}
}
