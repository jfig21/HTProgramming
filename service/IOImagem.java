/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.mysql.jdbc.Connection;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;

/**
 *
 * @author JoseQuiterio
 */
public class IOImagem {
    
static public BufferedImage linearResizeBi(BufferedImage origin, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resizedImage.createGraphics();
        float xScale = (float) width / origin.getWidth();
        float yScale = (float) height / origin.getHeight();
        AffineTransform at = AffineTransform.getScaleInstance(xScale, yScale);
        g.drawRenderedImage(origin, at);
        g.dispose();
        return resizedImage;
    }    
    
 public static void imageWrite(Connection con, File file) {
        try {

            FileInputStream io = new FileInputStream(file);
//            String query = "insert into alunos(foto) values(?)";
            String query = "update alunos set foto = ? where id = 2";
            java.sql.PreparedStatement stmt = con.prepareStatement(query);
            stmt.setBinaryStream(1, (InputStream) io, (int) file.length());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void imageWrite(ConnectBD c, File file, String numero) {
        Connection con = c.makeCon();
        try {

            FileInputStream io = new FileInputStream(file);
//            String query = "insert into alunos(foto) values(?)";
            String query = "update alunos set foto = ? where numero = '"+numero+"'";
            java.sql.PreparedStatement stmt = con.prepareStatement(query);
            stmt.setBinaryStream(1, (InputStream) io, (int) file.length());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
     
     
     
     
     public static BufferedImage getImageByNumero(ConnectBD c, String numero) {
        Connection con = c.makeCon();
         String query = "select foto from alunos where numero = ?";
        BufferedImage buffimg = null;
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, numero);
            ResultSet result = stmt.executeQuery();
            result.next();
            InputStream img = result.getBinaryStream(1); // reading image as InputStream
            buffimg = ImageIO.read(img); // decoding the inputstream as BufferedImage

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return buffimg;
    }    
}
