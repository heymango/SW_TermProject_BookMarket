import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    Font font = new Font("배달의민족 을지로체 TTF",0,13);
    public Button() { super(); decorate();}
    public Button(String text) { super(text); decorate();}
    public Button(Action action) { super(action); decorate(); }
    public Button(Icon icon) { super(icon); decorate(); }
    public Button(String text, Icon icon) { super(text, icon); decorate(); }
    protected void decorate() { setBorderPainted(false); setBackground(new Color(51,51,51)); setFont(font); setForeground(Color.WHITE); }

}
