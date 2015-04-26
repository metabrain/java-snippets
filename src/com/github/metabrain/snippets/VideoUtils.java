package com.github.metabrain.snippets;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Comparator;
import java.util.TreeMap;

public class VideoUtils {

	public static GraphicsDevice getLargerScreen() {
		TreeMap<GraphicsConfiguration,GraphicsDevice> screens = new TreeMap<GraphicsConfiguration,GraphicsDevice>(
			new Comparator<GraphicsConfiguration>() {
				@Override
				public int compare(GraphicsConfiguration arg0, GraphicsConfiguration arg1) {
					return arg1.getBounds().width - arg0.getBounds().width; //Sort screens by size
				}
			}
		);
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		for (GraphicsDevice gs: ge.getScreenDevices()) {
			for (GraphicsConfiguration gc: gs.getConfigurations()) {
				screens.put(gc, gs);
			}
		}
		
		return screens.pollFirstEntry().getValue();
	}
	
	public static BufferedImage screenshot(Rectangle dims, Robot r) {
		BufferedImage screenshot = r.createScreenCapture(dims);
		return screenshot;
	}

}