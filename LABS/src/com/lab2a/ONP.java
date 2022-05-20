package com.lab2a;

/**
 * Klasa implementuje metody do konwersji rownan na postac ONP oraz do obliczania rownan z postaci ONP
 * @author Lukasz Kaczynski
 * @version 2.1 30.03.2022
 */
public class ONP {
    private static final Stack stack = new Stack();

    /**
     * Rekurencyjnie oblicza wartosc silnia z x
     * @param x liczba typu double
     * @return silnia z x
     */
    private static Double factorialOfX(Double x){
        if(x>1) return x*factorialOfX(x-1.0);
        return 1.0;
    }

    /**
     * Zwraca wage podanego elementu char (operatory wedlug kolejnosci wykonywania dzialan {od 1 do 3}, inne znaki maja wage -9
     *
     * @param arg znak, ktorego wage chcemy uzyskac
     * @return waga znaku arg
     */
    private static int getWeight(char arg) {
        int weight;
        switch (arg) {
            case '^', '_', '\'', '!' -> weight = 3;
            case '*', '/', '%' -> weight = 2;
            case '+', '-' -> weight = 1;
            default -> weight = -9;
        }
        return weight;
    }

    /**
     * Zwraca wage podanego elementu String (operatory wedlug kolejnosci wykonywania dzialan {od 1 do 3}, liczby maja wage 0, nawiasy wagi ujemne
     *
     * @param arg String, ktorego wage chcemy uzyskac
     * @return waga podanego ciagu znakow arg
     */
    private static int getWeight(String arg) {
        int weight;
        switch (arg) {
            case "^", "_", "'", "!" -> weight = 3;
            case "*", "/", "%" -> weight = 2;
            case "+", "-" -> weight = 1;
            default -> weight = -9;
        }
        return weight;
    }

    /**
     * Oblicza 'b operator a', gdzie a i b to wartosci zdjete kolejno ze stosu
     *
     * @param op operator dzialania
     * @return wynik dzialania jako String
     */
    private static String calculate(String op) {
        String answer;
        Double a = Double.parseDouble(stack.peek());
        stack.pop();
        if(op.equals("!")){
            answer = Double.toString(factorialOfX(a));
            return answer;
        }
        Double b = Double.parseDouble(stack.peek());
        stack.pop();

        switch (op) {
            case "+" -> answer = Double.toString(b + a);
            case "-" -> answer = Double.toString(b - a);
            case "*" -> answer = Double.toString(b * a);
            case "/" -> {
                if (a != 0) answer = Double.toString(b / a);
                else answer = "Error";
            }
            case "%" -> answer = Double.toString(b % a);
            case "'" -> answer = Double.toString(Math.pow(b, a));
            case "_" -> answer = Double.toString(Math.pow(b, 1.0 / a));
            default -> answer = "Error";
        }
        return answer;
    }

    /**
     * Zwraca rownanie w ONP w postaci ciagu znakow
     *
     * @param eq ciag znakow zawierajacy rownanie, ktorego konwersji do ONP chcemy dokonac
     * @return rownanie w ONP jako String
     */
    public static String convertONP(String eq) {
        stack.clear();
        StringBuilder converted = new StringBuilder();
        if (!eq.endsWith("=") || eq.contains("/0")) {
            return "Error";
        }
        for (int i = 0; i < eq.length(); i++) {
            if (Character.isLetter(eq.charAt(i))) return "Error";
        }
        char temp;
        for(int i=0; i<eq.length(); i++){
            try {
                temp = eq.charAt(i);
                if (Character.isDigit(temp)) {
                    converted.append(temp);
                    if (!Character.isDigit(eq.charAt(i + 1))) converted.append(" ");
                } else if (temp == '.') {
                    converted.deleteCharAt(converted.length() - 1);
                    converted.append(temp);
                } else if (temp == '=') {
                    while (!stack.empty()) {
                        converted.append(stack.peek());
                        converted.append(" ");
                        stack.pop();
                    }
                    converted.append("=");
                } else if (temp == '(') stack.push(Character.toString(temp));
                else if (temp == ')') {
                    while (!stack.peek().equals("(")) {
                        converted.append(stack.peek());
                        converted.append(" ");
                        stack.pop();
                    }
                    stack.pop();
                } else if (getWeight(temp) < 0) return "Error";
                else {
                    if (stack.empty()) stack.push(Character.toString(temp));
                    else if (getWeight(temp) > getWeight(stack.peek())) {
                        stack.push(Character.toString(temp));
                    } else {
                        while (getWeight(temp) <= getWeight(stack.peek())) {
                            converted.append(stack.peek());
                            converted.append(" ");
                            stack.pop();
                            if (stack.empty()) break;
                        }
                        stack.push(Character.toString(temp));
                    }
                }
            }
            catch(ArrayIndexOutOfBoundsException aioobe){
                System.out.println(aioobe.getMessage());
                return "Error";
            }
        }
        return converted.toString();
    }

    /**
     * Zwraca wynik rownania podanego w ONP
     * @param s ciag znakow zawierajacy rownanie w ONP
     * @return wynik dzialania jako wartosc zmiennoprzecinkowa
     */
    public static double getAnswer(String s){
        if(s.equalsIgnoreCase("Error")){
            System.out.println("Error");
            return Double.NEGATIVE_INFINITY;
        }
        stack.clear();
        String[] eq = s.split(" ");
        for(String i:eq){
            if(i.equals("=")) break;
            if(getWeight(i) > 0){
                stack.push(calculate(i));
                if(stack.peek().equals("Error")){
                    System.out.println("Error");
                    return Double.NEGATIVE_INFINITY;
                }
            }
            else{
                stack.push(i);
            }
        }
        return Double.parseDouble(stack.peek());
    }
}