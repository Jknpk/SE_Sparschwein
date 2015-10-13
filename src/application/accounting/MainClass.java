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
			System.out.println("Geben Sie einen gueltigen Dateipfad an! (absolut oder relativ zur MainClass.java) \nBei der Eingabe von 'default' wird von application/data/input.csv ausgegangen");
			String dateipfad = sc.next();
			

			if(dateipfad.equals("default")) dateipfad = "src/data/input.csv";
			try{
			
				Buchhaltung neuesBuch = new Buchhaltung(zinssatz, dateipfad);
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