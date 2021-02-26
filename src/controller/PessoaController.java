package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.dao.EtapaDAO;
import model.dao.PessoaDAO;
import model.entity.Etapa;
import model.entity.Pessoa;
import view.JInternalFrameCadastroPessoa;
import view.JInternalFrameConsultaPessoa;

public class PessoaController implements ActionListener, ListSelectionListener{

    private JInternalFrameCadastroPessoa cadastroPessoa;
    private JInternalFrameConsultaPessoa consultaPessoa;
    
    public PessoaController(JInternalFrameCadastroPessoa cadastroPessoa)
    {
        this.cadastroPessoa = cadastroPessoa;
    }
    
    public PessoaController(JInternalFrameConsultaPessoa consultaPessoa)
    {
        this.consultaPessoa = consultaPessoa;
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        this.consultaPessoa.setPessoas(pessoaDAO.getList());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand())
        {
            case "Salvar":
                salvarAcao();
                break;
            
            case "Cancelar":
                cancelarAcao();
                break;
        }
    }
    
    private void salvarAcao()
    {
        PessoaDAO pessoaDAO = new PessoaDAO();
        try
        {
            if (pessoaDAO.save(cadastroPessoa.getPessoa()) != null)
            {
                JOptionPane.showMessageDialog(cadastroPessoa, "Pessoa salva com sucesso!", "Salvar pessoa", JOptionPane.INFORMATION_MESSAGE);
                cadastroPessoa.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(cadastroPessoa, "Ocorreu um erro ao salvar", "Salvar pessoa", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(cadastroPessoa, "Erro: " + e.getLocalizedMessage(), "Salvar pessoa", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cancelarAcao()
    {
        if (cadastroPessoa != null)
        {
            cadastroPessoa.dispose();
        }
        if (consultaPessoa != null)
        {
            consultaPessoa.dispose();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (consultaPessoa.getTable().getSelectedRow() > -1)
        {
            EtapaDAO etapaDAO = new EtapaDAO();
            
            Pessoa pessoa = consultaPessoa.getPessoaSelecionada(consultaPessoa.getTable().getSelectedRow());
            
            List<Etapa> listEtapa = etapaDAO.getByPessoa(pessoa);
            consultaPessoa.setPessoaSelecionada(pessoa, listEtapa);
        }
    }
}
