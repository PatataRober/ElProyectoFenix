import java.util.ArrayList;
import java.util.List;

public class ProcesadorUsuarios {

    private static final int ROL_ADMIN = 1;
    private static final int ROL_INVITADO = 2;

    // Método con 'code smells': largo, números mágicos, malos nombres.
    public String procesarLista(List<String> usuarios) {
        String admins = "";
        String invitados = "";

        for (String u : usuarios) {
            String[] parts = u.split(":"); // Formato "nombre:rol"
            if (parts.length == 2) {
                String nombre = parts[0];
                int rol = Integer.parseInt(parts[1]);

                if (rol == ROL_ADMIN) {
                    admins = procesarAdmin(admins, nombre);
                }
                else if (rol == ROL_INVITADO) {
                    invitados = procesarInvitado(invitados, nombre);
                }
            }
        }
        return "Admins: " + admins + " | Invitados: " + invitados;
    }
    private String procesarAdmin(String admins, String nombre) {
        admins += nombre + ",";
        return admins;
    }
    private String procesarInvitado(String invitados, String nombre) {
        invitados += nombre + ",";
        return invitados;
    }
}
