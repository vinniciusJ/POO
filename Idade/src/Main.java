
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Main {
     
    public static String lerInput(String[] opcoes){
        int opcaoEscolhida =  JOptionPane.showOptionDialog(null, "Escolha o sexo do Usuário(a): ",
                "Criando um Usuário",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        
        return opcoes[opcaoEscolhida];
    }
    public static String lerInput(String mensagem){
        return JOptionPane.showInputDialog(mensagem);
    }
    
    public static void main(String[] args) throws ParseException {
        String[] opcoesUsuario = {"Homem", "Mulher"};
        String opcaoEscolhida = lerInput(opcoesUsuario);
        
        var formatadorData =  new SimpleDateFormat("yyyy");
        
        if(opcaoEscolhida.equals(opcoesUsuario[0])){
            String nome = lerInput("Informe o nome do usuário: ");
            String dataNascimento  = lerInput("Informe o ano de Nascimento: ");
            
            Date dataNascFormatada = formatadorData.parse(dataNascimento);
            
            
            var usuario = new Homem(nome, dataNascFormatada);
            
            JOptionPane.showMessageDialog(null, "Nome da Usuária: " + usuario.getNome() + "\n" + "Idade do Usuária: " + usuario.getIdade());
        }
        else {
            String nome = lerInput("Informe o nome da usuária: ");
            String dataNascimento  = lerInput("Ano de Nascimento dela: "); 
            
             Date dataNascFormatada = formatadorData.parse(dataNascimento);
            
            var usuaria = new Mulher(nome, dataNascFormatada);
            
            JOptionPane.showMessageDialog(null, "Nome da Usuária: " + usuaria.getNome() + "\n" + "Idade do Usuária: " + usuaria.getIdade());
        }
        
    }
}
