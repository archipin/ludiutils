package com.archipin.ludiutils.service;

import com.archipin.ludiutils.domain.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class NumberServiceTest {
    @InjectMocks
    NumberService numberService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void truncate() {
        assertThat(numberService.truncate(5.014f, 2)).isEqualTo(5.01f);
    }

    @Test
    void testEquals() {
    }

    @Test
    void convertLevel() {
        Level level = numberService.convertLevel(1.7f);
        assertThat(level.getMajor()).isEqualTo(1);
        assertThat(level.getMinor()).isEqualTo(70);
        Level level1 = numberService.convertLevel(2.034f);
        assertThat(level1.getMajor()).isEqualTo(2);
        assertThat(level1.getMinor()).isEqualTo(3);
    }
}