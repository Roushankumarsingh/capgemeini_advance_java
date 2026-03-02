package com.example.LibraryManagement.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;

import com.example.LibraryManagement.Entity.Member;
import com.example.LibraryManagement.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
	private final MemberService ms   ; 
	public MemberController(MemberService ms) {
		this.ms = ms ;
	}
	
	@PostMapping("/create")
	public String create(@RequestBody Member m) {
		Member m1 =  ms.addMember(m) ; 
		return "inserted" ;
	}
	
	@GetMapping("/get/{id}")
	public String getId(@PathVariable Long id) {
		Member m = ms.getMemberById(id) ; 
		if(m != null) {
			return m.toString() ;
		}
		else {
			return "Not found" ;
		}
	}
	@GetMapping("/get/all")
	public List<Member> getAll(){
		return ms.getAllMembers() ;
	}
	
	@PutMapping("/update/{id}")
	public String updateId(@PathVariable Long id , @RequestBody Member mt) {
		Member m = ms.updateMember(id, mt) ; 
		if(m != null) {
			return "Updated" ; 
		}
		else {
			return "Not found" ;
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteId(@PathVariable Long id) {
		boolean res = ms.deleteOrDisableMember(id ) ;
		if(res)return "deleted" ; 
		return "Not found" ;
	}
}
