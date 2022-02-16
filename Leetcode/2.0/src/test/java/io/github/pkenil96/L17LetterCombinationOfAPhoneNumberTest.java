package io.github.pkenil96;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import io.github.pkenil96.backtracking.L17LetterCombinationsOfAPhoneNumber;

public class L17LetterCombinationOfAPhoneNumberTest {

	@Test
	public void testLetterCombinations() {
		L17LetterCombinationsOfAPhoneNumber obj = new L17LetterCombinationsOfAPhoneNumber();
		List<String> expected = Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf");
		assertAll(
			    () -> assertEquals(Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf"), obj.letterCombinations("23")),
			    () -> assertEquals(Arrays.asList("a","b","c"), obj.letterCombinations("2")),
			    () -> assertEquals(Arrays.asList(), obj.letterCombinations(""))
		);
	}

}
