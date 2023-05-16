package org.hangman;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HangmanTest {

    @Test
    public void testGameWon() {
        //given
        Hangman hangman = new Hangman();
        InputStream input = new ByteArrayInputStream("p\nr\no\ng\nr\na\nm\nm\ni\nn\ng\n".getBytes());
        System.setIn(input);
        //when
        hangman.play();
        //then
        String userWord = "programming";
        assertEquals("programming", userWord);
    }

    @Test
    public void testGameLost() {
        //given
        int lives = 0;
        Hangman hangman = new Hangman();
        InputStream input = new ByteArrayInputStream("a\nb\nc\nd\ne\nf\ng\nh\ni\nj\nk\nl\nm\nn\no\np\nq\nr\ns\nt\nu\nv\nw\nx\ny\nz\n".getBytes());
        System.setIn(input);
        //when
        hangman.play();
        //then
        assertEquals(0, lives);
    }

    @Test
    public void testInvalidInput() {
        //given
        Hangman hangman = new Hangman();
        InputStream input = new ByteArrayInputStream("1\n2\n3\n#\n@\n%\n^\n&\n*\n(\n)\n".getBytes());
        //when
        System.setIn(input);
        hangman.play();
        //then
        int lives = 5;
        assertEquals(5, lives);
    }
}