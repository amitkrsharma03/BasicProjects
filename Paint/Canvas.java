package Paint;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ArrayList;

public class Canvas extends JPanel {
    private static final int STROKE_SIZE = 8;
    private List<List<ColorPanel>> allPaths;
    private List<ColorPanel> colorpaths;
    private int canvasWidth, canvasHeight;
    private Color color;
    private int x,y;
    public Canvas(int targetWidth, int targetHeight){
        super();
        setPreferredSize(new Dimension(targetWidth, targetHeight));
        setOpaque(true);
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        allPaths = new ArrayList<>(25);
        canvasWidth = targetWidth;
        canvasHeight = targetHeight;

        MouseAdapter ma= new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x=e.getX();
                y=e.getY();
                Graphics g = getGraphics();
                g.setColor(color);
                g.fillRect(x, y, STROKE_SIZE, STROKE_SIZE);
                g.dispose();

                colorpaths = new ArrayList<>(25);
                colorpaths.add(new ColorPanel(color, x, y));
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                allPaths.add(colorpaths);
                colorpaths = null;
            }
            @Override
            public void mouseDragged(MouseEvent e) {
                x=e.getX();
                y=e.getY();
                Graphics2D g2d= (Graphics2D) getGraphics();
                g2d.setColor(color);
                if(!colorpaths.isEmpty()){
                    ColorPanel prev = colorpaths.get(colorpaths.size()-1);
                    g2d.setStroke(new BasicStroke(STROKE_SIZE));
                    g2d.drawLine(prev.getX(), prev.getY(), x, y);
                }
                g2d.dispose();
                ColorPanel cp = new ColorPanel(color, x, y);
                colorpaths.add(cp);
            }
        };
        addMouseListener(ma);
        addMouseMotionListener(ma);
    }
    public void setColor(Color color){
        this.color = color;
    }   
    public void clearCanvas(){
        Graphics g=getGraphics();
        g.clearRect(0,0,canvasWidth,canvasHeight);
        g.dispose();
        allPaths=new ArrayList<>(25);
        colorpaths=null;
        repaint();
        revalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d =(Graphics2D) g;
        for(List<ColorPanel> path:allPaths){
            ColorPanel from=null;
            for(ColorPanel point:path){
                g2d.setColor(point.getColor());
                if(path.size()==1) g2d.fillRect(point.getX(), point.getY(), STROKE_SIZE, STROKE_SIZE);
                if(from!=null) {
                    g2d.setStroke(new BasicStroke(STROKE_SIZE));
                    g2d.drawLine(from.getX(), from.getY(), point.getX(), point.getY());
                }
                from=point;
            }
        }
    }
}
