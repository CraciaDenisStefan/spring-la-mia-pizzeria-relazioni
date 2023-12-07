package org.java.spring.db.pojo;

import org.hibernate.validator.constraints.Length; 
import org.springframework.format.annotation.NumberFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 60)
    @NotEmpty(message = "Il campo nome è obbligatorio")
    @Length(min = 3, max = 60, message = "Il nome deve essere lungo tra 3 e 60 caratteri")
    private String nome;

    @Column(columnDefinition = "TEXT")
    @NotEmpty(message = "Il campo descrizione è obbligatorio")
    private String descrizione;

    @NotEmpty(message = "Il campo fotoUrl è obbligatorio")
    private String fotoUrl;

    @NotNull(message = "Il campo prezzo è obbligatorio")
    @DecimalMin(value = "0.01", message = "Il prezzo deve essere maggiore di 0.01")
    @DecimalMax(value = "999.99", message = "Il prezzo deve essere minore di 999.99")
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private double prezzo;
    
    public Pizza() { }
	public Pizza(String nome, String descrizione, String fotoUrl, double prezzo) {
		setNome(nome);
		setDescrizione(descrizione);
		setFotoUrl(fotoUrl);
		setPrezzo(prezzo);
		
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getFotoUrl() {
		return fotoUrl;
	}
	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] " + getNome() + " - " 
				+ getDescrizione() + " (" + getPrezzo() + ")";
	}
	
}
