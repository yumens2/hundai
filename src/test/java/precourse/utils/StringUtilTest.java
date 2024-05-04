package precourse.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class StringUtilTest{
    @ParameterizedTest(name = "중복된 문자가 없는지 확인")
    @MethodSource("provide4TestBeingEachCharUnique")
    void testBeingEachCharUnique(String str, boolean bool){
        assertEquals(bool, StringUtil.isEachCharUnique(str));
    }
    static Stream<Arguments> provide4TestBeingEachCharUnique(){
        return Stream.of(
                Arguments.of("12453", true),
                Arguments.of("ㅁㅇㄴㄹㅊ", true),
                Arguments.of("", true),
                Arguments.of("1233", false),
                Arguments.of("11", false)
        );
    }
}
