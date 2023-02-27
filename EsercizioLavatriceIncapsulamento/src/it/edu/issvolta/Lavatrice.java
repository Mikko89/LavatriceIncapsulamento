package it.edu.issvolta;

import java.time.LocalTime;
import java.util.Scanner;
import static java.time.temporal.ChronoUnit.SECONDS;

public class Lavatrice {
	
	Scanner r=new Scanner (System.in);
	
	private int capacità;
	private int livelloAcqua;  //max 6 litri
	private int temperatura;
	private int velocitàRotazione;
	private int stato; 
	private float credito;
	private boolean detersivo;
	private LocalTime dataOraAvvio;
	
	/*
	lt=LocatTime.now();
	System.out.println(SECONDS.between(dataOraAvvio, lt));  	//ogni volta che si chiama il getStato confronta il dataOraAvvio col secondo local time
	
	if(SECONDS.between(dataOraAvvio, lt)>60) //se sono passati più di60 secondi e lo stato attuale è 1 il lavaggio si ferma e lo stato diventa 2
	 
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
		super();
		if(capacità!=8 && capacità!=10 && capacità!=14)
		{
			System.out.println("Capacità non valida! Impostata capacità predefinita di 8 kg");
			this.capacità=8;
		}
		else
			this.capacità = capacità;
		inizializza();
	}
	
	public void inizializza() //inizializza attributi
	{
		livelloAcqua = 0;
		temperatura = 0;
		velocitàRotazione = 0;
		stato = 0;
		credito = 0;
		detersivo = false;
	}
	
	public void aggiungiAcqua(int litri) //livello max di acqua 6 litri
	{
		if(litri<=0)
			System.out.println("Quantità di acqua negativa, quindi non valida!");
		else	
			if(livelloAcqua+litri>6)
				System.out.println("Il valore eccede il totale di acqua massima caricabile!");
			else
				livelloAcqua+=litri;
		
		System.out.println("La quantità attuale di acqua nella lavatrice è " +livelloAcqua +" litri.");
		System.out.println("Quanti litri vuoi aggiungere per il lavaggio? Livello massimo di acqua = 6 litri.");
	}
	
	public void setTemperatura(int gradi) //la temperatura può essere 40, 60 90 gradi;
	{
		System.out.println("Quale ciclo di lavaggio vuoi usare? 40/60/90.");
		
		if(gradi==40 || gradi==60 || gradi ==90)
			this.temperatura=gradi;
		else 
			System.out.println("Temperatura non valida!");
	}
	
	public void setVelocitàRotazione(int velocitàRotazione) // la velocità può essere 600giri/m 800giri/m 1000giri/m
	{
		if(velocitàRotazione==600 || velocitàRotazione==800 || velocitàRotazione==1000)
			this.velocitàRotazione=velocitàRotazione;
		else
			System.out.println("Velocità di rotazione non valida!");
	}
	
	public void aggiungiDetersivo() //detersivo vero o falso
	{
		detersivo=true;
	}
	
	public void aggiungiMoneta(float moneta)
	{
		if(moneta==0.10 || moneta==0.20 || moneta==0.50 || moneta==1.0 || moneta==2.0)
			credito+=moneta;
		else
			System.out.println("Moneta non valida!");
	}
	
	public float getCosto()
	{
		switch(capacità) 
		{
		case 8:
			return 4.50f;
		case 10:
			return 5.50f;
		case 14:
			return 6.50f;
		default:
			return 0;
		}
	}
	
	public void start() //impostare il local time dataOraAvvio
	{
		if(credito<getCosto())
			System.out.println("Credito insufficiente!");
		else 
		{
			if(livelloAcqua<4)
				System.out.println("Livello acqua insufficiente!");
			else 
				if (temperatura==0)
					System.out.println("Temperatura non impostata!");
				else 
					if(velocitàRotazione==0)
						System.out.println("Velocità di rotazione non impostata!");
					else 
						if(!detersivo)
							System.out.println("Detersivo non aggiunto!");
						else 
							if(stato!=0)
								System.out.println("La lavatrice non è libera");
							else
							{
								stato=1;
								dataOraAvvio=LocalTime.now();
								System.out.println("La lavatrice è partita.");
							}
		}
	}
	
	public void stop() //funziona con lo stato 1 e lo porta a 2
	{
		if(stato==1)
		{
			stato=2;
			System.out.println("La lavatrice si è fermata");
		}
		else 
			System.out.println("Lavatrice già ferma!");
	}
	
	public String getStato()
	{
		LocalTime lt = LocalTime.now();
		
		if(stato==1 && SECONDS.between(dataOraAvvio, lt)>60)
			stato=2;
		
		switch(stato)
		{
		case 0:
			return "libera";
		case 1:
			return "lavaggio in corso. Tempo trascorso: "+SECONDS.between(dataOraAvvio, lt);
		case 2:
			return "lavaggio terminato";
		default:
			return "";
		}
	}

	public int getCapacità() 
	{
		return capacità;
	}

	public int getLivelloAcqua() 
	{
		return livelloAcqua;
	}

	public int getTemperatura() 
	{
		return temperatura;
	}

	public int getVelocitàRotazione() 
	{
		return velocitàRotazione;
	}
	
	public boolean detersivoAggiunto()
	{
		return detersivo;
	}
	
	public float getCredito()
	{
		return credito;
	}
	
	public void svuota() //riporta lo stato a 0 (se lo stato attuale è 2)
	{
		if(stato==2)
			inizializza();
		else 
			{
			if (stato==0)
			
				System.out.println("Lavatrice già vuota");
			else 
				System.out.println("Lavaggio in corso");
			}
	}
}
