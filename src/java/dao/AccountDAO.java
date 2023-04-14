/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dbcontext.DBContext;
import entity.*;
import java.util.*;

/**
 *
 * @author okanh
 */
public class AccountDAO extends DBContext {
    public Account getAccount(String username, String password){
        Account account = null;
        query = "SELECT * FROM Account WHERE accountname=? AND password=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id=rs.getInt("id");                
                String name=rs.getString("accountname");
                String pass=rs.getString("password");
                int roleid=rs.getInt("roleid");
                String email=rs.getString("email");
                account=new Account(id, name, pass, roleid, email);
            }
        } catch (Exception e) {
        }
        return account;
    }
    public List<Role> getRole(){
        List<Role> role = new ArrayList<>();
        query = "SELECT * FROM Roles WHERE [name] NOT LIKE 'admin'";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id=rs.getInt("id");                
                String rname=rs.getString("name");
                role.add(new Role(id, rname));
            }
        } catch (Exception e) {
        }
        return role;
    }
    
    public boolean checkAccount(String username, String email){
        Account account = null;
        query = "SELECT * FROM Account WHERE accountname=? OR email=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,username);
            ps.setString(2,email);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id=rs.getInt("id");                
                String name=rs.getString("accountname");
                String pass=rs.getString("password");
                int roleid=rs.getInt("roleid");
                String emails=rs.getString("email");
                account=new Account(id, name, pass, roleid, emails);
            }
        } catch (Exception e) {
        }
        if(account==null) return true;
        else return false;
    }
    
     public void insertAccount(String username,String password,int roleid, String email){
        query = "INSERT INTO Account VALUES (?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setInt(3,roleid);
            ps.setString(4,email);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
     
        public Account getAccountByEmail(String username, String email){
        Account account= null;
        query = "SELECT * FROM Account WHERE accountname=? AND email=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,username);
            ps.setString(2,email);
            rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");                
                String name=rs.getString("accountname");
                String pass=rs.getString("password");
                int roleid=rs.getInt("roleid");
                String emails=rs.getString("email");
                account=new Account(id, name, pass, roleid, emails);
            }
        } catch (Exception e) {
        }
        return account;
    }
        
        public void changePassword(int accid,String newpassword){
        query = "UPDATE Account SET Password=? WHERE id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,newpassword);
            ps.setInt(2,accid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
        public int checkrole(int accid) {
        query = "SELECT r.id id FROM roles r, ACCOUNT a WHERE r.id=a.roleid AND a.id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accid);
            rs = ps.executeQuery();
            while (rs.next()) {
                int role = rs.getInt("id");
                return role;
            }
        } catch (Exception e) {
        }
        return 0;
    }
        
        public Account getAccountByid(int ids){
        Account account= null;
        query = "SELECT * FROM Account WHERE id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,ids);
            rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");                
                String name=rs.getString("accountname");
                String pass=rs.getString("password");
                int roleid=rs.getInt("roleid");
                String emails=rs.getString("email");
                account=new Account(id, name, pass, roleid, emails);
            }
        } catch (Exception e) {
        }
        return account;
    }
    
    public List<Account> getAllAccount(){
        List<Account> list= new ArrayList<>();
        query = "SELECT * FROM Account ";
        try {
            ps = connection.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");                
                String name=rs.getString("accountname");
                String pass=rs.getString("password");
                int roleid=rs.getInt("roleid");
                String emails=rs.getString("email");
                list.add(new Account(id, name, pass, roleid, emails));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public Role allRole(int aid){
        Role role = null;
        query = "SELECT * FROM Roles r,account a WHERE a.roleid=r.id AND a.id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,aid);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id=rs.getInt("id");                
                String rname=rs.getString("name");
                return role=new Role(id, rname);
            }
        } catch (Exception e) {
        }
        return role;
    }
    public List<Account> searchAccount(String infor,int index){
        List<Account> list=new ArrayList<>();
        query = "SELECT * FROM Account  WHERE (accountname LIKE ? OR email LIKE ?)\n"
                + "ORDER BY id\n"
                + "OFFSET ? ROWS FETCH NEXT 4 ROWS ONLY";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "%" + infor + "%");
            ps.setString(2, "%" + infor + "%");
            ps.setInt(3, (index - 1) * 4);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String accountname = rs.getString("accountname");
                String pass = rs.getString("password");
                int roleid = rs.getInt("roleid");
                String email = rs.getString("email");
                list.add(new Account(id, accountname, pass, roleid, email));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<Account> pagingAccount(int index){
        List<Account> list=new ArrayList<>();
         query = "SELECT * FROM Account \n"
                 + "ORDER BY id\n"
                 + "OFFSET ? ROWS FETCH NEXT 4 ROWS ONLY";
         try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, (index - 1) * 4);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String accountname = rs.getString("accountname");
                String pasword = rs.getString("password");
                int roleid = rs.getInt("roleid");
                String email = rs.getString("email");
                list.add(new Account(id, accountname, pasword, roleid, email));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public int getTotalAccount(){
        query = "SELECT COUNT(*) count FROM Account";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int x = rs.getInt("count");
                return x;
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public void insertadminAccount(String username,String password, String email){
        query = "INSERT INTO Account VALUES (?,?,3,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,email);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public boolean checkadminAccount(String username){
        Account account = null;
        query = "SELECT * FROM Account WHERE accountname=? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,username);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id=rs.getInt("id");                
                String name=rs.getString("accountname");
                String pass=rs.getString("password");
                int roleid=rs.getInt("roleid");
                String emails=rs.getString("email");
                account=new Account(id, name, pass, roleid, emails);
            }
        } catch (Exception e) {
        }
        if(account==null) return true;
        else return false;
    }
    
    public List<Mentee> pagingMentee(int index) {
        List<Mentee> list = new ArrayList<>();
        query = "SELECT * FROM Mentee\n"
                + "ORDER BY id\n"
                + "OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, (index - 1) * 3);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int accountid = rs.getInt("accountid");
                String mentorname = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                java.sql.Date birthday = rs.getDate("birthday");
                String sex = rs.getString("sex");
                String introduce = rs.getString("introduce");
                String avatar = rs.getString("avatar");
                list.add(new Mentee(id, accountid, mentorname, address, phone, birthday, sex, introduce, avatar));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public int getTotalMentee(){
        query = "SELECT COUNT(*) count FROM Mentee";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int x = rs.getInt("count");
                return x;
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public List<Mentee> searchsomeMentee(String name, int index) {
        List<Mentee> list = new ArrayList<>();
        query = "SELECT * FROM Mentee m WHERE m.name LIKE ?\n"
                + "ORDER BY id\n"
                + "OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "%" + name + "%");
            ps.setInt(2, (index - 1) * 3);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int accountid = rs.getInt("accountid");
                String mentorname = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                java.sql.Date birthday = rs.getDate("birthday");
                String sex = rs.getString("sex");
                String introduce = rs.getString("introduce");
                String avatar = rs.getString("avatar");
                list.add(new Mentee(id, accountid, mentorname, address, phone, birthday, sex, introduce, avatar));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
