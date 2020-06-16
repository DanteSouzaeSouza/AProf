package Models;

import java.util.Date;
import java.util.List;

public class Aluno {
	int ra;
	String nome;
	String rg;
	String cpf;
	Date dtnasc;
	List<Telefone> telefones;

	public Aluno(int ra, String nome, String rg, String cpf, Date dtnasc, List<Telefone> telefones) {
		super();
		this.ra = ra;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.dtnasc = dtnasc;
		this.telefones = telefones;
	}

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDtnasc() {
		return dtnasc;
	}

	public void setDtnasc(Date dtnasc) {
		this.dtnasc = dtnasc;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	@Override
	public String toString() {
		return "Aluno [ra=" + ra + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", dtnasc=" + dtnasc
				+ ", telefones=" + telefones + "]";
	}

}
