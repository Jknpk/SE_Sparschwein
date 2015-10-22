package application.accounting;
import java.util.Scanner;
import java.io.IOException;
import java.util.logging.*;



public class MainClass{

	protected static final Logger logger = Logger.getLogger(Buchhaltung.class.getName());
	


	public static void main(String[] args){
	  logger.setLevel(Level.ALL);
	
	  try{
	    String log = parser.getLogger();
	    boolean append = true;
	    FileHandler fh = new FileHandler(log, append);
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
	  
	  
	  
	  logger.warning("ICH WILL WAS SEHEN, TITEN AUF DEN TISCH, Butter am Fisch!");
	  
	  
	
		
		if(args.length != 0){
			ArgParser parser = new ArgParser(args);
				try{
						logger.info("lese von Datei: " + parser.getInputFilename());
						Buchhaltung neuesBuch = new Buchhaltung(Double.parseDouble(parser.getNonOptions()), parser.getInputFilename(), parser.getOutputFilename());
						System.out.println("done successfully");
					}
					catch(IOException e){
						logger.severe("Alles scheisse, Leben hat kein Sinn mehr 1");
						System.out.println("Parameter waren nicht korrekt!");
					}	
						
		}
		else{
		
			// System.out.println(args.length);
			
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
					logger.info("lese von Datei: " + dateipfad_input);
					Buchhaltung neuesBuch = new Buchhaltung(zinssatz, dateipfad_input, dateipfad_output);
					System.out.println("done successfully");
					break;
				}
				catch(IOException e){
					logger.severe("Alles scheisse, Leben hat kein Sinn mehr 2");
					System.out.println("Ihre Eingaben waren nicht Korrekt! Versuchen wir es erneut..");
					continue;
				}
				
				
				
			
			}
			
			
			
			sc.close();
		}
	}	
	
}
