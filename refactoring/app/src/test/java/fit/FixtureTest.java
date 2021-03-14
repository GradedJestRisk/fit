package fit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FixtureTest {
	@Test public void testEscape() {
		assertEquals(" &nbsp; &nbsp; ", Fixture.escape("     "));
	}
}
