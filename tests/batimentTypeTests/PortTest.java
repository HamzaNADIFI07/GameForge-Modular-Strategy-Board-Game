package batimentTypeTests;
import tuile.Tuile;
import tuile.type_tuile.Champ;
import tuile.type_tuile.Mer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import batiment.type_batiment.Port;
public class PortTest {


	@Test
	public void testPortCreation() {
		Tuile champTuile = new Champ(3, 2);
		Port port = new Port(champTuile);
		assertNotNull(port);
		assertEquals("Port", port.getType());
		assertEquals(champTuile, port.getTuile());
	}

}
