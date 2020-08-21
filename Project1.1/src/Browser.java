/**
 * 
 * @author Alicia Abrams
 *
 */
public class Browser {
	public static void main(String args[]) {
		int row = 1920;
		int col = 1080;
		String dir = "";
		for (int i = 0; i < args.length; i++) {
			switch (args[i]) {
			case "-h":
			case "--h":
			case "--help":
			case "--usage":
			case "--?":

				break;
				
			case "-r":
			case "--r":
			case "--rows":
				row = Integer.parseInt(args[++i]);
				break;

			case "-c":
			case "--c":
			case "--cols":
				col = Integer.parseInt(args[++i]);
				break;

			default:
				dir = args[i];
				break;
			}
		}
		if (dir.equals("")) {
			ImageGUI guis = new ImageGUI();
		} else {
			ImageGUI gui = new ImageGUI(dir, row, col);
		}
	}
}
