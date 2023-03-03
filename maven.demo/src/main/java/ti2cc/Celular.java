package ti2cc;

public class Celular {
	private int memoria;
	private String marca;
	private String modelo;
	private double preco;
	
	public Celular() {
		this.memoria = -1;
		this.marca = "";
		this.modelo = "";
		this.preco = 0;
	}
	
	public Celular(int memoria, String marca, String modelo, Double preco) {
		this.memoria = memoria;
		this.marca = marca;
		this.modelo = modelo;
		this.preco = preco;
	}

	public int getMemoria() {
		return memoria;
	}

	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Celular [memoria=" + memoria + ", marca=" + marca + ", modelo=" + modelo + ", preco=" + preco + "]";
	}	
}







