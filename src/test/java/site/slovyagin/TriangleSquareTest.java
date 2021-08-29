package site.slovyagin;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.slovyagin.Utils.TimingExtention;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static site.slovyagin.TriangleSquare.triangleSquare;

@ExtendWith(TimingExtention.class)
public class TriangleSquareTest {

    private static Logger logger = LoggerFactory.getLogger(TriangleSquareTest.class);

    @BeforeAll
    static void beforeAll() {
        logger.info("tests started");
    }

    @Test
    @DisplayName("Проверка метода triangleSquare при передаче отрицательного либо нулевого значения")
    void testGivenNullOrMinusSideWhenTriangleSquareThenException() {
        assertAll(
                () -> assertThatExceptionOfType(IncorectSideException.class).isThrownBy(() -> triangleSquare(0, 1, 1)),
                () -> assertThatExceptionOfType(IncorectSideException.class).isThrownBy(() -> triangleSquare(-1, 1, 1)),
                () -> assertThatExceptionOfType(IncorectSideException.class).isThrownBy(() -> triangleSquare(-1, -1, 1)),
                () -> assertThatExceptionOfType(IncorectSideException.class).isThrownBy(() -> triangleSquare(0, -1, 0))
        );
    }

    @Test
    @DisplayName("Проверка метода triangleSquare с целыми числами и целым результатом")
    void testGivenIntegersSidesWhenTriangleSquareThenCorrectResult() throws IncorectSideException {
        assertEquals(triangleSquare(6, 8, 10), 24);
    }

    @Test
    @DisplayName("Проверка метода triangleSquare при получении нецелового значения")
    void testGivenSidesWhenTriangleSquareThenDoubleResult() throws IncorectSideException {
        assertEquals(triangleSquare(6, 5, 2.2), (double) 5.28);
    }

    @Test
    @DisplayName("Проверка метода triangleSquare при передаче сторон не образующих треугольник")
    void testGivenIncorrectSidesWhenTriangleSquareThenException() {
        assertThatExceptionOfType(IncorectSideException.class).isThrownBy(() -> triangleSquare(1, 2, 1));
    }

    @AfterAll
    static void afterAll() {
        logger.info("tests completeds");
    }
}