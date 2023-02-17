package it.edu.issvolta;

import java.time.LocalTime;
import java.util.Scanner;

public class Lavatrice {
	
	Scanner r=new Scanner (System.in);
	
	private int capacità;
	private int livelloAcqua;
	private int temperatura;
	private int velocitàRotazione;
	private int stato; 
	private float credito;
	private boolean detersivo;
	private LocalTime dataOraAvvio;
	
	/*
	* La lavatrice può partire se:
	* 	-il credito è sufficiente (il costo lavaggio dipende dalla capacità
	* 	(8kg=4,5 euro, 10kg=5,5 euro, 14kg=6,5 euro)
	*	-il livello dell'acqua è almeno 4 litri
	* 	-la temperatura deve essere impostata (!=0)
	* 	-la velocità di rotazione deve essere impostata (!=0)
	* 	-il detersivo è stato aggiunto
	* 	-lo stato è 0 (in questo caso diventa 1)
	*
	* 	
	*/
	
	public Lavatrice (int capacità)
	{
		this.capacità = capacità;
		livelloAcqua = 0;
		temperatura = 0;
		velocitàRotazione = 0;
		stato = 0;
		credito = 0;
		detersivo = false;
	}
	
	public void aggiungiAcqua(int litri) //livello max di acqua 6 litri
	{
		System.out.println("La quantità attuale di acqua nella lavatrice è " +livelloAcqua +" litri.");
		System.out.println("Quanti litri vuoi aggiungere per il lavaggio? Livello massimo di acqua = 6 litri.");
		do 
		{
			litri=r.nextInt();
			if(livelloAcqua+litri>6)
				System.out.println("Il valore eccede il totale di acqua massima caricabile!");
		} while (livelloAcqua+litri>6);
	}
	
	public void setTemperatura(int gradi) //la temperatura può essere 40, 60 90 gradi;
	{
		System.out.println("Quale ciclo di lavaggio vuoi usare? 40/60/90.");
		do 
		{
			gradi=r.nextInt();
			if(gradi!=40 || gradi!=60 || gradi !=90)
				System.out.println("Temperatura errata! Scegliere 40/60/90.");
		} while (gradi!=40 || gradi!=60 || gradi !=90);
	}
	
	public void setVelocitàRotazione(int velocitàRotazione) // la velocità può essere 600giri/m 800giri/m 1000giri/m
	{
		System.out.println("Imposta una velocità. 600/800/1000 giri/minuto.");
		do 
		{
			velocitàRotazione=r.nextInt();
			if(velocitàRotazione!=600 || velocitàRotazione!=800 || velocitàRotazione!=1000)
				System.out.println("Velocità errata! Scegliere 600/800/1000.");
		} while (velocitàRotazione!=600 || velocitàRotazione!=800 || velocitàRotazione!=1000);
		
	}
	
	public void aggiungiDetersivo() //detersivo vero o falso
	{
		if(detersivo=false)
			System.out.println("Detersivo non presente!");
		else 
		{
			System.out.println("Premere enter per aggiungere detersivo");
			r.nextLine();
			detersivo=true;
		}
	}
	
	public void aggiungiMoneta(float moneta)
	{
		System.out.println("Inserisci la moneta...");
		
		do 
		{
			moneta=r.nextFloat();
			if(moneta!=0.10f || moneta!=0.20f || moneta!=0.50f || moneta!=1.0f || moneta!=2.0f)
				System.out.println("Moneta errata! Inserire solo monete da 0.10/0.20/0.50/1/2 Euro");
		} while (moneta!=0.10f || moneta!=0.20f || moneta!=0.50f || moneta!=1.0f || moneta!=2.0f);
	}
	
	public void start() //impostare il local time dataOraAvvio
	{
		System.out.println("La lavatrice è partita.");
		dataOraAvvio=LocalTime.now();
		stato=1;
	}
	
	public void stop() //funziona con lo stato 1 e lo porta a 2
	{
		System.out.println("La lavatrice si è fermata");
		stato=2;
	}
	
	public void svuota() //riporta lo stato a 0 (se lo stato attuale è 2)
	{
		System.out.println("La lavatrice ora è vuota e pronta per un'altra macchinata.");
		stato=0;
		
	}
	public String getStato()
	{
		
		switch (stato)		//stato: 0=libera 1=lavaggio in corso 2=lavaggio terminato
		{
		case 0:
			System.out.println("Lavatrice libera."); //restituisce una stringa corrispondente allo stato
			break;
		case 1:
			System.out.println("Lavaggio in corso.");
			break;
		case 2:
			System.out.println("Lavaggio terminato");
			break;
			default:
				break;
		}
		/*
		lt=LocatTime.now();
		System.out.println(SECONDS.between(dataOraAvvio, lt));  	//ogni volta che si chiama il getStato confronta il dataOraAvvio col secondo local time
		
		if(SECONDS.between(dataOraAvvio, lt)>60) //se sono passati più di60 secondi e lo stato attuale è 1 il lavaggio si ferma e lo stato diventa 2
		 */
	}
	
	public int getLivelloAcqua()
	{
		
	}
	
	public int getTemperatura()
	{
		
	}
	
	public int getVelocitàRotazione()
	{
		
	}
	
	public int getCapacità()
	{
		
	}
	
	public boolean detersvioAggiunto()
	{
		
	}
	
	public float getCredito()
	{
		
	}
	
	public float getCosto()
	{
		//restituisce i prezzi della lavatrice in euro(in base alla capacità)
	}

	
	
}
