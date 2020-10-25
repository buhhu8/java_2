package ru.levelup.lessons.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    // test<ИмяМетода>_when<>_<then>
    @DisplayName("Should return true if value is null")
    public void testIsEmpty_whenValueIsNull_thenReturnTrue() {
        //given
        //String value = null;
        //when
        boolean result = StringUtils.isEmpty(null);

        //then
        Assertions.assertTrue(result);
    }

    @Test
    public void testIsEmpty_whenValueIsEmptyString_thenReturnTrue(){
        //given
        String value = "";
        //when
        boolean result = StringUtils.isEmpty(value);
        //then
        Assertions.assertTrue(result);

    }

    @Test
    public void testIsEmpty_whenValueConsistsOnlyFromWhitespaces_thenReturnTrue(){
        String value= "    ";
        boolean result = StringUtils.isEmpty(value);
        Assertions.assertTrue(result);

    }

    @Test
    public void testIsEmpty_whenValueHasSymbols_thenReturnFalse(){
        String value = "value";
        boolean result = StringUtils.isEmpty(value);
        Assertions.assertFalse(result);
    }

    @Test
    public void testRequiredEmpty_whenValueIsNull_thenThrowException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> StringUtils.requiredNotEmpty(null));

    }
}
