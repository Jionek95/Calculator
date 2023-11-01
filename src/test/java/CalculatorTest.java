import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void returns(){
        Assertions.assertThat(Calculator.add("")).isEqualTo(0);
    }    

//    @Test
//    public void returns(){
//        Assertions.assertThat(Calculator.add())
//    }

//    @Test
//    public void returns(){
//        Assertions.assertThat(Calculator.add())
//    }

//    @Test
//    public void returns(){
//        Assertions.assertThat(Calculator.add())
//    }
}
