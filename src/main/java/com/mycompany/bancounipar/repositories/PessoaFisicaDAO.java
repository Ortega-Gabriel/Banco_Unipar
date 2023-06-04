package com.mycompany.bancounipar.repositories;


import com.mycompany.bancounipar.models.PessoaFisica;
import com.mycompany.bancounipar.utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PessoaFisicaDAO {
    
    private static final String INSERT = 
            "INSERT INTO PESSOAFISICA (NOME, CPF, RG, DATANASCIMENTO, "
            + "PESSOA_ID) VALUES (?, ?, ?, ?, ?)";
    
    private static final String FIND_ALL = 
            "SELECT NOME, CPF, RG, DATANASCIMENTO, PESSOA_ID FROM PESSOA";
    
    private static final String FIND_BY_ID =
            "SELECT NOME, CPF, RG, DATANASCIMENTO, PESSOA_ID FROM PESSOA "
            + "WHERE ID = ?";
    
    private static final String DELETE_BY_ID =
            "DELETE FROM PESSOA WHERE ID = ?";
    
    private static final String UPDATE =
            "UPDATE PESSOA SET NOME = ?, "
            + "NOME = ?, "
            + "CPF = ?,"
            + "RG = ?,"
            + "DATANASCIMENTO = ?,"
            + "PESSOA_ID = ? "
            + "WHERE ID = ?";
    
    public void insert(PessoaFisica pessoaFisica) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            
            pstmt.setInt(1, pessoaFisica.getPessoa().getId());
            pstmt.setString(2, pessoaFisica.getNome());
            pstmt.setString(3, pessoaFisica.getCpf());
            pstmt.setString(4, pessoaFisica.getRg());
            //pstmt.setDate(5, pessoaFisica.getDataNascimento());
            
            pstmt.executeUpdate();
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
    }
    
    public List<PessoaFisica> findAll() throws SQLException {
       
        List<PessoaFisica> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                PessoaFisica pessoaFisica = new PessoaFisica();
                pessoaFisica.setPessoa(new PessoaFisicaDAO().findById(rs.getInt(
                        "ID")));
                pessoaFisica.setNome(rs.getString("NOME"));
                pessoaFisica.setCpf(rs.getString("CPF"));
                pessoaFisica.setRg(rs.getString("RG"));
                pessoaFisica.setDataNascimento(rs.getDate("DATANASCIMENTO"));
                retorno.add(pessoaFisica);
            }
        } finally {
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
        
        return retorno;
    } 
    
    public PessoaFisica findById(int id) throws SQLException {
        
        PessoaFisica pessoaFisica = new PessoaFisica();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            if (rs.next()){
                pessoaFisica.setPessoa(new PessoaDAO().findById(rs.getInt(
                        "ID")));
                pessoaFisica.setNome(rs.getString("NOME"));
                pessoaFisica.setCpf(rs.getString("CPF"));
                pessoaFisica.setRg(rs.getString("RG"));
                pessoaFisica.setDataNascimento(rs.getDate("DATANASCIMENTO"));
            }
            
        } finally {
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
        return pessoaFisica;
    }
    
    public void deleteById(int id) throws SQLException {
        
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
    
    public void update(PessoaFisica pessoaFisica) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, pessoaFisica.getPessoa().getId());
            pstmt.setString(2, pessoaFisica.getNome());
            pstmt.setString(3, pessoaFisica.getCpf());
            pstmt.setString(3, pessoaFisica.getRg());
            //pstmt.setDate(4, pessoaFisica.getDataNascimento());
            pstmt.executeUpdate();
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
    }
}
