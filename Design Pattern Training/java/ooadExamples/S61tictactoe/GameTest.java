package tictactoe;
import static org.hamcrest.core.Is.is;

public class GameTest {
    Game sut = new Game();
    @Test
    public void leftDiagonalTest() {
        assertThat(sut.isOver(), is(false));
        sut.putO(0, 0);
        assertThat(sut.isOver(), is(false));
        sut.putO(1, 1);
        assertThat(sut.isOver(), is(false));
        sut.putO(2, 2);
        assertThat(sut.isOver(), is(true));
    }
    @Test
    public void rightDiagonalTest() {
        assertThat(sut.isOver(), is(false));
        sut.putX(0, 2);
        assertThat(sut.isOver(), is(false));
        sut.putX(1, 1);
        assertThat(sut.isOver(), is(false));
        sut.putX(2, 0);
        assertThat(sut.isOver(), is(true));
    }
    @Test
    public void rowDone() {
        assertThat(sut.isOver(), is(false));
        sut.putO(1, 0);
        assertThat(sut.isOver(), is(false));
        sut.putO(1, 1);
        assertThat(sut.isOver(), is(false));
        sut.putO(1, 2);
        assertThat(sut.isOver(), is(true));
    }
    @Test
    public void colDone() {
        assertThat(sut.isOver(), is(false));
        sut.putX(1, 0);
        assertThat(sut.isOver(), is(false));
        sut.putX(1, 1);
        assertThat(sut.isOver(), is(false));
        sut.putX(1, 2);
        assertThat(sut.isOver(), is(true));
    }
    @Test
    public void boardCompleted() {
        assertThat(sut.isOver(), is(false));
        sut.putX(0, 0);
        assertThat(sut.isOver(), is(false));
        sut.putX(0, 1);
        assertThat(sut.isOver(), is(false));
        sut.putO(0, 2);
        assertThat(sut.isOver(), is(false));
        sut.putO(1, 0);
        assertThat(sut.isOver(), is(false));
        sut.putO(1, 1);
        assertThat(sut.isOver(), is(false));
        sut.putX(1, 2);
        assertThat(sut.isOver(), is(false));
        sut.putX(2, 0);
        assertThat(sut.isOver(), is(false));
        sut.putO(2, 1);
        assertThat(sut.isOver(), is(false));
        sut.putX(2, 2);
        assertThat(sut.isOver(), is(true));
    }
}
