/*
 * JenSoft API - Charting Framework
 * http://www.jensoftapi.com
 * Copyright (c) JenSoft. All rights reserved.
 * See JenSoft Software License Agreement
 */
package org.jensoft.catalog.views.capacity;

import java.awt.Color;

import org.jensoft.core.catalog.nature.JenSoftView;
import org.jensoft.core.catalog.ui.ViewFrameUI;
import org.jensoft.core.palette.color.PetalPalette;
import org.jensoft.core.plugin.capacity.CapacityPlugin;
import org.jensoft.core.plugin.capacity.CapacityUnit;
import org.jensoft.core.plugin.outline.OutlinePlugin;
import org.jensoft.core.projection.Projection;
import org.jensoft.core.view.View;
import org.jensoft.core.view.background.ViewDarkBackground;

/**
 * <code>Capacity1</code>
 * 
 * @author Sébastien Janaud
 */
@JenSoftView(background = ViewDarkBackground.class, description = "Show how to use capacity cell plugin")
public class CapacityDemo extends View {

	private static final long serialVersionUID = 8159753314041939307L;

	
	
	public CapacityDemo() {
		super(60);

		setDeviceBackground(Color.WHITE);

		Projection proj = new Projection.Linear.Identity();
		registerProjection(proj);

		proj.registerPlugin(new OutlinePlugin(Color.WHITE));

		// 864 capacity cell
		capacity = new CapacityPlugin(48, 18);
		proj.registerPlugin(capacity);

		CapacityUnit unit1 = new CapacityUnit(93);
		unit1.setColor(PetalPalette.PETAL1_HC);
		capacity.registerCapacity(unit1);

		CapacityUnit unit2 = new CapacityUnit(100);
		capacity.registerCapacity(unit2);
		unit2.setColor(PetalPalette.PETAL2_HC);

		CapacityUnit unit3 = new CapacityUnit(128);
		capacity.registerCapacity(unit3);
		unit3.setColor(PetalPalette.PETAL3_HC);

		CapacityUnit unit4 = new CapacityUnit(90);
		capacity.registerCapacity(unit4);
		unit4.setColor(PetalPalette.PETAL4_HC);

		CapacityUnit unit5 = new CapacityUnit(100);
		capacity.registerCapacity(unit5);
		unit5.setColor(PetalPalette.PETAL5_HC);

		CapacityUnit unit6 = new CapacityUnit(90);
		capacity.registerCapacity(unit6);
		unit6.setColor(PetalPalette.PETAL6_HC);

		CapacityUnit unit7 = new CapacityUnit(130);
		capacity.registerCapacity(unit7);
		unit7.setColor(PetalPalette.PETAL7_HC);

		CapacityUnit unit8 = new CapacityUnit(133);
		capacity.registerCapacity(unit8);
		unit8.setColor(PetalPalette.PETAL8_HC);

		Thread tdemo = new Thread(capaDemo, "TH-CapacityDemo");
		tdemo.start();

	}

	public static void main(String[] args) {
		ViewFrameUI ui = new ViewFrameUI(new CapacityDemo());
	}

	CapacityPlugin capacity;
	Runnable capaDemo = new Runnable() {

		@Override
		public void run() {

			// anim cell

			repaintDevice();
		}
	};

}
