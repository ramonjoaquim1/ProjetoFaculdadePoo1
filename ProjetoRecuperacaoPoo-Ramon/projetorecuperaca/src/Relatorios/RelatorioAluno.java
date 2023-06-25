package Relatorios;

import Model.*;
import Repository.*;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class RelatorioAluno extends AbstractTableModel{

    private static final long serialVersionUID = 1L;

    public static final int INDEX_NOME = 0;
    public static final int INDEX_EMAIL = 1;
    public static final int INDEX_TELEFONE = 2;
    public static final int INDEX_DATANASCIMENTO = 3;
    public static final int INDEX_NOTA1 = 4;
    public static final int INDEX_NOTA2 = 5;
    public static final int INDEX_NOTA3 = 6;
    public static final int INDEX_NOTA4 = 7;
    public static final int INDEX_MEDIA = 8;
    public static final int INDEX_APROVACAO = 9;

    public static final int INDEX_ESCONDIDO = 10;

    protected String[] nomeColunas;
    protected Vector<Aluno> vetorDados;

    public RelatorioAluno(String[] columnNames, Vector<Aluno> vetorDados) {
        this.nomeColunas = columnNames;
        this.vetorDados = vetorDados;
    }

    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }

    @Override
    public boolean isCellEditable(int linha, int coluna) {
        if (coluna == INDEX_ESCONDIDO) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Aluno registroAluno = (Aluno) vetorDados.get(linha);
        switch (coluna) {
            case INDEX_NOME:
                return registroAluno.getNome();
            case INDEX_EMAIL:
                return registroAluno.getEmail();
            case INDEX_TELEFONE:
                return registroAluno.getTelefone();
            case INDEX_DATANASCIMENTO:
                return registroAluno.getDataNascimento();
            case INDEX_NOTA1:
                return registroAluno.getNota1();
            case INDEX_NOTA2:
                return registroAluno.getNota2();
            case INDEX_NOTA3:
                return registroAluno.getNota3();
            case INDEX_NOTA4:
                return registroAluno.getNota4();
            case INDEX_MEDIA:
                return registroAluno.getMedia();
            case INDEX_APROVACAO:
                return registroAluno.isAprovacao();
            default:
                return new Object();
        }
    }

    @Override
    public int getRowCount() {
        return vetorDados.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }
}