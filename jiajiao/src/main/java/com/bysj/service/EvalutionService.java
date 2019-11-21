package com.bysj.service;

import com.bysj.pojo.Evalution;

import java.util.List;

/**
 * @author 123
 */
public interface EvalutionService {
    Evalution queryEvalutionById(int id);

    List<Evalution> queryEvalutionByTeacherId(int id);

    List<Evalution> queryEvalutionByUserId(int id);

    int addEvalution(Evalution evalution);

    int updateEvalution(Evalution evalution);
}
