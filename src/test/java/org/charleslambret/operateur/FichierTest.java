package org.charleslambret.operateur;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FichierTest {

    @Test
    public void testGetId() {
        Fichier fichier = new Fichier(1, "nom", "type");
        Assertions.assertEquals(1, fichier.getId());
    }

    @Test
    public void testGetNom() {
        Fichier fichier = new Fichier(1, "nom", "type");
        Assertions.assertEquals("nom", fichier.getNom());
    }

    @Test
    public void testGetType() {
        Fichier fichier = new Fichier(1, "nom", "type");
        Assertions.assertEquals("type", fichier.getType());
    }
}
