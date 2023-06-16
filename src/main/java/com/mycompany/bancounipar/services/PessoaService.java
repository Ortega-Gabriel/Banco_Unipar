/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancounipar.services;

import com.mycompany.bancounipar.exceptions.CampoNaoInformadoException;
import com.mycompany.bancounipar.exceptions.EntidadeNaoInformadaException;
import com.mycompany.bancounipar.exceptions.TamanhoCampoInvalidoException;
import com.mycompany.bancounipar.models.Pessoa;
import com.mycompany.bancounipar.repositories.PessoaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author crist
 */
public class PessoaService {

    private void validar(Pessoa pessoa) throws
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {

        if (pessoa == null) {
            throw new EntidadeNaoInformadaException("Pessoa");
        }

        if (pessoa.getId() <= 0) {
            throw new TamanhoCampoInvalidoException("ID", pessoa.getId());
        }

        if (pessoa.getEmail() == null ||
                pessoa.getEmail().isEmpty() ||
                pessoa.getEmail().isBlank()) {
            throw new CampoNaoInformadoException("Email");
        }

        if (pessoa.getRa() == null ||
                pessoa.getRa().isEmpty() ||
                pessoa.getRa().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }

    }

    public List<Pessoa> findAll() throws SQLException {
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Pessoa> resultado = pessoaDAO.findAll();
        return resultado;
    }

    public Pessoa findById(int id) throws SQLException,
            TamanhoCampoInvalidoException, Exception {
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);

        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa retorno = pessoaDAO.findById(id);

        if (retorno == null)
            throw new Exception("Não foi possível encontrar uma Pessoa com o ID: " + id + " informado");

        return retorno;
    }

    public void insert(Pessoa pessoa) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(pessoa);
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.insert(pessoa);
    }

    public void update(Pessoa pessoa) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(pessoa);
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.update(pessoa);
    }

    public void deleteById(int id) throws SQLException {
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.deleteById(id);
    }
}
