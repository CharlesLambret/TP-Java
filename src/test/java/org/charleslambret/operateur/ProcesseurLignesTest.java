package org.charleslambret.operateur;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;

class ProcesseurLignesTest {

    @Test
    void processLineValidInput() throws IOException, OperationException {
        StringWriter stringWriter = new StringWriter();
        BufferedWriter writer = new BufferedWriter(stringWriter);

        ProcesseurLignes.processLine("2 3 +", writer);
        writer.flush(); 

        assertEquals("5.0\n", stringWriter.toString());
    }

    @Test
    void processLineInvalidFormat() throws IOException {
        StringWriter stringWriter = new StringWriter();
        BufferedWriter writer = new BufferedWriter(stringWriter);

        ProcesseurLignes.processLine("invalid input", writer);
        writer.flush();  

        assertEquals("ERROR\n", stringWriter.toString());
    }
}
