package com.example.LibraryManagement.service;


import java.util.*;

import org.springframework.stereotype.Service;

import com.example.LibraryManagement.Entity.Member;
import com.example.LibraryManagement.Jpa.MemberJpa;

@Service
public class MemberServiceImp implements MemberService {
	private final MemberJpa mjpa ;
	public MemberServiceImp(MemberJpa mjpa) {
		this.mjpa = mjpa ;
	}
	
	public Member addMember(Member member) {
		return mjpa.save(member);
	}

    public Member getMemberById(Long id) {
    		Optional<Member> option = mjpa.findById(id) ; 
    		if(option.isPresent()) {
    			return option.get() ; 
    		}
    		else {
    			return null ;
    		}
    }

    public List<Member> getAllMembers(){
    		return mjpa.findAll();
    }

    public Member updateMember(Long id, Member updated) {
    		Optional<Member> option = mjpa.findById(id) ; 
    		if(option.isPresent()) {
    			Member m = option.get() ; 
    			m.setEmail(updated.getEmail());
    			m.setMemberSince(updated.getMemberSince());
    			m.setName(updated.getName());
    			m.setPhone(updated.getPhone());
    			m.setStatus(updated.getStatus());
    			m.setLoan(updated.getLoan()); 
    			return m ; 
    		}
    		else {
    			return null ;
    		}
    }

    public boolean deleteOrDisableMember(Long id) {
    		Optional<Member> option = mjpa.findById(id) ; 
    		if(option.isPresent()) {
    			mjpa.delete(option.get());
    			return true  ; 
    		}
    		else {
    			return false ;
    		}
    }
}
