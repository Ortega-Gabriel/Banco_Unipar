/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancounipar.services;

import com.mycompany.bancounipar.exceptions.CampoNaoInformadoException;
import com.mycompany.bancounipar.exceptions.EntidadeNaoInformadaException;
import com.mycompany.bancounipar.exceptions.TamanhoCampoInvalidoException;
import com.mycompany.bancounipar.models.PessoaJuridica;
import com.mycompany.bancounipar.repositories.PessoaJuridicaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author crist
 */
public class PessoaJuridicaService {

    private void validar(PessoaJuridica pessoaJuridica) throws
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {

        if (pessoaJuridica == null) {
            throw new EntidadeNaoInformadaException("PessoaJuridica");
        }

        if (pessoaJuridica.getPessoa() == null) {
            throw new EntidadeNaoInformadaException("Pessoa");
        }

        if (pessoaJuridica.getRazaoSocial() == null ||
                pessoaJuridica.getRazaoSocial().isEmpty() ||
                pessoaJuridica.getRazaoSocial().isBlank()) {
            throw new CampoNaoInformadoException("Razão Social");
        }

        if (pessoaJuridica.getCnpj() == null ||
                pessoaJuridica.getCnpj().isEmpty() ||
                pessoaJuridica.getCnpj().isBlank()) {
            throw new CampoNaoInformadoException("CNPJ");
        }

        if (pessoaJuridica.getCnaePrincipal() == null ||
                pessoaJuridica.getCnaePrincipal().isEmpty() ||
                pessoaJuridica.getCnaePrincipal().isBlank()) {
            throw new CampoNaoInformadoException("CNAE Principal");
        }

    }

    public List<PessoaJuridica> findAll() throws SQLException {
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        List<PessoaJuridica> resultado = pessoaJuridicaDAO.findAll();
        return resultado;
    }

    public PessoaJuridica findById(int id) throws SQLException,
            TamanhoCampoInvalidoException, Exception {
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);

        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        PessoaJuridica retorno = pessoaJuridicaDAO.findById(id);

        if (retorno == null)
            throw new Exception("Não foi possível encontrar uma PessoaJuridica com o ID: " + id + " informado");

        return retorno;
    }

    public void insert(PessoaJuridica pessoaJuridica) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(pessoaJuridica);
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.insert(pessoaJuridica);
    }

    public void update(PessoaJuridica pessoaJuridica) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(pessoaJuridica);
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.update(pessoaJuridica);
    }

    public void deleteById(int id) throws SQLException {
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.deleteById(id);
    }
}
