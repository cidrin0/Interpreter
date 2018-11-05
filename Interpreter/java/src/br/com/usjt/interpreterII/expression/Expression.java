package br.com.usjt.interpreterII.expression;

public interface Expression {

	boolean isAccept();
	void setValue(String value);
	String getValue();
	String getKey();
}