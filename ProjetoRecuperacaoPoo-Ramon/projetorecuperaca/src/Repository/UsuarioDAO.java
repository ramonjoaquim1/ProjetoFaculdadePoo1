package Repository;

import Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public final class UsuarioDAO {

    public static List<Usuario> findUsuariosSistema() {
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setLogin("professor1");
        usuario.setSenha("123");

        Usuario usuario1 = new Usuario();
        usuario1.setLogin("professor2");
        usuario1.setSenha("123");
        usuarios.add(usuario);
        usuarios.add(usuario1);

        return usuarios;
    }

    public static Object[] findUsuariosSistemaInArray() {
        List<Usuario> usuarios = findUsuariosSistema();
        List<String> usuariosLogins = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            usuariosLogins.add(usuario.getLogin());
        }

        return usuariosLogins.toArray();
    }

    public static Usuario findUsuarioByLogin(String login) {
        List<Usuario> usuariosSistema = findUsuariosSistema();

        for (Usuario usuario : usuariosSistema) {
            if (login.equals(login)) {
                return usuario;
            }
        }
        return null;
    }

}