/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dto.MemberDto;
import java.util.ArrayList;
import service.ServiceFactory;
import service.custom.MemberService;

/**
 *
 * @author goyum
 */
public class MemberController {
    
    private MemberService memberService = (MemberService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBERS);
    
    public String save(MemberDto memberDto)throws Exception{
        return memberService.save(memberDto);
    }
    
    public String update(MemberDto memberDto)throws Exception{
        return memberService.update(memberDto);
    }
    
    public String delete(String memberId)throws Exception{
        return memberService.delete(memberId);
    }
    
    public MemberDto get(String memberId)throws Exception{
        return memberService.get(memberId);
    }
    
    public ArrayList<MemberDto> getAll()throws Exception{
        return memberService.getAll();
    }
}
