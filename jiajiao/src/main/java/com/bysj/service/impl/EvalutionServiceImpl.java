package com.bysj.service.impl;

import com.bysj.dao.EvalutionMapper;
import com.bysj.pojo.Evalution;
import com.bysj.service.EvalutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 123
 */
@Service
public class EvalutionServiceImpl implements EvalutionService {

    @Autowired
    private EvalutionMapper evalutionMapper;

    @Override
    public Evalution queryEvalutionById(int id) {
        return evalutionMapper.queryEvalutionById(id);
    }

    @Override
    public List<Evalution> queryEvalutionByTeacherId(int id) {
        return evalutionMapper.queryEvalutionByTeacherId(id);
    }

    @Override
    public List<Evalution> queryEvalutionByUserId(int id) {
        return evalutionMapper.queryEvalutionByUserId(id);
    }

    @Override
    public int addEvalution(Evalution evalution) {
        return evalutionMapper.addEvalution(evalution);
    }

    @Override
    public int updateEvalution(Evalution evalution) {
        return evalutionMapper.updateEvalution(evalution);
    }
}
