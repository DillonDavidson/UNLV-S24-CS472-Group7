package nl.tudelft.jpacman.level;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test if points get added
 *
 * @author Dillon Davidson
 */
public class AddPointsTest
{
    private static final PacManSprites someSprites = new PacManSprites();
    private PlayerFactory someFactory = new PlayerFactory(someSprites);
    private Player somePlayer = someFactory.createPacMan();

    @Test
    void testAddPoints()
    {
        somePlayer.addPoints(1);
        assertThat(somePlayer.getScore()).isEqualTo(1);
    }
}
