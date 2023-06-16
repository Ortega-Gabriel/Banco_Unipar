/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancounipar.services;

import com.mycompany.bancounipar.exceptions.CampoNaoInformadoException;
import com.mycompany.bancounipar.exceptions.EntidadeNaoInformadaException;
import com.mycompany.bancounipar.exceptions.TamanhoCampoInvalidoException;
import com.mycompany.bancounipar.models.Cidade;
import com.mycompany.bancounipar.repositories.CidadeDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author crist
 */
public class CidadeService {
    
    private void validar(Cidade cidade) throws 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException{
        
        if (cidade == null) {
            throw new EntidadeNaoInformadaException("Cidade");
        }
        
        if (cidade.getNome() == null || 
            cidade.getNome().isEmpty() ||
            cidade.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome");
        }
        
        if (cidade.getRa() == null || 
            cidade.getRa().isEmpty() ||
            cidade.getRa().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }
        
        if (cidade.getNome().length() > 100) {
            throw new TamanhoCampoInvalidoException("Nome", 100);
        }
        
        if (cidade.getRa().length() > 50) {
            throw new TamanhoCampoInvalidoException("RA", 50);
        }
    }
    
    public List<Cidade> findAll() throws SQLException {
        CidadeDAO cidadeDAO = new CidadeDAO();
        List<Cidade> resultado = cidadeDAO.findAll();
        
        return resultado;
    }
    
    public Cidade findById(int id) throws SQLException, 
            TamanhoCampoInvalidoException, Exception {
        
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        CidadeDAO cidadeDAO = new CidadeDAO();
        
        Cidade retorno = cidadeDAO.findById(id);
        
        if (retorno == null)
            throw new Exception("Não foi possível encontrar uma cidade"
                    + " com o ID: " + id + " informado");
        
        return retorno;
    }
    
    public void insert(Cidade cidade) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(cidade);
        
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.insert(cidade);
    }
    
    public void update(Cidade cidade) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(cidade);
        
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.update(cidade);
    }
    
    public void deleteById(int id) throws SQLException, 
            TamanhoCampoInvalidoException {
        
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.deleteById(id);
    }
}
