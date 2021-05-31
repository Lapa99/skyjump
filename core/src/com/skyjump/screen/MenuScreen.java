package com.skyjump.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.skyjump.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private final static float LENGHT = 2f;
    private Texture img;
    private Vector2 pos;
    private Vector2 v;
    private Vector2 press;
    private Vector2 tmp;


    @Override
    public void show() {
        pos = new Vector2();
        press = new Vector2();
        tmp = new Vector2();
        v = new Vector2();
        batch = new SpriteBatch();
        img = new Texture("thebackground.jpg");
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        press.set(screenX, Gdx.graphics.getHeight() - screenY);
        v.set(press.cpy().sub(pos).setLength(LENGHT));
        return false;
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
        tmp.set(press);
        if(tmp.sub(pos).len() <= v.len()) {
            pos.set(press);
        } else {
            pos.add(v);
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
