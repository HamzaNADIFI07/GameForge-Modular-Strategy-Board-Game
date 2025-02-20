package batimentTypeTests;
import tuile.Tuile;
import tuile.type_tuile.Champ;
import tuile.type_tuile.Mer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import batiment.type_batiment.Port;
import ressource.enumRessource;
public class PortTest {


	@Test
	public void testPortCreation() {
		Tuile champTuile = new Champ(3, 2);
		Port port = new Port(champTuile);
		assertNotNull(port);
		assertEquals("Port", port.getType());
		assertEquals(champTuile, port.getTuile());
	}
	@Test
	public void testPortCout() {
		Tuile champTuile = new Champ(3, 2);
		Port port = new Port(champTuile);
		Map<enumRessource, Integer> cout = port.getCout();
		assertEquals(1, cout.get(enumRessource.Bois), "Un port coûte 1 bois");
		assertEquals(2, cout.get(enumRessource.Moutons), "Un port coûte 2 moutons");
	}

}
