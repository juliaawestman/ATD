package main.java;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Stack;

/**
 * Class:       Renderer
 * <p/>
 * Author:      Erik Moström
 * cs-user:     dv14emm
 * Date:        12/14/15
 */
public class Renderer {
    private final int width;
    private final int height;
    private BufferedImage image;
    private Graphics2D graphics;

    public Renderer(int height, int width){
        this.height = height;
        this.width = width;
    }

    public void drawImage(Stack<GraphicEvent> s){
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setBackground(new Color(255, 255, 255, 0));

        while (!s.isEmpty()){
            GraphicEvent event = s.pop();

            Position corner = convertPosition(event);
            graphics.drawImage(event.getImage(), corner.getX(), corner.getY(), null);
        }
    }

    private Position convertPosition(GraphicEvent event) {

        int cornerX = event.getPos().getX() - event.getImage().getWidth()/2;
        int cornerY = event.getPos().getY()- event.getImage().getHeight()/2;

        return new Position(cornerX, cornerY);
    }

    public BufferedImage getImage(){
        return image;
    }



    /*BELOW THIS ALL SHOULD BE REMOVED*/
    /*public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Renderer renderer = new Renderer(648, 648);
                Tower t = new GroundTower(new Position(50, 50));
                Unit u = new GroundUnit(new Position(50, 50), 1);
                Stack<GraphicEvent> stack = new Stack<>();
                stack.add(t.generateGraphicEvent());
                stack.add(u.generateGraphicEvent());
                renderer.drawImage(stack);

                GUI gui = new GUI();
                gui.setImage(renderer.getImage());
            }
        });

    }

    private static class GUI {
        JFrame frame;
        ImageIcon icon;

        public GUI(){
            frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //frame.setSize(100, 100);
            frame.setLocationRelativeTo(null);

            icon = new ImageIcon();
            //JPanel p = new JPanel();
            //p.add(new JLabel(icon));
            //p.setVisible(true);
            //p.setSize(p.getPreferredSize());

            //frame.add(p);
            frame.add(new JLabel(icon));
            frame.setVisible(true);
            frame.pack();
            frame.setResizable(false);
            frame.setExtendedState(Frame.MAXIMIZED_BOTH);

        }

        public void setImage(BufferedImage img){
            icon.setImage(img);
        }
    }*/
}
