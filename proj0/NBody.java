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
			String gif = in.readString();
			planetList[i] = new Planet(xP, yP, xV, yV, m, gif);
		}
		return planetList;
	}
}
