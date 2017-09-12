import javax.swing.*;

/**
 * Created by praewpatjiradecha on 9/12/2017 AD.
 */
public class ProjectGame2048 {

    public static void main(String arg[]){
        JFrame game = new JFrame();
        game.setTitle("2048");
        //game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setSize(340, 400);
        //game.setResizable(false);

        game.add(new Game2048());

        //game.setLocationRelativeTo(null);
        game.setVisible(true);
    }
}
