package CirclesThing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.PageAttributes.ColorType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.StrokeBorder;
import javax.swing.border.TitledBorder;

public class ControlsPanel extends JPanel {
	CirclePanel DrawCir = new CirclePanel();
	JPanel AddCircle = new JPanel();
	JLabel rad = new JLabel("Radius:");
	JSlider Radius = new JSlider(50, 100, 55);
	JLabel x = new JLabel("Center x: ");
	JTextField Xval = new JTextField(4);
	JLabel y = new JLabel("y: ");
	JTextField Yval = new JTextField(4);
	JComboBox<Color> ColorBox = new JComboBox<>();
	JButton add = new JButton("Add Circle");
	JLabel Fill = new JLabel("Fill Color ");
	JRadioButton fill = new JRadioButton("Fill");
	JRadioButton nfill = new JRadioButton("Outline");
	JCheckBox animate = new JCheckBox("Animated Circle ");
	JCheckBox merge = new JCheckBox("Merge on collide");
	ButtonGroup FillorNot = new ButtonGroup();
	private double xPos, yPos, Rad;
	private Color colorcir;

	public ControlsPanel() {
		fill.setSelected(true);
		FillorNot.add(fill);
		FillorNot.add(nfill);
		Radius.setMajorTickSpacing(10);
		Radius.setMinorTickSpacing(5);
		Radius.setPaintTicks(true);
		Radius.setPaintLabels(true);
		ColorBox.addItem(Color.BLACK);
		ColorBox.addItem(Color.MAGENTA);
		AddCircle.setPreferredSize(new Dimension(250, 200));
		AddCircle.setLayout(new FlowLayout());
		AddCircle.setBorder(new TitledBorder(new LineBorder(Color.gray, 3), "Add a Cirlce"));
		AddCircle.add(rad);
		AddCircle.add(Radius);
		AddCircle.add(x);
		AddCircle.add(Xval);
		AddCircle.add(y);
		AddCircle.add(Yval);
		AddCircle.add(ColorBox);
		AddCircle.add(add);
		this.setPreferredSize(new Dimension(260, 300));
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(AddCircle);
		this.add(Fill);
		this.add(fill);
		this.add(nfill);
		this.add(animate);
		this.add(merge);
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Rad = Radius.getValue();
					xPos = Double.parseDouble(Xval.getText());
					yPos = Double.parseDouble(Yval.getText());
					colorcir = (Color) ColorBox.getSelectedItem();
					DrawCir.add(new ColorCircle(xPos, yPos, Rad, colorcir));
					System.out.println(new ColorCircle(xPos, yPos, Rad, colorcir));
				} catch (NumberFormatException ee) {
					JOptionPane.showMessageDialog(null, "Invalid Number");
				}
				repaint();
			}
		});
		if (fill.isSelected()) {
			DrawCir.setFill(true);
			repaint();
		}
		else if (nfill.isSelected()) {
			DrawCir.setNfill(true);
			repaint();
		}
		if (animate.isSelected())
			DrawCir.setAnimate(true);
		else if (!animate.isSelected())
			DrawCir.setAnimate(false);
		if (merge.isSelected())
			DrawCir.setMerge(true);
		else if (!merge.isSelected())
			DrawCir.setMerge(false);
	}

	public double getxPos() {
		return xPos;
	}

	public double getyPos() {
		return yPos;
	}

	public double getRad() {
		return Rad;
	}

	public Color getColorcir() {
		return colorcir;
	}

	public JRadioButton getFill() {
		return fill;
	}

	public JRadioButton getNfill() {
		return nfill;
	}

	public JCheckBox getAnimate() {
		return animate;
	}

	public JCheckBox getMerge() {
		return merge;
	}
	public JPanel getCon() {
		return DrawCir;
	}

}
