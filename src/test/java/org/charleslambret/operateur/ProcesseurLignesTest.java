package org.charleslambret.operateur;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.BufferedWriter;
import java.io.IOException;

import static org.mockito.Mockito.*;

class ProcesseurLignesTest {

    @Test
    void processLineValidInput() throws IOException, OperationException {
        BufferedWriter writer = mock(BufferedWriter.class);
        ProcesseurLignes.processLine("2 3 +", writer);
        verify(writer).write("5.0\n");
    }

    @Test
    void processLineInvalidFormat() throws IOException {
        BufferedWriter writer = mock(BufferedWriter.class);
        ProcesseurLignes.processLine("invalid input", writer);
        verify(writer).write("ERROR\n");
    }
}
