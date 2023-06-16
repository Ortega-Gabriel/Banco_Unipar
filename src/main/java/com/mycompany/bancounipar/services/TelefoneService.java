/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancounipar.services;

import com.mycompany.bancounipar.exceptions.CampoNaoInformadoException;
import com.mycompany.bancounipar.exceptions.EntidadeNaoInformadaException;
import com.mycompany.bancounipar.exceptions.TamanhoCampoInvalidoException;
import com.mycompany.bancounipar.models.Telefone;
import com.mycompany.bancounipar.repositories.TelefoneDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author crist
 */
public class TelefoneService {

    private void validar(Telefone telefone) throws
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {

        if (telefone == null) {
            throw new EntidadeNaoInformadaException("Telefone");
        }

        if (telefone.getId() <= 0) {
            throw new TamanhoCampoInvalidoException("ID", telefone.getId());
        }

        if (telefone.getNumero() == null ||
                telefone.getNumero().isEmpty() ||
                telefone.getNumero().isBlank()) {
            throw new CampoNaoInformadoException("Número");
        }

        if (telefone.getOperadora() <= 0) {
            throw new TamanhoCampoInvalidoException("Operadora", telefone.getOperadora());
        }

        if (telefone.getRa() == null ||
                telefone.getRa().isEmpty() ||
                telefone.getRa().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }

        if (telefone.getAgencia() == null ||
                telefone.getAgencia().getId() <= 0) {
            throw new CampoNaoInformadoException("Agência");
        }

        if (telefone.getPessoa() == null ||
                telefone.getPessoa().getId() <= 0) {
            throw new CampoNaoInformadoException("Pessoa");
        }
        
    }

    public List<Telefone> findAll() throws SQLException {
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        List<Telefone> resultado = telefoneDAO.findAll();
        return resultado;
    }

    public Telefone findById(int id) throws SQLException,
            TamanhoCampoInvalidoException, Exception {
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("ID", id);

        TelefoneDAO telefoneDAO = new TelefoneDAO();
        Telefone retorno = telefoneDAO.findById(id);

        if (retorno == null)
            throw new Exception("Não foi possível encontrar um Telefone com o ID: " + id + " informado");

        return retorno;
    }

    public void insert(Telefone telefone) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(telefone);
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.insert(telefone);
    }

    public void update(Telefone telefone) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(telefone);
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.update(telefone);
    }

    public void deleteById(int id) throws SQLException {
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.deleteById(id);
    }
}
