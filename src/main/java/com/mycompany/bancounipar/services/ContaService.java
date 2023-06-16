/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancounipar.services;

import com.mycompany.bancounipar.exceptions.CampoNaoInformadoException;
import com.mycompany.bancounipar.exceptions.EntidadeNaoInformadaException;
import com.mycompany.bancounipar.exceptions.TamanhoCampoInvalidoException;
import com.mycompany.bancounipar.models.Conta;
import com.mycompany.bancounipar.repositories.ContaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author crist
 */
public class ContaService {
    
    private void validar(Conta conta) throws 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException{
        
        if (conta == null) {
            throw new EntidadeNaoInformadaException("Conta");
        }
        
        if (conta.getNumero() == null || 
            conta.getNumero().isEmpty() ||
            conta.getNumero().isBlank()) {
            throw new CampoNaoInformadoException("Número");
        }
        
        if (conta.getDigito() == null || 
            conta.getDigito().isEmpty() ||
            conta.getDigito().isBlank()) {
            throw new CampoNaoInformadoException("Dígito");
        }
        
        if (conta.getSaldo() < 0) {
            throw new CampoNaoInformadoException("Saldo");
        }
        
        if (conta.getNumero().length() > 20) {
            throw new TamanhoCampoInvalidoException("Número", 20);
        }
        
        if (conta.getDigito().length() > 5) {
            throw new TamanhoCampoInvalidoException("Dígito", 5);
        }
    }
    
    public List<Conta> findAll() throws SQLException {
        ContaDAO contaDAO = new ContaDAO();
        List<Conta> resultado = contaDAO.findAll();
        
        return resultado;
    }
    
    public Conta findById(int id) throws SQLException, 
            TamanhoCampoInvalidoException, Exception {
        
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        ContaDAO contaDAO = new ContaDAO();
        
        Conta retorno = contaDAO.findById(id);
        
        if (retorno == null)
            throw new Exception("Não foi possível encontrar uma conta"
                    + " com o ID: " + id + " informado");
        
        return retorno;
    }
    
    public void insert(Conta conta) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(conta);
        
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.insert(conta);
    }
    
    public void update(Conta conta) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(conta);
        
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.update(conta);
    }
    
    public void deleteById(int id) throws SQLException, 
            TamanhoCampoInvalidoException {
        
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.deleteById(id);
    }
}
