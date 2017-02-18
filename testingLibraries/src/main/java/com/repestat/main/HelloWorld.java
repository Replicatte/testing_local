/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repestat.main;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class HelloWorld {

    // The window handle
    private long window;
    public static final int WIN_WIDTH = 1280;
    public static final int WIN_HEIGHT = 720;

    public void init() {
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");

        start();

        loop();

        // Free the window callbacks and destroy the window
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        /*
                * FUNCIÓN DE CALLBACKS?
                *-Seguramente se encarga de recojer algún tipo de value, en plan
                *errores y tal.
         */
        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();

        /*
                *GLFW?
                *+Parece ser que se trata de unas libreras para la fácil 
                *creación de ventanas contextos  y superficies.
         */
    }

    private void start() {
        // Setup an error callback. The default implementation
        // will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW. Most GLFW functions will not work before 
        //doing this.
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize "
                    + "GLFW");
        }

        // Configure GLFW
        glfwDefaultWindowHints(); // optional, the current window hints are 
        //already the default

        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        // the window will stay hidden after creation

        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        // the window will be resizable

        // Create the window
        window = glfwCreateWindow(WIN_WIDTH, WIN_HEIGHT, "Mi frame :)", NULL, NULL);

//        PARA MODIFICIAR TAMAÑO
//        glfwSetWindowAspectRatio(window, 16, 9);
//        glfwSetWindowSize(window, WIN_WIDTH, WIN_HEIGHT);
        if (window == NULL) {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        // Setup a key callback. It will be called every time a key is pressed,
        //repeated or released.
        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
                glfwSetWindowShouldClose(window, true); // We will detect this 
                //in the rendering loop
            }
            if (key == GLFW_KEY_A && action == GLFW_PRESS) {
                // NO FUNCIONA COMO DEBERIA
                System.out.println("Se escucho el A");
                MemoryStack stack = stackPush();
                IntBuffer xWinPosition = stack.mallocInt(1);
                glfwGetMonitorPos(window, xWinPosition, null);
                glfwSetWindowPos(window, xWinPosition.get(0), 100);

            }

        });

        // Get the thread stack and push a new frame
        try (MemoryStack stack = stackPush()) {
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*
            /*
            * PARECE SER QUE ESTO DE ARRIBA EQUIVALE AL PUNTERO DE UNA DIRECCIÓN
            * DE MEMORIA, MUCHOS DE LOS METODOS DE GLFW (SOBRE TODO LOS GETTERS)
            * PARECE QUE REQUIEREN DE UN PUNTERO PARA COJER LOS DATOS.
             */

            // Get the window size passed to glfwCreateWindow
            glfwGetWindowSize(window, pWidth, pHeight);

            // Get the resolution of the primary monitor
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            int xPos = ((vidmode.width() - pWidth.get(0)) / 2);
            int yPos = ((vidmode.height() - pHeight.get(0)) / 2);

            System.out.println("" + xPos);
            System.out.println("" + yPos);
            // Center the window
            glfwSetWindowPos(
                    window,
                    xPos,
                    yPos
            );
        } // the stack frame is popped automatically

        // Make the OpenGL context current
        glfwMakeContextCurrent(window);

        // Not enable v-sync. ('1' to enable V-Sync)
        glfwSwapInterval(0);

        // Make the window visible
        glfwShowWindow(window);
    }

    private void loop() {
        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();

        // Set the clear color
        glClearColor(2.0f, 0.4f, 0.4f, 0.0f);

        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.       
        while (!glfwWindowShouldClose(window)) {
            
            
            
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            // clear the framebuffer 3D

            glfwSwapBuffers(window); // swap the color buffers

            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();

        }
    }

    public static void main(String[] args) {
        new HelloWorld().init();
    }

}
