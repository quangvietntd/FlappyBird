package com.quangviet.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quangviet.game.FlappyDemo;

public class MenuState extends State {

    private Texture background;
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, FlappyDemo.WIDTH/2,FlappyDemo.HEIGHT/2);
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");

    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        System.out.println("Menu State Disposed");

    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }

    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
      //  sb.draw(background, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
      //  sb.draw(playBtn,Gdx.graphics.getWidth()/2 - playBtn.getWidth()/2,Gdx.graphics.getHeight()/2 - playBtn.getHeight()/2);
        sb.draw(background,0,0);
      //  sb.draw(playBtn,FlappyDemo.WIDTH /2 - playBtn.getWidth() /2, FlappyDemo.HEIGHT /2 );
        sb.draw(playBtn, cam.position.x - playBtn.getWidth()/2,cam.position.y);
        sb.end();

    }
}
