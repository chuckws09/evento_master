package view;

import controller.PessoaController;
import model.entity.Pessoa;

public class JInternalFrameCadastroPessoa extends javax.swing.JInternalFrame {

    private final PessoaController pessoaController;
    
    public JInternalFrameCadastroPessoa() {
        pessoaController = new PessoaController(this);
        
        initComponents();
        
        cancelarButton.addActionListener(pessoaController);
        salvarButton.addActionListener(pessoaController);
    }
    
    public Pessoa getPessoa() throws Exception
    {        
        Pessoa p = new Pessoa();
        p.setNome(cadastroNomePessoa.getText());
        p.setSobrenome(cadastroSobrenomePessoa.getText());
        
        return p;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        cadastroNomePessoa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cadastroSobrenomePessoa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cancelarButton = new javax.swing.JButton();
        salvarButton = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastro de pessoa");
        setPreferredSize(new java.awt.Dimension(400, 223));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Cadastro de pessoa");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));
        getContentPane().add(cadastroNomePessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 320, -1));

        jLabel1.setText("Sobrenome");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));
        getContentPane().add(cadastroSobrenomePessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 290, -1));

        jLabel3.setText("Nome");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        cancelarButton.setText("Cancelar");
        getContentPane().add(cancelarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        salvarButton.setText("Salvar");
        getContentPane().add(salvarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cadastroNomePessoa;
    private javax.swing.JTextField cadastroSobrenomePessoa;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton salvarButton;
    // End of variables declaration//GEN-END:variables
}
