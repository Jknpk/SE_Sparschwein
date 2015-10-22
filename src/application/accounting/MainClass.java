package application.accounting;
import java.io.IOException;
import java.util.logging.*;

public class MainClass{
	

	protected static final Logger logger = Logger.getLogger(Buchhaltung.class.getName());
	
	public static void main(String[] args){
	// Vorinitialisierung der Übergabe-Parameter
	
	InputWerte eingabe = new InputWerte();
	if(args.length != 0){
	// Eingabe der Parameter erfolgt über XML-Datei
		ArgParser parser = new ArgParser(args);
		eingabe.setZinssatz(Double.parseDouble(parser.getNonOptions()));
		eingabe.setInputData(parser.getInputFilename());
		eingabe.setOutputData(parser.getOutputFilename());
		eingabe.setLog(parser.getLogFilename());		
	}
	else{
	// Eingabe der Parameter erfolgt über Tastatur
		eingabe.tastaturEingabe();
	}

	// Initialisierung des Loggers	
	logger.setLevel(Level.ALL);
	
	try{
	boolean append = true;
	FileHandler fh = new FileHandler(eingabe.getLog(), append);
	fh.setFormatter(new Formatter() {
		public String format(LogRecord rec) {
			StringBuffer buf = new StringBuffer(1000);
			buf.append(new java.util.Date()).append(' ');
			buf.append(rec.getLevel()).append(' ');
			buf.append(formatMessage(rec)).append('\n');
			return buf.toString();
		}
	});
	logger.addHandler(fh);
	    
	} catch(IOException e){
		logger.severe("Datei kann nicht geschrieben werden");
		e.printStackTrace();
	}
	   
	// Durchführung der Buchhaltung mit den gelesenen Parametern.   
	while(true){
		try{
			logger.info("lese von Datei: " + eingabe.getLog());
			System.out.println(eingabe.getZinssatz() + " " + eingabe.getInputData() + " " + eingabe.getOutputData());
			Buchhaltung neuesBuch = new Buchhaltung(eingabe.getZinssatz(), eingabe.getInputData(), eingabe.getOutputData());
			System.out.println("done successfully");
			break;
		}
		catch(IOException e){
			logger.severe("Es ist wohl ein Fehler aufgetreten..");
			System.out.println("Parameter waren nicht korrekt, erneuter Versuch mit manueller Eingabe...");
			eingabe.tastaturEingabe();
		}	
	}

	}
	
}
