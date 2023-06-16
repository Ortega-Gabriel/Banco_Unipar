/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancounipar.services;

import com.mycompany.bancounipar.exceptions.CampoNaoInformadoException;
import com.mycompany.bancounipar.exceptions.EntidadeNaoInformadaException;
import com.mycompany.bancounipar.exceptions.TamanhoCampoInvalidoException;
import com.mycompany.bancounipar.models.Agencia;
import com.mycompany.bancounipar.repositories.AgenciaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author crist
 */
public class AgenciaService {
    
    private void validar(Agencia agencia) throws 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException{
        
        if (agencia == null) {
            throw new EntidadeNaoInformadaException("Agencia");
        }
        
        if (agencia.getCodigo() == null || 
            agencia.getCodigo().isEmpty() ||
            agencia.getCodigo().isBlank()) {
            throw new CampoNaoInformadoException("Código");
        }
        
        if (agencia.getDigito() == null || 
            agencia.getDigito().isEmpty() ||
            agencia.getDigito().isBlank()) {
            throw new CampoNaoInformadoException("Digito");
        }
        
        if (agencia.getRazaoSocial() == null || 
            agencia.getRazaoSocial().isEmpty() ||
            agencia.getRazaoSocial().isBlank()) {
            throw new CampoNaoInformadoException("Razão Social");
        }
        
        if (agencia.getCnpj() == null || 
            agencia.getCnpj().isEmpty() ||
            agencia.getCnpj().isBlank()) {
            throw new CampoNaoInformadoException("CNPJ");
        }
        
        if (agencia.getRa() == null || 
            agencia.getRa().isEmpty() ||
            agencia.getRa().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }
        
        if (agencia.getBanco() == null) {
            throw new CampoNaoInformadoException("Banco");
        }
        
        if (agencia.getCodigo().length() > 10) {
            throw new TamanhoCampoInvalidoException("Código", 10);
        }
        
        if (agencia.getDigito().length() > 1) {
            throw new TamanhoCampoInvalidoException("Digito", 1);
        }
        
        if (agencia.getRazaoSocial().length() > 100) {
            throw new TamanhoCampoInvalidoException("Razão Social", 100);
        }
        
        if (agencia.getCnpj().length() > 14) {
            throw new TamanhoCampoInvalidoException("CNPJ", 14);
        }
        
        if (agencia.getRa().length() > 50) {
            throw new TamanhoCampoInvalidoException("RA", 50);
        }
    }
    
    public List<Agencia> findAll() throws SQLException {
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        List<Agencia> resultado =  agenciaDAO.findAll();
        
        return resultado;
    }
    
    public Agencia findById(int id) throws SQLException, 
            TamanhoCampoInvalidoException, Exception {
        
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        
        Agencia retorno = agenciaDAO.findById(id);
        
        if (retorno == null)
            throw new Exception("Não foi possível encontrar uma agência"
                    + " com o ID: " + id + " informado");
        
        return retorno;
    }
    
    public void insert(Agencia agencia) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(agencia);
        
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.insert(agencia);
    }
    
    public void update(Agencia agencia) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(agencia);
        
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.update(agencia);
    }
    
    public void deleteById(int id) throws SQLException, 
            TamanhoCampoInvalidoException {
        
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.deleteById(id);
    }
}

