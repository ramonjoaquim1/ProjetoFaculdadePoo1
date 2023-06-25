package Repository;
import Model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class AlunoDAO {

    static List<Aluno> alunos = new ArrayList<>();
    private static BigDecimal calcularMedia;

    public static void salvar(Aluno aluno) {
        if (aluno.getNome() == null) {
            aluno.setNome(String.valueOf(aluno.getNota1().intValue() + 1)+
                         (String.valueOf(aluno.getNota2().intValue() + 1))+
                         (String.valueOf(aluno.getNota3().intValue() + 1))+
                         (String.valueOf(aluno.getNota4().intValue() + 1)));
        } else {
            alunos.remove(aluno);
        }
        alunos.add(aluno);
    }

    public static List<Aluno> buscaTodosa() {
        if (alunos.isEmpty()) {
            alunos.add(new Aluno("Manoel Gomes", "manoelgomes@gmail.com", "(48) 9780-9850", LocalDate.of(2002, 6, 5), BigDecimal.valueOf(7), BigDecimal.valueOf(7), BigDecimal.valueOf(8), BigDecimal.valueOf(4.5), calcularMedia, false));
            alunos.add(new Aluno("Ednaldo Pereira", "ednaldopereira@hotmail.com", "(49) 9842-5874", LocalDate.of(2000, 2, 1), BigDecimal.valueOf(6.5), BigDecimal.valueOf(7), BigDecimal.valueOf(5), BigDecimal.valueOf(7), calcularMedia, false));
            alunos.add(new Aluno("Anderson Silva", "andersonsilva@gmail.com", "(51) 9750-4750", LocalDate.of(2001, 5, 30), BigDecimal.valueOf(10), BigDecimal.valueOf(8), BigDecimal.valueOf(7.5), BigDecimal.valueOf(3.5), calcularMedia, true));
            alunos.add(new Aluno("Gustavo Kunst", "gustavoknust@gmail.com", "(51) 9750-4750", LocalDate.of(1999, 11, 28), BigDecimal.valueOf(5), BigDecimal.valueOf(7), BigDecimal.valueOf(8), BigDecimal.valueOf(6.5), calcularMedia, false));
            alunos.add(new Aluno("Rogério Skynet", "rogerioskylab@gmail.com", "(51) 9750-4750", LocalDate.of(1997, 12, 17), BigDecimal.valueOf(9), BigDecimal.valueOf(7.5), BigDecimal.valueOf(5.5), BigDecimal.valueOf(4), calcularMedia, false));

            for (Aluno aluno : alunos) {
                BigDecimal media = calcularMedia(aluno.getNota1(), aluno.getNota2(), aluno.getNota3(), aluno.getNota4());
                aluno.setMedia(media);
            }
        }
        return alunos;
    }
        public static BigDecimal calcularMedia(BigDecimal nota1, BigDecimal nota2, BigDecimal nota3, BigDecimal nota4) {
            BigDecimal total = nota1.add(nota2).add(nota3).add(nota4);
            BigDecimal media = total.divide(BigDecimal.valueOf(4));
            return media;
        }

//    public static List<Aluno> buscarPorNome(String nome) {
//        buscaTodosa();
//        List<Aluno> alunoFiltrado = new ArrayList<>();
//        for (Aluno aluno : alunos) {
//            if (aluno.getNome() == nome) {
//                alunoFiltrado.add(aluno);
//            }
//        }
//        return alunoFiltrado;
//    }
//
//    public static Object[] findHospedeInArray() {
//        List<Aluno> alunos = buscaTodosa();
//        List<String> alunoDesc = new ArrayList<>();
//
//        for (Aluno aluno : alunos) {
//            alunoDesc.add(aluno.getNome());
//        }
//        return alunoDesc.toArray();
//    }
//
//    public static void removerAluno(Aluno alunoSelecionado) {}



}


