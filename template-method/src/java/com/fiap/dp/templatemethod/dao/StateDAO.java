package com.fiap.dp.templatemethod.dao;

import java.util.Set;

import com.fiap.dp.templatemethod.domain.State;

public interface StateDAO {

    Set getStates();

    State getState(String name);

}
