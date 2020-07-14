import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        OffByOne obo = new OffByOne();
        assertTrue("The test is not passed since it must be true.", obo.equalChars('a', 'b'));
        assertFalse("The test is not passed since it must be false.", obo.equalChars('b', 'd'));

    }
}