package br.com.usjt.interpreterII.interpreter;

import br.com.usjt.interpreterII.expression.Expression;
import br.com.usjt.interpreterII.expression.Numeric;
import br.com.usjt.interpreterII.expression.Variable;

public class Parser {

	private StringBuilder stringBuilder;
	private char letter = '?';
	private boolean number;
	
	
	private String word;
	private int pos;
	public Parser(String word) {
		this.word = word;
	}
	
	private char read() throws Exception {
		return word.charAt(pos++);
	}
	
	public Expression getExpression() {
		if(pos > word.length())
			return null;
		
		stringBuilder = new StringBuilder();
		
		try {
			getWord();
		} catch (Exception e) {
		}
	
		Expression expression;
		if(number) {
			expression = new Numeric(stringBuilder.toString());
		}else {
			expression = new Variable(stringBuilder.toString());
		}
		return expression;
	}

	private void getWord() throws Exception {
		stringBuilder.append(getLetter());
		
		if(number = isNumeric(letter)) {
			getNumeric();
			return;
		}
		getVariable();
	}
	
	public char getLetter() throws Exception {
		while(letter == ' ' || letter == '?')
			letter = read();
		return letter;
	}
	
	private void getVariable() throws Exception {
		while((letter = read()) != ' ')
			stringBuilder.append(letter);
		pos--;
	}

	private void getNumeric() throws Exception {
		while(isNumeric(letter = read()))
			stringBuilder.append(letter);
		pos--;
	}

	private boolean isNumeric(char in) {
		try {
			Integer.parseInt(String.valueOf(in));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}