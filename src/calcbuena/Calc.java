/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcbuena;

import java.util.Scanner;

/**
 *
 * @author Alejandro Bermúdez, Rogelio Torres, Dario Sotelo, José Mejias Las Palomas de Costa Rica
 */
public class Calc {

    /**
     * @param args the command line arguments
     */
    
public static String errorMatSintaxis(String ec){
        String resp="false";
        boolean res=true;
        boolean op1=false, op2=false;
        int x=ec.length();
        String[] ecuacion= new String[x];
        int j=0;
        int k=1;
        int m=0;  
        //Transforma la ecuación en un arreglo de Strings/
        for(int i=0; i<x; i++)
            ecuacion[i]= ec.substring(i, i+1);
        /*Revisa si el primer o último elemento de la cadena es un operando
        y vuelve el resultado falso si lo es*/
         if(ec.charAt(0)=='+' || ec.charAt(0)=='*' || ec.charAt(0)=='/'|| ecuacion[j].equals("-")
                || ec.charAt(0)=='^' || ec.charAt(x-1)=='*' || ec.charAt(x-1)=='+' || ec.charAt(x-1)=='-' ||
                ec.charAt(x-1)=='/' || ec.charAt(x-1)=='^'){
                res=false;
                
         }
         else{
             /*Recorre el arreglo buscando dos operadores juntos, revisa si en dos posiciones consecutivas
             del arreglo se encuentran dos operadores*/
           
                    
             while(k<x && !op1 && !op2){

                        if(ecuacion[j].equals("(")&&ecuacion[k].equals("-"))
                            res=true;
                     if(ecuacion[j].equals("-") || ecuacion[j].equals("+") ||ecuacion[j].equals("/") ||
                             ecuacion[j].equals("*") || ecuacion[j].equals("^"))
                            op1=true;
                        if( ecuacion[k].equals("-") || ecuacion[k].equals("/") || ecuacion[k].equals("+")||
                             ecuacion[k].equals("*") || ecuacion[k].equals("^"))
                            op2=true;
                        
                        if( ecuacion[j].equals("(")){
                            if(ecuacion[k].equals("/") || ecuacion[k].equals("+")||
                             ecuacion[k].equals("*") || ecuacion[k].equals("^"))
                            res=false;
                            k=x;
                        }
                        
                        
                                
                        //Si alguna de las dos es falso, se reinician los valores para que siga el ciclo/
                        if(op1==false || op2==false){
                        op1=false;
                        op2=false;
                         }
                            j++;
                            k++;
                            
            }
            /*Pregunta por qué se salió del ciclo. Si se salió antes de que se acabara de recorrer el arreglo 
            se encontrarón dos operandos juntos, por lo tanto la respuesta final cambia a falso*/
             if(k<x){
              res=false;
             }
         }
            
         if(res==true){
             resp="true";
         }
         else{
             resp="expresión no válida";
            }
            return resp;    
         }
                               
public static String revisaParentesis(String exp){
        //Declaración de variables
        String resp="false";
        ArrayStack<String> pila=new ArrayStack();
        String[] expr=new String[exp.length()];
        int i=0;
        int aux=0,b=0;
        boolean res=false,band=true;
        
        //Llena el arreglo con los datos de la expresión matemática
        for(int k=0; k<exp.length(); k++){
            expr[k]=exp.substring(k, k+1);
        }
         
       //Se buscan paréntesis abiertos en el arreglo.  
        while(i<expr.length && band){
            if(expr[i].equals("(")){
                pila.push("(");
                aux=i;
            }
            //De lo contrario, se buscan paréntesis cerrados.     
            else if(expr[i].equals(")")){
                //Si se encuentra uno en una posición anterior al contador la variable bandera cambia a falso y se sale del ciclo
                if(aux==i-1){
                    band=false;
                }
                else if(!pila.isEmpty() && pila.peek().equals("("))
                    pila.pop();
                else
                    band=false;
            }
            i++;
        }
        if(pila.isEmpty() && band)
            res=true;
        
        if(res==true)
            resp="true";
        else{
            resp="Error de Parentesis";        
        }
        
        return resp;
                    
    }
    

	 
public static String aPostfija(String expInf){// infix a postfix 
        
        ArrayStack res= new ArrayStack();      //Guardar la expresión    uso de ArrayStack
        ArrayStack aux = new ArrayStack(); //Uso de Array Stack
        ArrayStack<Character> op= new ArrayStack();     //Operadores  
        int i=0;
        int j;
        char c;
        String s;
        boolean b;
        String postfijo="";
                   expInf=expInf.replace("(-","(0-");//cambio de negativo en la primera posicion
                   expInf=expInf.replace("-+","-");//cambio de negativos
           expInf=expInf.replace("+-","-");//cambio a negativo con + y-

        int x=expInf.length();
        if(revisaParentesis(expInf).equals("true")){
           if(errorMatSintaxis(expInf).equals("true")){
               if(expInf.charAt(0)=='+'){
                  i++;
                  }
        
           expInf=expInf.replace("(-","(0-");
           
            while(i<x){
                c=expInf.charAt(i);
            
            //En caso de ser un numero y/o un punto
             if((int)c>=48&&(int)c<=57||c=='.'){     
                j=i+1;
                b=true;
                
                //El  String ira recorriendo uno a uno y finalmente los extraera en su conjunto y agregará a la pila res.
                while(j<x && b){        
                    if((int)expInf.charAt(j)>=48&&(int)expInf.charAt(j)<=57||expInf.charAt(j)=='.'){
                       j++; 
                    }
                    else{
                        b=false;
                    }
                }
                if(j>=x){
                    s=expInf.substring(i);
                }
                else{
                    s=expInf.substring(i,j);
                }
                
                res.push(s);
                i=j-1;

            }
            
            else{
               //En caso de encontrar paréntesis
                if(c=='('){
                    op.push(c);
                }
                else{
                    if(c==')'){
                        while(!op.isEmpty()&&op.peek()!='('){
                            res.push(op.pop());
                        }
                        
                        if(!op.isEmpty()&&op.peek()=='('){
                            op.pop();
                        }
                    }
                    else{
                        
                        /*
                        */
                        if(c=='+'||c=='-'){
                            while(!op.isEmpty()&&op.peek()!='('){
                                res.push(op.pop());
                            }
                        }
                        else{
                            b=true;
                            while(!op.isEmpty()&&op.peek()!='('&&b){
                                if(op.peek()=='*'||op.peek()=='/'){
                                    res.push(op.pop());
                                }
                                else{
                                    b=false;                                
                                }
                            }
                        }
                        op.push(c);
                    }
                }
           }
        
            i++;
        }
        
        while(!op.isEmpty()){
            res.push(op.pop());
        }
        
        while(!res.isEmpty()){
            aux.push(res.pop());
        }
        // Al formarse la expresión en la pila res, se recurre a la pila aux para que al ir extrayendo los elementos y agregarlos al String queden ordenados.
        while(!aux.isEmpty()){
            postfijo+= aux.pop() + " ";
        }
           }else
               throw new SintaxErrorException();
        }
        else
            throw new UnbalancedBracketsException();
        
        return postfijo;
    }

public static String resuelve(String expresionPostfija) {//Shunting yard, algoritmo que cambia de postfix y resuelve
        
        Scanner scanner = new Scanner(expresionPostfija);
        
        //Se crea una pila auxiliar para guardar los numeros que se acumulan
        ArrayStack<Double> aux = new ArrayStack();
        
        //Se busca dígito u operador
        while (scanner.hasNext()) {
            //Si resulta ser un número se pushea a la pila auxiliar
            if (scanner.hasNextDouble()) {
                aux.push(scanner.nextDouble());
            }
            //Si es un operador, se evalua la operación con los últimos dos elementos de la pila 
            else {
                String operador = scanner.next();
                double b = aux.pop();
                double c = aux.pop();
                
                switch (operador) {
                    case "+" :
                    aux.push(c + b);
                    break;
                    
                    case "-" :
                    aux.push(c - b);
                    break;
                
                    case "*" : 
                    aux.push(c * b ); 
                    break;
                
                    case "/" : 
                      
                      if(b!=0)
                      aux.push(c / b); 
                      else
                      throw new IndefinitionException();
                      break;
                            
                    case "^":
                    aux.push(Math.pow(c, b));      
                    break;
                }
            }
        
        }
        return Double.toString(aux.pop());
        
    }	   
	  
    
    
    public static void main(String[] args) {
        // TODO code application logic here
//        System.out.println(aPostfija("7+9-3-(5-1)"));
//        System.out.println(aPostfija("10+7"));          

//        System.out.println(resuelve(aPostfija("10.3+7")));
//        System.out.println(revisaParentesis("(4*4))/4"));
    
    }
    
    
    
}

