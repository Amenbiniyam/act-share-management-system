package com.share.sharemanagementapi;

import com.share.sharemanagementapi.utils.AgeCalculator;
import com.share.sharemanagementapi.utils.DuplicationCheck;
import jakarta.validation.constraints.AssertFalse;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneNumberIsExistTest {

    @Test
    void returnTrueIfPhoneIsExist() {
        String phone = "+251911825671";
        //DuplicationCheck duplicationCheck = new DuplicationCheck();
        Boolean result = DuplicationCheck.findPhoneNumber(phone);
        assertTrue(result);
        //assertTrue(30>16);
    }

    @Test
    void shouldReturnErrorIfDateOfBirthIsNull() {

        LocalDate dateOfBirth = null;
        LocalDate currentDate = LocalDate.of(2023, 3, 23);

//        AgeCalculator ageCalculator = new AgeCalculator();
        Integer result = AgeCalculator.calculateDifference(dateOfBirth, currentDate);

        assertNull(result);
    }

    @Test
    void shouldReturnErrorIfCurrentDateIsNull() {

        LocalDate dateOfBirth = LocalDate.of(2000, 3, 23);
        LocalDate currentDate = null;

//        AgeCalculator ageCalculator = new AgeCalculator();
        Integer result = AgeCalculator.calculateDifference(dateOfBirth, currentDate);

        assertNull(result);
    }
    @Test
    void shouldReturnTheCorrectDifferenceBetweenCurrentDateAndDateOfBirth() {

        LocalDate dateOfBirth = LocalDate.of(1990, 1, 1);
        LocalDate currentDate = LocalDate.of(2023, 3, 23);

//        AgeCalculator ageCalculator = new AgeCalculator();
        Integer result = AgeCalculator.calculateDifference(dateOfBirth, currentDate);

        assertEquals(33, result);
    }
}
