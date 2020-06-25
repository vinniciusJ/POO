
import java.util.Date;

public class Mulher extends Pessoa{

    public Mulher(String nome, Date DataNascimento){
        this.setNome(nome);
        this.setIdade(DataNascimento);
    }
    
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void setIdade(Date DataNascimento) {
        this.idade = this.calcularIdade(DataNascimento);
    }

    @Override
    public int getIdade() {
       return this.idade;
    }
    
}
