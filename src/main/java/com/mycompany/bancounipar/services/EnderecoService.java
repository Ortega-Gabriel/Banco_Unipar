/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancounipar.services;

import com.mycompany.bancounipar.exceptions.CampoNaoInformadoException;
import com.mycompany.bancounipar.exceptions.EntidadeNaoInformadaException;
import com.mycompany.bancounipar.exceptions.TamanhoCampoInvalidoException;
import com.mycompany.bancounipar.models.Endereco;
import com.mycompany.bancounipar.repositories.EnderecoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author crist
 */
public class EnderecoService {
    
    private void validar(Endereco endereco) throws 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException{
        
        if (endereco == null) {
            throw new EntidadeNaoInformadaException("Endereço");
        }
        
        if (endereco.getLogradouro() == null || 
            endereco.getLogradouro().isEmpty() ||
            endereco.getLogradouro().isBlank()) {
            throw new CampoNaoInformadoException("Logradouro");
        }
        
        if (endereco.getNumero() == null || 
            endereco.getNumero().isEmpty() ||
            endereco.getNumero().isBlank()) {
            throw new CampoNaoInformadoException("Número");
        }
        
        if (endereco.getBairro() == null || 
            endereco.getBairro().isEmpty() ||
            endereco.getBairro().isBlank()) {
            throw new CampoNaoInformadoException("Bairro");
        }
        
        if (endereco.getCep() == null || 
            endereco.getCep().isEmpty() ||
            endereco.getCep().isBlank()) {
            throw new CampoNaoInformadoException("CEP");
        }
        
        if (endereco.getComplemento() == null || 
            endereco.getComplemento().isEmpty() ||
            endereco.getComplemento().isBlank()) {
            throw new CampoNaoInformadoException("Complemento");
        }
        
        if (endereco.getPessoa() == null) {
            throw new CampoNaoInformadoException("Pessoa");
        }
        
        if (endereco.getCidade() == null) {
            throw new CampoNaoInformadoException("Cidade");
        }
        
        if (endereco.getLogradouro().length() > 100) {
            throw new TamanhoCampoInvalidoException("Logradouro", 100);
        }
        
        if (endereco.getNumero().length() > 20) {
            throw new TamanhoCampoInvalidoException("Número", 20);
        }
        
        if (endereco.getBairro().length() > 100) {
            throw new TamanhoCampoInvalidoException("Bairro", 100);
        }
        
        if (endereco.getCep().length() > 10) {
            throw new TamanhoCampoInvalidoException("CEP", 10);
        }
        
        if (endereco.getComplemento().length() > 100) {
            throw new TamanhoCampoInvalidoException("Complemento", 100);
        }
    }
    
    public List<Endereco> findAll() throws SQLException {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        List<Endereco> resultado = enderecoDAO.findAll();
        
        return resultado;
    }
    
    public Endereco findById(int id) throws SQLException, 
            TamanhoCampoInvalidoException, Exception {
        
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        
        Endereco retorno = enderecoDAO.findById(id);
        
        if (retorno == null)
            throw new Exception("Não foi possível encontrar um endereço"
                    + " com o ID: " + id + " informado");
        
        return retorno;
    }
    
    public void insert(Endereco endereco) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(endereco);
        
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.insert(endereco);
    }
    
    public void update(Endereco endereco) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(endereco);
        
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.update(endereco);
    }
    
    public void deleteById(int id) throws SQLException, 
            TamanhoCampoInvalidoException {
        
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.deleteById(id);
    }
}
