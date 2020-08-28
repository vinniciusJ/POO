public class Cavalo extends Animal {	
    public Cavalo(String nome, String especie, int idade){
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
    }
    @Override
    public void movimentar(){
        System.out.println("Cavalo " + this.nome + " está galopando...");
    }

    @Override
    public void emitirSom(){
        System.out.println("IRRRIINN");
    }
}