package com.example.extendeddemo.adminandenduser.dao;

import com.example.extendeddemo.admin.model.Categories;
import com.example.extendeddemo.persist.dao.IDAO;

public interface ICategoryDAO extends IDAO<Categories> { //note how the T (from the generic IDAO) to a specific implementation in this specific DAO interface

}
