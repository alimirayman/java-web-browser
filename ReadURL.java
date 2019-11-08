import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// import javafx.event.ActionEvent;

/**
 * ReadURL
 */
public class ReadURL extends JFrame{
  private JTextField addressBar;
  private JEditorPane display;

  public ReadURL() {
    super("Dexlab Browser");

    addressBar = new JTextField("https://...");
    addressBar.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent event) {
          loadURL(event.getActionCommand());
        }
      }
    );
    add(addressBar, BorderLayout.NORTH);

    display = new JEditorPane();
    display.setEditable(false);
    display.addHyperlinkListener(
      new HyperlinkListener(){
      
        @Override
        public void hyperlinkUpdate(HyperlinkEvent e) {
          if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            loadURL(e.getURL().toString());
          }
        }
      }
    );

    add(new JScrollPane(display), BorderLayout.CENTER);
    setSize(500, 300);
    setVisible(true);
  }

  private void loadURL(String userUrl) {
    try {
      display.setPage(userUrl);
      addressBar.setText(userUrl);
    } catch(Exception e) {
      System.out.println("crap!");
    }
  }
}