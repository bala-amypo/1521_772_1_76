package com.example.demo.service;
import java.util.*;

import com.example.demo.model.ConflictFlag;
public interface  ConflictFlagService
{
    ConflictFlag addFlag(ConflictFlag flag);
    List<ConflictFlag>getFlagsByCase(Long caseId);
    ConflictFlag getFlagById(Long id);
    List<ConflictFlag>getAllFlags();
}