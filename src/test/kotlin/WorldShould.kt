import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class WorldShould {

    @Test
    fun `find islands`() {
        assertThat(`number of islands`(arrayOf(
            charArrayOf('1'),
        ))).isEqualTo(1)
    }
}