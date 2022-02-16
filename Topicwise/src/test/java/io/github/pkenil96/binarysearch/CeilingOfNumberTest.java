package io.github.pkenil96.binarysearch;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.Test;

public class CeilingOfNumberTest {

	@Test
	public void ceilTest() {
		CeilingOfNumber obj = new CeilingOfNumber();
		assertAll(
				() -> assertEquals(14, obj.ceil(new int[] {2, 3, 5, 9, 14, 16, 18}, 14)),
				() -> assertEquals(2, obj.ceil(new int[] {2, 3, 5, 9, 14, 16, 18}, 0)),
				() -> assertEquals(null, obj.ceil(new int[] {2, 3, 5, 9, 14, 16, 18}, 100))
		);
	}
}
