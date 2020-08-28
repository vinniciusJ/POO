
import java.util.Random;

public class Main {
    private static String[] ESPECIES = {"Cachorro", "Cavalo", "Preguiça"};
    
   
    public static int gerarNumeroAleatorio(int fim){
        return new Random().nextInt(fim);
    }    
    public static Animal createAnimal(String especie){
        switch(especie){
            case "Cachorro" -> {
                String[] nomesCachorro = {"Thor", "Luke", "Theo", "Bily", "Chico", "Fred", "Logan", "Brutus", "Rocky", "Romeu"};
                
                String nome = nomesCachorro[gerarNumeroAleatorio(nomesCachorro.length)];
                int idade = gerarNumeroAleatorio(20);
                
                var cachorro = new Cachorro(nome, especie, idade);
                
                return cachorro;
            }
            case "Cavalo" -> {
                String[] nomeCavalo = {"Coronel", "Soberano", "Sucesso", "Sabiá", "Pirata", "Níger", "Albino", "Zorro", "Eclipse", "Holywood"};
                
                String nome = nomeCavalo[gerarNumeroAleatorio(nomeCavalo.length)];
                int idade = gerarNumeroAleatorio(20);
                
                var cavalo = new Cavalo(nome, especie, idade);
                
                return cavalo;
            }
            case "Preguiça" -> {
                String[] nomePreguica = {"Beiçola", "Bigodes", "Travolta", "Poepye", "Batman", "Choné", "Buzz", "Dengosa", "Contente", "Careta"};
                
                String nome = nomePreguica[gerarNumeroAleatorio(nomePreguica.length)];
                int idade = gerarNumeroAleatorio(20);
                
                var preguica = new Preguica(nome, especie, idade);
                
                return preguica;
                
            }
        }
       return new Animal();
    }
    
    
    
    public static void main(String[] args) {
        Animal[] animais = new Animal[10];
        
        
        for(int i = 0; i < animais.length; i++){
            animais[i] = createAnimal(ESPECIES[gerarNumeroAleatorio(ESPECIES.length)]);
        }
        
        for(Animal animal: animais){
            animal.movimentar();
            animal.emitirSom();
            System.out.println("");
        }
        
    }
}
