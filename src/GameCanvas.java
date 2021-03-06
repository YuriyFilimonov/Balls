import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    MainCircles listener;
    ColorManagement colorManagement= new ColorManagement(true);
    long lastFrameTime;
    float deltaTime;

    GameCanvas(MainCircles listener) {
        this.listener = listener;
        this.setBackground(colorManagement.getColor());
        lastFrameTime = System.nanoTime();
    }

    void update(){
        colorManagement.update(this,deltaTime);
    }

    void render(){
        this.setBackground(colorManagement.render());
    }

     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //60 frames per second
        long currentTime = System.nanoTime();
        deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        listener.onCanvasRepainted(this, g, deltaTime);
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public int getLeft() {
        return 0;
    }

    public int getRight() {
        return getWidth() - 1;
    }

    public int getTop() {
        return 0;
    }

    public int getBottom() {
        return getHeight() - 1;
    }
}
