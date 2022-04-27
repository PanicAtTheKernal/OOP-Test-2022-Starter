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
	int femalePartSize = 30;
	int malePartSize = 15;
	int limbsSize = 35;
	int nematodeColor = 255;
	int nematodeWeigth = 3;

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

	public void drawEyes(int eyesPresent, int limbsPresent)
	{
		drawBody(limbsPresent);
		if (eyesPresent == 1)
		{
			int eyeLength = limbsSize-15;
			int x1 = -(bodySize/2)+7;
			int y1 = -(bodySize/2)+7;
			line(x1, y1, x1-eyeLength, y1-eyeLength);
			ellipse(x1-eyeLength-eyeSize/2, y1-eyeLength-eyeSize/2, eyeSize, eyeSize);
	
			int x2 = (bodySize/2)-7;
			int y2 = -(bodySize/2)+7;
			line(x2, y2, x2+eyeLength, y2-eyeLength);
			ellipse(x2+eyeLength+eyeSize/2, y2-eyeLength-eyeSize/2, eyeSize, eyeSize);
		}


	}

	public void drawBottom(String gender, int limbsPresent) {
		switch (gender) {
			case "h":
				drawMaleBottom(limbsPresent);
				drawFemaleBottom(limbsPresent);
				break;
			case "m":
				drawMaleBottom(limbsPresent);
				break;
			case "f":
				drawFemaleBottom(limbsPresent);
				break;
			case "n":
				drawBody(limbsPresent);
				break;
			default:
				drawBody(limbsPresent);
				break;
		}
	}

	public void drawMaleBottom(int limbsPresent)
	{
		drawBody(limbsPresent);
		int y1 = bodySize/2;
		line(0, y1, 0, y1+limbsSize);
		ellipse(0, y1+limbsSize+malePartSize/2, malePartSize, malePartSize);
	}

	public void drawFemaleBottom(int limbsPresent)
	{
		drawBody(limbsPresent);
		ellipse(0, 0, femalePartSize, femalePartSize);		
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
		// drawBody(0);
		// drawBottom("n", 0);
		drawEyes(0, 1);
	}
}
