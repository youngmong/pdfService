package com.lss.service;


import com.lss.pojo.entity.Ingredient;

import java.util.List;

public interface IgdService {
    List<Ingredient> showAll();
    boolean saveIngredient(Ingredient ingredient);
    boolean updateIngredient(Ingredient ingredient);
    boolean deleteIngredientl(Integer IgdId);
}
