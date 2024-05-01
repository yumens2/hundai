import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ValidationTest {

    Validation validation = new Validation();

    @Test
    void lengthCheckFail(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->{
                    validation.validateNumber("1234");
                }).withMessage("You must enter a 3-digit number.");
    }

    @Test
    void typeCheckFail(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->{
                    validation.validateNumber("ab1");
                }).withMessage("Input other than integers is not allowed.");
    }

    @Test
    void duplicationCheckFail(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->{
                    validation.validateNumber("112");
                }).withMessage("The inputs must be different integers.");
    }
    @Test
    void checkSuccess(){
        validation.validateNumber("957");
    }

    @Test
    void intCheckFail1(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->{
                    validation.validateInt("a");
                }).withMessage("You must enter 1 or 2.");
    }
    @Test
    void intCheckFail2(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->{
                    validation.validateInt("31");
                }).withMessage("You must enter 1 or 2.");
    }

    @Test
    void intCheckSuccess1(){
       validation.validateInt("1");
       validation.validateInt("2");
    }
}
