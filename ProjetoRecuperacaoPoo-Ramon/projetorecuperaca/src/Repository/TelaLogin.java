//package Repository;
//import Model.*;
//
//
//import javax.swing.*;
//
//
//public class TelaLogin {
//
//    public static void exibirTelaLogin() {
//        JTextField usernameField = new JTextField();
//        JPasswordField passwordField = new JPasswordField();
//
//        Object[] message = {
//                "Login:", usernameField, //professor
//                "Senha:", passwordField //123
//        };
//
//        int option = JOptionPane.showConfirmDialog(null, message,
//                "Tela de Login", JOptionPane.OK_CANCEL_OPTION);
//
//        if (option == JOptionPane.OK_OPTION) {
//            String username = usernameField.getText();
//            String password = new String(passwordField.getPassword());
//
//            if (verificarCredenciais(username, password)) {
//                chamaMenuPrincipal();
//            } else {
//                JOptionPane.showMessageDialog(null,
//                        "Credenciais inválidas. Tente novamente.", "Erro de login", JOptionPane.ERROR_MESSAGE);
//                exibirTelaLogin();
//            }
//        } else {
//            System.exit(0);
//        }
//    }
//
//    private static void chamaMenuPrincipal() {
//
//    }
//
//
//    public static boolean verificarCredenciais(String username, String password) {
//        return username.equals("professor") && password.equals("123");
//    }
//
//}