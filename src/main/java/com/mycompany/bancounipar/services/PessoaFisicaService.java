/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancounipar.services;

import com.mycompany.bancounipar.exceptions.CampoNaoInformadoException;
import com.mycompany.bancounipar.exceptions.EntidadeNaoInformadaException;
import com.mycompany.bancounipar.exceptions.TamanhoCampoInvalidoException;
import com.mycompany.bancounipar.models.PessoaFisica;
import com.mycompany.bancounipar.repositories.PessoaFisicaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author crist
 */
public class PessoaFisicaService {

    private void validar(PessoaFisica pessoaFisica) throws
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {

        if (pessoaFisica == null) {
            throw new EntidadeNaoInformadaException("PessoaFisica");
        }

        if (pessoaFisica.getPessoa() == null) {
            throw new EntidadeNaoInformadaException("Pessoa");
        }

        if (pessoaFisica.getNome() == null ||
                pessoaFisica.getNome().isEmpty() ||
                pessoaFisica.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome");
        }

        if (pessoaFisica.getCpf() == null ||
                pessoaFisica.getCpf().isEmpty() ||
                pessoaFisica.getCpf().isBlank()) {
            throw new CampoNaoInformadoException("CPF");
        }

        if (pessoaFisica.getRg() == null ||
                pessoaFisica.getRg().isEmpty() ||
                pessoaFisica.getRg().isBlank()) {
            throw new CampoNaoInformadoException("RG");
        }

    }

    public List<PessoaFisica> findAll() throws SQLException {
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        List<PessoaFisica> resultado = pessoaFisicaDAO.findAll();
        return resultado;
    }

    public PessoaFisica findById(int id) throws SQLException,
            TamanhoCampoInvalidoException, Exception {
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaFisica retorno = pessoaFisicaDAO.findById(id);

        if (retorno == null)
            throw new Exception("Não foi possível encontrar uma PessoaFisica com o ID: " + id + " informado");

        return retorno;
    }

    public void insert(PessoaFisica pessoaFisica) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(pessoaFisica);
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.insert(pessoaFisica);
    }

    public void update(PessoaFisica pessoaFisica) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(pessoaFisica);
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.update(pessoaFisica);
    }

    public void deleteById(int id) throws SQLException {
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.deleteById(id);
    }
}