package com.mycompany.bancounipar.repositories;

import com.mycompany.bancounipar.models.Endereco;
import com.mycompany.bancounipar.utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {
    
    public static final String INSERT = 
            "INSERT INTO ENDERECO (ID, LOGRADOURO, NUMERO, BAIRRO, CEP, "
            + "COMPLEMENTO, PESSOA, CIDADE) "
            + "VALUES (?, ?, ?, ?, ?, ?, ? ,?)";
    public static final String FIND_ALL =
            "SELECT ID, LOGRADOURO, NUMERO, BAIRRO, CEP, "
            + "COMPLEMENTO, PESSOA, CIDADE FROM ENDERECO";
    public static final String FIND_BY_ID =
            "SELECT ID, LOGRADOURO, NUMERO, BAIRRO, CEP, "
            + "COMPLEMENTO, PESSOA, CIDADE FROM ENDERECO "
            + "WHERE ID = ?";
    public static final String DELETE_BY_ID =
            "DELETE * FROM PAIS WHERE ID = ?";
    public static final String UPDATE =
            "UPDATE ENDERECO SET"
            + "ID = ?,"
            + "LOGRADOURO = ?,"
            + "NUMERO = ?,"
            + "BAIRRO = ?,"
            + "CEP = ?,"
            + "COMPLEMENTO = ?,"
            + "PESSOA = ?,"
            + "CIDADE = ?"
            + "WHERE ID = ?";
    
    public void insert(Endereco endereco) throws SQLException{
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            
            pstmt.setInt(1, endereco.getId());
            pstmt.setString(2, endereco.getLogradouro());
            pstmt.setString(3, endereco.getNumero());
            pstmt.setString(4, endereco.getBairro());
            pstmt.setString(5, endereco.getCep());
            pstmt.setString(6, endereco.getComplemento());
            pstmt.setInt(7, endereco.getPessoa().getId());
            pstmt.setInt(8, endereco.getCidade().getId());
            
            pstmt.executeUpdate();
            
        }finally{
            if(pstmt != null)
                pstmt.close();
            if(conn != null)
                conn.close();
        }
    }
    
    public List<Endereco> findAll() throws SQLException{
        
        List<Endereco> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("ID"));
                endereco.setLogradouro(rs.getString("LOGRADOURO"));
                endereco.setNumero(rs.getString("NUMERO"));
                endereco.setBairro(rs.getString("BAIRRO"));
                endereco.setCep(rs.getString("CEP"));
                endereco.setComplemento(rs.getString("COMPLEMENTO"));
                endereco.setPessoa(new PessoaDAO().findById(rs.getInt(
                    "PESSOA_ID")));
                endereco.setCidade(new CidadeDAO().findById(rs.getInt(
                    "CIDADE_ID")));
                retorno.add(endereco);
            }
        }finally{
           if (rs != null)
                rs.close();
           if (pstmt != null)
                pstmt.close();
           if (conn != null)
                conn.close(); 
        }
        return retorno;
    }
    
    public Endereco findById(int id) throws SQLException{
        
        Endereco retorno = new Endereco();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            if (rs.next()){
                
                retorno.setId(rs.getInt("ID"));
                retorno.setLogradouro(rs.getString("LOGRADOURO"));
                retorno.setNumero(rs.getString("NUMERO"));
                retorno.setBairro(rs.getString("BAIRRO"));
                retorno.setCep(rs.getString("CEP"));
                retorno.setComplemento(rs.getString("COMPLEMENTO"));
                retorno.setPessoa(new PessoaDAO().findById(rs.getInt(
                    "PESSOA_ID")));
                retorno.setCidade(new CidadeDAO().findById(rs.getInt(
                    "CIDADE_ID")));
                
            }
        }finally{
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
        return retorno;
    }
    
    public void deleteById(int id) throws SQLException{
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
    }
    
    public void update(Endereco endereco) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, endereco.getId());
            pstmt.setString(2, endereco.getLogradouro());
            pstmt.setString(3, endereco.getNumero());
            pstmt.setString(4, endereco.getBairro());
            pstmt.setString(5, endereco.getCep());
            pstmt.setString(6, endereco.getComplemento());
            pstmt.setInt(7, endereco.getPessoa().getId());
            pstmt.setInt(8, endereco.getCidade().getId());
            
            pstmt.executeUpdate();
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
    }
}
