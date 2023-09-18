import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        try {
            BufferedImage resim1 = ImageIO.read(new File("resim1.png"));
            BufferedImage resim2 = ImageIO.read(new File("resim2.png"));
            int width = resim1.getWidth();
            int height = resim1.getHeight();
            BufferedImage differenceImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            int differentPiksels = 0;

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int piksel1 = resim1.getRGB(x, y);
                    int piksel2 = resim2.getRGB(x, y);

                    if (piksel1 != piksel2) {
                        differenceImage.setRGB(x, y, piksel2);
                        differentPiksels++; // Farklı bir piksel bulunduğunda sayaç artırılır
                    }
                }
            }
            
            double similarityPercentage = ((double) (width * height - differentPiksels) / (width * height)) * 100;
            System.out.println("Benzerlik yüzdesi: % " + similarityPercentage);
            double yüz = 100;
            double fark = yüz - similarityPercentage;
            System.out.println("Fark oranı: " + fark + "%");
            System.out.println("Fark bulma işlemi çalıştı");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
