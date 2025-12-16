    /*

        SIDNEI CORREIA JUNIOR [2510102122]
        ADRIANO MOISES [2510101615]

        INTERFACE MADE BY:
        SIDNEI CORREIA JUNIOR [2510102122]
    */ 

    import javax.swing.*;
    import java.awt.*;
    import java.io.File;
    import javax.imageio.ImageIO;
    import java.io.IOException;
    import java.awt.image.BufferedImage;

    class Circle extends JComponent {

        private Color circleColor = Color.BLACK;
        private String letter;
        private BufferedImage backgroundImage1;
        private BufferedImage backgroundImage2;



        protected Circle(int x, int y){
            setBounds(x, y, 81, 81); // Set bounds to contain the 80x80 circle + stroke
            letter = " ";
            try {
                backgroundImage1 = ImageIO.read(new File("images/0.png"));
                backgroundImage2 = ImageIO.read(new File("images/1.png"));

            } catch (IOException e) {
                System.err.print("Error trying to get the image file.");
            }
        }

        @Override
        public void paint(Graphics g)
        {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;

            // Fill the circle with gray color
            if (circleColor != Color.BLACK){
                g2.setColor(circleColor);
                g2.fillOval(0, 0, 80, 80);
            }

            // AI to undestand how to create geometric elements using Graphics2D
            g2.setColor(circleColor);
            g2.setStroke(new BasicStroke(3.0f));
            g2.drawOval(0, 0, 80, 80);
            // END AI

            if (backgroundImage1 != null && backgroundImage2 != null){
                if (letter.equals("A")){
                    g2.drawImage(backgroundImage1, 3, 3, (getWidth() - 10), (getHeight() - 10), null);
                } else if(letter.equals("C")){
                    g2.drawImage(backgroundImage2, 3, 3, (getWidth() - 10), (getHeight() - 10), null);
                }
            }
        }

        protected void changeColor(Color newColor) {
            this.circleColor = newColor;
            repaint();
        }

        protected String getLetter(){
        return this.letter;
        }

        protected Color getColor(){
            return this.circleColor;
        }

        protected void setLetter(String letter){
            this.letter = letter;
        }
    }