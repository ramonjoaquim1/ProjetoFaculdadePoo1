import Model.*;
import Relatorios.*;
import Repository.*;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;

public class RelatorioAlunoForm extends JPanel {

    private static final long serialVersionUID = 1L;

    public static final String[] nomeColunas =
            {"Nome", "Email", "Telefone", "Data Nascimento", "Nota 1", "Nota 2", "Nota 3", "Nota 4", "Media", "Aprovado",""};

    protected JTable table;
    protected JScrollPane scroller;
    protected RelatorioAluno tabela;

    public RelatorioAlunoForm(Vector<Aluno> vetorDados) {
        iniciarComponentes(vetorDados);
    }

    public void iniciarComponentes(Vector<Aluno> vetorDados) {
        tabela = new RelatorioAluno(nomeColunas, vetorDados);
        table = new JTable();
        table.setModel(tabela);
        table.setSurrendersFocusOnKeystroke(true);
        scroller = new javax.swing.JScrollPane(table);
        table.setPreferredScrollableViewportSize(new java.awt.Dimension(500, 300));

        TableColumn colunaEscondida = table.getColumnModel().getColumn(RelatorioAluno.INDEX_ESCONDIDO);
        colunaEscondida.setMinWidth(2);
        colunaEscondida.setPreferredWidth(2);
        colunaEscondida.setMaxWidth(2);
        setLayout(new BorderLayout());
        add(scroller, BorderLayout.CENTER);
    }

    public static void emitirRelatorio(List<Aluno> alunos) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame frame = new JFrame("Relatorio");

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    frame.setVisible(false);
                    Main.chamaMenuPrincipal();
                }

            });
            Vector<Aluno> vetorDados = new Vector<Aluno>();
            for (Aluno aluno : alunos) {
                vetorDados.add(aluno);
            }

            frame.getContentPane().add(new RelatorioAlunoForm(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}