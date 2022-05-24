package com.capp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Moeda implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value="code")
	private String code;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty(value="codein")
	private String codein;
	
	@JsonProperty(value="name")
	private String name;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty(value="high")
	private BigDecimal high;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty(value="low")
	private BigDecimal low;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty(value="varBid")
	private BigDecimal varBid;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty(value="pctChange")
	private BigDecimal pctChange;
	
	@JsonProperty(value="bid")
	private BigDecimal bid;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty(value="create_date")
	private LocalDateTime create_date;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty(value="total")
	private BigDecimal total;
	
	@JsonProperty("Moedas")
	private List<Moeda> lsMoedas;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodein() {
		return codein;
	}
	public void setCodein(String codein) {
		this.codein = codein;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getHigh() {
		return high;
	}
	public void setHigh(BigDecimal high) {
		this.high = high;
	}
	public BigDecimal getLow() {
		return low;
	}
	public void setLow(BigDecimal low) {
		this.low = low;
	}
	public BigDecimal getVarBid() {
		return varBid;
	}
	public void setVarBid(BigDecimal varBid) {
		this.varBid = varBid;
	}
	public BigDecimal getPctChange() {
		return pctChange;
	}
	public void setPctChange(BigDecimal pctChange) {
		this.pctChange = pctChange;
	}
	public BigDecimal getBid() {
		return bid;
	}
	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}
	public LocalDateTime getCreateDate() {
		return create_date;
	}
	public void setCreateDate(LocalDateTime create_date) {
		this.create_date = create_date;
	}
	
	
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bid, code, codein, high, low, name, pctChange, create_date, varBid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moeda other = (Moeda) obj;
		return Objects.equals(bid, other.bid) && Objects.equals(code, other.code)
				&& Objects.equals(codein, other.codein) && Objects.equals(high, other.high)
				&& Objects.equals(low, other.low) && Objects.equals(name, other.name)
				&& Objects.equals(pctChange, other.pctChange) && Objects.equals(create_date, other.create_date)
				&& Objects.equals(varBid, other.varBid);
	}
	@Override
	public String toString() {
		return "Moeda [code=" + code + ", codein=" + codein + ", name=" + name + ", high=" + high + ", low=" + low
				+ ", varBid=" + varBid + ", pctChange=" + pctChange + ", bid=" + bid + ", timestamp=" + create_date + "]";
	}
	
	
	

	
		
}