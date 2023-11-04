/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASM;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 *
 * @author USER
 */
public class SFile {
    
    // Luu du lieu
    public static void writeObject(String path,Object object){
        try {
            FileOutputStream fiw = new FileOutputStream(path);
            ObjectOutputStream obw = new ObjectOutputStream(fiw);
            obw.writeObject(object);
            object.getClass();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    public static Object ReadObject(String path){
        try {
            FileInputStream fir = new FileInputStream(path);
            ObjectInputStream obs = new ObjectInputStream(fir);
            Object object = obs.readObject();
            obs.close();
            return object;
                    
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
