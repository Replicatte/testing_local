/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lwjglb.game;

import org.lwjglb.engine.GameEngine;
import org.lwjglb.engine.IGameLogic;



public class Main {

    public static void main(String[] args) {

        try {

            boolean vSync = true;

            IGameLogic gameLogic = new DummyGame();

            GameEngine gameEng = new GameEngine("GAME", 1280, 720, vSync, gameLogic);

            gameEng.start();

        } catch (Exception excp) {

            excp.printStackTrace();

            System.exit(-1);

        }

    }

}
