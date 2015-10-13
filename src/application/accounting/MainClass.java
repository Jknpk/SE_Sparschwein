package application.accounting;
import java.util.Scanner;
import java.io.IOException;
public class MainClass{

	public static void main(String[] args){


		//String tryString = "025364;Adler;Susanne;287,34;24;2,13;167;24,2";

		//Sparer susanne = new Sparer(tryString);
		
		
		//System.out.println(System.getProperty("user.dir"));
		
		Scanner sc = new Scanner(System.in);

		
		while(true){
		
			System.out.println("Geben Sie einen Zinssatz an! (Prozent)");
			int zinssatz = sc.nextInt();
			System.out.println("Dateipfad zur Eingabedatei: (relativ zur build.xml)\nBei der Eingabe von 'default' wird von src/data/input.csv\n und src/data/output.csv ausgegangen");
			String dateipfad_input = sc.next();
			String dateipfad_output;
			if(dateipfad_input.equals("default")){
			dateipfad_input = "src/data/input.csv";
			dateipfad_output = "src/data/output.csv";
			}
			else{
				System.out.println("Dateipfad zur Ausgabedatei: (relativ zur build.xml)");
				dateipfad_output = sc.next();
			}
			try{
			
				Buchhaltung neuesBuch = new Buchhaltung(zinssatz, dateipfad_input, dateipfad_output);
				System.out.println("done successfully");
				break;
			}
			catch(IOException e){
				System.out.println("Ihre Eingaben waren nicht Korrekt! Versuchen wir es erneut..");
				continue;
			}
			
			
			
		
		}
		
		
		
		sc.close();
		
	}	
	
}