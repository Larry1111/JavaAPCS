/**
 * Represents the control panel for the Ramblecs game
 */

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ControlPanel extends JPanel
      implements ScoreDisplay
{
  private LetterPanel whiteboard;
  private JSlider speedSlider;
  private JTextField clockField, scoreField, speedField;
  private JButton go;
  private final int minSpeed = 5, initSpeed = 50, maxSpeed = 195;
  long startTime;

  public ControlPanel(LetterPanel lpanel)
  {
    whiteboard = lpanel;
    clockField = new JTextField();
    scoreField = new JTextField();
    speedField = new JTextField();
    speedSlider = new JSlider(JSlider.HORIZONTAL, minSpeed,
    		maxSpeed, initSpeed);
    speedField.addActionListener(new SpeedFieldListener());
    speedSlider.addChangeListener(new SliderListener());
    clockField.addActionListener(new ClockListener());
    // setup GUI:
    JPanel layout = new JPanel(new GridLayout(4,2));
	go = new JButton("Go");
	go.addActionListener(new GoButtonListener());
	
	add(whiteboard, BorderLayout.CENTER) ;
    Box box = Box.createVerticalBox();
    box.setPreferredSize(new Dimension(125,300));
    box.setBorder(new EmptyBorder(5,5,5,5));
    
    speedSlider.setMajorTickSpacing((maxSpeed - minSpeed)/2);
    speedSlider.setPaintTicks(true);
    speedSlider.setPaintLabels(true);
    layout.add(new JLabel("Time: "));
    layout.add(clockField);
    layout.add(new JLabel("Score: "));
	layout.add(scoreField);
	
	layout.add(Box.createVerticalGlue());
	layout.add(Box.createVerticalGlue());
	layout.add(new JLabel("Speed: "));
	layout.add(speedField);
	clockField.setEditable(false);
	scoreField.setEditable(false);
	box.add(layout);
	box.add(speedSlider);
	box.add(go);
	add(box);
  }

  // Starts a new game.
  public void newGame()
  {
    go.setText("Go");
    clockField.setText("00:00");
    startTime = System.currentTimeMillis();
    Timer clock = new Timer(1000, new ClockListener());
    clock.start();

    int speed = speedSlider.getValue();
    speedField.setText(String.format("%3d", speed));
    whiteboard.setSpeed(speed);

    whiteboard.newGame();
    requestFocus();
  }

  // Called from RamblecsKeyListener.
  public void slowDown()
  {
	int x = Integer.parseInt(speedField.getText().trim());
	speedField.setText(Integer.toString(x-10));
    // Get slider's current speed and reduce it by 10 units:
    speedSlider.setValue(speedSlider.getValue()-10);
  }

  // Called from RamblecsKeyListener.
  public void speedUp()
  {
	  int x = Integer.parseInt(speedField.getText().trim());
	  speedField.setText(Integer.toString(x+10));
    // Get slider's current speed and increase it by 10 units:
	  speedSlider.setValue(speedSlider.getValue()+10);
  }

  // Called from LetterPanel.
  public void update(int score)
  {
    scoreField.setText(String.format("%03d", score));
  }

  // Handles clock events.
  private class ClockListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      int secs = (int) ((System.currentTimeMillis() - startTime) / 1000);
      int mins = secs / 60;
      secs %= 60;
      mins %= 60;
      clockField.setText(String.format("%02d:%02d", mins, secs));
    }
  }

  // Handles speed slider events.
  private class SliderListener implements ChangeListener
  {
    public void stateChanged(ChangeEvent e)
    {
      int speed = speedSlider.getValue();
      speedField.setText(String.format("%3d", speed));
      whiteboard.setSpeed(speed);
      requestFocus();
    }
  }

  // Handles speed field events.
  private class SpeedFieldListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      // When ENTER is pressed on speedField:
      // gets the text, tries to parse an int out of it, and
      // if successful, sets the slider to that value;
      // otherwise (if input error) sets the field text back
      // to the current speed slider setting.
      try
      {
    	  int m = Integer.parseInt(speedField.getText());
    	  speedSlider.setValue(m);
      }
      catch(NumberFormatException ex)
      {
    	  speedField.setText(Integer.toString(speedSlider.getValue()));
      }
      requestFocus();
    }
  }

  // Handles Go button events.
  private class GoButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      String cmd = e.getActionCommand();
      if ("Go".equals(cmd))
      {
        whiteboard.dropCube();
        go.setText("Stop");
      }
      else
      {
        whiteboard.stopCube();
        go.setText("Go");
      }
      requestFocus();
    }
  }
}
