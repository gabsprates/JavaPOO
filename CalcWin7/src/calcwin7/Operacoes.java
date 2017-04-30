/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcwin7;

/**
 * @author gabriel
 */
class Operacoes {

    /**
     * Realiza a soma de dois números
     *
     * @param x
     * @param y
     * @return Double
     */
    public static Double soma(Double x, Double y)
    {
        return x + y;
    }

    /**
     * Realiza a subtração de dois números
     *
     * @param x
     * @param y
     * @return Double
     */
    public static Double subtracao(Double x, Double y)
    {
        return x - y;
    }

    /**
     * Realiza a multiplicação de dois números
     *
     * @param x
     * @param y
     * @return Double
     */
    public static Double multiplicacao(Double x, Double y)
    {
        return x * y;
    }

    /**
     * Realiza a divisão de dois números
     *
     * @param x
     * @param y
     * @return Double
     */
    public static Double divisao(Double x, Double y)
    {
        return x / y;
    }

    /**
     * Inverte o sinal do número
     *
     * @param x
     * @return Double
     */
    public static Double trocaSinal(Double x)
    {
        return x * (-1);
    }

    /**
     * Inverte o número, x^(-1)
     *
     * @param x
     * @return Double
     */
    public static Double inversao(Double x)
    {
        return 1 / x;
    }

    /**
     * Calcula porcentagem
     *
     * @param x
     * @param percentual
     * @return Double
     */
    public static Double porCentagem(Double x, Double percentual)
    {
        return (x * percentual) / 100;
    }
    
    /**
     * Calcula a raiz quadrada de x
     *
     * @param x
     * @return Double
     */
    public static Double raizQuadrada(Double x)
    {
        return (Double) Math.sqrt(x);
    }

}
