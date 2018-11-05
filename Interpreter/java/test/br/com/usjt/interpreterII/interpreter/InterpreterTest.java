package br.com.usjt.interpreterII.interpreter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.usjt.interpreterII.expression.Expression;

public class InterpreterTest {
	
	private BuilderExpression interpreter;

	@Before
	public void prepareInterpreter() {
		interpreter = new BuilderExpression();
	}

	@Test
	public void testExemploProjeto() {
		
		String entrada = "A25 345 A2 A A25 25B";
//		String entrada = "25B";

		Parser parser = new Parser(entrada);
		Expression element = parser.getExpression();
		do {
			interpreter.addElement(element);
			element = parser.getExpression();
		}while(element != null);
		System.out.println(interpreter);
		Assert.assertTrue(interpreter.equals("V(0)N(345)V(1)V(2)V(0)N(25)V(3)"));
	}
}