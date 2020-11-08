/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _manipulation;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.ImageIcon;

/**
 *
 * @author ITSUKA KOTORI
 */
public class Converter {

    public static Image blob_to_image(Blob blob) throws SQLException, IOException{
        InputStream in;
        in = blob.getBinaryStream();
        BufferedImage image = ImageIO.read(in);
        return image;
    }
    
    public static Blob image_to_blob(Image image) throws SQLException, IOException{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image_to_bufimg(image), "jpg", bos);
        return new SerialBlob(bos.toByteArray());
    }
    
    public static BufferedImage image_to_bufimg(Image img){
        if(img instanceof BufferedImage)
            return (BufferedImage)img;
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bgr = bi.createGraphics();
        bgr.drawImage(img, 0, 0, null);
        bgr.dispose();
        return bi;
    }
    
    public static Image bufimg_to_image(BufferedImage img){
        return new ImageIcon(img).getImage();
    }
}
