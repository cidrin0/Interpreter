package br.com.usjt.interpreterII.expression;

public class Variable implements Expression {

	private String variable;
	private String position;

	public Variable(String variable) {
		this(variable, "0");
	}

	public Variable(String variable, String position) {
		this.variable = variable;
		this.position = position;
	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	@Override
	public boolean isAccept() {
		return variable.substring(0, 1).replaceAll("[A-Za-z]", "").isEmpty();
	}
	
	@Override
	public String toString() {
		return "V("+ position + ")";
	}

	@Override
	public void setValue(String value) {
		position = value;
	}

	@Override
	public String getValue() {
		return position;
	}

	@Override
	public String getKey() {
		return variable;
	}
}