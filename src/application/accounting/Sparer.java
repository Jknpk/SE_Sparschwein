package application.accounting;
public class Sparer{

private String vorname = null;
private String nachname = null;
private String mitgliedsNummer = null;
private double kontostand;
private double zinssatz;

public Sparer(String zeilenInput, double zinssatz){
	this.zinssatz = zinssatz;	
	String[] splitArray = zeilenInput.split(";");
	String tag = "";
	for(int i = 0; i< splitArray.length; i++){
		if(i == 0) this.mitgliedsNummer = splitArray[i];
		else if(i == 1) this.nachname = splitArray[i];
		else if(i == 2) this.vorname = splitArray[i];
		else if(i == 3){
			this.kontostand = Double.parseDouble(splitArray[i].replace(',','.'));
			this.kontostand = this.kontostand * ((zinssatz/100)+1);
		}
		else{	
			if((i % 2) == 0)tag = splitArray[i];
			else{
				addiereEinzahlung(tag, splitArray[i]);
			}
		}
	  }
	//double round = (Math.round(100.0 * this.kontostand)/100.0);
	//System.out.println("Kontostand: " + round);
	
	}
	private void addiereEinzahlung(String tag, String geld){
		// einzelne Ueberweisungen aufloesen und auf Var: kontostand addieren
		
		//System.out.println(Integer.parseInt(tag));
		//System.out.println(Double.parseDouble(geld.replace(',','.')));
		kontostand += Double.parseDouble(geld.replace(',','.')) * ((zinssatz/100)*((360-Integer.parseInt(tag))/360)+1);
	}
	
	public String rueckgabeString(){
		String returnString = "";
		double roundKontostand = (Math.round(100.0 * this.kontostand)/100.0);
		returnString += this.mitgliedsNummer + ";" + this.nachname + ";" + this.vorname + ";" + roundKontostand + "\n";
		returnString = returnString.replace(".", ",");
		return returnString;
	}

	
	
}