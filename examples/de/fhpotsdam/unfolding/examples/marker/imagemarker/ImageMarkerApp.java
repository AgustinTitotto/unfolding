package de.fhpotsdam.unfolding.examples.marker.imagemarker;

import App.Mapa;

import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.utils.MapUtils;

import java.awt.*;
import java.util.ArrayList;

/**
 * Demonstrates how to use ImageMarkers with different icons. Note, the used icons contain translucent (the shadows) and
 * transparent (the inner holes) areas.
 */
public class ImageMarkerApp extends PApplet {

	Mapa mapa = new Mapa();
	ArrayList<Location> ubicaciones = new ArrayList<>();

	public void getUbicaciones(){
		for (int i = 0; i < mapa.getUbiLongitudes().size(); i++) {
			ubicaciones.add(new Location(mapa.getUbiLongitudes().get(i), mapa.getUbiLatitudes().get(i)));
		}
	}

	UnfoldingMap map;

	public void settings() {
		size(800, 600, P2D);
	}

	public static void main(String[] args) {
		PApplet.main(new String[] { ImageMarkerApp.class.getName() });
	}

	public void setup() {
		getUbicaciones();
		map = new UnfoldingMap(this);
		map.zoomAndPanTo(10, new Location(-34.5, -58.7));
		MapUtils.createDefaultEventDispatcher(this, map);

		for (int i = 0; i < ubicaciones.size(); i++) {
			ImageMarker imageMarkeri = new ImageMarker(ubicaciones.get(i), loadImage("ui/marker_red.png"));
			map.addMarkers(imageMarkeri);
		}
	}

	public void draw() {
		map.draw();
	}

}
