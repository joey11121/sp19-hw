import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue("The test is not passed since it must be true.", offByOne.equalChars('a', 'b'));
        assertFalse("The test is not passed since it must be false.", offByOne.equalChars('b', 'd'));

    }
}
