import java.util.Date;
import java.text.SimpleDateFormat;

public abstract class Pessoa {
    int idade;
    String nome;
    
    public abstract void setNome(String nome);
    public abstract String getNome();
    public abstract void setIdade(Date DataNascimento);
    public abstract int getIdade();
    
    public int calcularIdade(Date dataNascimento){
        var formatadorData = new SimpleDateFormat("yyyy");
        
        int dataAtual = Integer.parseInt(formatadorData.format(new Date()));
        int dataNascFormatada = Integer.parseInt(formatadorData.format(dataNascimento));
        
        return  dataAtual - dataNascFormatada;
    }
    
}
