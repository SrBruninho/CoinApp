package com.capp.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Moeda {
	
	@JsonProperty(value="code")
	private String code;
	@JsonProperty(value="codein")
	private String codein;
	@JsonProperty(value="name")
	private String name;
	@JsonProperty(value="high")
	private BigDecimal high;
	@JsonProperty(value="low")
	private BigDecimal low;
	@JsonProperty(value="varBid")
	private BigDecimal varBid;
	@JsonProperty(value="pctChange")
	private BigDecimal pctChange;
	@JsonProperty(value="bid")
	private BigDecimal bid;
	@JsonProperty(value="timestamp")
	private LocalDate timestamp;
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
	public LocalDate getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bid, code, codein, high, low, name, pctChange, timestamp, varBid);
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
				&& Objects.equals(pctChange, other.pctChange) && Objects.equals(timestamp, other.timestamp)
				&& Objects.equals(varBid, other.varBid);
	}
	@Override
	public String toString() {
		return "Moeda [code=" + code + ", codein=" + codein + ", name=" + name + ", high=" + high + ", low=" + low
				+ ", varBid=" + varBid + ", pctChange=" + pctChange + ", bid=" + bid + ", timestamp=" + timestamp + "]";
	}
	
	
	

	
		
}