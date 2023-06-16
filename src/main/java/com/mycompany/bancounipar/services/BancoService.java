/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancounipar.services;

import com.mycompany.bancounipar.exceptions.CampoNaoInformadoException;
import com.mycompany.bancounipar.exceptions.EntidadeNaoInformadaException;
import com.mycompany.bancounipar.exceptions.TamanhoCampoInvalidoException;
import com.mycompany.bancounipar.models.Banco;
import com.mycompany.bancounipar.repositories.BancoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author crist
 */
public class BancoService {
    
    private void validar(Banco banco) throws 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException{
        
        if (banco == null) {
            throw new EntidadeNaoInformadaException("Banco");
        }
        
        if (banco.getNome() == null || 
            banco.getNome().isEmpty() ||
            banco.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome");
        }
        
        if (banco.getRa() == null || 
            banco.getRa().isEmpty() ||
            banco.getRa().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }
        
        if (banco.getNome().length() > 100) {
            throw new TamanhoCampoInvalidoException("Nome", 100);
        }
        
        if (banco.getRa().length() > 50) {
            throw new TamanhoCampoInvalidoException("RA", 50);
        }
    }
    
    public List<Banco> findAll() throws SQLException {
        BancoDAO bancoDAO = new BancoDAO();
        List<Banco> resultado = bancoDAO.findAll();
        
        return resultado;
    }
    
    public Banco findById(int id) throws SQLException, 
            TamanhoCampoInvalidoException, Exception {
        
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        BancoDAO bancoDAO = new BancoDAO();
        
        Banco retorno = bancoDAO.findById(id);
        
        if (retorno == null)
            throw new Exception("Não foi possível encontrar um banco"
                    + " com o ID: " + id + " informado");
        
        return retorno;
    }
    
    public void insert(Banco banco) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(banco);
        
        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.insert(banco);
    }
    
    public void update(Banco banco) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(banco);
        
        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.update(banco);
    }
    
    public void deleteById(int id) throws SQLException, 
            TamanhoCampoInvalidoException {
        
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.deleteById(id);
    }
}