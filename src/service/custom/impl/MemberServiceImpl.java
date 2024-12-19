/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.custom.impl;

import dao.DaoFactory;
import dao.custom.MemberDao;
import dto.MemberDto;
import entity.MemberEntity;
import java.util.ArrayList;

import service.custom.MemberService;

/**
 *
 * @author goyum
 */
public class MemberServiceImpl implements MemberService{

    private MemberDao memberDao = (MemberDao)DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.MEMBERS);
            
    @Override
    public String save(MemberDto memberDto) throws Exception {
        MemberEntity memberEntity = getMemberEntity(memberDto);
        return memberDao.create(memberEntity)?"Success":"Fail";
    }

    @Override
    public String update(MemberDto memberDto) throws Exception {
        MemberEntity memberEntity = getMemberEntity(memberDto);
        return memberDao.update(memberEntity)?"Success":"Fail";
    }

    @Override
    public String delete(String memberId) throws Exception {
        return memberDao.delete(memberId)?"Success":"Fail";
    }

    @Override
    public MemberDto get(String memberId) throws Exception {
        MemberEntity memberEntity =memberDao.get(memberId);
        if(memberEntity!=null){
            return getMemberDto(memberEntity);
        }        
        return null;
    }

    @Override
    public ArrayList<MemberDto> getAll() throws Exception {
        
        ArrayList<MemberEntity> memberEntitys = memberDao.getAll();
        if(memberEntitys!=null&& !memberEntitys.isEmpty()){
            ArrayList<MemberDto> memberDtos= new ArrayList<>();
            for (MemberEntity memberEntity : memberEntitys) {
                memberDtos.add(getMemberDto(memberEntity));
            }
            return memberDtos;
        }
        return null;
    }
    
    
    private MemberEntity getMemberEntity(MemberDto memberDto){
        return new MemberEntity(
                memberDto.getMemberId(), 
                memberDto.getMemberName(),
                memberDto.getMemberPhoneNo(),
                memberDto.getMemberDob(), 
                memberDto.getMemberAddress());
    }
    
    private MemberDto getMemberDto(MemberEntity memberEntity){
        return new MemberDto(
                memberEntity.getMemberId(), 
                memberEntity.getMemberName(),
                memberEntity.getMemberPhoneNo(),
                memberEntity.getMemberDob(), 
                memberEntity.getMemberAddress());
    }
    
}
