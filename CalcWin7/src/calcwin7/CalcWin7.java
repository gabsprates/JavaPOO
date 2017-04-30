/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcwin7;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author gabriel
 */
public class CalcWin7 extends javax.swing.JFrame {

    /**
     * Pripriedades que não são geradas pelo NetBeans
     */
    private final int numEnter = 10;
    private final int numDelete = 127;
    private final int numBackspace = 8;
    private final char charDelete = 'D';
    private final char charOperador = '_';
    private final char charBackspace = 'B';
    private final char charPorcentagem = '%';
    private final char charUpdateTermo = 'U';
    private final char charMemoryRecall = 'M';
    private final char charSinalInverso = 'S';
    private final char charRaizQuadrada = 'R';
    private final char charBaseInvertida = '~';
    private final char charExibirResultado = '=';
    private final String stringZero = "0";
    private final ArrayList<String> digitos;
    private final ArrayList<String> operacoesEntreTermos;
    
    private String entrada;
    private String memoria;
    private Double termo;
    private Double resultado;
    private char operador;
    

    /**
     * Atualiza o valor de `entrada`, `termo` e o diplay
     * @param str
     */
    private void atualizaEntrada(char digito) {
        
        boolean temPonto = (digito == '.') && this.entrada.contains("" + digito);
        
        if (digito == this.charDelete) {
            this.entrada = this.stringZero;
        
        } else if (digito == this.charBackspace) {
            this.entrada = this.removeUltimoChar(this.entrada);
        
        } else if (digito == this.charMemoryRecall) {
            this.entrada = this.memoria;
        
        } else if (digito == this.charUpdateTermo) {
            System.out.println("update termo");
        
        } else if (this.termo == 0 && this.entrada.equals("0")) {
            
            if (digito == '.') {
                this.entrada = "0.";
            } else {
                this.entrada = "" + digito;
            }
        
        } else if (digito == this.charExibirResultado) {
            this.entrada = this.resultado.toString();
            
        } else if (!temPonto) {
            this.entrada = this.entrada.concat("" + digito);
        }
        
        if (digito != this.charExibirResultado) {
            this.termo = Double.parseDouble(this.entrada);
        }
        this.fieldDisplay.setText(this.entrada.replace('.', ','));
        System.out.println("------------------------------");
        System.out.println("termo:\t" + this.termo.toString());
        System.out.println("memo.:\t" + this.memoria);
        System.out.println("resu.:\t" + this.resultado.toString());
        System.out.println("oper.:\t" + this.operador);

    }
    
    
    /**
     * Resolve operações únicas
     * @param entrada
     * @param operacao
     */
    private void resolveOperacaoUnica(char operacao) {

        Double numero = Double.parseDouble(this.entrada);
        Double resultadoFinal = 0.0;

        if (operacao == this.charSinalInverso) {
            resultadoFinal = Operacoes.trocaSinal(numero);

        } else if (operacao == this.charRaizQuadrada) {
            resultadoFinal = Operacoes.raizQuadrada(numero);

        } else if (operacao == this.charBaseInvertida) {
            resultadoFinal = Operacoes.inversao(numero);

        }

        this.entrada = resultadoFinal.toString();
        this.resultado = resultadoFinal;

        this.atualizaEntrada(this.charUpdateTermo);
        
    }
    
    
    /**
     * Atualiza o valor do `resultado` baseado na solução da operação
     * @param operador
     * @param resultado
     * @param termo 
     */
    private void atualizaResultado(char operador, Double resultado, Double termo) {
        
        this.resultado = this.resolveOperacao(operador, resultado, termo);
        this.atualizaEntrada(this.charExibirResultado);
                
    }
    
    
    /**
     * Resolve operação
     * @param operador
     * @param x
     * @param y 
     */
    private Double resolveOperacao(char operador, Double x, Double y) {

        Double resultado = 0.0;
        
        switch (operador) {
            case '+':
                resultado = Operacoes.soma(x, y);
                break;

            case '-':
                resultado = Operacoes.subtracao(x, y);
                break;

            case '*':
                resultado = Operacoes.multiplicacao(x, y);
                break;

            case '/':
                resultado = Operacoes.divisao(x, y);
                break;
        }
        
        return resultado;
    }
    

    /**
     * Decide qual operação será executada
     * @param operacao
     */
    private void decideOperacao(char operacao) {
        this.operador   = operacao;
        this.resultado  = this.resultado == 0.0 ? this.termo : this.resultado;
        this.entrada    = "0";
        this.termo      = 0.0;
    }
    
