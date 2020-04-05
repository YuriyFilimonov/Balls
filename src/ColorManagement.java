import java.awt.*;

public class ColorManagement {
    private boolean variableColor;
    private final int MAX_COLOR = 255;

    private int baseR = (int) (Math.random() * 256);
    private int baseG = (int) (Math.random() * 256);
    private int baseB = (int) (Math.random() * 256);

    private int vR = (int) (Math.random() * 11);
    private int vG = (int) (Math.random() * 11);
    private int vB = (int) (Math.random() * 11);

    private int r, g, b;

    private Color color=new Color(baseR,baseG,baseB);

    ColorManagement(boolean variableColor) {
        this.variableColor = variableColor;
    }

    public Color getColor() {
        return color;
    }

    void update(GameCanvas canvas, float deltaTime) {
        if (variableColor) {
            r = (baseR + vR * (int) deltaTime) % MAX_COLOR;
            g = (baseG + vG * (int) deltaTime) % MAX_COLOR;
            b = (baseB + vB * (int) deltaTime) % MAX_COLOR;

            color = new Color(r, g, b);
        }
    }

    Color render(){
        return color;
    }
}
