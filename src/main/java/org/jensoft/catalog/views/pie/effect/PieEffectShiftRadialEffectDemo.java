/*
 * JenSoft API - Charting Framework
 * http://www.jensoftapi.com
 * Copyright (c) JenSoft. All rights reserved.
 * See JenSoft Software License Agreement
 */
package org.jensoft.catalog.views.pie.effect;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

import org.jensoft.core.catalog.nature.JenSoftView;
import org.jensoft.core.palette.color.ColorPalette;
import org.jensoft.core.palette.color.FilPalette;
import org.jensoft.core.palette.color.TangoPalette;
import org.jensoft.core.plugin.legend.title.TitleLegend;
import org.jensoft.core.plugin.legend.title.TitleLegendConstraints;
import org.jensoft.core.plugin.legend.title.TitleLegendConstraints.LegendAlignment;
import org.jensoft.core.plugin.legend.title.TitleLegendConstraints.LegendPosition;
import org.jensoft.core.plugin.legend.title.TitleLegendPlugin;
import org.jensoft.core.plugin.legend.title.painter.fil.TitleLegendGradientFill;
import org.jensoft.core.plugin.outline.OutlinePlugin;
import org.jensoft.core.plugin.pie.Pie;
import org.jensoft.core.plugin.pie.PiePlugin;
import org.jensoft.core.plugin.pie.PieSlice;
import org.jensoft.core.plugin.pie.PieToolkit;
import org.jensoft.core.plugin.pie.painter.draw.PieDefaultDraw;
import org.jensoft.core.plugin.pie.painter.effect.PieRadialEffect;
import org.jensoft.core.projection.Projection;
import org.jensoft.core.view.View;

@JenSoftView(description="Show how to use effect with shift angle")
public class PieEffectShiftRadialEffectDemo extends View {

	private static final long serialVersionUID = 156889765687899L;

	public PieEffectShiftRadialEffectDemo() {
		super(0);
		Projection proj = new Projection.Linear.Identity();
		registerProjection(proj);

		PiePlugin piePlugin = new PiePlugin();
		proj.registerPlugin(piePlugin);

		// CREATE PIE
		Pie pie = PieToolkit.createPie("pie", 120);
		PieSlice s1 = PieToolkit.createSlice("s1", new Color(240, 240, 240, 240), 45, 0);
		PieSlice s2 = PieToolkit.createSlice("s2", ColorPalette.alpha(TangoPalette.BUTTER2, 240), 5, 0);
		PieSlice s3 = PieToolkit.createSlice("s3", ColorPalette.alpha(TangoPalette.CHAMELEON2, 240), 30, 0);
		PieSlice s4 = PieToolkit.createSlice("s4", ColorPalette.alpha(TangoPalette.SKYBLUE2, 240), 20, 0);
		PieToolkit.pushSlices(pie, s1, s2, s3, s4);
		piePlugin.addPie(pie);

		// PIE OUTLINE
		PieDefaultDraw draw = new PieDefaultDraw(Color.WHITE);
		draw.setDrawStroke(new BasicStroke(1.4f));
		pie.setPieDraw(draw);

		// CUSTOM EFFECT
		Color[] colors = {new Color(255, 255, 255, 200), new Color(40, 40, 40, 80)};
		float[] fractions = {0,1f};
		PieRadialEffect effect2 = new PieRadialEffect(colors,fractions);
		effect2.setOffsetRadius(0);
		effect2.setFocusAngle(300);
		effect2.setFocusRadius(60);
		pie.setPieEffect(effect2);

		// OUTLINE
		proj.registerPlugin(new OutlinePlugin());

		// ANIMATOR
		PieRadialEffect.shiftIncidence(pie);
		PieRadialEffect.shiftRadius(pie);

		// LEGEND
		Font f =  new Font("Dialog", Font.PLAIN, 12);
		TitleLegend legend = new TitleLegend("EFFECT FOCUS ANIMATOR");
		legend.setLegendFill(new TitleLegendGradientFill(Color.WHITE, FilPalette.GREEN5));
		legend.setFont(f);
		legend.setConstraints(new TitleLegendConstraints(LegendPosition.South, 0.8f, LegendAlignment.Rigth));
		TitleLegendPlugin legendPlg = new TitleLegendPlugin();
		legendPlg.addLegend(legend);
		proj.registerPlugin(legendPlg);

	}

}
