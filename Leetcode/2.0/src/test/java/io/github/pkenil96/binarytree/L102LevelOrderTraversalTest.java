package io.github.pkenil96.binarytree;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class L102LevelOrderTraversalTest {

	@Test
	void levelOrderTest() {
		L102LevelOrderTraversal obj = new L102LevelOrderTraversal();
		List<List<Integer>> op1 = new ArrayList<>();
		op1.add(Arrays.asList(3));
		op1.add(Arrays.asList(9, 20));
		op1.add(Arrays.asList(15, 7));
		
		assertAll(
				() -> assertEquals(Arrays.asList(3,9,20,null,null,15,7), op1)
				);
	}

}