    /**
     * Função C (clear): apaga tudo e cancela a operação
     */
    private void apagarOperacao() {
        this.operador = this.charOperador;
        this.resultado = 0.0;
        this.atualizaEntrada(this.charDelete);
    }
    
    
    /**
     * Função Backspace: apaga último digito do termo
     */
    private void apagarUltimoDigito() {
        this.atualizaEntrada(this.charBackspace);
    }
    
    
    /**
     * Remove último caractere
     * @param str
     * @return String
     */
    private String removeUltimoChar(String str) {
        
        if (!str.equals(this.stringZero)) {
            str = str.substring(0, (str.length() - 1));
        }

        return str.isEmpty() ? this.stringZero : str;

    }
    
    
    /**
     * Verifica se é `,` ou outra coisa
     * @param str
     * @return 
     */
    private char trataVirgula(String str) {
        return str.equals(",") ? '.' : str.charAt(0);
    }


    /**
     * Verifica se existe alguma operação pendente
     * e se existe algum valor de entrada
     * @return 
     */
    private boolean podeOperar() {
        return this.operador != this.charOperador && !this.entrada.equals("0");
    }
    
    
    private void resolveOperacaoPorcentagem() {

        Double valor = Operacoes.porCentagem(this.resultado, this.termo);
        this.termo = 0.0;
        this.atualizaResultado(this.operador, this.resultado, valor);

    }
   
    
    /**
     * Creates new form CalcWin7
     */
    public CalcWin7() {
        this.termo = 0.0;
        this.memoria = "0";
        this.resultado = 0.0;
        this.operador = this.charOperador;
        
        this.digitos =  new ArrayList<String>(Arrays.asList(
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ",", "."
        ));
        this.operacoesEntreTermos = new ArrayList<String>(Arrays.asList(
            "+", "-", "*", "/"
        ));
        
        initComponents();
        
        this.atualizaEntrada(this.charDelete);
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        button1 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        button4 = new javax.swing.JButton();
        button5 = new javax.swing.JButton();
        button6 = new javax.swing.JButton();
        button7 = new javax.swing.JButton();
        button8 = new javax.swing.JButton();
        button9 = new javax.swing.JButton();
        button0 = new javax.swing.JButton();
        buttonPontoFlutuante = new javax.swing.JButton();
        buttonAdicao = new javax.swing.JButton();
        buttonSubtracao = new javax.swing.JButton();
        buttonMultiplicacao = new javax.swing.JButton();
        buttonDivisao = new javax.swing.JButton();
        buttonIgual = new javax.swing.JButton();
        buttonInverteNumero = new javax.swing.JButton();
        buttonPorcentagem = new javax.swing.JButton();
        buttonRaizQuadrada = new javax.swing.JButton();
        buttonInverteSinal = new javax.swing.JButton();
        buttonLimpaTudo = new javax.swing.JButton();
        buttonLimpaTermo = new javax.swing.JButton();
        buttonBackspace = new javax.swing.JButton();
        buttonMC = new javax.swing.JButton();
        buttonMR = new javax.swing.JButton();
        buttonMS = new javax.swing.JButton();
        buttonMPlus = new javax.swing.JButton();
        buttonMLess = new javax.swing.JButton();
        fieldDisplay = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buttonsPress(evt);
            }
        });

        button1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        button1.setText("1");
        button1.setFocusable(false);
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                digitosClique(evt);
            }
        });

        button2.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        button2.setText("2");
        button2.setFocusable(false);
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                digitosClique(evt);
            }
        });

        button3.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        button3.setText("3");
        button3.setFocusable(false);
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                digitosClique(evt);
            }
        });

        button4.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        button4.setText("4");
        button4.setFocusable(false);
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                digitosClique(evt);
            }
        });

        button5.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        button5.setText("5");
        button5.setFocusable(false);
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                digitosClique(evt);
            }
        });

        button6.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        button6.setText("6");
        button6.setFocusable(false);
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                digitosClique(evt);
            }
        });

        button7.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        button7.setText("7");
        button7.setFocusable(false);
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                digitosClique(evt);
            }
        });

        button8.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        button8.setText("8");
        button8.setFocusable(false);
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                digitosClique(evt);
            }
        });

        button9.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        button9.setText("9");
        button9.setFocusable(false);
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                digitosClique(evt);
            }
        });

        button0.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        button0.setText("0");
        button0.setFocusable(false);
        button0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                digitosClique(evt);
            }
        });

        buttonPontoFlutuante.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        buttonPontoFlutuante.setText(",");
        buttonPontoFlutuante.setFocusable(false);
        buttonPontoFlutuante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                digitosClique(evt);
            }
        });

        buttonAdicao.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        buttonAdicao.setText("+");
        buttonAdicao.setFocusable(false);
        buttonAdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleDecideOperacao(evt);
            }
        });

        buttonSubtracao.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        buttonSubtracao.setText("-");
        buttonSubtracao.setFocusable(false);
        buttonSubtracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleDecideOperacao(evt);
            }
        });

        buttonMultiplicacao.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        buttonMultiplicacao.setText("*");
        buttonMultiplicacao.setFocusable(false);
        buttonMultiplicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleDecideOperacao(evt);
            }
        });

        buttonDivisao.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        buttonDivisao.setText("/");
        buttonDivisao.setFocusable(false);
        buttonDivisao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleDecideOperacao(evt);
            }
        });

        buttonIgual.setBackground(new java.awt.Color(31, 145, 238));
        buttonIgual.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        buttonIgual.setForeground(new java.awt.Color(254, 254, 254));
        buttonIgual.setText("=");
        buttonIgual.setFocusable(false);
        buttonIgual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleResolveOperacao(evt);
            }
        });

        buttonInverteNumero.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        buttonInverteNumero.setText("1/x");
        buttonInverteNumero.setFocusable(false);
        buttonInverteNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleInverteBase(evt);
            }
        });

        buttonPorcentagem.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        buttonPorcentagem.setText("%");
        buttonPorcentagem.setFocusable(false);
        buttonPorcentagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleOperaPorcentagem(evt);
            }
        });

        buttonRaizQuadrada.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        buttonRaizQuadrada.setText("√");
        buttonRaizQuadrada.setFocusable(false);
        buttonRaizQuadrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleRaizQuadrada(evt);
            }
        });

        buttonInverteSinal.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        buttonInverteSinal.setText("±");
        buttonInverteSinal.setFocusable(false);
        buttonInverteSinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleInverteSinal(evt);
            }
        });

        buttonLimpaTudo.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        buttonLimpaTudo.setText("C");
        buttonLimpaTudo.setFocusable(false);
        buttonLimpaTudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleApagarOperacao(evt);
            }
        });

        buttonLimpaTermo.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        buttonLimpaTermo.setText("CE");
        buttonLimpaTermo.setFocusable(false);
        buttonLimpaTermo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagarEntrada(evt);
            }
        });

        buttonBackspace.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        buttonBackspace.setText("<=");
        buttonBackspace.setFocusable(false);
        buttonBackspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleBackspace(evt);
            }
        });

        buttonMC.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        buttonMC.setText("MC");
        buttonMC.setFocusable(false);
        buttonMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpaMemoria(evt);
            }
        });

        buttonMR.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        buttonMR.setText("MR");
        buttonMR.setFocusable(false);
        buttonMR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chamaValorMemoria(evt);
            }
        });

        buttonMS.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        buttonMS.setText("MS");
        buttonMS.setFocusable(false);
        buttonMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvaNaMemoria(evt);
            }
        });

        buttonMPlus.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        buttonMPlus.setText("M+");
        buttonMPlus.setFocusable(false);
        buttonMPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleOperacaoMemoria(evt);
            }
        });

        buttonMLess.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        buttonMLess.setText("M-");
        buttonMLess.setFocusable(false);
        buttonMLess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleOperacaoMemoria(evt);
            }
        });

        fieldDisplay.setEditable(false);
        fieldDisplay.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldDisplay.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonMC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonMR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(button0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(button7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonBackspace, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonLimpaTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPontoFlutuante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonLimpaTudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonMS, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonAdicao, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(buttonSubtracao, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(buttonMultiplicacao, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(buttonInverteSinal, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(buttonMPlus, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(buttonDivisao, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonRaizQuadrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonIgual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonInverteNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPorcentagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonMLess, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(fieldDisplay)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fieldDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonMC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonMR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonMS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonMPlus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonMLess, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonRaizQuadrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonInverteSinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonLimpaTudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonLimpaTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonBackspace, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDivisao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonInverteNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonMultiplicacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(buttonSubtracao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonPontoFlutuante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonAdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(buttonIgual, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Método chamado quando se clica em um botão de dígito
     * @param evt 
     */
    private void digitosClique(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_digitosClique
        
        char digito = this.trataVirgula(evt.getActionCommand());
        this.atualizaEntrada(digito);
        
    }//GEN-LAST:event_digitosClique

    
    /**
     * Método chamado quando se aperta um botão
     * @param evt 
     */
    private void buttonsPress(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonsPress
        
        char tecla = this.trataVirgula("" + evt.getKeyChar());

        if (evt.getKeyCode() == this.numEnter) {

            if (this.podeOperar()) {
                this.atualizaResultado(this.operador, this.resultado, this.termo);
            }

        } else if (evt.getKeyCode() == this.numDelete) {
            this.apagarOperacao();

        } else if (evt.getKeyCode() == this.numBackspace) {
            this.apagarUltimoDigito();

        } else if (tecla == this.charPorcentagem) {
            this.resolveOperacaoPorcentagem();
            
        } else if (this.digitos.contains("" + tecla)) {
            this.atualizaEntrada(tecla);

        } else if (this.operacoesEntreTermos.contains("" + tecla)) {
            this.decideOperacao(tecla);

        }
    }//GEN-LAST:event_buttonsPress

    
    /**
     * Função CE (clear entry): apaga o termo atual
     */
    private void apagarEntrada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagarEntrada
        this.atualizaEntrada(this.charDelete);
    }//GEN-LAST:event_apagarEntrada

    
    /**
     * Chama o método de apagar a operação através do clique no botão `C`
     * @param evt 
     */
    private void handleApagarOperacao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleApagarOperacao
        this.apagarOperacao();
    }//GEN-LAST:event_handleApagarOperacao

    
    /**
     * Chama o método de remover o último caractere
     * através do clique no botão de backspace
     * @param evt 
     */
    private void handleBackspace(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleBackspace
        this.apagarUltimoDigito();
    }//GEN-LAST:event_handleBackspace


    /**
     * Função MS (memory store): salva o valor do termo na memória
     */
    private void salvaNaMemoria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvaNaMemoria
        this.memoria = this.entrada;
    }//GEN-LAST:event_salvaNaMemoria

    
    /**
     * Função MR (memory recall): chama o valor da memória
     */
    private void chamaValorMemoria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chamaValorMemoria
        this.atualizaEntrada(this.charMemoryRecall);
    }//GEN-LAST:event_chamaValorMemoria


    /**
     * Função MC (memory clear): limpa o valor da memória
     */
    private void limpaMemoria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpaMemoria
        this.memoria = "0";
    }//GEN-LAST:event_limpaMemoria

    
    private void handleInverteSinal(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleInverteSinal
        this.resolveOperacaoUnica(this.charSinalInverso);
    }//GEN-LAST:event_handleInverteSinal

    private void handleRaizQuadrada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleRaizQuadrada
        this.resolveOperacaoUnica(this.charRaizQuadrada);
    }//GEN-LAST:event_handleRaizQuadrada

    private void handleInverteBase(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleInverteBase
        this.resolveOperacaoUnica(this.charBaseInvertida);
    }//GEN-LAST:event_handleInverteBase

    private void handleDecideOperacao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleDecideOperacao
        this.decideOperacao(evt.getActionCommand().charAt(0));
    }//GEN-LAST:event_handleDecideOperacao

    private void handleResolveOperacao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleResolveOperacao
        if (this.podeOperar()) {
            this.atualizaResultado(this.operador, this.resultado, this.termo);
        }
    }//GEN-LAST:event_handleResolveOperacao

    
    /**
     * Realiza operações de memória e salva novo valor de memória
     * @param evt 
     */
    private void handleOperacaoMemoria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleOperacaoMemoria

        char operacao = evt.getActionCommand().charAt(1);
        Double termo1 = Double.parseDouble(this.memoria);
        Double termo2 = Double.parseDouble(this.entrada);
        
        this.memoria = this.resolveOperacao(operacao, termo1, termo2).toString();
        
        this.atualizaEntrada(this.charUpdateTermo);

    }//GEN-LAST:event_handleOperacaoMemoria

    private void handleOperaPorcentagem(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleOperaPorcentagem
        this.resolveOperacaoPorcentagem();
    }//GEN-LAST:event_handleOperaPorcentagem


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CalcWin7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalcWin7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalcWin7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalcWin7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalcWin7().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button0;
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JButton button4;
    private javax.swing.JButton button5;
    private javax.swing.JButton button6;
    private javax.swing.JButton button7;
    private javax.swing.JButton button8;
    private javax.swing.JButton button9;
    private javax.swing.JButton buttonAdicao;
    private javax.swing.JButton buttonBackspace;
    private javax.swing.JButton buttonDivisao;
    private javax.swing.JButton buttonIgual;
    private javax.swing.JButton buttonInverteNumero;
    private javax.swing.JButton buttonInverteSinal;
    private javax.swing.JButton buttonLimpaTermo;
    private javax.swing.JButton buttonLimpaTudo;
    private javax.swing.JButton buttonMC;
    private javax.swing.JButton buttonMLess;
    private javax.swing.JButton buttonMPlus;
    private javax.swing.JButton buttonMR;
    private javax.swing.JButton buttonMS;
    private javax.swing.JButton buttonMultiplicacao;
    private javax.swing.JButton buttonPontoFlutuante;
    private javax.swing.JButton buttonPorcentagem;
    private javax.swing.JButton buttonRaizQuadrada;
    private javax.swing.JButton buttonSubtracao;
    private javax.swing.JTextField fieldDisplay;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
