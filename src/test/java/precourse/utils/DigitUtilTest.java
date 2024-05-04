package precourse.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DigitUtilTest {
    @ParameterizedTest(name = "만들어낸 숫자 문자열에 중복된 문자가 없는지 확인")
    @ValueSource(ints = {1, 5, 9})
    void testCreatingUniqueDigits(int length){
        assertTrue(StringUtil.isEachCharUnique(
                DigitUtil.createUniqueDigits(length))
        );
    }

    @ParameterizedTest(name = "숫자 문자열이 양수인지 확인")
    @MethodSource("provide4TestBeingDigitsOfPositive")
    void testBeingDigitsOfPositive(String str, boolean bool){
        assertSame(DigitUtil.isDigitsOfPositive(str), bool);
    }

    static Stream<Arguments> provide4TestBeingDigitsOfPositive(){
        return Stream.of(
                Arguments.of("12 3", false),
                Arguments.of("0", false),
                Arguments.of("1d3", false),
                Arguments.of("-123", false),
                Arguments.of("", false),
                Arguments.of("123", true),
                Arguments.of("001", true),
                Arguments.of("001135135135135135135139358584383259", true)
        );
    }

    @ParameterizedTest(name = "한자리의 양수인지 확인")
    @MethodSource("provide4TestBeingOneDigitOfPositive")
    void testBeingOneDigitOfPositive(int length, boolean bool){
        assertSame(DigitUtil.isOneDigitOfPositive(length), bool);
    }

    static Stream<Arguments> provide4TestBeingOneDigitOfPositive(){
        return Stream.of(
                Arguments.of(-1, false),
                Arguments.of(0, false),
                Arguments.of(1, true),
                Arguments.of(9, true),
                Arguments.of(10, false)
        );
    }

}
