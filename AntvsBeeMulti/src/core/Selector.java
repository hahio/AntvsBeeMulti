package core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import core.AntGame.AnimPosition;
import core.AntGame.ImageUtils;

public abstract class Selector {
	
	private static final String BEE_PKG = "bees";
	private final ArrayList<String> BEE_TYPES;
	private final Map<String, Image> BEE_IMAGES;
	private static final String BEE_FILE = "beelist.properties";
	
	// Draws the ant selector area
	public Selector(Graphics2D g2d, Map<Rectangle, Ant> antSelectorAreas, AntColony colony, Ant selectedAnt, Map<String, Image> ANT_IMAGES,Dimension PANEL_PADDING, Dimension ANT_IMAGE_SIZE, Rectangle removerArea, Image REMOVER_IMAGE ){
		// go through each selector area
		for (Map.Entry<Rectangle, Ant> entry : antSelectorAreas.entrySet()) {
			Rectangle rect = entry.getKey(); // selected area
			Ant ant = entry.getValue(); // ant to select

			// box status
			g2d.setColor(Color.WHITE);
			if (ant.getFoodCost() > colony.getFood()) {
				g2d.setColor(Color.GRAY);
			}
			else if (ant == selectedAnt) {
				g2d.setColor(Color.BLUE);
			}
			g2d.fill(rect);

			// box outline
			g2d.setColor(Color.BLACK);
			g2d.draw(rect);

			// ant image
			Image img = ANT_IMAGES.get(ant.getClass().getName());
			g2d.drawImage(img, rect.x + PANEL_PADDING.width, rect.y + PANEL_PADDING.height, null);

			// food cost
			g2d.drawString("" + ant.getFoodCost(), rect.x + (rect.width / 2), rect.y + ANT_IMAGE_SIZE.height + 4 + PANEL_PADDING.height);
		}

		// for removing an ant
		if (selectedAnt == null) {
			g2d.setColor(Color.BLUE);
			g2d.fill(removerArea);
		}
		g2d.setColor(Color.BLACK);
		g2d.draw(removerArea);
		g2d.drawImage(REMOVER_IMAGE, removerArea.x + PANEL_PADDING.width, removerArea.y + PANEL_PADDING.height, null);
	}
	

	
	private void initializeInsect (String IN_FILE, String IN_PKG, ArrayList<String> IN_TYPES, Map<String, Image> IN_IMAGES, Map<String, Color> LEAF_COLORS) {
		// load in properties from external file
				try {
					Scanner sc = new Scanner(new File(IN_FILE));
					while (sc.hasNextLine()) {
						String line = sc.nextLine();
						if (line.matches("\\w.*")) { // not a comment
							String[] parts = line.split(","); // get the entry parts
							String inType = IN_PKG + "." + parts[0].trim(); // prepend package name
							try {
								Class.forName(inType); // make sure the class is implemented and we can load it
								IN_TYPES.add(inType);
								IN_IMAGES.put(inType, ImageUtils.loadImage(parts[1].trim()));
								if (parts.length > 2) {
									LEAF_COLORS.put(inType, new Color(Integer.parseInt(parts[2].trim())));
								}
							}
							catch (ClassNotFoundException e) {
							} // if class isn't found, will continue (reading next line)
						}
					}
					sc.close();
				}
				catch (IOException e) { // for IOException, NumberFormatException, ArrayIndex exception... basically if anything goes wrong, don't crash
					System.out.println("Error loading insect gui properties: " + e);
				}
	}
	
	private void initializeAnts () {
		// load ant properties from external file
		try {
			Scanner sc = new Scanner(new File(ANT_FILE));
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.matches("\\w.*")) { // not a comment
					String[] parts = line.split(","); // get the entry parts
					String antType = ANT_PKG + "." + parts[0].trim(); // prepend package name
					try {
						Class.forName(antType); // make sure the class is implemented and we can load it
						ANT_TYPES.add(antType);
						ANT_IMAGES.put(antType, ImageUtils.loadImage(parts[1].trim()));
						if (parts.length > 2) {
							LEAF_COLORS.put(antType, new Color(Integer.parseInt(parts[2].trim())));
						}
					}
					catch (ClassNotFoundException e) {
					} // if class isn't found, will continue (reading next line)
				}
			}
			sc.close();
		}
		catch (IOException e) { // for IOException, NumberFormatException, ArrayIndex exception... basically if anything goes wrong, don't crash
			System.out.println("Error loading insect gui properties: " + e);
		}

	}
	
	private void initializeInsectSelector (Point panel, Dimension ANT_IMAGE_SIZE,Rectangle removerArea, ArrayList<String> IN_TYPES) {
		Point pos = panel;
		//Point pos = new Point(PANEL_POS); // starting point of the panel
		int width = ANT_IMAGE_SIZE.width + 2 * PANEL_PADDING.width;
		int height = ANT_IMAGE_SIZE.height + 2 * PANEL_PADDING.height;

		removerArea = new Rectangle(pos.x, pos.y, width, height);
		pos.translate(width + 2, 0);

		for (String antType : IN_TYPES) // go through the ants in the types; in order
		{
			Rectangle clickable = new Rectangle(pos.x, pos.y, width, height); // where to put the selector
			Ant ant = buildAnt(antType); // the ant that gets deployed from that selector
			antSelectorAreas.put(clickable, ant); // register the deployable ant so we can select it

			pos.translate(width + 2, 0); // shift rectangle position for next run
		}
	}
	
	private void initializeAntSelector (Point panel) {
		Point pos = panel;
		//Point pos = new Point(PANEL_POS); // starting point of the panel
		int width = ANT_IMAGE_SIZE.width + 2 * PANEL_PADDING.width;
		int height = ANT_IMAGE_SIZE.height + 2 * PANEL_PADDING.height;

		removerArea = new Rectangle(pos.x, pos.y, width, height);
		pos.translate(width + 2, 0);

		for (String antType : ANT_TYPES) // go through the ants in the types; in order
		{
			Rectangle clickable = new Rectangle(pos.x, pos.y, width, height); // where to put the selector
			Ant ant = buildAnt(antType); // the ant that gets deployed from that selector
			antSelectorAreas.put(clickable, ant); // register the deployable ant so we can select it

			pos.translate(width + 2, 0); // shift rectangle position for next run
		}
	}
			

}
