/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import conexao.ConexaoBD;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author josec
 */
public class Admin {
    ConexaoBD conexao = new ConexaoBD();
    
    private String user;
    private String senha;
    private ResultSet consulta;
    
    public boolean Login(String user, String senha) throws SQLException{
       boolean sessao = false;
       
       
            String query = "select user,senha from tb_admin where user='"+user+"' and senha='"+senha+"'";
       conexao.conectar();
        setConsulta(conexao.consultar(query));
       if(getConsulta()!=null){
           
           while(getConsulta().next()){
            Admin login  = new Admin();
            login.setUser(getConsulta().getString(1));
            login.setSenha(getConsulta().getString(2));
            sessao=true;
       
                
           }
       }
     return sessao;
        
    
           
       }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the consulta
     */
    public ResultSet getConsulta() {
        return consulta;
    }

    /**
     * @param consulta the consulta to set
     */
    public void setConsulta(ResultSet consulta) {
        this.consulta = consulta;
    }
}
