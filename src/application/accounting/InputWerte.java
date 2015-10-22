package application.accounting;
import java.util.Scanner;
public class InputWerte{

	private double zinssatz = 0;
	private String inputData = "./src/data/input.csv";
	private String outputData = "./src/data/output.csv";
	private String log = "./log.txt";


	public InputWerte(){

	}

	public void tastaturEingabe(){
	// Liest die 4 Eingabewerte von der Tastatur ein.
		Scanner sc = new Scanner(System.in);
		System.out.println("Geben Sie einen Zinssatz an! (Prozent)");
		setZinssatz(sc.nextDouble());
		System.out.println("Dateipfad zur Eingabedatei: (relativ zur build.xml)\nBei der Eingabe von 'default' wird von\n./src/data/input.csv als Eingabedatei\n./src/data/output.csv als Ausgabedatei\n./log.txt als Log-Datei ausgegangen");
		setInputData(sc.next());
		if(!inputData.equals("default")){		
			System.out.println("Dateipfad zur Ausgabedatei: (relativ zur build.xml)");
			setOutputData(sc.next());
			System.out.println("Dateipfad zur Log Datei: (relativ zur build.xml), default ist ./log.txt");
			setLog(sc.next());
		}else{
			setInputData("./src/data/input.csv");
		}
		sc.close();	
	}

	
	public double getZinssatz(){
		return zinssatz;
	}
	public void setZinssatz(double zinssatz_eingabe){
		 this.zinssatz = zinssatz_eingabe;
	}
	public String getInputData(){
		return inputData;
	}
	public void setInputData(String inputData_eingabe){
		 this.inputData = inputData_eingabe;
	}
	public String getOutputData(){
		return outputData;
	}
	public void setOutputData(String outputData_eingabe){
		 this.outputData = outputData_eingabe;
	}
	public String getLog(){
		return log;
	}
	public void setLog(String log_eingabe){
		 this.log = log_eingabe;
	}

}