package br.com.pv.response;

import java.io.Serializable;


//Objeto trafego entre os dois microserviços
public class Cambio implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String from;

	private String to;

	private Double conversionFactor;

	private Double convertedValue;

	private String enviroments;

	public Cambio() {
	}

	public Cambio(Long id, String from, String to, Double conversionFactor, Double convertedValue, String enviroments) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionFactor = conversionFactor;
		this.convertedValue = convertedValue;
		this.enviroments = enviroments;
	}

	public Long getId() {
		return id;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public Double getConversionFactor() {
		return conversionFactor;
	}

	public Double getConvertedValue() {
		return convertedValue;
	}

	public String getEnviroments() {
		return enviroments;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setConversionFactor(Double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public void setConvertedValue(Double convertedValue) {
		this.convertedValue = convertedValue;
	}

	public void setEnviroments(String enviroments) {
		this.enviroments = enviroments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conversionFactor == null) ? 0 : conversionFactor.hashCode());
		result = prime * result + ((convertedValue == null) ? 0 : convertedValue.hashCode());
		result = prime * result + ((enviroments == null) ? 0 : enviroments.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cambio other = (Cambio) obj;
		if (conversionFactor == null) {
			if (other.conversionFactor != null)
				return false;
		} else if (!conversionFactor.equals(other.conversionFactor))
			return false;
		if (convertedValue == null) {
			if (other.convertedValue != null)
				return false;
		} else if (!convertedValue.equals(other.convertedValue))
			return false;
		if (enviroments == null) {
			if (other.enviroments != null)
				return false;
		} else if (!enviroments.equals(other.enviroments))
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	};

}
