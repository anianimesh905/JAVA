package src.Project;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame(); // creates a frame
        frame.setTitle("JFrame title goes here"); // sets title of the frame
        // JFrame apne aap close nhi hota hai, red X pr click krne frame bs minimize hota soo...
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of the application
        // vaise HIDE_ON_CLOSE rehta, at DO_NOTHING_ON_CLOSE you can't close the box at all
        frame.setResizable(false);
        frame.setSize(420,420); // sets the x-dimension and y-dimension
        frame.setVisible(true); // make frame visible

    }
}
