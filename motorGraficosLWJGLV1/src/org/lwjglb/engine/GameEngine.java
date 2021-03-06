/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lwjglb.engine;

import org.lwjglb.engine.IGameLogic;
import org.lwjglb.engine.Timer;
import org.lwjglb.engine.Window;
import org.lwjglb.game.Renderer;

public class GameEngine implements Runnable {

    public static final int TARGET_FPS = 75;

    public static final int TARGET_UPS = 30;

    public final Window window;

    private final Thread gameLoopThread;

    private final Timer timer;

    private final IGameLogic gameLogic;

    public GameEngine(String windowTitle, int width, int height, boolean vSync, IGameLogic gameLogic) throws Exception {

        gameLoopThread = new Thread(this, "GAME_LOOP_THREAD");

        window = new Window(windowTitle, width, height, vSync);

        this.gameLogic = gameLogic;

        timer = new Timer();

    }

    public void start() {

        String osName = System.getProperty("os.name");

        if (osName.contains("Mac")) {

            gameLoopThread.run();

        } else {

            gameLoopThread.start();

        }

    }

    @Override

    public void run() {

        try {

            init();

            gameLoop();

        } catch (Exception excp) {

            excp.printStackTrace();

        } finally {
            
            cleanup();
        }

    }

    protected void init() throws Exception {

        window.init();

        timer.init();

        gameLogic.init(window);

    }

    protected void gameLoop() {

        float elapsedTime;

        float accumulator = 0f;

        float interval = 1f / TARGET_UPS;

        boolean running = true;

        while (running && !window.windowShouldClose()) {

            elapsedTime = timer.getElapsedTime();

            accumulator += elapsedTime;

            input();

            while (accumulator >= interval) {

                update(interval);

                accumulator -= interval;

            }

            render();

            if (!window.isvSync()) {

                sync();

            }

        }

    }

    private void sync() {

        float loopSlot = 1f / TARGET_FPS;

        double endTime = timer.getLastLoopTime() + loopSlot;

        while (timer.getTime() < endTime) {

            try {

                Thread.sleep(1);

            } catch (InterruptedException ie) {

            }

        }

    }

    protected void input() {

        gameLogic.input(window);

    }

    protected void update(float interval) {

        gameLogic.update(interval);

    }

    protected void render() {

        gameLogic.render(window);

        window.update();

    }

    private void cleanup() {
        gameLogic.cleanup();
    }

}
