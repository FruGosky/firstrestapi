package com.example.firstrestapi.job;

import java.util.List;

public interface JobService {
    void create(Job job);
    Job findById(Long id);
    List<Job> findAll();
    boolean update(Long id, Job job);
    boolean delete(Long id);
}
