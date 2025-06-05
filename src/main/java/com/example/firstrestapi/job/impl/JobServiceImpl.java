package com.example.firstrestapi.job.impl;

import com.example.firstrestapi.job.Job;
import com.example.firstrestapi.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private final List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public void create(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job findById(Long id) {
        for (Job job : jobs) {
            if (!job.getId().equals(id)) continue;
            return job;
        }
        return null;
    }

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public boolean update(Long id, Job newJob) {
        for (Job job : jobs) {
            if (!job.getId().equals(id)) continue;
            job.setTitle(newJob.getTitle());
            job.setDescription(newJob.getDescription());
            job.setMinSalary(newJob.getMinSalary());
            job.setMaxSalary(newJob.getMaxSalary());
            job.setLocation(newJob.getLocation());
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        Iterator<Job> iterator = jobs.iterator();
        while (iterator.hasNext()) {
            Job job = iterator.next();
            if (!job.getId().equals(id)) continue;
            iterator.remove();
            return true;
        }
        return false;
    }
}
