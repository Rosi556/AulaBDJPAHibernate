import DAO.FuncionarioJpaDAO;
import Entity.Fucionario;


public class main {

    public static void main(String[] args) {

        Fucionario funcionarioTaina = new Fucionario();
        funcionarioTaina.setCargo("Professora");
        funcionarioTaina.setCpf("123.123.123-23");
        funcionarioTaina.setMatricula(123);
        funcionarioTaina.setNome("Taina");

        Fucionario funcionarioRosicleite = new Fucionario();
        funcionarioTaina.setCargo("Aluna");
        funcionarioTaina.setCpf("123.123.123-24");
        funcionarioTaina.setMatricula(124);
        funcionarioTaina.setNome("Rosicleite");

       FuncionarioJpaDAO.getInstance().merge(funcionarioTaina);
       FuncionarioJpaDAO.getInstance().merge(funcionarioRosicleite);

    }
}
