package it.unibo.paw.db;

import java.sql.Date;

import it.unibo.paw.model.PrenotazioneRistorante;

public class PrenotazioneRistoranteRepository {
    
    private DataSource dataSource;

    private static final String TABLE = "prenotazione";

    private static final String COGNOME = "cognome";
	private static final String DATA = "data";
	private static final String NUMEROPERSONE = "numeroPersone";
	private static final String CELLULARE = "cellulare";
	private static final String ID = "id";
	private static final String TAVOLO = "idTavolo";

    private static String create = "CREATE TABLE " + TABLE + " ( " +
			ID + " INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1), " +
			COGNOME + " VARCHAR(20) NOT NULL, " +
			DATA + " DATE NOT NULL, " +
			NUMEROPERSONE + " INT, " +
			CELLULARE + " VARCHAR(10), " +
			TAVOLO + " INT NOT NULL REFERENCES tavolo, " +
			"PRIMARY KEY (" + ID + "), " +
			"CONSTRAINT pt_PrenotazioneID UNIQUE (" + COGNOME + "," + DATA + "), " +
			"CONSTRAINT pr_PranotazioneTavoloID UNIQUE (" + DATA + "," + TAVOLO + ") " +
			") ";

    private static String drop = "DROP TABLE "+TABLE;

    private static final String insert = "INSERT INTO " + TABLE + " ( " +
			COGNOME + ", " + DATA + ", " + NUMEROPERSONE + ", " + CELLULARE + ", " + TAVOLO + " " +
			") " +
			"VALUES (?,?,?,?,?) ";

    public PrenotazioneRistoranteRepository(int dbType)
    {
        dataSource = new DataSource(dbType);
    }


    private static boolean RichiestaPrenotazione(String cognome, Date data, int numeroPersone, String cellulare) throws PersistenceException
    {
        String tableAvaible = TavoloRepository.DisponibilitaTavolo(data, numeroPersone);
		if(tableAvaible == null)
			return false;
		
		int numeroTavolo = TavoloRepository.getTavoloById(tableAvaible);

		PrenotazioneRistorante pr = new PrenotazioneRistorante();
		pr.setCognomePrentazione(cognome);
		pr.setDataPrenotazione(data);
		pr.setNumeroPersonePrenotazione(numeroPersone);
		pr.setCellularePrenotazione(cellulare);
		pr.setIdTavoloPrenotazione(numeroTavolo);
		PrenotazioneRistoranteRepository.persist(pr);
        return true;
    }


	private static void persist(PrenotazioneRistorante pr) {

		
	}

    

}
