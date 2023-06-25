import Model.*;
import Repository.*;
import Relatorios.*;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import static Repository.AlunoDAO.calcularMedia;

public class Main {
    public static void main(String[] args) {

        exibirMensagemBoasVindas();
        chamaMenuPrincipal();

    }

    public static void exibirMensagemBoasVindas() {
        JOptionPane.showOptionDialog(null, "Bem vindo ao Sistema Notas Escolares",
                "Mensagem de Boas-vindas", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                new String[]{"Entrar"}, "Entrar");
    }

    public static void chamaMenuPrincipal() {
        String[] opcoesMenu = {"Cadastrar Aluno", "Relatorios de Alunos", "Sair"};
        int opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Principal",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu, opcoesMenu[0]);

        switch (opcao) {
            case 0: //Cadastrar Aluno
                chamaMenuAluno();
                break;

            case 1: //Relatorios de Alunos
                chamaRelatorioAluno();
                break;

            case 2: //Sair
                int opcaoS = JOptionPane.showOptionDialog(null, " Deseja realmente sair ? ",
                        "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null,
                        null);

                if (opcaoS == JOptionPane.YES_NO_OPTION) {
                    System.exit(0);
                } else {
                    chamaMenuPrincipal();
                }
        }
    }

    public static void chamaMenuAluno() {
        String[] opcoesMenuHospede = {"Inserir Aluno", "Voltar"};
        int opcao = 0;
        opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu de cadastros ALUNO",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuHospede, opcoesMenuHospede[0]
        );

        switch (opcao) {
            case 0: // Cadastrar Aluno
                chamaCadastrarAluno();
                break;
            case 1: // Voltar
                chamaMenuPrincipal();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    public static void chamaCadastrarAluno() {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do aluno");
        if (nome == null) {
            chamaMenuPrincipal();
        }
        String email = JOptionPane.showInputDialog(null, "Digite o email do aluno");
        if (email == null) {
            chamaMenuPrincipal();
        }
        String telefone = JOptionPane.showInputDialog(null, "Digite o telefone do aluno");
        if (telefone == null) {
            chamaMenuPrincipal();
        }
        LocalDate dataNascimento = null;
        String dataNascimentoStr = JOptionPane.showInputDialog(null, "Digite a data de nascimento do Aluno: Ano/Mês/Dia");
        if (dataNascimentoStr == null) {
            chamaMenuPrincipal();
        } else {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Data de nascimento inválida! Use o formato: Ano/Mês/Dia");
                chamaMenuPrincipal();
            }
        }

        BigDecimal nota1 = BigDecimal.valueOf(Long.parseLong( JOptionPane.showInputDialog(null, "Digite a 1° nota do Aluno")));
        if (nota1 == null) {
            chamaMenuPrincipal();
        }
        BigDecimal nota2 = BigDecimal.valueOf(Long.parseLong(JOptionPane.showInputDialog(null, "Digite a 2° nota do Aluno")));
        if (nota2 == null) {
            chamaMenuPrincipal();
        }
        BigDecimal nota3 = BigDecimal.valueOf(Long.parseLong(JOptionPane.showInputDialog(null, "Digite a 3° nota do Aluno")));
        if (nota3 == null) {
            chamaMenuPrincipal();
        }
        BigDecimal nota4 = BigDecimal.valueOf(Long.parseLong(JOptionPane.showInputDialog(null, "Digite a 4° nota do Aluno")));
        if (nota4 == null) {
            chamaMenuPrincipal();
        }

        BigDecimal media = calcularMedia(nota1, nota2, nota3, nota4);
        boolean aprovacao = verificarAprovacao(media);

        String mensagem = "Aluno cadastrado com sucesso!\n\n";
        mensagem += "Nome: " + nome + "\n";
        mensagem += "Email: " + email + "\n";
        mensagem += "Telefone: " + telefone + "\n";
        mensagem += "Data de Nascimento: " + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n";
        mensagem += "Nota 1: " + nota1 + "\n";
        mensagem += "Nota 2: " + nota2 + "\n";
        mensagem += "Nota 3: " + nota3 + "\n";
        mensagem += "Nota 4: " + nota4 + "\n";
        mensagem += "Média: " + media + "\n";
        mensagem += "Aprovado: " + (aprovacao ? "Sim, Parabens!" : "Não, seu burro. Vai estudar!") + "\n";

        JOptionPane.showMessageDialog(null, mensagem);

        Aluno aluno = new Aluno(nome, email, telefone, dataNascimento, nota1, nota2, nota3, nota4, media, aprovacao);
        aluno.setMedia(media);
        aluno.setAprovacao(aprovacao);

        AlunoDAO.salvar(aluno);
        chamaMenuPrincipal();
    }

    private static boolean verificarAprovacao(BigDecimal media) {
        BigDecimal mediaMinima = BigDecimal.valueOf(6.0);
        return media.compareTo(mediaMinima) >= 0;
    }

    public static void chamaRelatorioAluno() {
            List<Aluno> alunos = AlunoDAO.buscaTodosa();
            RelatorioAlunoForm.emitirRelatorio(alunos);
    }
}