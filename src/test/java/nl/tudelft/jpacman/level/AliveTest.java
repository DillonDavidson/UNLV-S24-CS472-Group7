package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test if the player is alive
 *
 * @author Dillon Davidson
 */
public class AliveTest
{
    private static final PacManSprites someSprites = new PacManSprites();
    private PlayerFactory someFactory = new PlayerFactory(someSprites);
    private Player somePlayer = someFactory.createPacMan();

    @Test
    void testIsAlive()
    {
        assertThat(somePlayer.isAlive()).isEqualTo(true);
    }
}
