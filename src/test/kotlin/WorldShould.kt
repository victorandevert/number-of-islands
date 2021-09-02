import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(PER_CLASS)
class WorldShould {

    @ParameterizedTest
    @MethodSource("grids")
    fun `find islands`(grid: Array<CharArray>, islands: Int) {
        assertThat(`number of islands`(grid)).isEqualTo(islands)
    }

    private fun grids(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(arrayOf(charArrayOf('1')), 1),
            Arguments.of(arrayOf(charArrayOf('1','1')), 1),
            Arguments.of(arrayOf(charArrayOf('1','1','0','1')), 2),
            Arguments.of(arrayOf(
                charArrayOf('1','0'),
                charArrayOf('0','1')), 2),
            Arguments.of(arrayOf(
                charArrayOf('1','1','1','1','0'),
                charArrayOf('1','1','0','1','0'),
                charArrayOf('1','1','0','0','0'),
                charArrayOf('0','0','0','0','0')), 1),
            Arguments.of(arrayOf(
                charArrayOf('1','1','0','0','0'),
                charArrayOf('1','1','0','0','0'),
                charArrayOf('0','0','1','0','0'),
                charArrayOf('0','0','0','1','1')), 3),
            Arguments.of(arrayOf(
                charArrayOf('1','0','0','0','0','0'),
                charArrayOf('0','1','0','1','1','1'),
                charArrayOf('0','0','1','0','1','0'),
                charArrayOf('1','1','0','0','1','0'),
                charArrayOf('1','0','1','1','0','0'),
                charArrayOf('1','0','0','0','0','1')), 7),
            Arguments.of(arrayOf(
                charArrayOf('1','0','1','0','0'),
                charArrayOf('1','0','0','0','0'),
                charArrayOf('0','0','1','0','0'),
                charArrayOf('0','0','0','1','1')), 4),
        )
    }
}