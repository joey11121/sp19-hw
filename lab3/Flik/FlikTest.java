import org.junit.Test;
import static org.junit.Assert.*;

public class FlikTest {

    @Test
    public void isSameNumberTest(){
        int a = 128, b = 128;
        assertTrue("a and b are different", Flik.isSameNumber(a, b));
    }

}
