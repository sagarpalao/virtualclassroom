/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualclassroom;

/**
 *
 * @author Sagar
 */

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.hslf.model.Slide;
import org.apache.poi.hslf.usermodel.SlideShow;

//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Image;
//import com.lowagie.text.Rectangle;
//import com.lowagie.text.pdf.PdfWriter;

public class Silkahn {

public Silkahn(String sldname)
{
        FileInputStream inputStream = null;
         String value = System.getenv("TEMP");
        try {
            inputStream = new FileInputStream( value+"/"+sldname);
            SlideShow ppt = new SlideShow(inputStream);
            inputStream.close();
            Dimension pgsize = ppt.getPageSize();
            //take first slide and save it as an image
            Slide slide[] = ppt.getSlides();
            BufferedImage img = new BufferedImage(pgsize.width, pgsize.height,BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = img.createGraphics();
            graphics.setPaint(Color.white);
            graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width,pgsize.height));
            for(int i=0;i<slide.length;i++)
            {
                FileOutputStream out = null;
                try {
                    slide[i].draw(graphics);
                    out = new FileOutputStream(value+"/"+sldname+i+".png");
                    javax.imageio.ImageIO.write(img, "png", out);
                } catch (IOException ex) {
                    Logger.getLogger(Silkahn.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        out.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Silkahn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Silkahn.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Silkahn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
    public static void main(String[] args) throws IOException, DocumentException {

        //load any ppt file
        
        //out.close();


        //get saved slide-image and save it into pdf
   /*     Image slideImage = Image.getInstance("e:/Java_codes/bank/clientserver/slideImage.png");
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("e:/Java_codes/bank/clientserver/PPTtoImageTest.pdf"));
        Rectangle rct = new Rectangle(0,0,(float)slideImage.getWidth(),(float)slideImage.getWidth());
 //       document.setPageSize(rct);
     //   document.setPageSize(new Rectangle((float)slideImage.getWidth(),(float)slideImage.getWidth()));
        
  //              .setPageSize(new Rectangle(slideImage.getWidth(), slideImage.getHeight()));
        document.open();
        slideImage.setAbsolutePosition(0, 0);
        document.add(slideImage);
        document.close();
*/
    }
}
