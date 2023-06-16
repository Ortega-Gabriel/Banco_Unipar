/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancounipar.services;

import com.mycompany.bancounipar.exceptions.CampoNaoInformadoException;
import com.mycompany.bancounipar.exceptions.EntidadeNaoInformadaException;
import com.mycompany.bancounipar.exceptions.TamanhoCampoInvalidoException;
import com.mycompany.bancounipar.models.Transacao;
import com.mycompany.bancounipar.repositories.TransacaoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author crist
 */
public class TransacaoService {

    private void validar(Transacao transacao) throws
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {

        if (transacao == null) {
            throw new EntidadeNaoInformadaException("Transação");
        }

        if (transacao.getId() <= 0) {
            throw new TamanhoCampoInvalidoException("ID", transacao.getId());
        }

    }

    public List<Transacao> findAll() throws SQLException {
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        List<Transacao> resultado = transacaoDAO.findAll();
        return resultado;
    }

    public Transacao findById(int id) throws SQLException,
            TamanhoCampoInvalidoException, Exception {
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("ID", id);

        TransacaoDAO transacaoDAO = new TransacaoDAO();
        Transacao retorno = transacaoDAO.findById(id);

        if (retorno == null)
            throw new Exception("Não foi possível encontrar uma Transação com o ID: " + id + " informado");

        return retorno;
    }

    public void insert(Transacao transacao) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(transacao);
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.insert(transacao);
    }

    public void update(Transacao transacao) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(transacao);
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.update(transacao);
    }

    public void deleteById(int id) throws SQLException {
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.deleteById(id);
    }
}
