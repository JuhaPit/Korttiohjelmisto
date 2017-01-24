package fi.juha.korttiohjelmisto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.juha.korttiohjelmisto.bean.Osoite;

public class OsoiteDAO {

	/**
	 * Konstruktori lataa tietokantayhteyden ajurin
	 */
	public OsoiteDAO() throws DAOPoikkeus {
		try {
			Class.forName(
					DBConnectionProperties.getInstance().getProperty("driver"))
					.newInstance();
		} catch (Exception e) {
			throw new DAOPoikkeus("Tietokannan ajuria ei kyetty lataamaan.", e);
		}
	}

	/**
	 * Avaa tietokantayhteyden
	 * 
	 * @return avatun tietokantayhteyden
	 * @throws Exception
	 *             Mik�li yhteyden avaaminen ei onnistu
	 */
	private Connection avaaYhteys() throws DAOPoikkeus {

		try {
			return DriverManager.getConnection(DBConnectionProperties
					.getInstance().getProperty("url"), DBConnectionProperties
					.getInstance().getProperty("username"),
					DBConnectionProperties.getInstance()
							.getProperty("password"));
		} catch (Exception e) {
			throw new DAOPoikkeus("Tietokantayhteyden avaaminen ep�onnistui", e);
		}
	}

	/**
	 * Sulkee tietokantayhteyden
	 * 
	 * @param yhteys
	 *            Suljettava yhteys
	 */
	private void suljeYhteys(Connection yhteys) throws DAOPoikkeus {
		try {
			if (yhteys != null && !yhteys.isClosed())
				yhteys.close();
		} catch (Exception e) {
			throw new DAOPoikkeus(
					"Tietokantayhteys ei jostain syyst� suostu menem��n kiinni.",
					e);
		}
	}

	/**
	 * Hakee kaikki henkil�t kannasta
	 * 
	 * @return listallinen henkil�it�
	 */
	public List<Osoite> haeKaikki() throws DAOPoikkeus {

		ArrayList<Osoite> osoitteet = new ArrayList<Osoite>();

		// avataan yhteys
		Connection yhteys = avaaYhteys();

		try {

			// suoritetaan haku
			String sql = "select id, henkilonNimi, osoite, postinro, postitmp from osoitteet";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);

			// k�yd��n hakutulokset l�pi
			while (tulokset.next()) {
				int id = tulokset.getInt("id");
				String henkilonNimi = tulokset.getString("henkilonNimi");
				String osoite = tulokset.getString("osoite");
				String postinro = tulokset.getString("postinro");
				String postitmp = tulokset.getString("postitmp");

				// lis�t��n henkil� listaan
				Osoite o = new Osoite(id, henkilonNimi, osoite, postinro,
						postitmp);
				osoitteet.add(o);
			}

		} catch (Exception e) {
			// JOTAIN VIRHETT� TAPAHTUI
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		} finally {
			// LOPULTA AINA SULJETAAN YHTEYS
			suljeYhteys(yhteys);
		}

		System.out.println("HAETTIIN TIETOKANNASTA HENKIL�T: "
				+ osoitteet.toString());

		return osoitteet;
	}

	/**
	 * Lis�� henkil�n tietokantaan
	 * 
	 * @param h
	 *            Lis�tt�v�n henkil�n tiedot
	 */
	public void lisaa(Osoite o) throws DAOPoikkeus {

		// avataan yhteys
		Connection yhteys = avaaYhteys();

		try {

			// suoritetaan haku

			// alustetaan sql-lause
			String sql = "insert into osoitteet(henkilonNimi, osoite, postinro, postitmp) values(?,?,?,?)";
			PreparedStatement lause = yhteys.prepareStatement(sql);

			// t�ytet��n puuttuvat tiedot
			lause.setString(1, o.getHenkilonNimi());
			lause.setString(2, o.getOsoite());
			lause.setString(3, o.getPostinro());
			lause.setString(4, o.getPostitmp());

			// suoritetaan lause
			lause.executeUpdate();
			System.out.println("LIS�TTIIN HENKIL� TIETOKANTAAN: " + o);
		} catch (Exception e) {
			// JOTAIN VIRHETT� TAPAHTUI
			throw new DAOPoikkeus("Henkil�n lis��misyritys aiheutti virheen", e);
		} finally {
			// LOPULTA AINA SULJETAAN YHTEYS
			suljeYhteys(yhteys);
		}

	}
	
	public List<Osoite> hae(String peruste, String haku) throws DAOPoikkeus {

		ArrayList<Osoite> osoitteet = new ArrayList<Osoite>();

		// avataan yhteys
		Connection yhteys = avaaYhteys();

		try {

			// suoritetaan haku
			String sql = "select id, henkilonNimi, osoite, postinro, postitmp from osoitteet where " + peruste + "='" + haku + "'";
			Statement hakuSQL = yhteys.createStatement();
			ResultSet tulokset = hakuSQL.executeQuery(sql);

			// k�yd��n hakutulokset l�pi
			while (tulokset.next()) {
				int id = tulokset.getInt("id");
				String henkilonNimi = tulokset.getString("henkilonNimi");
				String osoite = tulokset.getString("osoite");
				String postinro = tulokset.getString("postinro");
				String postitmp = tulokset.getString("postitmp");

				// lis�t��n henkil� listaan
				Osoite o = new Osoite(id, henkilonNimi, osoite, postinro,
						postitmp);
				osoitteet.add(o);
			}

		} catch (Exception e) {
			// JOTAIN VIRHETT� TAPAHTUI
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		} finally {
			// LOPULTA AINA SULJETAAN YHTEYS
			suljeYhteys(yhteys);
		}

		System.out.println("HAETTIIN TIETOKANNASTA HENKIL�T: "
				+ osoitteet.toString());

		return osoitteet;
	}
	


}
