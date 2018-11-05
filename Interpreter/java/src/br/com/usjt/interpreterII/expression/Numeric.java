package br.com.usjt.interpreterII.expression;

public class Numeric implements Expression {

	private String num;
	
	public Numeric(String num) {
		this.num = num;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Override
	public boolean isAccept() {
		return num.replaceAll("[0-9]", "").isEmpty();
	}
	
	@Override
	public String toString() {
		return "N("+ num +")";
	}

	@Override
	public void setValue(String value) {}

	@Override
	public String getValue() {return null;}

	@Override
	public String getKey() {
		return num;
	}
}