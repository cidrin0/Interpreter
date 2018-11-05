package br.com.usjt.interpreterII.interpreter;

import java.util.ArrayList;

import br.com.usjt.interpreterII.expression.Expression;

public class BuilderExpression {

	private ArrayList<Expression> expressions;
	private int countVariable = 0;
	
	public BuilderExpression() {
		expressions = new ArrayList<Expression>();
	}
	
	public void addElement(Expression expression){
		
		if(!expression.isAccept())
			return;
		Expression expression2 = getByKey(expression.getKey());
		if(expression2 != null) {
			expression.setValue(expression2.getValue());
		}else if(expression.getValue() != null){
			expression.setValue(String.valueOf(countVariable++));
		}
		
		expressions.add(expression);
	}
	
	private Expression getByKey(String key) {
		for(Expression expression : expressions)
			if(expression.getKey().equals(key))
				return expression;
		return null;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(Expression expression : expressions)
			builder.append(expression.toString());
		return builder.toString();
	}
}