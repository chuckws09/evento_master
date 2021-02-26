package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.entity.Espaco;
import model.dao.EspacoCafeDAO;
import model.dao.EtapaDAO;
import model.dao.TipoEspacoDAO;
import model.entity.Etapa;
import view.JInternalFrameCadastroEspacoCafe;
import view.JInternalFrameConsultaEspacoCafe;

public class EspacoCafeController implements ActionListener, ListSelectionListener{

    private JInternalFrameCadastroEspacoCafe cadastroEspacoCafe;
    private JInternalFrameConsultaEspacoCafe consultaEspacoCafe;
    
    public EspacoCafeController(JInternalFrameCadastroEspacoCafe cadastroEspacoCafe)
    {
        this.cadastroEspacoCafe = cadastroEspacoCafe;
    }
    
    public EspacoCafeController(JInternalFrameConsultaEspacoCafe consultaEspacoCafe)
    {
        this.consultaEspacoCafe = consultaEspacoCafe;
        
        EspacoCafeDAO espacoCafeDAO = new EspacoCafeDAO();
        
        this.consultaEspacoCafe.setListEspacoCafe(espacoCafeDAO.getList());
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
        EspacoCafeDAO espacoCafeDAO = new EspacoCafeDAO();
        TipoEspacoDAO tipoEspacoDAO = new TipoEspacoDAO();
        try
        {
            Espaco espaco = cadastroEspacoCafe.getEspaco();
            espaco.setTipoEspaco(tipoEspacoDAO.getById(2));

            if (espacoCafeDAO.save(espaco) != null)
            {
                JOptionPane.showMessageDialog(cadastroEspacoCafe, "Espaço café salvo com sucesso!", "Salvar espaço café", JOptionPane.INFORMATION_MESSAGE);
                cadastroEspacoCafe.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(cadastroEspacoCafe, "Ocorreu um erro ao salvar", "Salvar espaço café", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(cadastroEspacoCafe, "Erro: " + e.getLocalizedMessage(), "Salvar espaço café", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cancelarAcao()
    {
        if (cadastroEspacoCafe != null)
        {
            cadastroEspacoCafe.dispose();
        }
        else if (consultaEspacoCafe != null)
        {
            consultaEspacoCafe.dispose();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (consultaEspacoCafe.getTable().getSelectedRow() > -1)
        {
            EtapaDAO etapaDAO = new EtapaDAO();
            
            Espaco espaco = consultaEspacoCafe.getEspacoSelecionado(consultaEspacoCafe.getTable().getSelectedRow());
            
            List<Etapa> listEtapa = etapaDAO.getByEspaco(espaco);
            consultaEspacoCafe.setEspacoSelecionado(listEtapa);
        }
    }
}
