import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI for Image Browsing 
 * 
 * @author Alicia Abrams
 *
 */

public class ImageGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton submitDirectory;
	private JPanel topPanel;
	private JLabel topLabel;
	private JTextField directoryTextField;
	private JLabel label;
	private JTextField sizeTextFieldX;
	private JTextField sizeTextFieldY;
	private JButton previous;
	private JButton next;
	private JPanel bottomPanel;
	private JPanel imagePanel;
	private JLabel imageLabel;
	JFrame frame;
	String directoryName;
	String sizeX;
	String sizeY;
	AcquireImage image;
	int yAxis;
	int xAxis;

	public ImageGUI() {
		this.setLayout(new BorderLayout());
		topPanel = new JPanel();
		topLabel = new JLabel(" Directory ");
		directoryTextField = new JTextField(20);
		imagePanel = new JPanel();
		imageLabel = new JLabel();
		label = new JLabel(" Image Size ");
		sizeTextFieldX = new JTextField(4);
		sizeTextFieldY = new JTextField(4);
		submitDirectory = new JButton("Submit");
		bottomPanel = new JPanel();
		previous = new JButton("Previous");
		next = new JButton("  Next  ");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 800);
		topPanel.add(topLabel);
		topPanel.add(directoryTextField);
		topPanel.add(label);
		topPanel.add(sizeTextFieldX);
		topPanel.add(sizeTextFieldY);
		topPanel.add(submitDirectory);

		imagePanel.add(imageLabel);
		bottomPanel.add(previous);
		bottomPanel.add(next);

		submitDirectory.addActionListener(this);
		previous.addActionListener(this);
		next.addActionListener(this);
		this.getContentPane().add(BorderLayout.NORTH, topPanel);
		this.getContentPane().add(BorderLayout.CENTER, imagePanel);
		this.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
		this.setVisible(true);

	}

	public ImageGUI(String dir, int row, int col) {
		this();
		directoryName = dir;
		xAxis = row;
		yAxis = col;
		image = new AcquireImage(directoryName, yAxis, xAxis);
		setImage();
	}

	/**
	 * Displays current image in GUI
	 */
	public void setImage() {
		imageLabel.setIcon(new ImageIcon(image.getImage()));
	}

	/**
	 * Sets the directoryName, sizeX, and sizeY in AcquireImage when the
	 * submitDirectory button is pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(submitDirectory)) {
			if (getInput()) {
				image = new AcquireImage(directoryName, yAxis, xAxis);
				if (image.getImages().size() > 0) {
					setImage();
				}
			} else {
				JOptionPane.showMessageDialog(this, "Invalid Input");
			}
		} else if (e.getSource().equals(previous)) {
			image.previousImage();
			setImage();
		} else if (e.getSource().equals(next)) {
			image.nextImage();
			setImage();
		}
	}

	/**
	 *
	 * @return true if values inputed to sizeX and sizeY can be converted to
	 *         integers
	 */
	public boolean getInput() {
		directoryName = directoryTextField.getText();
		sizeX = sizeTextFieldX.getText();
		sizeY = sizeTextFieldY.getText();
		if (sizeX == null || sizeY == null) {
			return false;
		}
		try {
			xAxis = Integer.parseInt(sizeX);
			yAxis = Integer.parseInt(sizeY);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

}
