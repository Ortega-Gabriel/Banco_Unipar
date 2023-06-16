/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancounipar.services;

import com.mycompany.bancounipar.exceptions.CampoNaoInformadoException;
import com.mycompany.bancounipar.exceptions.EntidadeNaoInformadaException;
import com.mycompany.bancounipar.exceptions.TamanhoCampoInvalidoException;
import com.mycompany.bancounipar.models.Estado;
import com.mycompany.bancounipar.repositories.EstadoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author crist
 */
public class EstadoService {
    
    private void validar(Estado estado) throws 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException{
        
        if (estado == null) {
            throw new EntidadeNaoInformadaException("Estado");
        }
        
        if (estado.getNome() == null || 
            estado.getNome().isEmpty() ||
            estado.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome");
        }
        
        if (estado.getSigla() == null || 
            estado.getSigla().isEmpty() ||
            estado.getSigla().isBlank()) {
            throw new CampoNaoInformadoException("Sigla");
        }
        
        if (estado.getRa() == null || 
            estado.getRa().isEmpty() ||
            estado.getRa().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }
        
        if (estado.getPais() == null) {
            throw new CampoNaoInformadoException("Pais");
        }
        
        if (estado.getNome().length() > 100) {
            throw new TamanhoCampoInvalidoException("Nome", 100);
        }
        
        if (estado.getSigla().length() > 10) {
            throw new TamanhoCampoInvalidoException("Sigla", 10);
        }
        
        if (estado.getRa().length() > 10) {
            throw new TamanhoCampoInvalidoException("RA", 10);
        }
    }
    
    public List<Estado> findAll() throws SQLException {
        EstadoDAO estadoDAO = new EstadoDAO();
        List<Estado> resultado = estadoDAO.findAll();
        
        return resultado;
    }
    
    public Estado findById(int id) throws SQLException, 
            TamanhoCampoInvalidoException, Exception {
        
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        EstadoDAO estadoDAO = new EstadoDAO();
        
        Estado retorno = estadoDAO.findById(id);
        
        if (retorno == null)
            throw new Exception("Não foi possível encontrar um estado"
                    + " com o ID: " + id + " informado");
        
        return retorno;
    }
    
    public void insert(Estado estado) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(estado);
        
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.insert(estado);
    }
    
    public void update(Estado estado) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(estado);
        
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.update(estado);
    }
    
    public void deleteById(int id) throws SQLException, 
            TamanhoCampoInvalidoException {
        
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.deleteById(id);
    }
}
