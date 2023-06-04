package com.mycompany.bancounipar.repositories;

import com.mycompany.bancounipar.models.Conta;
import com.mycompany.bancounipar.utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {
    
    public static final String INSERT =
            "INSERT INTO CONTA (ID, NUMERO, DIGITO, SALDO, TIPO, AGENCIA_ID,"
            + "PESSOA_ID)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?) FROM CONTA";
    
    public static final String FIND_ALL =
            "SELECT ID, NUMERO, DIGITO, SALDO, TIPO, AGENCIA_ID, PESSOA_ID"
            + "FROM CONTA";
    
    public static final String FIND_BY_ID =
            "SELECT ID, NUMERO, DIGITO, SALDO, TIPO, AGENCIA_ID, PESSOA_ID"
            + "FROM CONTA"
            + "WHERE ID = ?";
    
    public static final String DELETE_BY_ID =
            "DELETE * FROM CONTA"
            + "WHERE ID = ?";
    
    public static final String UPDATE =
            "UPDATE CONTA SET"
            + "ID = ?,"
            + "NUMERO = ?,"
            + "DIGITO = ?,"
            + "SALDO = ?,"
            + "TIPO = ?,"
            + "AGENCIA_ID = ?,"
            + "PESSOA_ID = ?"
            + "WHERE ID = ?";
    
    public void insert(Conta conta) throws SQLException{
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            
            pstmt.setInt(1, conta.getId());
            pstmt.setString(2, conta.getNumero());
            pstmt.setString(3, conta.getDigito());
            pstmt.setDouble(4, conta.getSaldo());
            pstmt.setInt(5, conta.getTipo());
            pstmt.setInt(6, conta.getAgencia().getId());
            pstmt.setInt(7, conta.getPessoa().getId());
            
        }finally{
            if(pstmt != null)
                pstmt.close();
            if(conn != null)
                conn.close();
        }
        
    }
    
    public List<Conta> findAll() throws SQLException{
        
        List<Conta> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                
                Conta conta = new Conta();
                conta.setId(rs.getInt("ID"));
                conta.setNumero(rs.getString("NUMERO"));
                conta.setDigito(rs.getString("DIGITO"));
                conta.setSaldo(rs.getDouble("SALDO"));
                conta.setTipo(rs.getInt("TIPO"));
                conta.setAgencia(new AgenciaDAO().findById(rs.getInt(
                        "AGENCIA_ID")));
                conta.setPessoa(new PessoaDAO().findById(rs.getInt(
                        "PESSOA_ID")));
                retorno.add(conta);
                
            }
        }finally{
            if(rs != null)
                rs.close();
            if(pstmt != null)
                pstmt.close();
            if(conn != null)
                conn.close();
            
        }
        return retorno;
    }
    
    public Conta findById(int id) throws SQLException{
        
        Conta conta = new Conta();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            conta.setId(rs.getInt("ID"));
            conta.setNumero(rs.getString("NUMERO"));
            conta.setDigito(rs.getString("DIGITO"));
            conta.setSaldo(rs.getDouble("SALDO"));
            conta.setTipo(rs.getInt("TIPO"));
            conta.setAgencia(new AgenciaDAO().findById(rs.getInt(
                    "AGENCIA_ID")));
            conta.setPessoa(new PessoaDAO().findById(rs.getInt(
                    "PESSOA_ID")));
            
        }finally{
            if(rs != null)
                rs.close();
            if(pstmt != null)
                pstmt.close();
            if(conn != null)
                conn.close();
        }
        return conta;
    }
    
    public void deleteById(int id) throws SQLException{
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            
            
        }finally{
            if(pstmt != null)
                pstmt.close();
            if(conn != null)
                conn.close();
        }
    }
    
    public void update(Conta conta) throws SQLException{
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, conta.getId());
            pstmt.setString(2, conta.getNumero());
            pstmt.setString(3, conta.getDigito());
            pstmt.setDouble(4, conta.getSaldo());
            pstmt.setInt(5, conta.getTipo());
            pstmt.setInt(6, conta.getAgencia().getId());
            pstmt.setInt(7, conta.getPessoa().getId());
            
        }finally{
            if(pstmt != null)
                pstmt.close();
            if(conn != null)
                conn.close();
        }
    }
            
}
