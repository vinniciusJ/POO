public class Cachorro extends Animal {

    public Cachorro(String nome, String especie, int idade){
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
    }
    @Override
    public void movimentar(){
        System.out.println("Cachorro " + this.nome + " está correndo...");;
    }

    @Override
    public void emitirSom(){
        System.out.println("AU AU AU!");
    }
}