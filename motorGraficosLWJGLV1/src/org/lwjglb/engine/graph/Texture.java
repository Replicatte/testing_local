/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lwjglb.engine.graph;

import de.matthiasmann.twl.utils.PNGDecoder;
import java.nio.ByteBuffer;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.glGenerateMipmap;

/**
 *
 * @author repli
 */
public class Texture {

    private final int id;

    public Texture(int id) {
        this.id = id;
    }

    public void bind() {
        glBindTexture(GL_TEXTURE_2D, id);
    }
    PNGDecoder decoder = new PNGDecoder(Texture.class.getResourceAsStream(fileName));
}
