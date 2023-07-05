import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
	
	private DrawPanel drawPanel;
	
	public Main() {
		super("Paint Application");
		// west panel
		setLayout(new BorderLayout());
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(6,1));
		westPanel.setBackground(Color.CYAN);
		JComboBox colorMenu;
		String[] colors = {"Black", "Red", "Blue", "Green", "Yellow", "Orange", "Pink"};
		colorMenu = new JComboBox(colors);
		colorMenu.addActionListener(this);
		westPanel.add(colorMenu);
		JRadioButton rectangleRadio = new JRadioButton("Rectangle");
		JRadioButton circleRadio = new JRadioButton("Circle");
		JRadioButton arcRadio = new JRadioButton("Arc");
		ButtonGroup buttonGroup = new ButtonGroup();
		rectangleRadio.addActionListener(this);
		circleRadio.addActionListener(this);
		arcRadio.addActionListener(this);
		rectangleRadio.setSelected(true);
		buttonGroup.add(rectangleRadio);
		buttonGroup.add(circleRadio);
		buttonGroup.add(arcRadio);
		westPanel.add(rectangleRadio);
		westPanel.add(circleRadio);
		westPanel.add(arcRadio);
		add(westPanel,BorderLayout.WEST);
		// draw panel
		drawPanel = new DrawPanel();
		drawPanel.setBackground(Color.LIGHT_GRAY);
		drawPanel.setShape (rectangleRadio.getText());
		drawPanel.setColor((String) colorMenu.getSelectedItem());
		add(drawPanel,BorderLayout.CENTER);
		// south panel
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout());
		JButton undo = new JButton("Undo");
		JButton erase = new JButton("Erase");
		undo.addActionListener(this);
		erase.addActionListener(this);
		southPanel.add(undo);
		southPanel.add(erase);
		add(southPanel,BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		Main app = new Main();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(600,400);
		app.setVisible(true);
		app.setResizable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().getClass().getName().equals("javax.swing.JButton")) {
			if( ((JButton) e.getSource()).getText().equals("Erase")) {
				drawPanel.erase();
			} else {
				drawPanel.undo();
			}
		} else if(e.getSource().getClass().getName().equals("javax.swing.JRadioButton")) {
			drawPanel.setShape (((JRadioButton)e.getSource()).getText());
		} else if(e.getSource().getClass().getName().equals("javax.swing.JComboBox")) {
			drawPanel.setColor((String)((JComboBox)e.getSource()).getSelectedItem());
		}
	}

}
