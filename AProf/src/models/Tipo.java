package models;

public enum Tipo { 
	Comercial(1), Residencial(2), Celular(3); 
	
	private final int valor;
    Tipo(int valorOpcao){
        valor = valorOpcao;
    }
    public int getValor(){
        return valor;
    }

}