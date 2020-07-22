package com.sqldemo.demo.Repo;

import org.springframework.data.repository.CrudRepository;

import com.sqldemo.demo.Model.Clip;

public interface ClipRepo extends CrudRepository<Clip, Integer> {

}