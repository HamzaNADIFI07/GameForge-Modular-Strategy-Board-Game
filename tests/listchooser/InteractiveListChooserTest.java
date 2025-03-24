package listchooser;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class InteractiveListChooserTest {
	 private final List<String> options = Arrays.asList("apple", "banana", "cherry");
	 private final InputStream originalIn = System.in;
	@Test
	void testValidChoice() {
		String simulatedInput = "1\n";
		System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
		InteractiveListChooser chooser = new InteractiveListChooser();
		String result = chooser.choose("Choose a fruit:", options);
		assertEquals("banana", result);
	}
	

}
