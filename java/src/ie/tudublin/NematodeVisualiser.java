package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{
	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();
	int bodySize = 60;
	int eyeSize = 15;
	int femalePartSize = 40;
	int malePartSize = 15;
	int limbsSize = 35;
	int nematodeColor = 255;
	int nematodeWeigth = 5;

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
		}		
	}


	public void settings()
	{
		size(800, 800);
		loadNematodes();
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();				
	}
	

	public void loadNematodes()
	{
		Table table = loadTable("nematodes.csv", "header");

		for(TableRow row:table.rows())
		{
			Nematode nematode = new Nematode(row);
			nematodes.add(nematode);
		}

		for(Nematode n:nematodes)
		{
			println(n);
		}
	}

	public void drawBottom(String gender, int limbsPresent) {
		switch (gender) {
			case "":
				
				break;
		
			default:
				break;
		}
	}


	public void drawBody(int limbsPresent) {
		ellipseMode(CENTER);
		stroke(nematodeColor);
		strokeWeight(nematodeWeigth);
		noFill();
		ellipse(0, 0, bodySize, bodySize);
		

		if(limbsPresent == 1)
		{
			int x1 = -(bodySize/2);
			int x2 = bodySize/2;
			line(x1, 0, x1-limbsSize, 0);
			line(x2, 0, x2+limbsSize, 0);
		}
	}

	public void draw()
	{	
		translate(400, 400);
		drawBody(0);
	}
}
