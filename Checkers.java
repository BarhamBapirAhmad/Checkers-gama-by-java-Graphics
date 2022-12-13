import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

                        //Barham baper Ahmed

public class Checkers extends JFrame {
    // you can by your self how money rows you want
    public int rows = 8;
    public int columns = 8;

    Checkers() throws AWTException {
        setDefaultCloseOperation(3);
        setBounds(new Rectangle((rows +1)* 32, ((columns +1) * 32)));
        setBackground(new Color(117, 103, 68));
          setResizable(false);
        setLocationRelativeTo(null);
        //  add(new drawLine());

        JPanel panel = new JPanel(new FlowLayout());
        add(new drawLine());

        setVisible(true);

    }

    public static void main(String[] args) throws AWTException {
     int  first=   JOptionPane.showConfirmDialog(null,"first white Moves and then Blacks ","barham  Mirawdali" , JOptionPane. PLAIN_MESSAGE,JOptionPane.INFORMATION_MESSAGE);
        if (first==0  ){
            int s =  JOptionPane.showConfirmDialog(null,"  جولەکان تەنیا بۆ پێشەوەیە ناتوانی بۆ لاکان بڕۆی زۆر کەمم ماوە ئەشتوانم وای لێبکەم بەلام"+"\n" +" بە هۆی نەبونی کاتەوە و لەبەر فاینەل تەنیا ئەوەندەم مەجال هیوادارم بەپێی کۆدەکە کە نوسیومە دەرجەم بدەیەی،  "+"\n"+" بۆ جولەکەش زۆر زۆر ئاسانە بەچەند ifێک ئەیکەم ئەیکەم بەلام لەبەر دەرسی architecture مەجالم نیە ","barham  Mirawdali ", JOptionPane.PLAIN_MESSAGE,JOptionPane.INFORMATION_MESSAGE);

            if( s==0){
                new Checkers();

            }
        }

    }

    class drawLine extends JPanel {
        static int posx = 0;
        public static byte Players=1;
        static boolean c2;
        static int i1 = 0;
        public static int x = 0;
        public static int y = 0;
        public static int x1 = 0;
        public static int y1 = 0;
        Color color;
        public static boolean firstTime = true;
        public int positionX = 0;
        public int positionX1 = 0;
        public int positionY = (int) 32;
        public int positionY1 = (int) 32;
        public int[] posArrayx = new int[rows +2] ;
        public int[] posArrayY =  new int[columns+ 2];
        //  { 0,30, 60, 90, 120, 150, 180, 210, 240, 270};
        public int positionY_green = ((columns * 30) - 60);
        public int positionY_green1 = ((columns * 30) - 90);
        boolean b = true;
        JPanel panel = new JPanel(new FlowLayout());
        Point positionPoint = new Point();

        drawLine() throws AWTException {
            int yty=0;

            //y=0,30,60,90,120,150
            for(int i = 0; i <(rows +2) ; i++){

                posArrayx[i] = (yty);
                posArrayY[i] = yty;
                yty+= 30;

            }
            System.out.println(Arrays.toString(posArrayx));
            final int[] i = {0};
            Robot robot = new Robot();

            addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    PointerInfo info = MouseInfo.getPointerInfo();
                    color = robot.getPixelColor(info.getLocation().x, info.getLocation().y);

                    System.out.println(color);
                    firstTime = false;
                    positionPoint = e.getLocationOnScreen();
                    int c = 2;
                    boolean x2;
                    x2 = (positionPoint.getX() - 2) > 30;

                    xSetter(e.getX(), e.getY(), posArrayx);
                    ySetter(e.getX(), e.getY(), posArrayY);
                   update(getGraphics());
                 }
            });
        }

        public void paintComponent(Graphics g) {



            g.setColor(Color.white);
            //zhmaray row w columns dyare daka bapey awa zyade daka

            for (int i = 0; i < rows; i++) {
                g.drawLine(0, y += 30, 30 * rows, y);
            }
            for (int i1 = 0; i1 < columns; i1++) {
                g.drawLine(x += 30, 0, x, 30 * columns);
            }
            if (b) {

                for (int i = 0; i < (columns); i++) {
                    g.setColor(Color.white);
                    g.fillOval(positionX, 30, 30, 30);            //g.fillOval(,(int) 32.5,25,25);
                    g.fillOval(positionX, 60, 30, 30);
                    g.setColor(Color.black);
                    g.fillOval(positionX, positionY_green1, 30, 30);
                    g.fillOval(positionX, (positionY_green), 30, 30);
                    positionX += 30;
                    //positionY_green -= 30;
                      }
                b = false;
            }
            Color white = Color.white;
            Color black = Color.black;
                    if (Players==1) {
                        if (!firstTime && color.getGreen() == white.getGreen()) {
                            g.setColor(new Color(117, 103, 68));
                            g.fillOval(posArrayx[x1], posArrayY[y1], 30, 30);

                             g.setColor(Color.white);
                            g.fillOval(posArrayx[x1], posArrayY[y1 + 1], 30, 30);

                            Players=2;

}
                    }
            if (Players == 2) {


              if (!firstTime && color.getGreen() == black.getGreen()) {

                g.setColor(new Color(117, 103, 68));
                g.fillOval(posArrayx[x1], posArrayY[y1], 30, 30);
                 g.setColor(Color.black);
                g.fillOval(posArrayx[x1], posArrayY[y1 - 1], 30, 30);
                  Players = 1;

            }
            }




        }
        public void xSetter(int x, int y, int[] posArrayx) {
            for (int i = 0; i < posArrayx.length - 1; i++) {
                if ((x >= posArrayx[i] && x <= posArrayx[i + 1])) {
                    this.x1 = i;
                    break;
                }
            }

        }
        public void ySetter(int x, int y, int[] posArrayY) {
            for (int i = 0; i < posArrayY.length - 1; i++) {
                if ((y >= posArrayY[i] && y <= posArrayY[i + 1])) {
                    this.y1 = i;
                    break;
                }
            }

        }

    }


}
