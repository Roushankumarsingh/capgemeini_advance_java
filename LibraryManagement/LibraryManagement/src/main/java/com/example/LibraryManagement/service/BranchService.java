package com.example.LibraryManagement.service;
import java.util.*;

import com.example.LibraryManagement.Entity.Branch;

public interface BranchService {
	public Branch addBranch(Branch branch);

    public Branch getBranchById(Long id);

    public List<Branch> getAllBranches();

    public Branch updateBranch(Long id, Branch updated);

    public boolean deleteBranch(Long id);
}
