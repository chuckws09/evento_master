package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.dao.EtapaDAO;
import model.entity.Espaco;
import model.dao.SalaEventoDAO;
import model.dao.TipoEspacoDAO;
import model.entity.Etapa;
import view.JInternalFrameCadastroSalaEvento;
import view.JInternalFrameConsultaSalaEvento;

public class SalaEventoController implements ActionListener, ListSelectionListener{

    private JInternalFrameCadastroSalaEvento cadastroSalaEvento;
    private JInternalFrameConsultaSalaEvento consultaSalaEvento;
    
    public SalaEventoController(JInternalFrameCadastroSalaEvento cadastroSalaEvento)
    {
        this.cadastroSalaEvento = cadastroSalaEvento;
    }

    public SalaEventoController(JInternalFrameConsultaSalaEvento consultaSalaEvento)
    {
        this.consultaSalaEvento = consultaSalaEvento;
        
        SalaEventoDAO salaEventoDAO = new SalaEventoDAO();
        
        this.consultaSalaEvento.setListSalaEvento(salaEventoDAO.getList());
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
        SalaEventoDAO salaEventoDAO = new SalaEventoDAO();
        TipoEspacoDAO tipoEspacoDAO = new TipoEspacoDAO();
        
        try
        {
            Espaco espaco = cadastroSalaEvento.getEspaco();
            espaco.setTipoEspaco(tipoEspacoDAO.getById(1));

            if (salaEventoDAO.save(espaco) != null)
            {
                JOptionPane.showMessageDialog(cadastroSalaEvento, "Sala de evento salva com sucesso!", "Salvar sala de envento", JOptionPane.INFORMATION_MESSAGE);
                cadastroSalaEvento.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(cadastroSalaEvento, "Ocorreu um erro ao salvar", "Salvar sala de envento", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(cadastroSalaEvento, "Erro: " + e.getLocalizedMessage(), "Salvar sala de envento", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cancelarAcao()
    {
        if (cadastroSalaEvento != null)
        {
            cadastroSalaEvento.dispose();
        }
        else if (consultaSalaEvento != null)
        {
            consultaSalaEvento.dispose();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (consultaSalaEvento.getTable().getSelectedRow() > -1)
        {
            EtapaDAO etapaDAO = new EtapaDAO();
            
            Espaco espaco = consultaSalaEvento.getSalaSelecionada(consultaSalaEvento.getTable().getSelectedRow());
            
            List<Etapa> listEtapa = etapaDAO.getByEspaco(espaco);
            consultaSalaEvento.setSalaSelecionada(listEtapa);
        }
    }
}
