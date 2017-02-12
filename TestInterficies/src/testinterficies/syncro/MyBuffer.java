/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testinterficies.syncro;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 *
 * @author repli
 */
public class MyBuffer {
    private IntBuffer buff;

    public MyBuffer() {
        String s = "pene";
        buff = ByteBuffer.wrap(s.getBytes()).asIntBuffer();
    }
    
    
}
