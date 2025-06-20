import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RealImage implements Image {
    String fileName;
    BufferedImage image;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFile();
    }

    private void loadFile() {
        System.out.println("Loading file from remote server....");
        try {
            image = ImageIO.read(new File("images/"+fileName+".jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("File loaded!");
    }

    @Override
    public void display() {
        System.out.println("Displaying image...");
        JFrame frame = new JFrame("Image Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon(image);
        JLabel label = new JLabel(icon);
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
