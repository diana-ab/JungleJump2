import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Menu extends BackgroundPanel {
    public static final int BUTTON_WIDTH = 0;
    public static final int BUTTON_HEIGHT = 30;
    private JButton start;
    private JButton instructions;

    public Menu(int x, int y, int width, int height){
        super( x,  y,  width,  height);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); //בלי זה לא נראה את הרקע
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.start = new JButton("START GAME"); //יצרתי כפתורים
        instructions = new JButton("INSTRUCTIONS");

        start.setAlignmentX(Component.CENTER_ALIGNMENT); //למרכז אותם עם ה BOXLAYOUT
        instructions.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createVerticalGlue()); // רווח גמיש מלמעלה
        this.add(start);
        this.add(Box.createRigidArea(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT))); // רווח קבוע בין הכפתורים
        this.add(instructions);
        this.add(Box.createVerticalGlue()); // רווח גמיש מלמטה

        this.add(buttonPanel);

    }

    public void setStartButtonAction(ActionListener actionListener){
        this.start.addActionListener(actionListener);
    }


    public void setInstructionsButtonAction(ActionListener actionListener) {
        this.instructions.addActionListener(actionListener);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
    }
}
