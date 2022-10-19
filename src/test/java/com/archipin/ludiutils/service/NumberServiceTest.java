package com.archipin.ludiutils.service;

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
}