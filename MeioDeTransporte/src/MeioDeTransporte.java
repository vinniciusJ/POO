//Regras de retorno
// return 0: sucesso
// return 1: erro

// Regra de gastos de combustivel por tipo de automovel
// Avião: (Total = 24.000L) (Gasto/viagem): 8.000L)
// Barco: (Total = 60L) (Gasto/viagem): 15L)
// Automóvel: (Total = 40L) (Gasto/viagem): 10L)

public abstract class MeioDeTransporte {
    String combustivel, locomocao, marca, modelo;
    double peso;
    int ano, litrosTanque, totalLitrosTanque, litrosPorViagem;
    boolean status = false;
    
    String tipoLocomocoes[] = {"Avião", "Barco", "Automóvel"};
    int totalLitrosLocomocao[] = {24000, 60, 40};
    int litrosGastosViagem[] = {8000, 15, 10};
    
    public void set(String locomocao, String marca, String modelo, int ano, String combustivel){
        this.locomocao = locomocao;
        this.marca = marca;
        this.modelo = modelo;
        this.combustivel = combustivel;
        
        for(int i = 0; i < this.tipoLocomocoes.length; i++){
            if(this.locomocao.equals(this.tipoLocomocoes[i])){
                this.totalLitrosTanque = this.totalLitrosLocomocao[i];
                this.litrosPorViagem = this.litrosGastosViagem[i];
            }
        }
    }
    
    
    
    public int abastecer(int qtdLitros){
        if(qtdLitros > this.totalLitrosTanque || (this.litrosTanque + qtdLitros) > this.totalLitrosTanque){
            return 1;
        }
        
        this.litrosTanque += qtdLitros;
        
        return 0;
    }
    public int ligar(){
        if(!this.status){
            this.status = true;
        }
        else {
            return 1;
        }
        
        return 0;
    }
    public int desligar(){
        if(this.status){
            this.status = false;
        }
        else {
            return 1;
        }
        
        return 0;
    }
    public int mover(){
        if((this.litrosTanque - this.litrosPorViagem) < 0){
            return 1;
        }
        
        this.litrosTanque -= this.litrosPorViagem;
        
        return 0;
    }
    
    @Override
    public String toString() {
        return (
                "Meio de Transporte: " + this.locomocao + "\n\n" +
                "Marca: " + this.marca + "\n" +
                "Modelo: " + this.modelo + "\n" +
                "Ano de lançamento: " + this.ano + "\n\n" +
                "Tipo de combustivel: " + this.combustivel + "\n" +
                "Total de litros no tanque: " + this.litrosTanque + "\n" +
                "Máximo de litros no tanque: " + this.totalLitrosTanque + "\n" +
                "Gasto por viagem: " + this.litrosPorViagem + "\n\n" +
                "Ligado/Desligado: " + (this.status ? "Ligado": "Desligado")
        );
    }
}
