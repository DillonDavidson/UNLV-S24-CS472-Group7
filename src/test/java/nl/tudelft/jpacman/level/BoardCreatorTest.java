package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.points.DefaultPointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test if board is created properly
 *
 * @author Dillon Davidson
 */
public class BoardCreatorTest
{
    private static final PacManSprites someSprites = new PacManSprites();
    private static final GhostFactory someGhostFactory = new GhostFactory(someSprites);
    private static final DefaultPointCalculator someCalculator = new DefaultPointCalculator();
    private LevelFactory someLevelFactory = new LevelFactory(someSprites, someGhostFactory, someCalculator);
    private BoardFactory someBoardFactory = new BoardFactory(someSprites);
    private MapParser someMapParser = new MapParser(someLevelFactory, someBoardFactory);

    @Test
    void testGetBoardCreator()
    {
        assertThat(someMapParser.getBoardCreator()).isEqualTo(someBoardFactory);
    }
}
