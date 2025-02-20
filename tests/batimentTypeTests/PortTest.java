package batimentTypeTests;
import tuile.Tuile;
import tuile.type_tuile.Champ;
import tuile.type_tuile.Mer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
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
	@Test
	public void testPortPeutEtreConstruit() {
		Tuile merTuile = new Mer(3, 3);
		Tuile champTuile = new Champ(3, 2);
		List<Tuile> champAdjacents = champTuile.getAdjacents();
		champAdjacents.add(merTuile);
		Port port = new Port(champTuile);
		assertTrue(port.peutEtreConstruit(), "Un port doit être adjacent à une tuile Mer");
	}
}
