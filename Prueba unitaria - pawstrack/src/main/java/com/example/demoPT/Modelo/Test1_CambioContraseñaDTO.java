package com.example.demoPT.Modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Test1_CambioContraseñaDTO {

    @Test
    void testConstructorConParametros() {
        CambioContrasenaDTO dto = new CambioContrasenaDTO("actual123", "nueva456", "nueva456");

        assertEquals("actual123", dto.getCurrentPassword());
        assertEquals("nueva456", dto.getNewPassword());
        assertEquals("nueva456", dto.getConfirmPassword());
    }

    @Test
    void testSettersYGetters() {
        CambioContrasenaDTO dto = new CambioContrasenaDTO();

        dto.setCurrentPassword("vieja");
        dto.setNewPassword("nueva");
        dto.setConfirmPassword("nueva");

        assertEquals("vieja", dto.getCurrentPassword());
        assertEquals("nueva", dto.getNewPassword());
        assertEquals("nueva", dto.getConfirmPassword());
    }
}
