
public class Notation {
	
	public static int operations(String x) { //This is the precedence method.
		
		switch(x) {
		
		case ("+"):
			return 1 ;
		
		case("-"):
			return 2; 
		case("/"):
			return 3;
		case("*"):
			return 4;
		}
		return -1;
	}
	
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException { 
	//	String result = ""; 
		
		MyStack<String> mystack = new MyStack<String>(); //Declare the stack
		MyQueue<String> myqueue = new MyQueue<String>(); // Declare the queue
		
		for(int i =0;i<infix.length();i++) { //read the string
			
		if(Character.isDigit(infix.charAt(i))) { //Check if the current character in the infix is a digit 
			
		myqueue.enqueue(Character.toString(infix.charAt(i)));	//copy it to the postfix solution queue
		
		}
		
		else if(infix.charAt(i) == '(') { //Check if the current character in the infix is a left parenthesis
			mystack.push(Character.toString(infix.charAt(i))); //push it onto the stack 
		}
		else if((infix.charAt(i)) == '+' || infix.charAt(i) == '-'
				|| infix.charAt(i) == '/' || infix.charAt(i) == '*') { // Check the current character is an operator
			while(!mystack.isEmpty()&&operations(mystack.top())
					>= operations(Character.toString(infix.charAt(i)))){ //Check the top of the stack while they have equal or higher precedence than the current operator
				mystack.push(mystack.pop()); //pop the operator and insert the popped one in postfix queue
			}
			
			mystack.push(Character.toString(infix.charAt(i))); //Push the current character in the infix onto the stack 
		}
		else if(infix.charAt(i) == ')') { //check if the current character in the infix is a right parenthesis 
			if(mystack.isEmpty()) { //if the stack is empty throw exception
				throw new InvalidNotationFormatException();
			}
			while(mystack.top().charAt(0) != '(') { //while the character in the top not left parenthesis.
				if(mystack.size() == 1 && mystack.top().charAt(0) != '(') { //throw excpetion if the size is 1 and the character isn't left parenthesis.
					throw new InvalidNotationFormatException();
				}
				myqueue.enqueue(mystack.pop());//Pop operators from the top of the stack and insert them in postfix solution queue 
			}
			
			mystack.pop(); //Since everyhting is already popped from the stack, left parenthesis will be left, so pop it.
		}
		
	}
		
		//After the expression has been ready and not empty,
		//Pop any remaining operators and insert them in postfix solution queue.
		while(!mystack.isEmpty()) {
			myqueue.enqueue(mystack.pop());
		}
		return myqueue.toString();
		
}
	
	public static Double evaluatePostfixExpression (String post) throws InvalidNotationFormatException {
		MyStack<String> mystack = new MyStack<String>(); //Declare my stack
		
		for(int i = 0; i<post.length();i++) { //read the expression
			
			if(Character.isDigit(post.charAt(i)) || (post.charAt(i) == '(')) { //If the current character is an operand or left parenthesis, 
				//push on the stack
				mystack.push(Character.toString(post.charAt(i)));
			}
			
			//Check if the current character is an operator.
			else if((post.charAt(i)) == '+' || post.charAt(i) == '-'
					|| post.charAt(i) == '/' || post.charAt(i) == '*') 
			{ 
				if(mystack.size()<2) { //Check if the size of the stack is less than two.
					throw new InvalidNotationFormatException(); //throw InvalidNotationFormatException excpetion.
				}
				else {
					
					String v1 = mystack.pop(); //pop the first value
					String v2 = mystack.pop(); //pop the second value
					double result = 0.0;//store the result of the operations
					
					/*
					Perform the arithmetic calculation of the operator-
					with the first popped value as the right operand and the second popped value as the left operand
					*/
					if(post.charAt(i)== '+') {
						Double x = Double.parseDouble(v1);
						Double x2 = Double.parseDouble(v2);
						result =+ x2+x;			
					}
					
					else if(post.charAt(i) == '-') {
						Double x = Double.parseDouble(v1);
						Double x2 = Double.parseDouble(v2);
						result =+ x2-x;			
					}
					else if(post.charAt(i) == '/') {
						
						Double x = Double.parseDouble(v1);
						Double x2 = Double.parseDouble(v2);
						result =+ x2/x;			
					}
					else if(post.charAt(i)=='*') {
						
						Double x = Double.parseDouble(v1);
						Double x2 = Double.parseDouble(v2);
						result =+ x2*x;			
					}
					
					mystack.push(String.valueOf(result));//Push the resulting value onto the stack
				}
		}
			
	
	}
		
		if(mystack.size() == 1) {
			return Double.parseDouble(mystack.pop());
		}
		else {
			throw new InvalidNotationFormatException(); //if more than one value remains, throw an error.
		}
}
	
	public static String convertPostfixToInfix (String posttoinfix) {
		
		MyStack <String> mystack = new MyStack<String>(); //Declare a stack.
		
		//read the expression characters
		for(int i = 0; i< posttoinfix.length();i++) {
			if(Character.isDigit(posttoinfix.charAt(i))) { //If the current character is an operand,
				//push on the stack
				mystack.push(Character.toString(posttoinfix.charAt(i)));
			}
			//Check if the current character is an operator.
			else if((posttoinfix.charAt(i)) == '+' || posttoinfix.charAt(i) == '-'
					|| posttoinfix.charAt(i) == '/' || posttoinfix.charAt(i) == '*') 
			{
				if(mystack.size()<2) { ////Check if the size of the stack is less than two.
					throw new InvalidNotationFormatException(); //throw InvalidNotationFormatException
				}
				else {
				String v1 = mystack.pop();//pop the first value
				String v2 = mystack.pop();//pop the second value
				String infix  = "(" + v2 +posttoinfix.charAt(i)  + v1 + ")"; //Encapsulate the resulting string within parenthesis.
				mystack.push(infix); //push it to the stack.
				}
			}
		}
		
		if(mystack.size() != 1) //if more than one value remains in the stack, throw exception.
		{
			throw new InvalidNotationFormatException();

		} else { 
		String result = mystack.pop();
		return result;
	}
}
}
