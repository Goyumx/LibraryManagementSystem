/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.MemberDao;
import entity.MemberEntity;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author goyum
 */
public class MemberDaoImpl implements MemberDao{

    @Override
    public boolean create(MemberEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Members VALUES(?,?,?,?,?)", t.getMemberId(), t.getMemberName(),t.getMemberPhoneNo(),t.getMemberDob(),t.getMemberAddress());
    }

    @Override
    public boolean update(MemberEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Members SET MemberName =?, MemberPhoneNo = ?, MemberDob=?, MemberAddress=? WHERE MemberId =?",t.getMemberName(),t.getMemberPhoneNo(),t.getMemberDob(),t.getMemberAddress(),t.getMemberId() );
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM Members WHERE MemberId = ?", id);
    }

    @Override
    public MemberEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Members WHERE MemberId = ?", id);
        
        if(rst.next()){
            MemberEntity memberEntity = new MemberEntity( 
                rst.getString("MemberId"),
                rst.getString("MemberName"),
                rst.getString("MemberPhoneNo"),
                rst.getString("MemberDob"),
                rst.getString("MemberAddress"));
            return memberEntity;
        }
        return null;
    }

    @Override
    public ArrayList<MemberEntity> getAll() throws Exception {
        ArrayList<MemberEntity> memberEntitys = new ArrayList<>();
        
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Members");
        while(rst.next()){
            MemberEntity memberEntity= new MemberEntity(
                    rst.getString("MemberId"), 
                    rst.getString("MemberName"), 
                    rst.getString("MemberPhoneNo"),
                    rst.getString("MemberDob"),
                    rst.getString("MemberAddress"));
            memberEntitys.add(memberEntity);
        }
        return memberEntitys;
    }
    
}
