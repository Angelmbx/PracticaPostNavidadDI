
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class PanelDibujo extends JPanel {
    private Punto p1;
    private Punto p2;
    private Boolean limpiar;
    private final int WIDTH = 200;
    private final int HEIGHT = 200;

    public PanelDibujo() {
        p1 = new Punto();
        p2 = new Punto();
        this.limpiar = false;
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public PanelDibujo(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.limpiar = false;
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public void asignarPunto(Punto p1, Punto p2) {
        this.p1.asignarX(p1.obtenerX());
        this.p1.asignarY(p1.obtenerY());
        this.p2.asignarX(p2.obtenerX());
        this.p2.asignarY(p2.obtenerY());
    }

    public Punto obtenerPunto1(){
        return this.p1;
    }

    public Punto obtenerPunto2(){
        return this.p2;
    }
    
    public void setLimpiar(Boolean limpiar) {
        this.limpiar = limpiar;
    }

    public boolean getLimpiar() {
        return this.limpiar;
    }

    @Override
    public void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        int width = 0;
        String figura = "RECTANGULO";
        g.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 22));

        width = (int) (this.p2.obtenerX()) - (int) (this.p1.obtenerX());
        if (width > this.WIDTH){
            this.setPreferredSize(new Dimension(width, width));
        }
       
        if (this.limpiar) {
            g.setColor(Color.gray);
            g.fillRect((int) (p1.obtenerX()), (int) (p1.obtenerY()), width, width);
        } else {
            g.setColor(Color.RED);
            g.drawString(figura, (figura.length() + this.getWidth() / 4), 40);

            g.setColor(Color.yellow);
            g.drawRect((int) (p1.obtenerX()), (int) (p1.obtenerY()), width, width);
            g.setColor(Color.blue);
            g.fillRect((int) (p1.obtenerX() + 2), (int) (p1.obtenerY() + 2), width - 2, width - 2);
        }

    }
}
