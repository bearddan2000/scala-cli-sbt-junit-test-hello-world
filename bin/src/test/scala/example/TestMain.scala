package example;

import org.junit.Test;

import org.junit.Assert.assertEquals;

class TestMain {
    @Test
    def getGreeting(): Unit = {
        val test = example.Main.greeting("Steve");
        val expected = "Hello World, Steve";
        assertEquals(expected, test);
    }
}
