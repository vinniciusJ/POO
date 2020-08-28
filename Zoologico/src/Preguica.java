public class Preguica extends Animal {
    public Preguica(String nome, String especie, int idade){
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
    }
    @Override
    public void movimentar(){
        System.out.println("Preguica " + this.nome + " está subindo em arvores...");
    }

    @Override
    public void emitirSom(){
        System.out.println("AAAAAAHHHHZZZZ");
    }
}