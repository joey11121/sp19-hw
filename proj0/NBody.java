public class NBody{
	/** readRadius returns the radius of universe.*/
	public static double readRadius(String file){
		In  in = new In(file);
		int planetNumber = in.readInt();
		double univRadius = in.readDouble();
		return univRadius;
	}
	/**readPlanets returns an array that saves the info of planets*/
	public static Planet[] readPlanets(String file){
		In in = new In(file);
		int planetNumber = in.readInt();
		double univRadius = in.readDouble();
		Planet[] planetList = new Planet[planetNumber];
		for(int i = 0; i < planetNumber; i++){
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String gif =  in.readString();
			planetList[i] = new Planet(xP, yP, xV, yV, m, gif);
		}
		return planetList;
	}
	/**main method */
	public static void main(String[] args){
		double T = Double.parseDouble(args[0]), dt = Double.parseDouble(args[1]);
		String filename = args[2];
		StdDraw.enableDoubleBuffering();
		double time = 0;
		NBody nb = new NBody();
		double univRad = nb.readRadius(filename);
		Planet[] planets = nb.readPlanets(filename);
		StdDraw.setScale(-univRad / 2, univRad / 2);
		StdDraw.picture(0, 0, "images/starfield.jpg");
		for(Planet p : planets){
			p.draw();
		}
		StdDraw.show();
		StdDraw.pause(10);
		while(time <= T){
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];
			for(int i = 0; i < planets.length; i++){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for(int i = 0; i < planets.length; i++){
				planets[i].update(dt, xForces[i], yForces[i]);
			}
			StdDraw.setScale(-univRad, univRad);
			StdDraw.picture(0, 0, "images/starfield.jpg");
			for(Planet p : planets){
				p.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			time += dt;
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", univRad);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                          planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
	    }
	}
}
