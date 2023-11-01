import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void returns_zero_for_empty_String(){
        Assertions.assertThat(Calculator.add("")).isEqualTo(0);
    }

    @Test
    public void returns_number_for_one_number(){
        Assertions.assertThat(Calculator.add("6")).isEqualTo(6);
    }

//    @Test
//    public void returns(){
//        Assertions.assertThat(Calculator.add())
//    }

//    @Test
//    public void returns(){
//        Assertions.assertThat(Calculator.add())
//    }
}
