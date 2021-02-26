package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import view.JFrameInicial;
import view.JInternalFrameCadastroEspacoCafe;
import view.JInternalFrameCadastroSalaEvento;
import view.JInternalFrameCadastroPessoa;
import view.JInternalFrameConsultaEspacoCafe;
import view.JInternalFrameConsultaPessoa;
import view.JInternalFrameConsultaSalaEvento;

public class InicialController implements ActionListener{

    private final JFrameInicial inicial;
    
    private JInternalFrameCadastroPessoa cadastroPessoa;
    private JInternalFrameCadastroSalaEvento cadastoSalaEvento;    
    private JInternalFrameCadastroEspacoCafe cadastroEspacoCafe;
    private JInternalFrameConsultaPessoa consultaPessoa;
    private JInternalFrameConsultaSalaEvento consultaSalaEvento;
    private JInternalFrameConsultaEspacoCafe consultaEspacoCafe;
    
    public InicialController(JFrameInicial inicial)
    {
        this.inicial = inicial;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand())
        {
            case "Encerrar programa":
                encerrarPrograma();
                break;

            case "Cadastro Pessoa":
                cadastroPessoa();
                break;

            case "Cadastro Sala Evento":
                cadastroSalaEvento();
                break;

            case "Cadastro Espaço Café":
                cadastroEspacoCafe();
                break;
                
            case "Consulta Pessoa":
                consultaPessoa();
                break;
                
            case "Consulta Sala Evento":
                consultaSalaEvento();
                break;
                
            case "Consulta Espaço Café":
                consultaEspacoCafe();
                break;
        }
    }
    
    private void cadastroPessoa()
    {
        cadastroPessoa = new JInternalFrameCadastroPessoa();
        iniciarInternalFram(cadastroPessoa);
    }
    
    private void cadastroSalaEvento()
    {
        cadastoSalaEvento = new JInternalFrameCadastroSalaEvento();
        iniciarInternalFram(cadastoSalaEvento);
    }
    
    private void cadastroEspacoCafe()
    {
        cadastroEspacoCafe = new JInternalFrameCadastroEspacoCafe();
        iniciarInternalFram(cadastroEspacoCafe);
    }
    
    private void consultaPessoa()
    {
        consultaPessoa = new JInternalFrameConsultaPessoa();
        iniciarInternalFram(consultaPessoa);
    }
    
    private void consultaSalaEvento()
    {
        consultaSalaEvento = new JInternalFrameConsultaSalaEvento();
        iniciarInternalFram(consultaSalaEvento);
    }
    
    private void consultaEspacoCafe()
    {
        consultaEspacoCafe = new JInternalFrameConsultaEspacoCafe();
        iniciarInternalFram(consultaEspacoCafe);
    }
    
    private void iniciarInternalFram(JInternalFrame internalFrame)
    {
        inicial.getDesktopPane().removeAll();
        inicial.getDesktopPane().repaint();
        inicial.getDesktopPane().add(internalFrame);
        internalFrame.setVisible(true);
        inicial.getDesktopPane().setSelectedFrame(internalFrame);
    }
    
    private void encerrarPrograma()
    {
        System.exit(0);
    }
}
