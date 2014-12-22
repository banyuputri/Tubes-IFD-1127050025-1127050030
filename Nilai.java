import java.io.*;
public class Nilai{
	public static void main(String[] args){
		String HM;
		int NA= Integer.parseInt(args[1]);
		if(NA >=81 && NA <=100)
			HM="A";
		else if (NA >=71 && NA <81)
			HM="AB";
		else if (NA >=66 && NA <71)
			HM="B";
		else if (NA >=61 && NA <66)
			HM="BC";
		else if (NA >=56 && NA <61)
			HM="C";
		else if (NA >=41 && NA <55)
			HM="D";
		else 
			HM="E";
		System.out.println("Nama anda = "+args[0]);
		System.out.println("Nilai Huruf = "+HM);
		}
		}
		