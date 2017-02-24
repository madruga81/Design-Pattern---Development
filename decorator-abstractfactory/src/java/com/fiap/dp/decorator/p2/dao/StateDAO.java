package com.fiap.dp.decorator.p2.dao;

import java.util.Set;

import com.fiap.dp.decorator.p2.domain.State;

public interface StateDAO {

    Set getStates();

    State getState(String name);

}
