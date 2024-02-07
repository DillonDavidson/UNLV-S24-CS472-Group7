package nl.tudelft.jpacman.game;

import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test if game factory is returned
 *
 * @author Dillon Davidson
 */
public class GameFactoryTest
{
    private static final PacManSprites someSprites = new PacManSprites();
    private PlayerFactory someFactory = new PlayerFactory(someSprites);
    private GameFactory someGameFactory = new GameFactory(someFactory);

    @Test
    void testGetPlayerFactory()
    {
        assertThat(someGameFactory.getPlayerFactory()).isEqualTo(someFactory);
    }
}
