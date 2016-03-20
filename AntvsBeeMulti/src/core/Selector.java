package core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Map;

public class Selector{
	
	/**
	 * Initializes the graphical Ant Selector area.
	 * Assumes that the Ants have already been initialized (and have established image resources)
	 */
	
	public Selector(){
	}
	
	
	
	public static void antSelector(Point panel,ArrayList<String> IN_TYPES){
		Point pos = panel;
		//Point pos = new Point(PANEL_POS); // starting point of the panel
		int width = AntGame.ANT_IMAGE_SIZE.width + 2 * AntGame.PANEL_PADDING.width;
		int height = AntGame.ANT_IMAGE_SIZE.height + 2 * AntGame.PANEL_PADDING.height;

		AntGame.removerArea = new Rectangle(pos.x, pos.y, width, height);
		pos.translate(width + 2, 0);

		for (String antType : IN_TYPES) // go through the ants in the types; in order
		{
			Rectangle clickable = new Rectangle(pos.x, pos.y, width, height); // where to put the selector
			Ant ant = AntGame.buildAnt(antType); // the ant that gets deployed from that selector
			AntGame.antSelectorAreas.put(clickable, ant); // register the deployable ant so we can select it

			pos.translate(width + 2, 0); // shift rectangle position for next run
		}
	}
	
	public static void beeSelector(Point panel,ArrayList<String> IN_TYPES){
		Point pos = panel;
		//Point pos = new Point(PANEL_POS); // starting point of the panel
		int width = AntGame.ANT_IMAGE_SIZE.width + 2 * AntGame.PANEL_PADDING.width;
		int height = AntGame.ANT_IMAGE_SIZE.height + 2 * AntGame.PANEL_PADDING.height;

		AntGame.removerArea = new Rectangle(pos.x, pos.y, width, height);
		pos.translate(width + 2, 0);

		for (String beeType : IN_TYPES) // go through the ants in the types; in order
		{
			Rectangle clickable = new Rectangle(pos.x, pos.y, width, height); // where to put the selector
			Bee bee = AntGame.buildBee(beeType); // the ant that gets deployed from that selector
			AntGame.beeSelectorAreas.put(clickable,bee); // register the deployable ant so we can select it
			pos.translate(width + 2, 0); // shift rectangle position for next run
		}
	}
	
	public static void drawAntSelector (Graphics2D g2d,AntColony colony) {
		// go through each selector area
		for (Map.Entry<Rectangle, Ant> entry : AntGame.antSelectorAreas.entrySet()) {
			Rectangle rect = entry.getKey(); // selected area
			Ant ant = entry.getValue(); // ant to select

			// box status
			g2d.setColor(Color.WHITE);
			if (ant.getFoodCost() > colony.getFood()) {
				g2d.setColor(Color.GRAY);
			}
			else if (ant == AntGame.selectedAnt) {
				g2d.setColor(Color.BLUE);
			}
			g2d.fill(rect);

			// box outline
			g2d.setColor(Color.BLACK);
			g2d.draw(rect);

			// ant image
			Image img = AntGame.ANT_IMAGES.get(ant.getClass().getName());
			g2d.drawImage(img, rect.x + AntGame.PANEL_PADDING.width, rect.y + AntGame.PANEL_PADDING.height, null);

			// food cost
			g2d.drawString("" + ant.getFoodCost(), rect.x + (rect.width / 2), rect.y + AntGame.ANT_IMAGE_SIZE.height + 4 + AntGame.PANEL_PADDING.height);
		}

		// for removing an ant
		if (AntGame.selectedAnt == null) {
			g2d.setColor(Color.BLUE);
			g2d.fill(AntGame.removerArea);
		}
		g2d.setColor(Color.BLACK);
		g2d.draw(AntGame.removerArea);
		g2d.drawImage(AntGame.REMOVER_IMAGE, AntGame.removerArea.x + AntGame.PANEL_PADDING.width, AntGame.removerArea.y + AntGame.PANEL_PADDING.height, null);
	}
	
	public static void drawBeeSelector (Graphics2D g2d,AntColony colony) {
		// go through each selector area
		for (Map.Entry<Rectangle, Bee> entry : AntGame.beeSelectorAreas.entrySet()) {
			Rectangle rect = entry.getKey(); // selected area
			Bee bee = entry.getValue(); // ant to select

			// box status
			g2d.setColor(Color.WHITE);
			if (bee.getFoodCost() > colony.getFood()) {
				g2d.setColor(Color.GRAY);
			}
			else if (bee == AntGame.selectedBee) {
				g2d.setColor(Color.BLUE);
			}
			g2d.fill(rect);

			// box outline
			g2d.setColor(Color.BLACK);
			g2d.draw(rect);

			// bee image
			Image img = AntGame.BEE_IMAGES.get(bee.getClass().getName());
			g2d.drawImage(img, rect.x + AntGame.PANEL_PADDING.width, rect.y + AntGame.PANEL_PADDING.height, null);

			// food cost
			g2d.drawString("" + bee.getFoodCost(), rect.x + (rect.width / 2), rect.y + AntGame.ANT_IMAGE_SIZE.height + 4 + AntGame.PANEL_PADDING.height);
		}
		g2d.setColor(Color.BLACK);
		g2d.draw(AntGame.removerArea);
		g2d.drawImage(AntGame.REMOVER_IMAGE, AntGame.removerArea.x + AntGame.PANEL_PADDING.width, AntGame.removerArea.y + AntGame.PANEL_PADDING.height, null);
	}
}