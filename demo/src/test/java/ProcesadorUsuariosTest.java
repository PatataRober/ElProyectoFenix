import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ProcesadorUsuariosTest {

    @Test
    void testProcesarLista_DebeSepararAdminsEInvitados() {
        ProcesadorUsuarios procesador = new ProcesadorUsuarios();
        List<String> datosEntrada = Arrays.asList(
            "Ana:1",
            "Pedro:2",
            "Luis:1",
            "Marta:2"
        );

        String resultado = procesador.procesarLista(datosEntrada);

        String esperado = "Admins: Ana,Luis, | Invitados: Pedro,Marta,";
        assertEquals(esperado, resultado, "El procesamiento de la lista no coincide con el comportamiento actual.");
    }
}