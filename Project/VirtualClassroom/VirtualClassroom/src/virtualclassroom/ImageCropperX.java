/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualclassroom;

/**
 *
 * @author ASUS
 */
    import java.awt.BorderLayout;
    import java.awt.Graphics;
    import java.awt.Image;
    import java.awt.Rectangle;
    import java.awt.event.*;
    import java.awt.image.BufferedImage;
    import java.io.IOException;
    import java.io.*;
    import java.net.URL;
    import java.util.Vector;
    import java.awt.image.*;
    import javax.imageio.ImageIO;
    import javax.swing.*;
    public class ImageCropperX extends JFrame implements MouseListener, MouseMotionListener {
    private static final long serialVersionUID = 1L;
    int x1, x2, y1, y2;
    String opstr;
    int w, h;
    int x3,y3,w3,h3;
    JLabel lbn;
    BufferedImage im;
    private final JLabel k;
    private final Vector< Rectangle > rectangles = new Vector< Rectangle >();
    private boolean isNewRect = true;
    public ImageCropperX(String str, JLabel lbx) throws IOException{
        
    super( "Crop Image..." );
    this.setLocationRelativeTo(null);
    lbn=lbx;
    setLayout(null);
    opstr=str;
    URL u = new URL("file:"+str);
    im=ImageIO.read(u);
    w=im.getWidth();
    h=im.getHeight();
    ImageIcon op=new ImageIcon(im);
    k=new JLabel(op);
    k.setBounds(0, 0, w, h);
    getContentPane().add(k);
    JButton but=new JButton("Crop...");
    but.setBounds(0,h+10, w, 30);
    getContentPane().add(but);
    
    but.addActionListener(new ActionListener() {
    
    @Override
    public void actionPerformed(ActionEvent e) {
    BufferedImage subim=im.getSubimage(x3, y3-30, w3, h3);
    try {
     BufferedImage bi = subim;
     File outputfile = new File(opstr);
     ImageIO.write(bi, "jpg", outputfile);
     ImageIcon ic = new ImageIcon(opstr);
     lbn.setIcon(ic);
     } catch (IOException w) {
    w.printStackTrace();
    }

    JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(subim)));
    dispose();
    }
    });
    addMouseListener( this ); // listens for own mouse and
    addMouseMotionListener( this ); // mouse-motion events
    setSize( w, h+100 );
    setVisible( true );
    }
     
    String getpath()
    {
        return opstr;
    }
    
    public void mouseClicked( final MouseEvent event ) {
    repaint();
    }
    public void mousePressed( final MouseEvent event ) {
    this.x1 = event.getX();
    this.y1 = event.getY();
    repaint();
    }
    public void mouseReleased( final MouseEvent event ) {
    this.x2 = event.getX();
    this.y2 = event.getY();
    Rectangle rectangle = getRectangleFromPoints();
    this.rectangles.add( rectangle );
    this.x1 = this.y1 = this.x2 = this.y2 = 0;
    this.isNewRect = true;
    repaint();
    }
    private Rectangle getRectangleFromPoints() {
    int width = this.x1 - this.x2;
    int height = this.y1 - this.y2;
    Rectangle rectangle = new Rectangle( width < 0 ? this.x1
    : this.x2, height < 0 ? this.y1
    : this.y2, Math.abs( width ), Math.abs( height ) );
    return rectangle;
    }
    public void mouseEntered( final MouseEvent event ) {
    repaint();
    }
    public void mouseExited( final MouseEvent event ) {
    repaint();
    }
    public void mouseDragged( final MouseEvent event ) {
    this.x2 = event.getX();
    this.y2 = event.getY();
    this.isNewRect = false;
    repaint();
    }
    public void mouseMoved( final MouseEvent event ) {
    repaint();
    }
    @Override
    public void paint( final Graphics g ) {
    super.paint( g ); // clear the frame surface
    Rectangle newRectangle = getRectangleFromPoints();
    if ( !this.isNewRect ) {
    g.drawRect( newRectangle.x, newRectangle.y, newRectangle.width, newRectangle.height );
    }
    if(rectangles.size()==2){
    rectangles.removeElementAt(0);
    }
    for( Rectangle rectangle : this.rectangles ) {
    g.drawRect( rectangle.x, rectangle.y, rectangle.width, rectangle.height );
    x3=rectangle.x;
    y3=rectangle.y;
    w3=rectangle.width;
    h3=rectangle.height;
    }
    }
    }

