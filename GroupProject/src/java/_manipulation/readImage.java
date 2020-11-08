/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _manipulation;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author ITSUKA KOTORI
 */
public class readImage {

    private String filepath;
    private Image image = null;
    public readImage(String filepath) {
        try {
            File file = new File(filepath);
            BufferedImage images = null;
            images = ImageIO.read(file);
            image = Converter.image_to_bufimg(images);
        } catch (IOException ex) {
            image = null;
        }
    }
    public String getFilepath() {
        return filepath;
    }
    public boolean isIsfile() {
        return image == null;
    }
    public Image getImage() {
        return image;
    }
}
