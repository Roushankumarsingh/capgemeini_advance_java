package com.example.LibraryManagement.service;

import com.example.LibraryManagement.Entity.Member;
import java.util.*;

public interface MemberService {

    public Member addMember(Member member);

    public Member getMemberById(Long id);

    public List<Member> getAllMembers();

    public Member updateMember(Long id, Member updated);

    public boolean deleteOrDisableMember(Long id);
}