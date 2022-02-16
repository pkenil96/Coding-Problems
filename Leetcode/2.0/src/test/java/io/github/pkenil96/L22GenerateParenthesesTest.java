package io.github.pkenil96;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.github.pkenil96.backtracking.L22GenerateParentheses;

class L22GenerateParenthesesTest {

	@Test
	public void testGenerateParentheses() {
		L22GenerateParentheses obj = new L22GenerateParentheses();
		List<String> expected = Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf");
		assertAll(
			    () -> assertEquals(Arrays.asList("((()))","(()())","(())()","()(())","()()()"), obj.generateParenthesis(3)),
			    () -> assertEquals(Arrays.asList("()"), obj.generateParenthesis(1))
		);
	}

}
