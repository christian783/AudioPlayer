import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("sunflower-street-drumloop-85bpm-163900.wav");
        Scanner scanner = new Scanner(System.in);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);

        Clip clip = AudioSystem.getClip();

        clip.open(audioInputStream);

        String response = "";

        while (!response.equals("Q")) {

            System.out.println("Enter p-Play s-Stop r-Reset");

            response = scanner.next();
            response = response.toUpperCase();



            switch(response) {
                case "P": clip.start();
                    break;

                case "S": clip.stop();
                    break;

                case "R": clip.setMicrosecondPosition(0);
                    break;

                case "Q": clip.close();
                    break;

                default : System.out.println("Not a valid input");
                    break;
            }



        }

        System.out.println("Byeee!");
        scanner.close();

    }
}
