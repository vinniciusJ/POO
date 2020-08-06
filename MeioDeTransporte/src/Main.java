import javax.swing.JOptionPane;

public class Main {
    final static String TIPOSLOCOMOCAO[] = {"Avião", "Barco", "Automóvel"};
    
    public static void menuOpcoes(MeioDeTransporte md){
        String opcoes[] = {"Ligar", "Desligar", "Abastecer", "Dirigir",("Status do " + md.locomocao),"Voltar", "Sair"};
        int opcaoEscolhida = lerInput(opcoes, "O que você deseja fazer agora");
        
        switch(opcaoEscolhida){
            case 0 -> {
                int statusOperacao = md.ligar();
                
                if(statusOperacao == 1){
                    imprimirMensagem("O " + md.locomocao + " já está ligado");
                }
                else {
                    imprimirMensagem("O " + md.locomocao + " foi ligado com sucesso");
                }
                
                menuOpcoes(md);
            }
            case 1 -> {
                int statusOperacao = md.desligar();
                
                if(statusOperacao == 1){
                    imprimirMensagem("O " + md.locomocao + " já está desligado");
                }
                else {
                    imprimirMensagem("O " + md.locomocao + " foi desligado com sucesso");
                }   
                
                 menuOpcoes(md);
            }
            case 2 -> {
                int qtdLitros = 0;
                
                try {
                    qtdLitros = Integer.parseInt(lerInput("Por favor insira a quantidade de litros\n" + "Máximo: " + md.totalLitrosTanque));
                } catch (Exception e) {
                    imprimirMensagem("Por favor insira um número válido");
                    
                    menuOpcoes(md);
                }
                
                int statusOperacao = md.abastecer(qtdLitros);
                
                if(statusOperacao == 1){
                    imprimirMensagem("Essa quantidade ultrapassa o máximo de litros por tanque de " + md.totalLitrosTanque + "L\nPor favor tente novamente");
                }
                else {
                    imprimirMensagem("O " + md.locomocao + " foi abastecido com sucesso");
                }
                
                 menuOpcoes(md);
            }
            case 3 -> {
                int statusOperacao = md.mover();
                
                if(statusOperacao == 1){
                    imprimirMensagem("Combustível insuficiente para a viagem\n" + "Por favor, abasteça o " + md.locomocao);
                }
                else {
                    imprimirMensagem("Viagem realizada com sucesso.\nAtual quantidade de litros no tanque: " + md.litrosTanque);
                }
                
                 menuOpcoes(md);
            }
            case 4 -> {
                String mensagemStatus = md.toString();
                
                imprimirMensagem(mensagemStatus);
                
                menuOpcoes(md);
            }
            case 5 -> {
                iniciar();
            }
            case 6 -> {
                System.exit(0);
            }
        }
    }
    
        
    
    public static int lerInput(String[] opcoes, String message){
        int opcaoEscolhida =  JOptionPane.showOptionDialog(null, message,
                "Meios de Transporte",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        
        return opcaoEscolhida;
    }
    public static String lerInput(String mensagem){
        return JOptionPane.showInputDialog(mensagem);
    }
    public static void imprimirMensagem(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    public static void verificarInput(String valor){
        if(valor == null){
            iniciar();
           
        }
    }
    
    public static String[] lerPropriedades(int indexLocomocao){
        String marca = lerInput("Informe o nome do " + TIPOSLOCOMOCAO[indexLocomocao]);
        verificarInput(marca);
        
        String modelo = lerInput("Informe o modelo do " + TIPOSLOCOMOCAO[indexLocomocao]);
        verificarInput(modelo);
        
        int ano = 0;
        
        while(ano == 0){
            try {
                ano = Integer.parseInt(lerInput("Informe o ano de lançamento do " + TIPOSLOCOMOCAO[indexLocomocao]));
                verificarInput(Integer.toString(ano));
            } catch (Exception e) {
                imprimirMensagem("Por favor insira um número");
            }
        }
        
        String combustivel = lerInput("Informe o tipo de combustivel do " + TIPOSLOCOMOCAO[indexLocomocao]);
        verificarInput(combustivel);
        
        String anoFormatado = Integer.toString(ano);
        String atributosMeioDeTransporte[] = {marca, modelo, anoFormatado, combustivel};
        
        return atributosMeioDeTransporte;
    }
    
    public static void iniciar(){
        String opcoes[] = {TIPOSLOCOMOCAO[0], TIPOSLOCOMOCAO[1], TIPOSLOCOMOCAO[2], "Sair"};
        int locomocaoID = lerInput(opcoes, "Por favor, escolher um meio de transporte para utilizar");
       
        String propriedades[] = lerPropriedades(locomocaoID);
        
        
        switch(locomocaoID){
            case 0 -> {
                var aviao = new Aviao(propriedades[0], propriedades[1],  Integer.parseInt(propriedades[2]),  propriedades[3]);
                
                menuOpcoes(aviao);
            }
            case 1 -> {
                var barco = new Barco(propriedades[0], propriedades[1],  Integer.parseInt(propriedades[2]),  propriedades[3]);
                
                menuOpcoes(barco);
            }
            case 2 -> {
                var automovel = new Automovel(propriedades[0], propriedades[1],  Integer.parseInt(propriedades[2]),  propriedades[3]);
                
                menuOpcoes(automovel);
            }
            case 3 -> {
                 System.exit(0);
            }
        }
    }
    public static void main(String[] args) {
        iniciar();
    }
}
