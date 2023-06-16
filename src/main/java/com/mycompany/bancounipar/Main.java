package com.mycompany.bancounipar;

import com.mycompany.bancounipar.exceptions.*;
import com.mycompany.bancounipar.models.*;
import com.mycompany.bancounipar.services.*;
import java.util.List;
import javax.swing.JOptionPane;


public class Main {

    public static void main(String[] args){
        
        try{
            AgenciaService agServ = new AgenciaService();
            
            
            //Consultado todas as Agências
            List<Agencia> agResultado = agServ.findAll();
            
            JOptionPane.showMessageDialog(null, agResultado);
            
            /*Inserindo uma Nova Agência
            Agencia agNova = new Agencia();
            agNova.setCodigo("23243800");
            agNova.setDigito("14563");
            agNova.setRazaoSocial("Teste Agência - 00232438");
            agNova.setCnpj("1234567896");
            agNova.setBanco(new BancoService().findById(485));
            agServ.insert(agNova);
            
            /*Atualizando o Cadastro de uma Agência
            agNova.setRazaoSocial("00232438 - Agência Teste");
            agServ.update(agNova);/
            
            //Encontrando a Agência
            Agencia agPesq = new Agencia();
            agPesq = agServ.findById(232438);
            JOptionPane.showMessageDialog(null, agPesq);
            
            /*Deletando o Cadastro da Agência
            agServ.deleteById(232438);*/
            
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        
                           
        
    }
}

