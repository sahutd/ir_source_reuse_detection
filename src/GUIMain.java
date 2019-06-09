import javax.swing.*;


public class GUIMain
{
    public static void main(String args[])
    {
        JFrame frame = new JFrame("IR Based Source code plagiarism detection");
        Demo gui = new Demo();
        gui.refreshView();
        frame.setContentPane(gui.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
