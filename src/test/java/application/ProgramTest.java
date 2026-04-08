package application;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;

import org.junit.jupiter.api.Test;

class ProgramTest {

    @Test
    void mainDeveExecutarSemExcecao() {
        assertTimeoutPreemptively(Duration.ofSeconds(5), () -> Program.main(new String[0]));
    }
}
