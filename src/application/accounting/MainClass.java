package application.accounting;
import java.io.IOException;
import java.util.logging.*;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;


public class MainClass{
	

	protected static final Logger logger = Logger.getLogger(Buchhaltung.class.getName());
	
	public static void main(String[] args){
	// Vorinitialisierung der Ueberbergabe-Parameter
	
	InputWerte eingabe = new InputWerte();
	if(args.length != 0){
	// Eingabe der Parameter erfolgt ueber XML-Datei	
		ArgParser parser = new ArgParser(args);
		eingabe.setZinssatz(Double.parseDouble(parser.getNonOptions()));
		eingabe.setInputData(parser.getInputFilename());
		eingabe.setOutputData(parser.getOutputFilename());
		eingabe.setLog(parser.getLogFilename());		
	}
	else{
	// Eingabe der Parameter erfolgt ueber Tastatur
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
	   
	// Durchfuehrung der Buchhaltung mit den gelesenen Parametern.
	String baseName = "MainClass";
	ResourceBundle rb = ResourceBundle.getBundle(baseName);  
	while(true){
		try{
			String readinput_msg = rb.getString("readinput_msg");
			logger.info(readinput_msg + " " + eingabe.getInputData());
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
