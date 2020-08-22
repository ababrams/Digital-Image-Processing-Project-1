
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

//import org.opencv.core.Core;
//import org.opencv.core.Mat;
//import org.opencv.imgcodecs.Imgcodecs;

/**
 * Creates an array of file names.
 * 
 * @author ALicia Abrams
 *
 */
public class AcquireImage {
//	private List<Mat> matImages;
	private List<File> files;
	private List<BufferedImage> images;
	private int currentIndex = 0;

	public AcquireImage(String directoryName, int yAxis, int xAxis) {
		images = new ArrayList<>();
//		matImages = new ArrayList<>();
		files = new ArrayList<>();
		try {
			File traverseDir = new File(directoryName);
			if (traverseDir.isDirectory()) {
				traverse(traverseDir);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates an array of file names
	 * 
	 * @param directory
	 * @throws IOExceptionS
	 */
	public void traverse(File directory) throws IOException {
		if (directory.isDirectory()) {
			for (String filename : directory.list()) {
				File file = new File(directory, filename);
				if (!file.isDirectory()) {
					try {
						BufferedImage image = ImageIO.read(file);
						if (image != null) {
							images.add(ImageIO.read(file));
							files.add(file);
						}
					} catch (Exception e) {

					}
				}
				traverse(new File(directory, filename));
			}
		}
	}

	/**
	 * loads images from the files and stores them in a list of mat
	 * 
	 * @param imageNames
	 */
//	public void readFiles() {
//		for (File file : files) {
//			Mat img = Imgcodecs.imread(file.getAbsolutePath());
//			matImages.add(img);
//		}
//	}

	/**
	 * goes to the previous image
	 */
	public void previousImage() {
		if (currentIndex == 0) {
			currentIndex = images.size() - 1;
		} else {
			currentIndex--;
		}
	}

	/**
	 * goes to the next image
	 */
	public void nextImage() {
		if (currentIndex == images.size() - 1) {
			currentIndex = 0;
		} else {
			currentIndex++;
		}
	}

	public BufferedImage getImage() {
		if (!images.isEmpty()) {
			return images.get(currentIndex);
		} else {
			return null;
		}
	}

	public List<BufferedImage> getImages() {
		return images;
	}
}
