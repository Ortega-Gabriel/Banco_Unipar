package com.mycompany.bancounipar;

import com.mycompany.bancounipar.exceptions.*;
import com.mycompany.bancounipar.models.*;
import com.mycompany.bancounipar.services.*;
import java.util.List;
import javax.swing.JOptionPane;


public class Main {

    public static void main(String[] args){
        
        try{
            AgenciaService agServ = new AgenciaService();
            BancoService baServ = new BancoService();
            CidadeService ciServ = new CidadeService();
            ContaService coServ = new ContaService();
            EnderecoService enServ = new EnderecoService();
            EstadoService esServ = new EstadoService();
            PaisService paServ = new PaisService();
            PessoaService peServ = new PessoaService();
            PessoaFisicaService pfServ = new PessoaFisicaService();
            PessoaJuridicaService pjServ = new PessoaJuridicaService();
            TelefoneService teServ = new TelefoneService();
            TransacaoService trServ = new TransacaoService();
            
            //**Consultado todas as Agências
            //List<Agencia> agResultado = agServ.findAll();
            //JOptionPane.showMessageDialog(null, agResultado);
            
            //**Inserindo uma Nova Agência
            //Agencia agNova = new Agencia("23243800" , "1", "Teste Agência - 00232438", "1234567896", new BancoService().findById(485), "00239776");
            //agServ.insert(agNova);
            
            //**Atualizando o Cadastro de uma Agência
            //Agencia agNova = new Agencia("23243800" , "1", "Teste Agência - 00232438", "1234567896", new BancoService().findById(485), "00239776");
            //agNova.setRazaoSocial("00232438 - Agência Teste");
            //agServ.update(agNova);
            
            //Encontrando a Agência
            //Agencia agPesq = new Agencia();
            //agPesq = agServ.findById(232438);
            //JOptionPane.showMessageDialog(null, agPesq);
            
            /*Deletando o Cadastro da Agência
            agServ.deleteById(232438);*/
            
            //----------------------------------------------
            
            //**Consultado todos os Bancos
            //List<Banco> bcResultado = bcServ.findAll();
            //JOptionPane.showMessageDialog(null, bcResultado);
            
            //**Inserindo um Novo Banco
            //Banco bcNova = new Banco("nome");
            //bcServ.insert(bcNova);
            
            //**Atualizando o Cadastro de um Banco
            //Banco bcNova = new Banco("nome");
            //bcNova.setNome("teste");
            //bcServ.update(bcNova);
            
            //Encontrando o Banco
            //Banco bcPesq = new Banco();
            //bcPesq = bcServ.findById(232438);
            //JOptionPane.showMessageDialog(null, bcPesq);
            
            /*Deletando o Cadastro do Banco
            bcServ.deleteById(232438);*/
            
            //--------------------------
            
            //**Consultado Cidade
            //List<Cidade> ciResultado = ciServ.findAll();
            //JOptionPane.showMessageDialog(null, ciResultado);
            
            //**Inserindo
            //Cidade ciNova = new Cidade("nome", "estado");
            //ciServ.insert(ciNova);
            
            //**Atualizando o Cadastro
            //Cidade ciNova = new Cidade("nome", "estado");
            //ciNova.setNome("teste");
            //ciServ.update(ciNova);
            
            //Encontrando
            //Cidade ciPesq = new Cidade();
            //ciPesq = ciServ.findById(232438);
            //JOptionPane.showMessageDialog(null, ciPesq);
            
            /*Deletando o Cadastro
            ciServ.deleteById(232438);*/
            
            //-------------------------------
            
            //**Consultado todas
            //List<Conta> coResultado = coServ.findAll();
            //JOptionPane.showMessageDialog(null, coResultado);
            
            //**Inserindo uma Nova
            //Conta coNova = new Conta(numero, digito, saldo, tipo, agencia, pessoa);
            //coServ.insert(coNova);
            
            //**Atualizando o Cadastro
            //Conta coNova = new Conta(numero, digito, saldo, tipo, agencia, pessoa);
            //coNova.setNumero(5);
            //coServ.update(coNova);
            
            //Encontrando
            //Conta coPesq = new Conta();
            //coPesq = coServ.findById(232438);
            //JOptionPane.showMessageDialog(null, coPesq);
            
            /*Deletando o Cadastro
            coServ.deleteById(232438);*/
            
            //-----------------------------------
            
            //**Consultado todas
            //List<Endereco> enResultado = enServ.findAll();
            //JOptionPane.showMessageDialog(null, enResultado);
            
            //**Inserindo uma Nova
            //Endereco enNova = new Endereco(logradouro, numero, bairro, cep, complemento, pessoa, cidade);
            //enServ.insert(enNova);
            
            //**Atualizando o Cadastro
            //Endereco enNova = new Endereco(logradouro, numero, bairro, cep, complemento, pessoa, cidade);
            //enNova.setLogradouro("teste");
            //enServ.update(enNova);
            
            //enPesq = enServ.findById(232438);
            //JOptionPane.showMessageDialog(null, enPesq);
            //Encontrando
            //Endereco enPesq = new Endereco();
            
            /*Deletando o Cadastro
            enServ.deleteById(232438);*/
            
            //------------------------------------
            
            //**Consultado todas
            //List<Estado> esResultado = esServ.findAll();
            //JOptionPane.showMessageDialog(null, esResultado);
            
            //**Inserindo uma Nova
            //Estado esNova = new Estado(nome, sigla, pais);
            //esServ.insert(esNova);
            
            //**Atualizando o Cadastro
            //Estado esNova = new Estado(nome, sigla, pais);
            //esNova.setNome("teste");
            //esServ.update(esNova);
            
            //Encontrando
            //Estado esPesq = new Estado();
            //esPesq = eserv.findById(232438);
            //JOptionPane.showMessageDialog(null, esPesq);
            
            /*Deletando o Cadastro
            esServ.deleteById(232438);*/
            
            //---------------------------------------
            
            //**Consultado todas
            //List<Pais> paResultado = paServ.findAll();
            //JOptionPane.showMessageDialog(null, paResultado);
            
            //**Inserindo uma Nova
            //Pais paNova = new Pais(nome, sigla);
            //paServ.insert(paNova);
            
            //**Atualizando o Cadastro
            //Pais paNova = new Pais(nome, sigla);
            //paNova.setNome("teste");
            //paServ.update(paNova);
            
            //Encontrando
            //Pais paPesq = new Pais();
            //paPesq = paServ.findById(232438);
            //JOptionPane.showMessageDialog(null, paPesq);
            
            /*Deletando o Cadastro
            paServ.deleteById(232438);*/
            
            //--------------------------------
            
            //**Consultado todas
            //List<Pessoa> peResultado = peServ.findAll();
            //JOptionPane.showMessageDialog(null, peResultado);
            
            //**Inserindo uma Nova
            //Pessoa peNova = new Pessoa(email);
            //peServ.insert(peNova);
            
            //**Atualizando o Cadastro
            //Pessoa peNova = new Pessoa(email);
            //peNova.setRazaoSocial("teste@teste.com");
            //peServ.update(agNova);
            
            //Encontrando
            //Pessoa pePesq = new Pessoa();
            //pePesq = peServ.findById(232438);
            //JOptionPane.showMessageDialog(null, pePesq);
            
            /*Deletando o Cadastro da Agência
            peServ.deleteById(232438);*/
            
            //---------------------------
            
            //**Consultado todas
            //List<PessoaFisica> pfResultado = pfServ.findAll();
            //JOptionPane.showMessageDialog(null, pfResultado);
            
            //**Inserindo uma Nova
            //PessoaFisica pfNova = new PessoaFisica(pessoa, nome, cpf, rg, dataNascimento, email);
            //peServ.insert(peNova);
            
            //**Atualizando o Cadastro
            //PessoaFisica pfNova = new PessoaFisica(pessoa, nome, cpf, rg, dataNascimento, email);
            //pfNova.setNome("teste");
            //pfServ.update(pfNova);
            
            //Encontrando
            //PessoaFisica pfPesq = new PessoaFisica();
            //pfPesq = pfServ.findById(232438);
            //JOptionPane.showMessageDialog(null, pfPesq);
            
            /*Deletando o Cadastro
            pfServ.deleteById(232438);*/
            
            //---------------------------------
            
            //**Consultado todas
            //List<PessoaJuridica> pjResultado = pjServ.findAll();
            //JOptionPane.showMessageDialog(null, pjResultado);
            
            //**Inserindo uma Nova
            //PessoaJuridica pjNova = new PessoaJuridica(pessoa, razaoSocial, cnpj, cnaePrincipal, fantasia, email);
            //pjServ.insert(pjNova);
            
            //**Atualizando o Cadastro
            //PessoaJuridica pjNova = new PessoaJuridica(pessoa, razaoSocial, cnpj, cnaePrincipal, fantasia, email);
            //pjNova.setRazaoSocial("teste");
            //pjServ.update(pjNova);
            
            //Encontrando
            //PessoaJuridica pjPesq = new PessoaJuridica();
            //pjPesq = pjServ.findById(232438);
            //JOptionPane.showMessageDialog(null, pjPesq);
            
            /*Deletando o Cadastro
            pjServ.deleteById(232438);*/
            
            //-----------------------------------
            
            //**Consultado todas
            //List<Telefone> teResultado = teServ.findAll();
            //JOptionPane.showMessageDialog(null, teResultado);
            
            //**Inserindo uma Nova
            //Telefone teNova = new Telefone(numero, operadora, agencia, pessoa);
            //teServ.insert(teNova);
            
            //**Atualizando o Cadastro
            //Telefone teNova = new Telefone(numero, operadora, agencia, pessoa);
            //teNova.setNumero("000000000");
            //teServ.update(teNova);
            
            //Encontrando
            //Telefone tePesq = new Telefone();
            //tePesq = teServ.findById(232438);
            //JOptionPane.showMessageDialog(null, tePesq);
            
            /*Deletando o Cadastro
            teServ.deleteById(232438);*/
            
            //------------------------------------------
            
            //**Consultado todas
            //List<Transacao> trResultado = trServ.findAll();
            //JOptionPane.showMessageDialog(null, trResultado);
            
            //**Inserindo uma Nova
            //Transacao trNova = new Transacao(datahora, valor, tipo, ContaOrigem, ContaDestino);
            //trServ.insert(trNova);
            
            //**Atualizando o Cadastro
            //Transacao trNova = new Transacao(datahora, valor, tipo, ContaOrigem, ContaDestino);
            //trNova.setValor(5);
            //trServ.update(trNova);
            
            //Encontrando
            //Transacao trPesq = new Transacao();
            //trPesq = trServ.findById(232438);
            //JOptionPane.showMessageDialog(null, trPesq);
            
            /*Deletando o Cadastro
            trServ.deleteById(232438);*/
            
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        
                           
        
    }
}

