package at.mgl.Mitgliederbuchhaltung.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import at.mgl.position.Genossenschaft;
import at.mgl.position.Mitglied;
import at.mgl.transaktion.MglTransaktion;
import at.mgl.transaktion.MglTransaktionsTyp;
import at.mgl.transaktion.inhalt.MglTransaktionInhaltDouble;
import at.mgl.transaktion.inhalt.MglTransaktionInhaltString;
import at.mgl.transaktion.inhalt.MglTransaktionInhaltInteger;
import at.mgl.transaktion.inhalt.MglTransaktionInhaltDate;

public class MitgliedTest {
	
	Genossenschaft gen;
	Mitglied mgl;
	Date datumTest;
	
	@Before
	public void setUp() {
		gen = new Genossenschaft();
		mgl = gen.neuesMitglied();
		datumTest = new Date(1900,1,1);
	}
	@After
	public void cleanUp() {

	}
		
	@Test
	public void testAufrollen() {
		
		//Mitglied mglAufroll = gen.neuesMitglied();
	}
		
	@Test
	public void shouldSetMglNummerAndTransaktion() {
		int mglNummer = 1000;
		MglTransaktion t = mgl.setMglNummerTransaktion(1000);
		//MglTransaktion t = mgl.setMitTransaktion(mgl.getMglNummer(), 1000);

		assertEquals("Mitgliedsnummer wurde nicht gesetzt"
				,mglNummer
				, mgl.getMglNummer());
		assertEquals("Transaktion Mitgliedsnummer wurde nicht erzeugt oder in die Transaktionsliste eingefügt"
				,1
				,mgl.getTransaktionen().size());
		assertEquals("Transaktion Mitgliedsnummer hat den falschen MglTransaktionstyp " + t.getMglTransaktionsTyp()
				,MglTransaktionsTyp.MglMitgliedsnummer
				,t.getMglTransaktionsTyp());
		assertEquals("Transaktion Mitgliedsnummer hat nicht den angegebenen Wert " + mglNummer
				,mglNummer
				,((MglTransaktionInhaltInteger)t.getMglInhalt()).getInhalt());
	}
	@Test
	public void shouldSetMglNummerAndTransaktionPer() {
		int mglNummer = 1000;
		MglTransaktion t = mgl.setMglNummerTransaktionPer(1000,datumTest);
		//MglTransaktion t = mgl.setMitTransaktion(mgl.getMglNummer(), 1000);

		assertEquals("Mitgliedsnummer wurde nicht gesetzt"
				,mglNummer
				, mgl.getMglNummer());
		assertEquals("Transaktion Mitgliedsnummer wurde nicht erzeugt oder in die Transaktionsliste eingefügt"
				,1
				,mgl.getTransaktionen().size());
		assertEquals("Transaktion Mitgliedsnummer hat den falschen MglTransaktionstyp " + t.getMglTransaktionsTyp()
				,MglTransaktionsTyp.MglMitgliedsnummer
				,t.getMglTransaktionsTyp());
		assertEquals("Transaktion Mitgliedsnummer hat nicht den angegebenen Wert " + mglNummer
				,mglNummer
				,((MglTransaktionInhaltInteger)t.getMglInhalt()).getInhalt());
		assertEquals("Transaktion Mitgliedsnummer hat nicht das korrekte Datum" + datumTest
				,datumTest
				,t.getMglDatumTransaktion());
	}
	@Test
	public void shouldSetVornameAndTransaktionPer() {
		String name = "Vorname_1";
		MglTransaktion t = mgl.setVornameTransaktionPer(name,datumTest);
		//MglTransaktion t = mgl.setMitTransaktion(mgl.getVorname(), name);

		assertEquals("Mitglied Vorname wurde nicht gesetzt"
				,name
				, mgl.getVorname());
		assertEquals("Transaktion Mitglied Vorname wurde nicht erzeugt oder in die Transaktionsliste eingefügt"
				,1
				,mgl.getTransaktionen().size());
		assertEquals("Transaktion Mitglied Vorname hat den falschen MglTransaktionstyp " + t.getMglTransaktionsTyp()
				,MglTransaktionsTyp.MglVorname
				,t.getMglTransaktionsTyp());
		assertEquals("Transaktion Mitglied Vorname hat nicht den angegebenen Wert " + name
				,name
				,((MglTransaktionInhaltString)t.getMglInhalt()).getInhalt());
		assertEquals("Transaktion Vorname hat nicht das korrekte Datum" + datumTest
				,datumTest
				,t.getMglDatumTransaktion());
	}
	@Test
	public void shouldSetVornameAndTransaktion() {
		String name = "Vorname_1";
		MglTransaktion t = mgl.setVornameTransaktion(name);
		//MglTransaktion t = mgl.setMitTransaktion(mgl.getVorname(), name);

		assertEquals("Mitglied Vorname wurde nicht gesetzt"
				,name
				, mgl.getVorname());
		assertEquals("Transaktion Mitglied Vorname wurde nicht erzeugt oder in die Transaktionsliste eingefügt"
				,1
				,mgl.getTransaktionen().size());
		assertEquals("Transaktion Mitglied Vorname hat den falschen MglTransaktionstyp " + t.getMglTransaktionsTyp()
				,MglTransaktionsTyp.MglVorname
				,t.getMglTransaktionsTyp());
		assertEquals("Transaktion Mitglied Vorname hat nicht den angegebenen Wert " + name
				,name
				,((MglTransaktionInhaltString)t.getMglInhalt()).getInhalt());
	}
	@Test
	public void shouldSetNachnameAndTransaktionPer() {
		String nachname = "Nachname_1";
		MglTransaktion t = mgl.setNachnameTransaktionPer(nachname,datumTest);
		//MglTransaktion t = mgl.setMitTransaktion(mgl.getNachname(), nachname);

		assertEquals("Transaktion Mitglied Nachname wurde nicht erzeugt oder in die Transaktionsliste eingefügt"
				,1
				,mgl.getTransaktionen().size());
		assertEquals("Transaktion Mitglied Nachname hat den falschen MglTransaktionstyp " + t.getMglTransaktionsTyp()
				,MglTransaktionsTyp.MglNachname
				,t.getMglTransaktionsTyp());
		assertEquals("Transaktion Mitglied Nachname hat nicht den angegebenen Wert " + nachname
				,nachname
				,((MglTransaktionInhaltString)t.getMglInhalt()).getInhalt());
		assertEquals("Transaktion Nachname hat nicht das korrekte Datum" + datumTest
				,datumTest
				,t.getMglDatumTransaktion());
		
	}
	@Test
	public void shouldSetNachnameAndTransaktion() {
		String nachname = "Nachname_1";
		MglTransaktion t = mgl.setNachnameTransaktion(nachname);
		//MglTransaktion t = mgl.setMitTransaktion(mgl.getNachname(), nachname);

		assertEquals("Transaktion Mitglied Nachname wurde nicht erzeugt oder in die Transaktionsliste eingefügt"
				,1
				,mgl.getTransaktionen().size());
		assertEquals("Transaktion Mitglied Nachname hat den falschen MglTransaktionstyp " + t.getMglTransaktionsTyp()
				,MglTransaktionsTyp.MglNachname
				,t.getMglTransaktionsTyp());
		assertEquals("Transaktion Mitglied Nachname hat nicht den angegebenen Wert " + nachname
				,nachname
				,((MglTransaktionInhaltString)t.getMglInhalt()).getInhalt());
		
	}
	@Test
	public void shouldSetBeitrittsdatumAndTransaktionPer() {
		Date beitritt = new Date(2021,04,01);
		MglTransaktion t = mgl.setBeitrittsdatumTransaktionPer(beitritt,datumTest);
		//MglTransaktion t = mgl.setMitTransaktion(mgl.getBeitrittsdatum(), beitritt);

		assertEquals("Mitglied Beitrittsdatum wurde nicht gesetzt"
				,beitritt
				, mgl.getBeitrittsdatum());
		assertEquals("Transaktion Mitglied Beitrittsdatum wurde nicht erzeugt oder in die Transaktionsliste eingefügt"
				,1
				,mgl.getTransaktionen().size());
		assertEquals("Transaktion Mitglied Beitrittsdatum hat den falschen MglTransaktionstyp " + t.getMglTransaktionsTyp()
				,MglTransaktionsTyp.MglBeitritt
				,t.getMglTransaktionsTyp());
		assertEquals("Transaktion Mitglied Beitrittsdatum hat nicht den angegebenen Wert " + beitritt
				,beitritt
				,((MglTransaktionInhaltDate)t.getMglInhalt()).getInhalt());
		assertEquals("Transaktion Beitrittsdatum hat nicht das korrekte Datum" + datumTest
				,datumTest
				,t.getMglDatumTransaktion());
	}
	@Test
	public void shouldSetBeitrittsdatumAndTransaktion() {
		Date beitritt = new Date(2021,04,01);
		MglTransaktion t = mgl.setBeitrittsdatumTransaktion(beitritt);
		//MglTransaktion t = mgl.setMitTransaktion(mgl.getBeitrittsdatum(), beitritt);

		assertEquals("Mitglied Beitrittsdatum wurde nicht gesetzt"
				,beitritt
				, mgl.getBeitrittsdatum());
		assertEquals("Transaktion Mitglied Beitrittsdatum wurde nicht erzeugt oder in die Transaktionsliste eingefügt"
				,1
				,mgl.getTransaktionen().size());
		assertEquals("Transaktion Mitglied Beitrittsdatum hat den falschen MglTransaktionstyp " + t.getMglTransaktionsTyp()
				,MglTransaktionsTyp.MglBeitritt
				,t.getMglTransaktionsTyp());
		assertEquals("Transaktion Mitglied Beitrittsdatum hat nicht den angegebenen Wert " + beitritt
				,beitritt
				,((MglTransaktionInhaltDate)t.getMglInhalt()).getInhalt());
	}
	@Test
	public void shouldSetAustrittsdatumAndTransaktionPer() {
		Date austritt = new Date(2025,05,01);
		MglTransaktion t = mgl.setAustrittsdatumTransaktionPer(austritt,datumTest);
		//MglTransaktion t = mgl.setMitTransaktion(mgl.getAustrittsdatum(), austritt);

		assertEquals("Mitglied Austrittsdatum wurde nicht gesetzt"
				,austritt
				, mgl.getAustrittsdatum());
		assertEquals("Transaktion Mitglied Austrittsdatum wurde nicht erzeugt oder in die Transaktionsliste eingefügt"
				,1
				,mgl.getTransaktionen().size());
		assertEquals("Transaktion Mitglied Austrittsdatum hat den falschen MglTransaktionstyp " + t.getMglTransaktionsTyp()
				,MglTransaktionsTyp.MglAustritt
				,t.getMglTransaktionsTyp());
		assertEquals("Transaktion Mitglied Austrittsdatum hat nicht den angegebenen Wert " + austritt
				,austritt
				,((MglTransaktionInhaltDate)t.getMglInhalt()).getInhalt());
		assertEquals("Transaktion Austrittsdatum hat nicht das korrekte Datum" + datumTest
				,datumTest
				,t.getMglDatumTransaktion());
	}
	@Test
	public void shouldSetAustrittsdatumAndTransaktion() {
		Date austritt = new Date(2025,05,01);
		MglTransaktion t = mgl.setAustrittsdatumTransaktion(austritt);
		//MglTransaktion t = mgl.setMitTransaktion(mgl.getAustrittsdatum(), austritt);

		assertEquals("Mitglied Austrittsdatum wurde nicht gesetzt"
				,austritt
				, mgl.getAustrittsdatum());
		assertEquals("Transaktion Mitglied Austrittsdatum wurde nicht erzeugt oder in die Transaktionsliste eingefügt"
				,1
				,mgl.getTransaktionen().size());
		assertEquals("Transaktion Mitglied Austrittsdatum hat den falschen MglTransaktionstyp " + t.getMglTransaktionsTyp()
				,MglTransaktionsTyp.MglAustritt
				,t.getMglTransaktionsTyp());
		assertEquals("Transaktion Mitglied Austrittsdatum hat nicht den angegebenen Wert " + austritt
				,austritt
				,((MglTransaktionInhaltDate)t.getMglInhalt()).getInhalt());
	}

}
