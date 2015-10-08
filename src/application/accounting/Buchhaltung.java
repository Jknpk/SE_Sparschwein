package application.accounting;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Buchhaltung{
	
	//Einlesen 
	//Ausgeben
	
	private double zinssatz;
	private String inputData;

    public Buchhaltung(double zinssatz, String inputData) throws IOException{

		this.zinssatz = zinssatz;
		this.inputData = inputData;
		
		input();
		
    } 


	private void input() throws IOException{
		Scanner sc = null;
		PrintWriter writer = null;
		
		// Zeug einlesen
		sc = new Scanner(new File(inputData));

		
		
		
		// Ausgabe Datei initialisieren
		File ausgabeFile = new File("data/output.csv");
		if(!(ausgabeFile.exists() && !ausgabeFile.isDirectory())) ausgabeFile.createNewFile();
		writer = new PrintWriter(new FileWriter(ausgabeFile, false)); // false ueberschreibt Datei
		
		String nextLine = "";
		while(sc.hasNext()){
			nextLine = sc.nextLine(); 
			try{
				if(!(nextLine.charAt(0)==('#') || nextLine.charAt(0)==(' ') || nextLine.charAt(0)==('\n'))){
					Sparer irgendjemand = new Sparer(nextLine, zinssatz);
					writer.write(irgendjemand.rueckgabeString());
				}
				else{
					writer.println(nextLine);				
				}
			} catch(StringIndexOutOfBoundsException e){
				writer.println("");
			}
			
		}
	
		sc.close();
		writer.close();
		
	}



} 



//String tryString = "025364;Adler;Susanne;287,34;24;2,13;167;24,2";
//Sparer susanne = new Sparer(tryString, zinssatz);