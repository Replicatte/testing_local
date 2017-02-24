package org.lwjglb.game;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;
import org.lwjgl.system.MemoryUtil;
import org.lwjglb.engine.Utils;
import org.lwjglb.engine.Window;
import org.lwjglb.engine.graph.Mesh;
import org.lwjglb.engine.graph.ShaderProgram;

public class Renderer {

    private ShaderProgram shaderProgram;

    private int vaoId;
    private int vboId;

    public Renderer() {

    }

    public void init() throws Exception {
        shaderProgram = new ShaderProgram();
        shaderProgram.createVertexShader(Utils.loadResource("/org/resources/vertex.vs"));
        shaderProgram.createFragmentShader(Utils.loadResource("/org/resources/fragment.fs"));
        shaderProgram.link();

    }

    public void clear() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    public void render(Window window, Mesh mesh) {
        clear();
        if (window.isResized()) {
            glViewport(0, 0, window.getWidth(), window.getHeight());
            window.setResized(false);
        }
        shaderProgram.bind();
// Draw the mesh glBindVertexArray(mesh.getVaoId()); glEnableVertexAttribArray(0); glDrawArrays(GL_TRIANGLES, 0, mesh.getVertexCount());
// Restore state glDisableVertexAttribArray(0); glBindVertexArray(0);
        shaderProgram.unbind();
    }

    public void cleanup() {
        if (shaderProgram != null) {
            shaderProgram.cleanup();
        }
    }

    public void render(Window window) {
        clear();

        if (window.isResized()) {
            glViewport(0, 0, window.getWidth(), window.getHeight());
            window.setResized(false);
        }

        shaderProgram.bind();

        // Bind to the VAO
        glBindVertexArray(vaoId);
        glEnableVertexAttribArray(0);

        // Draw the vertices
        glDrawArrays(GL_TRIANGLES, 0, 3);

        // Restore state
        glDisableVertexAttribArray(0);
        glBindVertexArray(0);

        shaderProgram.unbind();
    }

    //EN INIT()
//        float[] vertices = new float[]{
//            0.0f, 0.5f, 0.0f,
//            -0.5f, -0.5f, 0.0f,
//            0.5f, -0.5f, 0.0f
//        };
//
//        FloatBuffer verticesBuffer = null;
//        try {
//            verticesBuffer = MemoryUtil.memAllocFloat(vertices.length);
//            verticesBuffer.put(vertices).flip();
//
//            // Create the VAO and bind to it
//            vaoId = glGenVertexArrays();
//            glBindVertexArray(vaoId);
//
//            // Create the VBO and bint to it
//            vboId = glGenBuffers();
//            glBindBuffer(GL_ARRAY_BUFFER, vboId);
//            glBufferData(GL_ARRAY_BUFFER, verticesBuffer, GL_STATIC_DRAW);
//            // Define structure of the data
//            glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
//
//            // Unbind the VBO
//            glBindBuffer(GL_ARRAY_BUFFER, 0);
//
//            // Unbind the VAO
//            glBindVertexArray(0);
//        } finally {
//            if (verticesBuffer != null) {
//                MemoryUtil.memFree(verticesBuffer);
//            }
//        }
}
