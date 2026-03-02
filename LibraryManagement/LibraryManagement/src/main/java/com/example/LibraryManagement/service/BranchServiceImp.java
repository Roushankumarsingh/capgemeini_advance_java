package com.example.LibraryManagement.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.LibraryManagement.Entity.Branch;
import com.example.LibraryManagement.Jpa.BranchJpa;

@Service
public class BranchServiceImp implements BranchService {
	private final BranchJpa bjpa ;
	public BranchServiceImp(BranchJpa bjpa) {
		this.bjpa = bjpa ;
	}
	public Branch addBranch(Branch branch) {
		return bjpa.save(branch) ;
	}

    public Branch getBranchById(Long id) {
    		Optional<Branch> option = bjpa.findById(id) ; 
    		if(option.isPresent()) {
    			return option.get() ; 
    		}
    		else {
    			return null ;
    		}
    }

    public List<Branch> getAllBranches(){
    		return bjpa.findAll() ; 
    }

    public Branch updateBranch(Long id, Branch updated) {
    		Optional<Branch> option = bjpa.findById(id) ;
    		if(option.isPresent()) {
    			Branch b = option.get() ; 
    			b.setContact(updated.getContact());
    			b.setName(updated.getName());
    			b.setLocation(updated.getLocation());
    			bjpa.save(b) ; 
    			return b ; 
    		}
    		else {
    			return null ;
    		}
    }

    public boolean deleteBranch(Long id) {
    		Optional<Branch> option = bjpa.findById(id)  ; 
    		if(option.isPresent()) {
    			bjpa.delete(option.get()); 
    			System.out.println("Deleted");
    			return true ;
    		}
    		else {
    			System.out.println("Not found");
    			return false ;
    		}
    }
}
