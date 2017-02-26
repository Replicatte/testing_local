/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lwjglprojecto;

import java.nio.IntBuffer;
import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.system.MemoryStack;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.*;

/**
 *
 * @author repli
 */
public class LWJGLprojecto {

    public static long window;
    public static IntBuffer pWidth;
    public static IntBuffer pHeight;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        initDisplay();
        initGL();
        gameLoop();

        //ESTO PARA CUANDO ACABÉ EL JUEGO       
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    private static void initDisplay() {
        GLFWErrorCallback.createPrint(System.err).set();

        if (!glfwInit()) {
            throw new IllegalStateException("No se puede inicializar GLFW");
        }

        glfwDefaultWindowHints();//Opcional, esta ya por defecto.
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);

        window = glfwCreateWindow(800, 600, "LWJGL learning", NULL, NULL);

        if (window == NULL) {
            throw new RuntimeException("No se pudo crear la ventana GLFW");
        }

        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
                glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
            }
        });

        try (MemoryStack stack = stackPush()) {
             pWidth = stack.mallocInt(1); // int*
             pHeight = stack.mallocInt(1); // int*

            // Get the window size passed to glfwCreateWindow
            glfwGetWindowSize(window, pWidth, pHeight);

            System.out.println("Ancho: " + pWidth.get(0) + "- Alto:" + pHeight.get(0));
            // Get the resolution of the primary monitor
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            // Center the window
            glfwSetWindowPos(
                    window,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
            glfwMakeContextCurrent(window);
            glfwGetFramebufferSize(window, pWidth, pHeight);
        }

        
        
        glfwSwapInterval(1);

        glfwShowWindow(window);
    }

    private static void initGL() {
        GL.createCapabilities();

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, pWidth.get(0), 0, pHeight.get(0), -1, 1);
        glMatrixMode(GL_MODELVIEW);

        glClearColor(0.6f, 0.6f, 0.6f, 0.0f);

        glDisable(GL_DEPTH_TEST);//SOLO 2D
    }

    private static void gameLoop() {

        while (!glfwWindowShouldClose(window)) {
            
            
            glClear(GL_COLOR_BUFFER_BIT); //LIMPIAR CANVAS
            
            glColor3f(1.0f,1.0f,1.0f);
            glBegin(GL_QUADS);
            {
                glVertex2f(0, 0);
                glVertex2f(0, 64);
                glVertex2f(64, 64);
                glVertex2f(64, 0);
            }
            glEnd();
            
             glfwSwapBuffers(window);

            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }

    }

}
