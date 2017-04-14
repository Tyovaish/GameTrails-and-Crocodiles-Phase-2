import View.Display;

/**
 * Created by Lazaro on 4/11/2017.
 */
public class runView {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Display();
                new ImportManager();
            }

        });
    }
}
