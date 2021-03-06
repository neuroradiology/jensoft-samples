/*
 * JenSoft API - Charting Framework
 * http://www.jensoftapi.com
 * Copyright (c) JenSoft. All rights reserved.
 * See JenSoft Software License Agreement
 */
package org.jensoft.catalog.views.metrics.axis;

import java.awt.Font;

import org.jensoft.core.catalog.nature.JenSoftView;
import org.jensoft.core.catalog.ui.ViewFrameUI;
import org.jensoft.core.palette.color.NanoChromatique;
import org.jensoft.core.palette.color.RosePalette;
import org.jensoft.core.plugin.metrics.AxisMetricsPlugin;
import org.jensoft.core.plugin.metrics.Metrics.Gravity;
import org.jensoft.core.plugin.outline.OutlinePlugin;
import org.jensoft.core.plugin.translate.TranslateCompassWidget;
import org.jensoft.core.plugin.translate.TranslateDefaultDeviceContext;
import org.jensoft.core.plugin.translate.TranslatePlugin;
import org.jensoft.core.plugin.zoom.box.ZoomBoxDefaultDeviceContext;
import org.jensoft.core.plugin.zoom.box.ZoomBoxDonutWidget;
import org.jensoft.core.plugin.zoom.box.ZoomBoxPlugin;
import org.jensoft.core.plugin.zoom.wheel.ZoomWheelPlugin;
import org.jensoft.core.projection.Projection;
import org.jensoft.core.view.View;
import org.jensoft.core.view.ViewPart;
import org.jensoft.core.view.background.ViewDarkBackground;

/**
 * <code>ModeledMetricsDemo</code>
 * 
 * @author Sébastien Janaud
 */
@JenSoftView(background=ViewDarkBackground.class , description="Modeled metrics with Gravity : Natural or Rotate Metrics.")
public class ModeledMetricsSample_Gravity extends View {

	private static final long serialVersionUID = 7844944428314168114L;

	public static void main(String[] args) {
		ViewFrameUI ui = new ViewFrameUI(new ModeledMetricsSample_Gravity());
	}
	/**
	 * create the modeled metrics demo
	 */
	public ModeledMetricsSample_Gravity() {
		super();
		setPlaceHolder(100, ViewPart.South);
		setPlaceHolder(80, ViewPart.West,ViewPart.East);

		// create linear proj
		Projection.Linear proj = new Projection.Linear(-1000, 1000, -140, 300);
		proj.setThemeColor(RosePalette.LEMONPEEL);
		registerProjection(proj);

		// register a zoom wheel plug-in
		ZoomWheelPlugin wheel = new ZoomWheelPlugin();
		proj.registerPlugin(wheel);

		// register a translate with context menu plug-in and lock selected for
		// direct use
		TranslatePlugin translate = new TranslatePlugin();
		translate.registerContext(new TranslateDefaultDeviceContext());
		translate.registerWidget(new TranslateCompassWidget());
		proj.registerPlugin(translate);

		// register a zoom box with context menu and widget history
		ZoomBoxPlugin zoomBox = new ZoomBoxPlugin();
		proj.registerPlugin(zoomBox);
		zoomBox.registerWidget(new ZoomBoxDonutWidget());
		zoomBox.registerContext(new ZoomBoxDefaultDeviceContext());

		Font f1 = new Font("console", Font.PLAIN, 12);
		Font f2 = new Font("console", Font.PLAIN, 6);

		// create modeled axis plug-in in south part
		AxisMetricsPlugin.ModeledMetrics southMetrics = new AxisMetricsPlugin.ModeledMetrics.S();
		proj.registerPlugin(southMetrics);
		southMetrics.setMajorTextFont(f1);
		southMetrics.setMedianTextFont(f2);
		
		//southMetrics.setTextColor(NanoChromatique.BLUE);
		southMetrics.setMajorTextColor(NanoChromatique.BLUE.brighter());
		southMetrics.setMedianTextColor(NanoChromatique.GREEN.brighter());
		
		southMetrics.setMajorMarkerColor(NanoChromatique.BLUE.brighter());
		southMetrics.setMedianMarkerColor(NanoChromatique.GREEN.brighter());
		southMetrics.setMinorMarkerColor(NanoChromatique.PINK);
		
		//gravity natural
		southMetrics.setGravity(Gravity.Natural);
		
		// create modeled axis plug-in in west part
		AxisMetricsPlugin.ModeledMetrics westMetrics = new AxisMetricsPlugin.ModeledMetrics.W();
		proj.registerPlugin(westMetrics);
		westMetrics.setTextFont(f1);
		westMetrics.setTextColor(NanoChromatique.PINK);
		
		//#########
		//Gravity Rotate, Along the axis the metrics label
		westMetrics.setGravity(Gravity.Rotate);
		
		
		AxisMetricsPlugin.ModeledMetrics eastMetrics = new AxisMetricsPlugin.ModeledMetrics.E();
		proj.registerPlugin(eastMetrics);
		eastMetrics.setTextFont(f1);
		eastMetrics.setTextColor(NanoChromatique.YELLOW);
		
		//#########
		//Gravity Natural, human readable
		eastMetrics.setGravity(Gravity.Natural);
		
		
		// register device outline plug-in
		proj.registerPlugin(new OutlinePlugin());
		
		

	}
	
}