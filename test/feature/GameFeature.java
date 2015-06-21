package feature;

import com.senpai.bowling.Game;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameFeature {

    private Game game;

    @Before
    public void init(){
        game = new Game();
    }

}
