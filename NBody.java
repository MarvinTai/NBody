/**
 * @author YOUR NAME THE STUDENT IN 201
 * 
 * Simulation program for the NBody assignment
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
// this is a class called NBody
public class NBody {
	
	/**
	 * Read the specified file and return the radius
	 * @param fname is name of file that can be open
	 * @return the radius stored in the file
	 * @throws FileNotFoundException if fname cannot be open
	 */
	// output method 
	public static double readRadius(String fname) throws FileNotFoundException  {
		//make an object scanner called s which takes ...
		Scanner s = new Scanner(new File(fname));
		// calling a function is when I . smth
		s.nextInt();
		// reading next line
		double rad = s.nextDouble();

		// TODO: read values at beginning of file to
		// find the radius
		
		s.close();
		return rad;
	}
	
	/**
	 * Read all data in file, return array of Celestial Bodies
	 * read by creating an array of Body objects from data read.
	 * @param fname is name of file that can be open
	 * @return array of Body objects read
	 * @throws FileNotFoundException if fname cannot be open
	 */
	// output celestislbody[] method readBodies that takes input String fname 
	// CelestialBody already exists because there is a class in the other file CelestialBody.java
	// the other file has all the properties and the constructors & methods laid out 
	public static CelestialBody[] readBodies(String fname) throws FileNotFoundException {
		// making new object s 
		Scanner s = new Scanner(new File(fname));
			
		// TODO: read # bodies, store in nb
		int nb = s.nextInt();         // # bodies to be read

		// TODO: Create array that can store nb CelestialBodies
		// CelestialBody is a class, and every term in array is an object
		// we're making an array of CelestialBody 
		// making a new object called infoofCelestialBodies 
		// array of celestialbody objects
		// object is an instance of the class
		CelestialBody[] infoofCelestialBodies = new CelestialBody[nb];
		// TODO: read and ignore radius
		s.nextDouble();

		for(int k=0; k < nb; k++) {
			double xPos = s.nextDouble();
			double yPos = s.nextDouble();
			double xVel = s.nextDouble();
			double yVel = s.nextDouble();
			double bMass = s.nextDouble();
			String image = s.next();
			//whenever I use new I'm making a new object
			//here i'm entering for each index of the array I'm creating, I'm creating the 6 parameters to be stored
			infoofCelestialBodies[k] = new CelestialBody(xPos, yPos, xVel, yVel, bMass, image);
			// new object of class CelestialBody is initialized with parameters (xPos, yPos, xVel, yVel, bMass, image)
			// for each kth element of my array of infoofCelestialBodies, I'm setting it equal to a new object with 6 parameters
			// TODO: read data for each body
			// TODO: construct new body object and add to array

		}

		s.close();

		return infoofCelestialBodies;
	}
	public static void main(String[] args) throws FileNotFoundException{
		double totalTime = 39447000.0;
		double dt = 25000.0;

		String fname= "./data/planets.txt";

		if (args.length > 2) {
			totalTime = Double.parseDouble(args[0]);
			dt = Double.parseDouble(args[1]);
			fname = args[2];
		}	
		
		CelestialBody[] bodies = readBodies(fname);
		double radius = readRadius(fname);

		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0,0,"images/starfield.jpg");

		// run simulation until over

		for(double t = 0.0; t < totalTime; t += dt) {
			
			// TODO: create double arrays xforces and yforces
			//       to hold forces on each body
			double[] xForce = new double[bodies.length];
			double[] yForce = new double[bodies.length];
			

			// TODO: in loop, calculate netForcesX and netForcesY and store in
			//       arrays xforces and yforces for each object in bodies

			for(int k=0; k < bodies.length; k++) {
				// need to use bodies[k] because I need to call the method on a certain object (by inputing all the other bodies)
				xForce[k] = bodies[k].calcNetForceExertedByX(bodies);
				yForce[k] = bodies[k].calcNetForceExertedByY(bodies);
  			}

			// TODO: loop over all bodies and call update
			//       with dt and corresponding xforces and yforces arrays

			for(int k=0; k < bodies.length; k++){
				bodies[k].update(dt, xForce[k], yForce[k]);
			}

			StdDraw.clear();
			StdDraw.picture(0,0,"images/starfield.jpg");
			
			// TODO: loop over all bodies and call draw on each one

			for(CelestialBody b : bodies){
				b.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);

		}
		
		// prints final values after simulation
		
		System.out.printf("%d\n", bodies.length);
		System.out.printf("%.2e\n", radius);
		for (int i = 0; i < bodies.length; i++) {
		    System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		   		              bodies[i].getX(), bodies[i].getY(), 
		                      bodies[i].getXVel(), bodies[i].getYVel(), 
		                      bodies[i].getMass(), bodies[i].getName());	
		}
	}
}
