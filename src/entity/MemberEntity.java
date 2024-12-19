/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author goyum
 */
public class MemberEntity {

    private String MemberId;
    private String MemberName;
    private String MemberPhoneNo;
    private String MemberDob;
    private String MemberAddress;

    public MemberEntity() {
    }

    public MemberEntity(String MemberId, String MemberName, String MemberPhoneNo, String MemberDob, String MemberAddress) {
        this.MemberId = MemberId;
        this.MemberName = MemberName;
        this.MemberPhoneNo = MemberPhoneNo;
        this.MemberDob = MemberDob;
        this.MemberAddress = MemberAddress;
    }

    /**
     * @return the MemberId
     */
    public String getMemberId() {
        return MemberId;
    }

    /**
     * @param MemberId the MemberId to set
     */
    public void setMemberId(String MemberId) {
        this.MemberId = MemberId;
    }

    /**
     * @return the MemberName
     */
    public String getMemberName() {
        return MemberName;
    }

    /**
     * @param MemberName the MemberName to set
     */
    public void setMemberName(String MemberName) {
        this.MemberName = MemberName;
    }

    /**
     * @return the MemberPhoneNo
     */
    public String getMemberPhoneNo() {
        return MemberPhoneNo;
    }

    /**
     * @param MemberPhoneNo the MemberPhoneNo to set
     */
    public void setMemberPhoneNo(String MemberPhoneNo) {
        this.MemberPhoneNo = MemberPhoneNo;
    }

    /**
     * @return the MemberDob
     */
    public String getMemberDob() {
        return MemberDob;
    }

    /**
     * @param MemberDob the MemberDob to set
     */
    public void setMemberDob(String MemberDob) {
        this.MemberDob = MemberDob;
    }

    /**
     * @return the MemberAddress
     */
    public String getMemberAddress() {
        return MemberAddress;
    }

    /**
     * @param MemberAddress the MemberAddress to set
     */
    public void setMemberAddress(String MemberAddress) {
        this.MemberAddress = MemberAddress;
    }

    @Override
    public String toString() {
        return "MemberEntity{" + "MemberId=" + MemberId + ", MemberName=" + MemberName + ", MemberPhoneNo=" + MemberPhoneNo + ", MemberDob=" + MemberDob + ", MemberAddress=" + MemberAddress + '}';
    }
    
}
